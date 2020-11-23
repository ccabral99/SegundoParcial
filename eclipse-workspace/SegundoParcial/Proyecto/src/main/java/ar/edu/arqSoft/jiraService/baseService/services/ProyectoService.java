package ar.edu.arqSoft.jiraService.baseService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.jiraService.baseService.dao.ProyectoDao;
import ar.edu.arqSoft.jiraService.baseService.dao.TareaDao;
import ar.edu.arqSoft.jiraService.baseService.dao.UsuarioDao;
import ar.edu.arqSoft.jiraService.baseService.dto.ProyectoRequestDto;
import ar.edu.arqSoft.jiraService.baseService.dto.ProyectoResponseDto;
import ar.edu.arqSoft.jiraService.baseService.dto.TareaRequestDto;
import ar.edu.arqSoft.jiraService.baseService.dto.UsuarioRequestDto;
import ar.edu.arqSoft.jiraService.baseService.model.Proyecto;
import ar.edu.arqSoft.jiraService.common.dto.*;
import ar.edu.arqSoft.jiraService.common.exception.BadRequestException;
import ar.edu.arqSoft.jiraService.common.exception.EntityNotFoundException;

@Service
@Transactional
public class ProyectoService{
	
	@Autowired
	private ProyectoDao proyectoDao;
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private TareaDao tareaDao;
	
	public ProyectoResponseDto insertProyecto (ProyectoRequestDto request) throws BadRequestException, EntityNotFoundException {
		
		Proyecto proyecto= new Proyecto();
		
		proyecto.setName(request.getName());
		proyecto.setDescription(request.getDescription());
		proyecto.setStartDate(request.getStartDate());
		proyecto.setFinishDate(request.getFinishDate());
		
		proyectoDao.insert(proyecto);
		
		
	
		ProyectoResponseDto response = new ProyectoResponseDto();
		
		response.setName(proyecto.getName());
		response.setDescription(proyecto.getDescription());
		response.setStartDate(proyecto.getStartDate());
		response.setFinishDate(proyecto.getFinishDate());
		
		return response; 
		
	}
	
	public ProyectoResponseDto addUsuario (Long id, Long proyectoid)throws BadRequestException, EntityNotFoundException {
		if(proyectoid<=0)
		{
			throw new BadRequestException();
		}
	
		Proyecto proyecto = proyectoDao.load(proyectoid);
		
		proyecto.setUsuarios(usuarioDao.load(id.getId()));
		
		ProyectoResponseDto response = new ProyectoResponseDto();
		
		response = (ProyectoResponseDto) new ModelDtoConverter().convertToDto(proyecto,new ProyectoResponseDto());
		
		return response;
	}
	
	
	public ProyectoResponseDto addTarea (TareaRequestDto req, Long proyectoid) throws BadRequestException, EntityNotFoundException{
		if(proyectoid<=0)
		{
			throw new BadRequestException();
		}
		Proyecto proyecto = proyectoDao.load(proyectoid);
		
		proyecto.setTareas(tareaDao.load(req.getId()));
		
		ProyectoResponseDto response = new ProyectoResponseDto();
		
		response = (ProyectoResponseDto) new ModelDtoConverter().convertToDto(proyecto,new ProyectoResponseDto());
		
		return response;
	}
	
	
	public List<ProyectoResponseDto> GetByName(String name) throws BadRequestException, EntityNotFoundException{
		List<Proyecto> proyectos = proyectoDao.FindByName(name);
		
		List<ProyectoResponseDto> response = new ArrayList<ProyectoResponseDto>();
		for(Proyecto proyecto: proyectos) {
			if(proyecto.getId()<=0)
			{
				throw new BadRequestException();
			}
		response.add((ProyectoResponseDto) new ModelDtoConverter().convertToDto(proyecto,new ProyectoResponseDto()));
		}
		return response;
	}

	public List<ProyectoResponseDto> getAllProyecto() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProyectoResponseDto getProyectoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}