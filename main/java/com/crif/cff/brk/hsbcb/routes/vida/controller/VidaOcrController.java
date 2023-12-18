package com.crif.cff.brk.hsbcb.routes.vida.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.service.VidaOcrService;

@RestController
@RequestMapping("/vida/api/v1")
public class VidaOcrController {

	private static final Logger LOGGER= LoggerFactory.getLogger(VidaOcrController.class);

	@Autowired
	private VidaOcrService vidaOCRService;

	@GetMapping("/ocr")
	public ResponseEntity<VidaOcrResponseDto> ocr(@RequestBody VidaOcrRequestDto vidaOcrRequest) {
		LOGGER.debug( this.getClass().getSimpleName() + " : in Ocr controller calling /vida/api/v1/ocr" );
		return vidaOCRService.getOcr(vidaOcrRequest);
	}

}
