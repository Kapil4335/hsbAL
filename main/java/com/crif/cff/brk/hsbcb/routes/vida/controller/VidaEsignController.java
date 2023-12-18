package com.crif.cff.brk.hsbcb.routes.vida.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignStatusResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaEsignService;

@RestController
@RequestMapping("/vida/api/v1")
public class VidaEsignController {

	private static final Logger LOGGER= LoggerFactory.getLogger(VidaEsignController.class);

	@Autowired
	private VidaEsignService vidaEsignService;

	@GetMapping (value ="/esign")//, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<VidaEsignResponseDto> getVidaEsign(@RequestParam(name ="raType", required = false) String raType, @RequestParam(name = "docType", required = false) String docType, @RequestBody VidaEsignRequestDto vidaEsignRequest)
	{
		LOGGER.debug( this.getClass().getSimpleName() + " : in esign controller calling /vida/api/v1/esign" );
		return vidaEsignService.getEsign(raType, docType, vidaEsignRequest);
	}
	
	@GetMapping ("/esign/status/{esignId}")
	public ResponseEntity<VidaEsignStatusResponseDto> getVidaEsignStatus(@PathVariable("esignId") String esignId)
	{
		LOGGER.debug( this.getClass().getSimpleName() + " : in esign controller calling /vida/api/v1/esign/status/{esignId}" );
		return vidaEsignService.getEsignStatus(esignId);
	}
}
