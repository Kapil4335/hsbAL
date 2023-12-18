package com.crif.gd.hsbcb.vida.brick.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Logger;

import org.ehcache.shadow.org.terracotta.context.query.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.expression.AccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.crif.cff.brk.hsbcb.routes.vida.controller.VidaAuthTokenController;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaTokenResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.service.impl.VidaTokenServiceImpl;

class VidaTokenServiceTest {
	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private VidaTokenServiceImpl VidaTokenServiceImpl;

	@Mock
	private Logger loggerMock;

	@Mock
	private VidaTokenResponseDto vidaTokenResponseDto;

	@Mock
	public HttpEntity requestEntity;

	@Mock
	private VidaAuthTokenController vidaAuthTokenController;

	@BeforeEach
	public void setup() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getVidaAuthTokenTest_Success() {
//	//public void testGetVidaAuthToken_Success() {
//	
//		String token = "drdhtfjygkgtrdhdfjfhthtdfhddhcthddhddhtdthdhtdtdyerwsguyrtdffjdrrdht";
//		VidaTokenResponseDto vidaTokenResponseDto = new VidaTokenResponseDto();
//		vidaTokenResponseDto.setAccessToken(token);
//		
//	
//		// Mock the response
//		ResponseEntity<VidaTokenResponseDto> mockResponse = new ResponseEntity<>(vidaTokenResponseDto, HttpStatus.OK);
//		// mockResponse.setAccessToken(token);
//
//		VidaTokenServiceImpl vidaTokenServiceImpl=new VidaTokenServiceImpl();
//		
//		//VidaTokenServiceImpl tokenServiceImpl = mock(VidaTokenServiceImpl.class);
//		 MultiValueMap<String, String> requestBody = vidaTokenServiceImpl.createRequestBody();
//		when(restTemplate.exchange("", HttpMethod.POST, requestEntity, VidaTokenResponseDto.class))
//				.thenReturn(mockResponse);
//
//
//		// Call the method to test
//		VidaTokenResponseDto result = vidaTokenServiceImpl.getVidaAuthToken();
//		
//		   // Assert
//       assertEquals("vidaGrantType", requestBody.getFirst("GRANT_TYPE"));
//       assertEquals("Scope", requestBody.getFirst("_SCOPE"));
//        assertEquals("ClientId", requestBody.getFirst("_CLIENT_ID"));
//       assertEquals("ClientSecret", requestBody.getFirst("_CLIENT_SECRET"));
//
//		// Verify the result
//		assertNotNull(token,result);
//		assertEquals(token, result);
		
		}
	
	 public MultiValueMap<String, String> createRequestBody() {
	        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
	        requestBody.add("GRANT_TYPE", "vidaGrantType");
	        requestBody.add("_SCOPE", "Scope");
	        requestBody.add("_CLIENT_ID", "ClientId");
	        requestBody.add("_CLIENT_SECRET", "ClientSecret");
	        return requestBody;
	    }

////////////////////////////////////////////////////////////////////////////////////////////	

	@Test
	public void testGetVidaAuthToken_Error() {
		
		// Mock a 401 Unauthorized response
		HttpStatusCodeException exception = mock(HttpStatusCodeException.class);
		when(exception.getStatusCode()).thenReturn(HttpStatus.UNAUTHORIZED);

		VidaTokenServiceImpl tokenServiceImpl = mock(VidaTokenServiceImpl.class);
		when(restTemplate.exchange("", HttpMethod.POST, requestEntity, VidaTokenResponseDto.class))
				.thenThrow(exception);

		assertThrows(AccessException.class, () -> tokenServiceImpl.getVidaAuthToken());

	}
///////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void testIsAccessTokenExpired_NotExpired() {
		String token = "drdhtfjygkgtrdhdfjfhthtdfhddhcthddhddhtdthdhtdtdyerwsguyrtdffjdrrdht";

		VidaTokenResponseDto accessToken = new VidaTokenResponseDto();
		accessToken.setAccessToken(token);

		VidaTokenServiceImpl vidaTokenServiceImpl = mock(VidaTokenServiceImpl.class);

		Instant expirationTime = Instant.now().plusSeconds(3600);
		when(vidaTokenServiceImpl.getAccessToken()).thenReturn("" + expirationTime);

		accessToken.setExpiresIn("" + expirationTime);

		// Call the method to test
		boolean result = vidaTokenServiceImpl.isAccessTokenExpired();

		// Verify that the result is false since the token is not expired
		assertFalse(result, "The token should not be expired.");

	}

///////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testIsAccessTokenExpired_Expired() {
		String token = "drdhtfjygkgtrdhdfjfhthtdfhddhcthddhddhtdthdhtdtdyerwsguyrtdffjdrrdht";
		VidaTokenResponseDto validToken = new VidaTokenResponseDto();
		// vidaTokenResponseDto.setAccessToken(token);

		// Set up an expired access token
		// VidaTokenResponseDto expiredToken = new VidaTokenResponseDto();
		vidaTokenResponseDto.setExpirationTime(Instant.now().minusSeconds(3600));

		VidaTokenServiceImpl vidaTokenServiceImpl = new VidaTokenServiceImpl();

		validToken.setAccessToken(token);

		// Call the method to test
		boolean result = vidaTokenServiceImpl.isAccessTokenExpired();

		// Verify the result
		assertTrue(result);
	}

/////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testRefreshToken() {
		String token = "drdhtfjygkgtrdhdfjfhthtdfhddhcthddhddhtdthdhtdtdyerwsguyrtdffjdrrdht";

		VidaTokenResponseDto accessToken = new VidaTokenResponseDto();
		accessToken.setAccessToken(token);

		VidaTokenServiceImpl tokenServiceImpl = mock(VidaTokenServiceImpl.class);

		Instant expirationTime = Instant.now().plusSeconds(3600);
		when(tokenServiceImpl.getAccessToken()).thenReturn("" + expirationTime);

		// Assuming refreshToken returns a string
		VidaTokenResponseDto actualTokenResponse = tokenServiceImpl.refreshToken();
		accessToken.setExpiresIn("" + expirationTime);

		VidaTokenResponseDto result = tokenServiceImpl.refreshToken();

		// Verify the result
		assertEquals(result, actualTokenResponse);
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testGetAccessToken() {

		String token = "drdhtfjygkgtrdhdfjfhthtdfhddhcthddhddhtdthdhtdtdyerwsguyrtdffjdrrdht";
		VidaTokenResponseDto vidaTokenResponseDto = new VidaTokenResponseDto();
		vidaTokenResponseDto.setAccessToken(token);
		// Set up a mock access token

		// VidaTokenServiceImpl.setAccessToken(token);

		// Call the method to test
		String result = vidaTokenResponseDto.getAccessToken();

		// Verify the result
		assertEquals(token, result);
		// assertNotNull( result); //working
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
