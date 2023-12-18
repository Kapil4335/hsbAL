package com.crif.cff.brk.hsbcb.routes.vida.service.impl;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.crif.cff.brk.hsbcb.routes.vida.advice.customexception.VidaTokenAccessException;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaTokenResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaTokenService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class VidaTokenServiceImpl implements VidaTokenService{

	private static final Logger LOGGER= LoggerFactory.getLogger(VidaTokenServiceImpl.class);
			
	private static final String VIDA_CLIENT_SECRET = "client_secret";
	private static final String VIDA_CLIENT_ID = "client_id";
	private static final String VIDA_SCOPE = "scope";
	private static final String VIDA_GRANT_TYPE = "grant_type";

	private VidaTokenResponseDto accessToken;
	
	@Autowired
	RestTemplate restTemplate;

	@Value("${vida.media_type}")
	private String vidaMediaType;

	@Value("${vida.client_secret}")
	private String vidaClientSecret;

	@Value("${vida.client_id}")
	private String vidaClientId;

	@Value("${vida.grant_type}")
	private String vidaGrantType;

	@Value("${vida.scope}")
	private String vidaScope;

	@Value("${vida.accesstoken.base-url-services}")
	private String vidaAccessTokenBaseUrlServices;

	@Override
	public VidaTokenResponseDto getVidaAuthToken() 
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(vidaMediaType));

		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<String, String>();
		requestBody.add(VIDA_GRANT_TYPE, vidaGrantType);
		requestBody.add(VIDA_SCOPE, vidaScope);
		requestBody.add(VIDA_CLIENT_ID, vidaClientId);
		requestBody.add(VIDA_CLIENT_SECRET, vidaClientSecret);

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

		ResponseEntity<VidaTokenResponseDto> response=null;

		LOGGER.debug( this.getClass().getSimpleName() + " : getVidaAuthToken : Calling VIDA auth");
		
		try
		{
			long startTime=System.currentTimeMillis();
			response = restTemplate.exchange(vidaAccessTokenBaseUrlServices, 
												 HttpMethod.POST, 
												 requestEntity,
												 VidaTokenResponseDto.class);
			long endTime=System.currentTimeMillis();
			LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsign : time taken by token service is : "+(endTime-startTime) + " ms");
			LOGGER.debug( this.getClass().getSimpleName() + " : getVidaAuthToken : auth API called : response returned");
				
			accessToken =  response.getBody();
						
			if(accessToken != null)
			{
				accessToken.setExpiresIn("60");//For testing purpose only
				accessToken.setExpirationTime(Instant.now().plusSeconds(Integer.parseInt(accessToken.getExpiresIn())));
				LOGGER.debug( this.getClass().getSimpleName() + " : getVidaAuthToken : VIDA auth token received");
			}
		}
		catch(HttpStatusCodeException ex)
		{
			VidaTokenResponseDto vidaTokenResponse = null;
				
				try 
				{
					vidaTokenResponse = (VidaTokenResponseDto) new ObjectMapper().readValue(ex.getResponseBodyAsString(),
							  											VidaTokenResponseDto.class);
				} 
				catch (JsonProcessingException e) 
				{
					
					throw new VidaTokenAccessException(vidaTokenResponse, ex, ex.getStatusCode());
				}
				
			if(ex.getStatusCode().equals(HttpStatus.BAD_REQUEST) || ex.getStatusCode().equals(HttpStatus.UNAUTHORIZED))
			{
				throw new VidaTokenAccessException(vidaTokenResponse, ex, ex.getStatusCode());
			}
				
		}
		
		return accessToken;
	}

	@Override
	public boolean isAccessTokenExpired() {
		
		if (accessToken != null && accessToken.getExpirationTime() != null) 
		{
			boolean expired = Instant.now().isAfter(accessToken.getExpirationTime());
			LOGGER.debug(this.getClass().getSimpleName() + " : isAccessTokenExpired : " + expired);

			return expired;
		}
		LOGGER.debug(this.getClass().getSimpleName() + " : isAccessTokenExpired : true ");
		return true;
	}

	@Override
	public VidaTokenResponseDto refreshToken() {
	
		LOGGER.debug(this.getClass().getSimpleName() + " : refreshToken : Calling getVidaAuthToken");
		return getVidaAuthToken();
	}

	@Override
	public String getAccessToken() {
		
		if (accessToken != null) {

			LOGGER.debug(this.getClass().getSimpleName() + " : getAccessToken : " + accessToken.getAccessToken());
			return accessToken.getAccessToken();
		}

		LOGGER.debug(this.getClass().getSimpleName() + " : getAccessToken : null ");
		return null;
	}
	
}