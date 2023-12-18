package com.crif.cff.brk.hsbcb.routes.vida.service;

import org.springframework.http.ResponseEntity;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycDataResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycResponseDto;

public interface VidaEkycService {

	public VidaEkycResponseDto getEkyc(VidaEkycRequestDto vidaEkycRequest);
	
	public ResponseEntity<VidaEkycResponseDto> getEkycStatus(String ekycEventId);

	public ResponseEntity<VidaEkycDataResponseDto> getkycData(String ekycEventId);
	
}
