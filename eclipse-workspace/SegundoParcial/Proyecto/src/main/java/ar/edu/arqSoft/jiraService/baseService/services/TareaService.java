package ar.edu.arqSoft.jiraService.baseService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.jiraService.baseService.dao.ProyectoDao;
import ar.edu.arqSoft.jiraService.baseService.dao.EstadoDao;
import ar.edu.arqSoft.jiraService.baseService.dao.TareaDao;
import ar.edu.arqSoft.jiraService.baseService.dao.UsuarioDao;
import ar.edu.arqSoft.jiraService.baseService.dto.TareaRequestDto;
import ar.edu.arqSoft.jiraService.baseService.dto.TareaResponseDto;
import ar.edu.arqSoft.jiraService.baseService.model.Tarea;
import ar.edu.arqSoft.jiraService.common.dto.*;
import ar.edu.arqSoft.jiraService.common.exception.BadRequestException;
import ar.edu.arqSoft.jiraService.common.exception.EntityNotFoundException;

@Service
@Transactional
public class TareaService {

	@Autowired
	private TareaDao tareaDao;
	
	@Autowired
	private EstadoDao estadoDao;
	
 public TareaResponseDto insertTarea(TareaRequestDto request){
		
		Tarea tarea = (Tarea) new ModelDtoConverter().convertToEntity(new Tarea(), request);
		
		tareaDao.insert(tarea);
		
		TareaResponseDto response = new TareaResponseDto();
		
		response.setId(tarea.getId());
		response.setName(tarea.getName());
		response.setDescription(tarea.getDescription());
		response.setIdUsuario(tarea.getUsuarios().getId());
		response.setProyecto(tarea.getProyecto().getId());
		response.setEstado(tarea.getEstado().getId());
		
		
		return response;
	}
 
 
 public List<TareaResponseDto> getAllTareas() {
		List<Tarea> tareas = tareaDao.getAll();
		
		List<TareaResponseDto> response = new ArrayList<TareaResponseDto>();
		 
		for (Tarea tarea : tareas) {
			response.add((TareaResponseDto) new ModelDtoConverter().convertToDto(tarea, new TareaResponseDto()));
		}
		
		return response;
	}
 
 public TareaResponseDto getTareaByName(String name) {
		
		Tarea tarea = (Tarea) tareaDao.FindByName(name);
				
		TareaResponseDto response = (TareaResponseDto) new ModelDtoConverter().convertToDto(tarea, new TareaResponseDto());	
		return response;
	}
 
 
 public TareaResponseDto getTareaById(Long id) {
		Tarea tarea = tareaDao.load(id);
				
		TareaResponseDto response = (TareaResponseDto) new ModelDtoConverter().convertToDto(tarea, new TareaResponseDto());	
		return response;
	}
 
 public TareaResponseDto cambioEstado(Long id, Long request) {
		Tarea tarea = tareaDao.load(id);

		tarea.setEstado(estadoDao.load(request));
		tareaDao.update(tarea);

		Tarea task_after_update = tareaDao.load(id);
		TareaResponseDto response = new TareaResponseDto();

		response.setId(task_after_update.getId());
		response.setName(task_after_update.getName());
		response.setDescription(task_after_update.getDescription());
		response.setIdUsuario(task_after_update.getUsuarios().getId());
		response.setProyecto(task_after_update.getProyecto().getId());
		response.setEstado(task_after_update.getEstado().getId());
		return response;
	}
 
	
}