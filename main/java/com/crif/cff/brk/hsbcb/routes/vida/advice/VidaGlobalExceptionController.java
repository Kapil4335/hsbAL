package com.crif.cff.brk.hsbcb.routes.vida.advice;

import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;

import com.crif.cff.brk.hsbcb.routes.vida.advice.customexception.VidaEkycDataException;
import com.crif.cff.brk.hsbcb.routes.vida.advice.customexception.VidaEkycException;
import com.crif.cff.brk.hsbcb.routes.vida.advice.customexception.VidaEsignException;
import com.crif.cff.brk.hsbcb.routes.vida.advice.customexception.VidaEsignStatusException;
import com.crif.cff.brk.hsbcb.routes.vida.advice.customexception.VidaOcrException;
import com.crif.cff.brk.hsbcb.routes.vida.advice.customexception.VidaTokenAccessException;
import com.crif.cff.brk.hsbcb.routes.vida.service.impl.VidaEkycServiceImpl;
import com.hazelcast.internal.ascii.rest.HttpBadRequestException;

@ControllerAdvice
public class VidaGlobalExceptionController  {

	private static final Logger LOGGER= LoggerFactory.getLogger(VidaEkycServiceImpl.class);

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {

		LOGGER.error(this.getClass().getSimpleName() + " : in Global exception handler [NullPointerException]: " + ex.getMessage());
		return new ResponseEntity<>(getErrorMap(ex.getMessage()), HttpStatus.PARTIAL_CONTENT);
	}
	
	@ExceptionHandler(VidaEsignException.class)
	public ResponseEntity<Object> handleVidaEsignException(VidaEsignException ex, WebRequest request) {

		LOGGER.error(this.getClass().getSimpleName() + " : in Global exception handler [VidaEsignException]: " + ex.getMessage());
		return new ResponseEntity<>(ex.getVidaEsignResponse(), ex.getHttpStatus());
	}
	
	@ExceptionHandler(VidaEkycDataException.class)
	public ResponseEntity<Object> handleVidaEkycDataException(VidaEkycDataException ex, WebRequest request) {

		LOGGER.error(this.getClass().getSimpleName() + " : in Global exception handler [VidaEkycDataException]: " + ex.getMessage());
		return new ResponseEntity<>(ex.getVidaEkycDataResponse(), ex.getHttpStatus());
	}
	
	@ExceptionHandler(VidaEsignStatusException.class)
	public ResponseEntity<Object> handleVidaEsignStatusException(VidaEsignStatusException ex, WebRequest request) {

		LOGGER.error(this.getClass().getSimpleName() + " : in Global exception handler [VidaEsignStatusException]: " + ex.getMessage());
		return new ResponseEntity<>(ex.getVidaEsignStatusResponse(), ex.getHttpStatus());
	}
	
	@ExceptionHandler(VidaTokenAccessException.class)
	public ResponseEntity<Object> handleVidaTokenAccessException(VidaTokenAccessException ex, WebRequest request) {

		LOGGER.error(this.getClass().getSimpleName() + " : in Global exception handler [VidaTokenAccessException]: " + ex.getMessage());
		return new ResponseEntity<>(ex.getVidaTokenResponse(), ex.getHttpStatus());
	}
	
	@ExceptionHandler(VidaEkycException.class)
	public ResponseEntity<Object> handleVidaEkycExceptionn(VidaEkycException ex, WebRequest request) {

		LOGGER.error(this.getClass().getSimpleName() + " : in Global exception handler [VidaEkycException]: " + ex.getMessage());
		//return new ResponseEntity<>(getErrorMap(ex.getVidaEkycResponse()), ex.getHttpStatus());
		return new ResponseEntity<>(ex.getVidaEkycResponse(), ex.getHttpStatus());
	}
	
	@ExceptionHandler(VidaOcrException.class)
	public ResponseEntity<Object> handleVidaOcrException(VidaOcrException ex, WebRequest request) {

		LOGGER.error(this.getClass().getSimpleName() + " : in Global exception handler [VidaOcrException]: " + ex.getMessage());
		return new ResponseEntity<>(ex.getVidaOcrResponse(), ex.getHttpStatus());
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleHttpClientErrorException(HttpClientErrorException ex) {
	
		LOGGER.error( this.getClass().getSimpleName() + " : in Global exception handler : [HttpClientErrorException]"+ex.getMessage(), ex);
		//String errorMessage = "Client error: " + ex.getRawStatusCode() + " - " + ex.getStatusText();
		return new ResponseEntity<>(ex.getMessage(), ex.getStatusCode());
	}
	
	@ExceptionHandler(HttpBadRequestException.class)
	public ResponseEntity<String> handleHttpBadRequestException(HttpBadRequestException ex) throws IOException {
		
		LOGGER.error( this.getClass().getSimpleName() + " : in Global exception handler : [HttpBadRequestException]"+ex.getMessage());
		String errorMessage = "HttpBadRequestException : " + ((ClientHttpResponse) ex).getRawStatusCode();
		return new ResponseEntity<>(errorMessage, ((ClientHttpResponse) ex).getStatusCode());
	}
	
	@ExceptionHandler(HttpStatusCodeException.class)
	public ResponseEntity<String> handleResourceAccessException(HttpStatusCodeException ex) {

		LOGGER.error( this.getClass().getSimpleName() + " : in Global exception handler : [HttpStatusCodeException]"+ex.getMessage());
		String errorMessage = "Error accessing the remote service. Please try again later";
		return new ResponseEntity<>(errorMessage, HttpStatus.SERVICE_UNAVAILABLE);
	}

	@ExceptionHandler(ResourceAccessException.class)
	public ResponseEntity<Object> handleResourceAccessException(ResourceAccessException ex) {
		
		LOGGER.error(this.getClass().getSimpleName() + " : [ResourceAccessException]" + ex.getMessage());
		return new ResponseEntity<>(getErrorMap(ex.getMessage()), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
	}
	
//	@ExceptionHandler(ResourceAccessException.class)
//	public ResponseEntity<String> handleResourceAccessException(ResourceAccessException ex) {
//		
//		LOGGER.error(this.getClass().getSimpleName() + " : in Global handler part" + ex.getMessage(), ex);
//		String errorMessage = "Error accessing the remote service. Please try again later !!!";
//		return new ResponseEntity<>(ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
//	}


	@ExceptionHandler(HttpServerErrorException.class)
	public ResponseEntity<String> handleHttpServerErrorException(HttpServerErrorException ex) {
		
		LOGGER.error( this.getClass().getSimpleName() + " : in Global exception handler : [HttpServerErrorException]"+ex.getMessage());
		String errorMessage = "Server error: " + ex.getRawStatusCode() + " - " + ex.getStatusText();
		return new ResponseEntity<>(errorMessage, ex.getStatusCode());
	}

	@ExceptionHandler(RestClientException.class)
	public ResponseEntity<String> handleRestClientException(RestClientException ex) {
		
		LOGGER.error( this.getClass().getSimpleName() + " : in Global exception handler : [RestClientException]"+ex.getMessage());
		String errorMessage = "Error during the HTTP request: " + ex.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UnknownHostException.class)
	public ResponseEntity<String> handleUnknownHostException(UnknownHostException ex) {
		
		LOGGER.error( this.getClass().getSimpleName() + " : in Global exception handler : [UnknownHostException]"+ex.getMessage());
		String errorMessage = "UnknownHostException: " + ex.getMessage();
		return new ResponseEntity<>(errorMessage, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	private Map<String, Object> getErrorMap(Object object) {
		Map<String, Object> errorMap = new LinkedHashMap<String, Object>();
		errorMap.put("timestamp", LocalDateTime.now());
		errorMap.put("message", object);
		return errorMap;
	}

}
