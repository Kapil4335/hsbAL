package com.crif.gd.hsbcb.vida.brick.controller;
//////////////////////////////////////////////////////
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

///////////////////////////////////////////////////////////////////////
import static org.mockito.ArgumentMatchers.any;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.mapper.VidaRequestHandler;
import com.crif.cff.brk.hsbcb.routes.vida.mapper.VidaResponseHandler;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaCommunicationService;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaOcrService;
import com.crif.cff.brk.hsbcb.routes.vida.service.impl.VidaOcrServiceImpl;
import com.crif.cff.brk.hsbcb.routes.vida.util.VidaValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
//@WebMvcTest(VidaOcrController.class)
public class VidaOcrController {

	
	private static final String ENDPOINT_GET_OCR = "/vida/api/v1/ocr";

	@Mock
	VidaCommunicationService vidaCommunicationService;

	@Mock
	VidaRequestHandler vidaRequestHandler;

	@Mock
	VidaResponseHandler vidaResponseHandler;

	@Mock
	VidaValidator vidaValidator;
	@Autowired
	private MockMvc mockMvc;

	
	@Mock
	private VidaOcrServiceImpl vidaOcrServiceImpl;


	@InjectMocks
	private VidaOcrController vidaOcrController;

	@Test
	public void VidaOcrControllerTest() throws Exception {
//		// Prepare a sample request DTO
//		VidaOcrRequestDto requestDto = new VidaOcrRequestDto(/* your request data here */);
//		
//		
//		VidaOcrResponseDto mockResponseDto = new VidaOcrResponseDto(/* your mocked response data here */);
//		when(RestTemplate.exchange(
//				ENDPOINT_GET_OCR + "ktp/ocr/transaction", 
//				HttpMethod.POST, 
//				requestDto,
//				VidaOcrResponseDto.class).thenReturn(ResponseEntity.ok(mockResponseDto)));
//
////		// Mock the service response
////		VidaOcrResponseDto mockResponseDto = new VidaOcrResponseDto(/* your mocked response data here */);
////		when(vidaOcrService.getOcr(any(VidaOcrRequestDto.class))).thenReturn(ResponseEntity.ok(mockResponseDto));
//
//		// Perform the HTTP request using MockMvc
//		mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_GET_OCR).contentType(MediaType.APPLICATION_JSON)
//				.content(new ObjectMapper().writeValueAsString(requestDto)))
//				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
//						MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(mockResponseDto)));
//
//	}
//	
	}
 

	    @Test
	    public void testMakeHttpRequest() throws Exception {
	        // Arrange
	        RestTemplate restTemplateMock = mock(RestTemplate.class);
	        VidaOcrServiceImpl VidaOcrService = new VidaOcrServiceImpl();

	        VidaOcrRequestDto crRequest = new VidaOcrRequestDto();
	        VidaOcrResponseDto expectedResponse = new VidaOcrResponseDto();

	        String url = "/vida/api/v1/ocr";
	        HttpEntity<VidaOcrRequestDto> requestEntity = new HttpEntity<>(crRequest);

	        // Mock the exchange method
	        when(restTemplateMock.exchange(
	                url,
	                HttpMethod.POST, // or HttpMethod.GET, depending on your API
	                requestEntity,
	                VidaOcrResponseDto.class
	        )).thenReturn(ResponseEntity.ok(expectedResponse));
	        

			// Perform the HTTP request using MockMvc
//			mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_GET_OCR).contentType(MediaType.APPLICATION_JSON)
//					.content(new ObjectMapper().writeValueAsString(crRequest)))
//					.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
//							MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(expectedResponse)));

	        

	        // Act
	        ResponseEntity<VidaOcrResponseDto> responseEntity = vidaOcrServiceImpl.getOcr(crRequest);

	        // Assert
	        assertEquals(expectedResponse, responseEntity.getBody());
	    }
	}

	
	
	


