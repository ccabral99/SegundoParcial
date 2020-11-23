package ar.edu.arqSoft.jiraService.baseService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.jiraService.common.dto.ModelDtoConverter;
import ar.edu.arqSoft.jiraService.common.exception.BadRequestException;
import ar.edu.arqSoft.jiraService.common.exception.EntityNotFoundException;
import ar.edu.arqSoft.jiraService.baseService.dao.ComentarioDao;

import ar.edu.arqSoft.jiraService.baseService.dao.TareaDao;
import ar.edu.arqSoft.jiraService.baseService.dao.UsuarioDao;
import ar.edu.arqSoft.jiraService.baseService.dto.ComentarioResponseDto;
import ar.edu.arqSoft.jiraService.baseService.model.Comentario;
import ar.edu.arqSoft.jiraService.baseService.dto.ComentarioRequestDto;


@Service
@Transactional
public class ComentarioService{
	
	@Autowired
	private ComentarioDao comentarioDao;
	
	private TareaDao tareaDao;
	
	private UsuarioDao usuarioDao;
	
	public ComentarioResponseDto insertComentario (ComentarioRequestDto request) throws EntityNotFoundException, BadRequestException{
	
		Comentario comentario = new Comentario();
		
		Comentario.setDescription(request.getDescription());
		Comentario.setEstado(request.getEstado());
		Comentario.setUsuario(usuarioDao.load(request.getIdUsuario()));
		Comentario.setTarea(tareaDao.load(request.getIdTarea()));
		
		comentarioDao.insert(comentario);
		
		ComentarioResponseDto response = new ComentarioResponseDto();
		
		response.setDescription(comentario.getDescription());
		response.setEstado(comentario.getEstado());
		response.setUsuario(comentario.getUsuario());
		response.setTask(comentario.getTarea());
		
		return response;
		
	}
	
	
	public List<ComentarioResponseDto> getAll() throws EntityNotFoundException, BadRequestException{
		List<Comentario> Comentarios = comentarioDao.getAll();
		List<ComentarioResponseDto> response = new ArrayList<ComentarioResponseDto>();
		for (Comentario Comentario : Comentarios) {
			if (Comentario.getId() <= 0) {
				throw new BadRequestException();
			}
			response.add((ComentarioResponseDto) new ModelDtoConverter().convertToDto(Comentario, new ComentarioResponseDto()));
			}
		return response;
	}


	public List<ComentarioResponseDto> getAllComentario() {
		// TODO Auto-generated method stub
		return null;
	}


	public ComentarioResponseDto getComentarioById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}