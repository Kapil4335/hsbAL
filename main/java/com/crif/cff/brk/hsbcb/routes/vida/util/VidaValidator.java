package com.crif.cff.brk.hsbcb.routes.vida.util;

import org.springframework.stereotype.Component;

import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEkycRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaEsignRequestDto;
import com.crif.cff.brk.hsbcb.routes.vida.dto.VidaOcrRequestDto;

@Component
public class VidaValidator {

	public boolean isValidRequest(String request)
	{
		if(request != null)
			return true;
		else 
			throw new NullPointerException("request is null");
	}

	public boolean isValidRequest(VidaEkycRequestDto vidaEkycRequest) {
		
		if(vidaEkycRequest != null)
			return true;
		else 
			throw new NullPointerException("request is null");
	}

	public boolean isValidRequest(VidaOcrRequestDto vidaOcrRequest) { 
		
		if(vidaOcrRequest != null)
			return true;
		else 
			throw new NullPointerException("request is null");
		
	}

	public boolean isValidRequest(VidaEsignRequestDto vidaEsignRequest) {
		
		if(vidaEsignRequest != null)
			return true;
		else 
			throw new NullPointerException("request is null");
		
	}
}
