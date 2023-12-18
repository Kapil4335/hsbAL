package com.crif.cff.brk.hsbcb.routes.vida.service;

import org.springframework.http.ResponseEntity;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrResponseDto;

public interface VidaOcrService {

	public ResponseEntity<VidaOcrResponseDto> getOcr(VidaOcrRequestDto vidaOcrRequest);

}
