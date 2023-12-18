package com.crif.cff.brk.hsbcb.routes.vida.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycDataResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.mapper.VidaRequestHandler;
import com.crif.cff.brk.hsbcb.routes.vida.mapper.VidaResponseHandler;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaCommunicationService;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaEkycService;
import com.crif.cff.brk.hsbcb.routes.vida.util.VidaValidator;

@Service
public class VidaEkycServiceImpl implements VidaEkycService{

	private static final Logger LOGGER= LoggerFactory.getLogger(VidaEkycServiceImpl.class);

	@Autowired
	VidaCommunicationService vidaCommunicationService;
	
	@Autowired
	VidaRequestHandler vidaRequestHandler;

	@Autowired
	VidaResponseHandler vidaResponseHandler;
	
	@Autowired
	VidaValidator vidaValidator; 
	
	@Override
	public VidaEkycResponseDto getEkyc(VidaEkycRequestDto vidaEkycRequest) {

		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKyc");
		VidaEkycResponseDto vidaEkycResponseDto = null;
		
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKyc : request received : \n"+ vidaEkycRequest);
		
		//#1 Validation for the request received from controller
		vidaValidator.isValidRequest(vidaEkycRequest);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKyc : request validated");
		
		//#2 VidaRequestHandler for all mapping related stuff for request if required before sending it to VIDA server
		VidaEkycRequestDto vidaEkycRequestDto=vidaRequestHandler.prepareVidaEkycRequest(vidaEkycRequest);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKyc : vidaEkycRequestDto received");
		
		//#3 VidaCommunicationService for all communication send to VIDA server
		long startTime=System.currentTimeMillis();
		vidaEkycResponseDto = vidaCommunicationService.processEkycRequest(vidaEkycRequestDto);
		long endTime=System.currentTimeMillis();
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKyc : time taken by ekyc service is : "+(endTime-startTime) + " ms");
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKyc : vidaEkycResponseDto received from VIDA");

		//#4 VidaResponseHandler for all mapping related stuff for response if required before sending back it
		vidaEkycResponseDto = vidaResponseHandler.prepareVidaEkycResponse(vidaEkycResponseDto);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKyc : vidaEkycResponseDto received after mapping");
		
		return vidaEkycResponseDto;
	}

	@Override
	public ResponseEntity<VidaEkycResponseDto> getEkycStatus(String ekycEventId) {

		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKycStatus");
		ResponseEntity<VidaEkycResponseDto> vidaEkycStatusResponseDto = null;
		
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKycStatus : event Id received : "+ ekycEventId);
		
		//#1 Validation for the request received from controller
		vidaValidator.isValidRequest(ekycEventId);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKycStatus : request validated");
		
		//#2 VidaCommunicationService for all communication send to VIDA server
		long startTime=System.currentTimeMillis();
		vidaEkycStatusResponseDto = vidaCommunicationService.processEkycStatusRequest(ekycEventId);
		long endTime=System.currentTimeMillis();
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKycStatus : time taken by eKyc status service is : "+(endTime-startTime) + " ms");
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKycStatus : vidaEkycStatusResponseDto received from VIDA");

		//#3 VidaResponseHandler for all mapping related stuff for response if required before sending back it
		vidaEkycStatusResponseDto = vidaResponseHandler.prepareVidaEkycStatusResponse(vidaEkycStatusResponseDto);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEKycStatus : vidaEkycStatusResponseDto received after mapping");
		
		return vidaEkycStatusResponseDto;
	}

	@Override
	public ResponseEntity<VidaEkycDataResponseDto> getkycData(String ekycEventId) {
		
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getkycData");
		ResponseEntity<VidaEkycDataResponseDto> vidaEkycDataResponseDto = null;
		
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getkycData : event Id received : "+ ekycEventId);
		
		//#1 Validation for the request received from controller
		vidaValidator.isValidRequest(ekycEventId);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getkycData : request validated");
		
		//#2 VidaCommunicationService for all communication send to VIDA server
		long startTime=System.currentTimeMillis();
		vidaEkycDataResponseDto = vidaCommunicationService.processEkycDataRequest(ekycEventId);
		long endTime=System.currentTimeMillis();
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getkycData : time taken by eKyc status service is : "+(endTime-startTime) + " ms");
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getkycData : vidaEkycStatusResponseDto received from VIDA");

		//#3 VidaResponseHandler for all mapping related stuff for response if required before sending back it
		vidaEkycDataResponseDto = vidaResponseHandler.prepareVidaEkycDataResponse(vidaEkycDataResponseDto);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getkycData : vidaEkycStatusResponseDto received after mapping");
		
		return vidaEkycDataResponseDto;

	}

}
