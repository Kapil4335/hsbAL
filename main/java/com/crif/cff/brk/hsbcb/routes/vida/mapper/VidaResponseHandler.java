package com.crif.cff.brk.hsbcb.routes.vida.mapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycDataResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignStatusResponseDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrResponseDto;

@Component
public class VidaResponseHandler {

	public VidaEkycResponseDto prepareVidaEkycResponse(VidaEkycResponseDto vidaEkycResponseDto)
	{
		return vidaEkycResponseDto; 
	}
	
	public ResponseEntity<VidaEkycResponseDto> prepareVidaEkycStatusResponse(ResponseEntity<VidaEkycResponseDto> vidaEkycResponseDto)
	{
		return vidaEkycResponseDto; 
	}

	public ResponseEntity<VidaEkycDataResponseDto> prepareVidaEkycDataResponse(ResponseEntity<VidaEkycDataResponseDto> vidaEkycDataResponseDto) 
	{	
		return vidaEkycDataResponseDto;
	}

	public ResponseEntity<VidaOcrResponseDto> prepareVidaOcrResponse(ResponseEntity<VidaOcrResponseDto> vidaOcrResponseDto) 
	{
		return vidaOcrResponseDto;
	}

	public ResponseEntity<VidaEsignResponseDto> prepareVidaEsignResponse(ResponseEntity<VidaEsignResponseDto> vidaEsignResponseDto) 
	{
		return vidaEsignResponseDto;
	}

	public ResponseEntity<VidaEsignStatusResponseDto> prepareVidaEsignStatusResponse(ResponseEntity<VidaEsignStatusResponseDto> vidaEsignStatusResponseDto) 
	{
		return vidaEsignStatusResponseDto;
	}
}
