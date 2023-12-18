package com.crif.cff.brk.hsbcb.routes.vida.mapper;

import org.springframework.stereotype.Component;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrRequestDto;

@Component
public class VidaRequestHandler {

	public VidaEkycRequestDto prepareVidaEkycRequest(VidaEkycRequestDto vidaEkycRequest)
	{
		return vidaEkycRequest; 
	}
	
	public VidaOcrRequestDto prepareVidaOcrRequest(VidaOcrRequestDto vidaOcrRequest)
	{
		return vidaOcrRequest; 
	}

	public VidaEsignRequestDto prepareVidaEsignRequest(VidaEsignRequestDto vidaEsignRequest) 
	{
		return vidaEsignRequest; 
	}
}
