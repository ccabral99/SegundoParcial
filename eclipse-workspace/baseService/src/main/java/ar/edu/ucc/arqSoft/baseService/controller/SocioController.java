package ar.edu.ucc.arqSoft.baseService.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.ucc.arqSoft.baseService.dto.SocioRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.SocioResponseDto;
import ar.edu.ucc.arqSoft.baseService.service.SocioService;

@Controller
@RequestMapping("/socio")
public class SocioController {
	
	@Autowired
    private SocioService socioService;
	
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody SocioResponseDto Registrar (@RequestBody SocioRequestDto request) throws Exception {
		 
		 return socioService.registrarSocio(request);
		 
	 }

//    @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody List<SocioResponseDto> getAllStates()
//    {
//        return socioService.getAllSocio();
//    }
//
//    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody SocioResponseDto lookupStateById(@PathVariable("id") Long id)
//    {
//        //return stateService.getStateById(id);
//    	return null;
//    }
//    
//    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody SocioResponseDto saveSatate(@RequestBody SocioRequestDto request)
//    {
//        return SocioService.insert(request);
//    }
}
