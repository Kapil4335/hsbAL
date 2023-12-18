package com.crif.cff.brk.hsbcb.routes.vida.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.crif.cff.brk.hsbcb.routes.vida.advice.customexception.VidaEkycDataException;
import com.crif.cff.brk.hsbcb.routes.vida.advice.customexception.VidaEkycException;
import com.crif.cff.brk.hsbcb.routes.vida.advice.customexception.VidaEsignException;
import com.crif.cff.brk.hsbcb.routes.vida.advice.customexception.VidaEsignStatusException;
import com.crif.cff.brk.hsbcb.routes.vida.advice.customexception.VidaOcrException;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycDataResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignStatusResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaCommunicationService;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaTokenService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class VidaCommunicationServiceImpl implements VidaCommunicationService{

	private static final Logger LOGGER= LoggerFactory.getLogger(VidaCommunicationServiceImpl.class);

	@Value("${vida.ekyc.base-url-services}")
	private String vidaEkycBaseUrlServices;
	
	@Value("${vida.ocr.base-url-services}")
	private String vidaOcrBaseUrlServices;
	
	@Value("${vida.esign.base-url-services}")
	private String vidaEsignBaseUrlServices;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private VidaTokenService vidaTokenService;
	
	@Override
	public VidaEkycResponseDto processEkycRequest(VidaEkycRequestDto ekycRequest) {
		
		HttpHeaders headers = null;
		headers = setAccessTokenInRequest();
		
		HttpEntity<VidaEkycRequestDto> requestEntity = new HttpEntity<>(ekycRequest, headers);
		
		ResponseEntity<VidaEkycResponseDto> response = null;

		try 
		{
			response = restTemplate.exchange(
										vidaEkycBaseUrlServices + "/services/kyc", 
										HttpMethod.POST, 
										requestEntity,
										VidaEkycResponseDto.class);
			LOGGER.debug( this.getClass().getSimpleName() + " : processEkycRequest : eKyc response received from VIDA");
		}
		catch(HttpStatusCodeException ex)
		{
			VidaEkycResponseDto vidaEkycResponse = null;
				
				try 
				{
					vidaEkycResponse = (VidaEkycResponseDto) new ObjectMapper().readValue(ex.getResponseBodyAsString(), VidaEkycResponseDto.class);
				} 
				catch (JsonProcessingException e) 
				{
					
					throw new VidaEkycException(vidaEkycResponse, ex, ex.getStatusCode());
				}
				
			throw new VidaEkycException(vidaEkycResponse, ex, ex.getStatusCode());			
		}
		
		return response.getBody();
	}

	
	@Override
	public ResponseEntity<VidaEkycResponseDto> processEkycStatusRequest(String ekycEventId) {
		
		HttpHeaders headers = null;
		headers = setAccessTokenInRequest();
		
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		
		ResponseEntity<VidaEkycResponseDto> response = null;
		
		try 
		{
			response = restTemplate.exchange(
										vidaEkycBaseUrlServices + "services/kyc/{ekycEventId}/status", 
										HttpMethod.GET, 
										requestEntity,
										VidaEkycResponseDto.class,
										ekycEventId);
			LOGGER.debug( this.getClass().getSimpleName() + " : processEkycRequest : eKyc status response received from VIDA" + response.getBody());
		}
		catch(HttpStatusCodeException ex)
		{
			VidaEkycResponseDto vidaEkycResponse = null;
				
				try 
				{
					vidaEkycResponse = (VidaEkycResponseDto) new ObjectMapper().readValue(ex.getResponseBodyAsString(), VidaEkycResponseDto.class);
				} 
				catch (JsonProcessingException e) 
				{
					
					throw new VidaEkycException(vidaEkycResponse, ex, ex.getStatusCode());
				}

			throw new VidaEkycException(vidaEkycResponse, ex, ex.getStatusCode());
				
		}
		catch(Exception ex)
		{
			throw new VidaEkycException(null, ex, ((HttpStatusCodeException) ex).getStatusCode());
		}
		
		return response;
	}

	@Override
	public ResponseEntity<VidaEkycDataResponseDto> processEkycDataRequest(String ekycEventId) {
		
		HttpHeaders headers = null;
		headers = setAccessTokenInRequest();
		
		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		
		ResponseEntity<VidaEkycDataResponseDto> response = null;
		
		try 
		{
			response = restTemplate.exchange(
										vidaEkycBaseUrlServices + "services/kyc/{ekycEventId}/kycdata", 
										HttpMethod.GET, 
										requestEntity,
										VidaEkycDataResponseDto.class,
										ekycEventId);
			LOGGER.debug( this.getClass().getSimpleName() + " : processEkycDataRequest : eKyc data response received from VIDA" + response.getBody());
		}
		catch(HttpStatusCodeException ex)
		{
			VidaEkycDataResponseDto vidaEkycDataResponse = null;
				
				try 
				{
					vidaEkycDataResponse = (VidaEkycDataResponseDto) new ObjectMapper().readValue(ex.getResponseBodyAsString(), VidaEkycDataResponseDto.class);
				} 
				catch (JsonProcessingException e) 
				{
					
					throw new VidaEkycDataException(vidaEkycDataResponse, ex, ex.getStatusCode());
				}

			throw new VidaEkycDataException(vidaEkycDataResponse, ex, ex.getStatusCode());
				
		}
		catch(Exception ex)
		{
			throw new VidaEkycDataException(null, ex, ((HttpStatusCodeException) ex).getStatusCode());
		}
		
		return response;
	}
	
	
	@Override
	public ResponseEntity<VidaEsignResponseDto> processEsignRequest(VidaEsignRequestDto eSignRequest, String raType, String docType) 
	{

		HttpHeaders headers = null;
		headers = setAccessTokenInRequest();

		HttpEntity<VidaEsignRequestDto> requestEntity = new HttpEntity<>(eSignRequest, headers);

        
        ResponseEntity<VidaEsignResponseDto> response = null;
		try 
		{
			String baseUrl = vidaEsignBaseUrlServices + "services/esign";

	        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl)
									                .queryParam("raType", raType)
									                .queryParam("docType", docType);

	        String urlWithQueryParams = builder.toUriString();


//	        LOGGER.debug("-----------------------------------------------------------------------------");
//	        LOGGER.debug("raType : "+raType);
//	        LOGGER.debug("docType : "+docType);
//	        LOGGER.debug("requestEntity : "+ requestEntity.getBody());
//	        LOGGER.debug("url 1: "+urlWithQueryParams);
//	        LOGGER.debug("url 2: " + vidaEsignBaseUrlServices + "services/esign?raType="+raType+"&docType="+docType);
//	        
//	        LOGGER.debug("-----------------------------------------------------------------------------");
//		       
	        
			response = restTemplate.exchange(
										urlWithQueryParams,
										//vidaEsignBaseUrlServices + "services/esign?raType="+raType+"&docType="+docType,
										HttpMethod.POST, 
										requestEntity, 
										VidaEsignResponseDto.class);

			LOGGER.debug(this.getClass().getSimpleName() + " : processEsignRequest : response received esign from VIDA");
		} 
		catch (HttpStatusCodeException ex) 
		{
			VidaEsignResponseDto vidaEsignResponse = null;

				try 
				{
					vidaEsignResponse = (VidaEsignResponseDto) new ObjectMapper().readValue(ex.getResponseBodyAsString(),
							VidaEsignResponseDto.class);
				} 
				catch (JsonProcessingException e) 
				{
	
					throw new VidaEsignException(vidaEsignResponse, ex, ex.getStatusCode());
				}
	

			throw new VidaEsignException(vidaEsignResponse, ex, ex.getStatusCode());

		}

		return response;
	}


	@Override
	public ResponseEntity<VidaEsignStatusResponseDto> processEsignStatusRequest(String esignId) {
		
		HttpHeaders headers = null;
		headers = setAccessTokenInRequest();

		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);

		ResponseEntity<VidaEsignStatusResponseDto> response = null;

		try 
		{
			response = restTemplate.exchange(
										vidaEsignBaseUrlServices + "/services/esign/{esignId}",
										HttpMethod.GET, 
										requestEntity, 
										VidaEsignStatusResponseDto.class,
										esignId);
			LOGGER.debug(this.getClass().getSimpleName() + " : processEsignStatusRequest : response received esign status from VIDA");
		} 
		catch (HttpStatusCodeException ex) 
		{
			VidaEsignStatusResponseDto vidaEsignStatusResponseDto = null;

				try 
				{
					vidaEsignStatusResponseDto = (VidaEsignStatusResponseDto) new ObjectMapper().readValue(ex.getResponseBodyAsString(),VidaEsignStatusResponseDto.class);
				} 
				catch (JsonProcessingException e) 
				{
	
					throw new VidaEsignStatusException(vidaEsignStatusResponseDto, ex, ex.getStatusCode());
				}
	

			throw new VidaEsignStatusException(vidaEsignStatusResponseDto, ex, ex.getStatusCode());

		}

		return response;
	}


	@Override
	public ResponseEntity<VidaOcrResponseDto> processOcrRequest(VidaOcrRequestDto ocrRequest) {
		
		HttpHeaders headers = null;
		headers = setAccessTokenInRequest();
		
		HttpEntity<VidaOcrRequestDto> requestEntity = new HttpEntity<>(ocrRequest, headers);

		ResponseEntity<VidaOcrResponseDto> response=null;
				
		try {
			response = restTemplate.exchange(
										vidaOcrBaseUrlServices + "ktp/ocr/transaction", 
										HttpMethod.POST, 
										requestEntity,
										VidaOcrResponseDto.class);
			LOGGER.debug( this.getClass().getSimpleName() + " : processOcrRequest : OCR response received from VIDA");
		} 
		catch(HttpStatusCodeException ex)
		{
			VidaOcrResponseDto vidaOcrResponse = null;
				
				try 
				{
					vidaOcrResponse = (VidaOcrResponseDto) new ObjectMapper().readValue(ex.getResponseBodyAsString(), VidaOcrResponseDto.class);
				} 
				catch (JsonProcessingException e) 
				{
					
					throw new VidaOcrException(vidaOcrResponse, ex, ex.getStatusCode());
				}

			throw new VidaOcrException(vidaOcrResponse, ex, ex.getStatusCode());
				
		}

		return response;
	}
	
	private HttpHeaders setAccessTokenInRequest() 
	{
		// Accessing token from VidaTokenService
		LOGGER.debug(this.getClass().getSimpleName() + " : setAccessTokenInRequest : checking token validity");

		if (vidaTokenService.isAccessTokenExpired()) {
			LOGGER.debug(this.getClass().getSimpleName() + " : setAccessTokenInRequest : token expired, calling refreshToken");
			vidaTokenService.refreshToken();
		}

		String accessToken = vidaTokenService.getAccessToken();

		if (accessToken == null) {
			LOGGER.error(this.getClass().getSimpleName() + " : setAccessTokenInRequest : access token is NULL");
			throw new NullPointerException("access token is NULL");
		}

		LOGGER.debug(this.getClass().getSimpleName() + " : setAccessTokenInRequest : received access token");

		// Creating request for VIDA eKyc
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(accessToken);

		return headers;
	}

}
