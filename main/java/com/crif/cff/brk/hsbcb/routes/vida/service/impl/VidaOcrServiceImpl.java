package com.crif.cff.brk.hsbcb.routes.vida.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.mapper.VidaRequestHandler;
import com.crif.cff.brk.hsbcb.routes.vida.mapper.VidaResponseHandler;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaCommunicationService;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaOcrService;
import com.crif.cff.brk.hsbcb.routes.vida.util.VidaValidator;

@Service
public class VidaOcrServiceImpl implements VidaOcrService{

	private static final Logger LOGGER= LoggerFactory.getLogger(VidaOcrServiceImpl.class);
	
	@Autowired
	VidaCommunicationService vidaCommunicationService;
	
	@Autowired
	VidaRequestHandler vidaRequestHandler;

	@Autowired
	VidaResponseHandler vidaResponseHandler;
	
	@Autowired
	VidaValidator vidaValidator;
	
	@Override
	public ResponseEntity<VidaOcrResponseDto> getOcr(VidaOcrRequestDto vidaOcrRequest) {
		
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getOcr");
		ResponseEntity<VidaOcrResponseDto> vidaOcrResponseDto = null;
		
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getOcr : request received : \n"+ vidaOcrRequest);
		System.out.println( this.getClass().getSimpleName() + " : inside getOcr : request received : \n"+ vidaOcrRequest);
		
		vidaValidator.isValidRequest(vidaOcrRequest);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getOcr : request validated");
		
		VidaOcrRequestDto vidaOcrRequestDto=vidaRequestHandler.prepareVidaOcrRequest(vidaOcrRequest);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getOcr : vidaOcrRequestDto received");
		
		long startTime=System.currentTimeMillis();
		vidaOcrResponseDto = vidaCommunicationService.processOcrRequest(vidaOcrRequestDto);
		long endTime=System.currentTimeMillis();
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getEsign : time taken by Ocr service is : "+(endTime-startTime) + " ms");
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getOcr : vidaOcrResponseDto received from VIDA");

		vidaOcrResponseDto = vidaResponseHandler.prepareVidaOcrResponse(vidaOcrResponseDto);
		LOGGER.debug( this.getClass().getSimpleName() + " : inside getOcr : vidaOcrResponseDto received after mapping");
		
		return vidaOcrResponseDto;
	}
}
