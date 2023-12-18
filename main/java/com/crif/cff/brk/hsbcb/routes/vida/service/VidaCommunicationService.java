package com.crif.cff.brk.hsbcb.routes.vida.service;

import org.springframework.http.ResponseEntity;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycDataResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignStatusResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrResponseDto;

public interface VidaCommunicationService {
	
	VidaEkycResponseDto processEkycRequest(VidaEkycRequestDto vidaEkycRequestDto);
	
	ResponseEntity<VidaEkycResponseDto> processEkycStatusRequest(String ekycEventId);

	ResponseEntity<VidaEkycDataResponseDto> processEkycDataRequest(String ekycEventId);

	ResponseEntity<VidaOcrResponseDto> processOcrRequest(VidaOcrRequestDto ocrRequest);
	
	ResponseEntity<VidaEsignResponseDto> processEsignRequest(VidaEsignRequestDto vidaEsignRequestDto, String raType, String docType);

	ResponseEntity<VidaEsignStatusResponseDto> processEsignStatusRequest(String esignId);
	
}
