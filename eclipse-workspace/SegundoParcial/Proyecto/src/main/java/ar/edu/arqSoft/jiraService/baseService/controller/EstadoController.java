package ar.edu.arqSoft.jiraService.baseService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import ar.edu.arqSoft.jiraService.baseService.dto.EstadoResponseDto;
import ar.edu.arqSoft.jiraService.baseService.services.EstadoService;
import ar.edu.arqSoft.jiraService.common.exception.EntityNotFoundException;



@Controller
@RequestMapping("/estado")
public class EstadoController{
	
	@Autowired
	private EstadoService estadoService;

    @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<EstadoResponseDto> getAllEstado()
    {
        return EstadoService.getAllEstado();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody EstadoResponseDto lookupEstadoById(@PathVariable("id") Long id) throws EntityNotFoundException
    {
        return estadoService.getEstadoById(id);
    }
}