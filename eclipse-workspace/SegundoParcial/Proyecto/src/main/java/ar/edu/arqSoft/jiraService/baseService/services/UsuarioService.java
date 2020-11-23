package ar.edu.arqSoft.jiraService.baseService.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.arqSoft.jiraService.baseService.dao.UsuarioDao;
import ar.edu.arqSoft.jiraService.baseService.dto.UsuarioRequestDto;
import ar.edu.arqSoft.jiraService.baseService.dto.UsuarioResponseDto;
import ar.edu.arqSoft.jiraService.baseService.model.Usuario;
import ar.edu.arqSoft.jiraService.common.dto.ModelDtoConverter;

@Service
@Transactional
public class UsuarioService {

	private UsuarioDao usuarioDao;
	
	public UsuarioResponseDto insertUsuario(UsuarioRequestDto request){
		
		Usuario usuario = (Usuario) new ModelDtoConverter().convertToEntity(new Usuario(), request);
		
		usuarioDao.insert(usuario);
		
		UsuarioResponseDto response = new UsuarioResponseDto();
		
		response.setName(usuario.getName());
		response.setLastName(usuario.getLastName());
		response.setEmail(usuario.getEmail());
		
		
		return response;
	}
	
	public UsuarioResponseDto getUsuarioByName(String name) {
		
		Usuario usuario = (Usuario) usuarioDao.FindByName(name);
				
		UsuarioResponseDto response = (UsuarioResponseDto) new ModelDtoConverter().convertToDto(usuario, new UsuarioResponseDto());	
		return response;
	}
	
	public UsuarioResponseDto getUsuarioById(Long id) {
        
		Usuario usuario = usuarioDao.load(id);
				
		UsuarioResponseDto response = (UsuarioResponseDto) new ModelDtoConverter().convertToDto(usuario, new UsuarioResponseDto());	
		return response;
	}
	
	public List<UsuarioResponseDto> getAllUsuarios() {
		
		List<Usuario> usuarios = usuarioDao.getAll();
		
		List<UsuarioResponseDto> response = new ArrayList<UsuarioResponseDto>();
		 
		for (Usuario usuario : usuarios) {
			response.add((UsuarioResponseDto) new ModelDtoConverter().convertToDto(usuario, new UsuarioResponseDto()));
		}
		
		return response;
	}
	
}