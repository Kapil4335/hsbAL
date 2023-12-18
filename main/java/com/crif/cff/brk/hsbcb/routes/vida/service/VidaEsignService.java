package com.crif.cff.brk.hsbcb.routes.vida.service;

import org.springframework.http.ResponseEntity;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignStatusResponseDto;

public interface VidaEsignService {

	ResponseEntity<VidaEsignResponseDto> getEsign(String raType, String docType, VidaEsignRequestDto viaEsignRequest);

	ResponseEntity<VidaEsignStatusResponseDto> getEsignStatus(String esignId);

}
