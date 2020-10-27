package ar.edu.ucc.arqSoft.trabajoPractico.baseService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.ucc.arqSoft.trabajoPractico.baseService.service.SocioService;

@Controller
@RequestMapping("/SOCIO")
public class SocioController {

	@Autowired
	private SocioService SocioService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SocioResponseDto register(@RequestBody SocioRequestDto request) {
		return SocioService.registerSocio(request);
	}
}

