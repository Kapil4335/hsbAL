package com.crif.cff.brk.hsbcb.routes.vida.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycDataResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaEkycService;

@RestController
@RequestMapping("/vida/api/v1")
public class VidaEkycController {

	private static final Logger LOGGER= LoggerFactory.getLogger(VidaEkycController.class);

	@Autowired
	private VidaEkycService vidaEkycService;

	@GetMapping(value = "/ekyc")
	public ResponseEntity<VidaEkycResponseDto> eKyc(@RequestBody VidaEkycRequestDto vidaEkycRequest)
	{
		LOGGER.debug( this.getClass().getSimpleName() + " : in Ekyc controller calling /vida/api/v1/ekyc" );
		
		return ResponseEntity.ok().body(vidaEkycService.getEkyc(vidaEkycRequest));
		//return new ResponseEntity<>((vidaEkycService.getEkyc(vidaEkycRequest)),HttpStatus.OK);
		//return vidaEkycService.getEkyc(vidaEkycRequest);
	}

	@GetMapping("/ekyc/status/{eventId}")
	public ResponseEntity<VidaEkycResponseDto> ekycStatus(@PathVariable("eventId") String ekycEventId) 
	{
		LOGGER.debug( this.getClass().getSimpleName() + " : in Ekyc controller calling /vida/ekyc/status/{eventId}" );
		return vidaEkycService.getEkycStatus(ekycEventId);
	}

	@GetMapping("/ekyc/kycdata/{eventId}")
	public ResponseEntity<VidaEkycDataResponseDto> ekycData(@PathVariable("eventId") String ekycEventId) 
	{
		LOGGER.debug( this.getClass().getSimpleName() + " : in Ekyc controller calling /vida/ekyc/kycdata/{eventId}" );
		return vidaEkycService.getkycData(ekycEventId);
	}

}
