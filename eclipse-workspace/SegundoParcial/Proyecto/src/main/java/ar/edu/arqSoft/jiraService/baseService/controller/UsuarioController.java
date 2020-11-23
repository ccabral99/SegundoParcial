package ar.edu.arqSoft.jiraService.baseService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import ar.edu.arqSoft.jiraService.baseService.services.UsuarioService;
import ar.edu.arqSoft.jiraService.common.dto.GenericExceptionDto;
import ar.edu.arqSoft.jiraService.common.exception.BadRequestException;
import ar.edu.arqSoft.jiraService.common.exception.EntityNotFoundException;
import ar.edu.arqSoft.jiraService.baseService.dto.UsuarioRequestDto;
import ar.edu.arqSoft.jiraService.baseService.dto.UsuarioResponseDto;


@Controller
@RequestMapping("/usuario")
public class UsuarioController{
	
	@Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UsuarioResponseDto> getAllUsuario()
    {
        return usuarioService.getAllUsuarios();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> lookupEstadoById(@PathVariable("id") Long id) throws EntityNotFoundException, BadRequestException
    {
        UsuarioResponseDto dto = usuarioService.getUsuarioById(id);
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody(code = HttpStatus.CREATED)
    public @ResponseBody UsuarioResponseDto saveSocio(@RequestBody UsuarioRequestDto request)
    {
        return usuarioService.insertUsuario(request);
    }
}