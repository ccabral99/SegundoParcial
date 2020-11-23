package ar.edu.arqSoft.jiraService.baseService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.jiraService.baseService.dao.EstadoDao;
import ar.edu.arqSoft.jiraService.baseService.dto.EstadoRequestDto;
import ar.edu.arqSoft.jiraService.baseService.dto.EstadoResponseDto;
import ar.edu.arqSoft.jiraService.baseService.model.Estado;
import ar.edu.arqSoft.jiraService.common.dto.ModelDtoConverter;
import ar.edu.arqSoft.jiraService.common.exception.BadRequestException;
import ar.edu.arqSoft.jiraService.common.exception.EntityNotFoundException;

@Service
@Transactional
public class EstadoService{
	
	@Autowired
	private EstadoDao estadoDao;
	
	public EstadoResponseDto insertEstado (EstadoRequestDto request){
		
		Estado estado = new Estado();
		
		estado.setName(request.getName());
		estado.setDescription(request.getDescription());
		
		estadoDao.insert(estado);
		
		EstadoResponseDto response = new EstadoResponseDto();
		
		response.setName(estado.getName());
		response.setDescription(estado.getDescription());		
		return response;
		
	}
	

	public List<EstadoResponseDto> GetByName(String name) throws EntityNotFoundException, BadRequestException {
		List<Estado> estados = estadoDao.FindByName(name);
		
		List<EstadoResponseDto> response = new ArrayList<EstadoResponseDto>();
		for(Estado estado: estados) 
		{
			if(estado.getId()<=0)
			{
				throw new BadRequestException();
			}
		response.add((EstadoResponseDto) new ModelDtoConverter().convertToDto(estado,new EstadoResponseDto()));
		}
		return response;
	}


	public static List<EstadoResponseDto> getAllEstado() {
		// TODO Auto-generated method stub
		return null;
	}


	public EstadoResponseDto getEstadoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}