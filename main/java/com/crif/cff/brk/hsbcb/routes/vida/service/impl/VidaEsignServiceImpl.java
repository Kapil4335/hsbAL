package com.crif.cff.brk.hsbcb.routes.vida.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignStatusResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.mapper.VidaRequestHandler;
import com.crif.cff.brk.hsbcb.routes.vida.mapper.VidaResponseHandler;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaCommunicationService;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaEsignService;
import com.crif.cff.brk.hsbcb.routes.vida.util.VidaValidator;

@Service
public class VidaEsignServiceImpl implements VidaEsignService{

	private static final Logger LOGGER= LoggerFactory.getLogger(VidaEsignServiceImpl.class);
	
	@Autowired
	VidaCommunicationService vidaCommunicationService;
	
	@Autowired
	VidaRequestHandler vidaRequestHandler;

	@Autowired
	VidaResponseHandler vidaResponseHandler;
	
	@Autowired
	VidaValidator vidaValidator; 

	@Override
	public ResponseEntity<VidaEsignResponseDto> getEsign(String raType, String docType, VidaEsignRequestDto vidaEsignRequest) {
		
		if(raType == null || raType.isBlank())
		{
			//Setting default raType
			raType="int";
		}
		
		if(docType == null || docType.isBlank())
		{
			//Setting default raType
			docType="template";
		}
		
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsign");
		ResponseEntity<VidaEsignResponseDto> vidaEsignResponseDto = null;
		
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsign : request received : \n"+ vidaEsignRequest);
		
		//#1 Validation for the request received from controller
		vidaValidator.isValidRequest(vidaEsignRequest);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsign : request validated");
		
		//#2 VidaRequestHandler for all mapping related stuff for request if required before sending it to VIDA server
		VidaEsignRequestDto vidaEsignRequestDto=vidaRequestHandler.prepareVidaEsignRequest(vidaEsignRequest);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsign : vidaEkycRequestDto received");
		
		//#3 VidaCommunicationService for all communication send to VIDA server
		long startTime= System.currentTimeMillis();
		vidaEsignResponseDto = vidaCommunicationService.processEsignRequest(vidaEsignRequestDto, raType, docType);
		long endTime= System.currentTimeMillis();
		
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsign : time taken by eSign service is : "+(endTime-startTime) + " ms");

		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsign : vidaEkycResponseDto received from VIDA");

		//#4 VidaResponseHandler for all mapping related stuff for response if required before sending back it
		vidaEsignResponseDto = vidaResponseHandler.prepareVidaEsignResponse(vidaEsignResponseDto);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsign : vidaEkycResponseDto received after mapping");

		return vidaEsignResponseDto;
	}

	@Override
	public ResponseEntity<VidaEsignStatusResponseDto> getEsignStatus(String esignId) {
		
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsignStatus");
		ResponseEntity<VidaEsignStatusResponseDto> vidaEsignStatusResponseDto = null;
		
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsignStatus : esignId request received : \n"+ esignId);
		
		//#1 Validation for the request received from controller
		vidaValidator.isValidRequest(esignId);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsignStatus : request validated");
	
		//#2 VidaCommunicationService for all communication send to VIDA server
		long startTime= System.currentTimeMillis();
		vidaEsignStatusResponseDto = vidaCommunicationService.processEsignStatusRequest(esignId);
		long endTime= System.currentTimeMillis();
		
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsignStatus : time taken by eSign status service is : "+(endTime-startTime) + " ms");

		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsignStatus : vidaEsignStatusResponseDto received from VIDA");

		//#2 VidaResponseHandler for all mapping related stuff for response if required before sending back it
		vidaEsignStatusResponseDto = vidaResponseHandler.prepareVidaEsignStatusResponse(vidaEsignStatusResponseDto);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsignStatus : vidaEsignStatusResponseDto received after mapping");

		return vidaEsignStatusResponseDto;
	}

}
