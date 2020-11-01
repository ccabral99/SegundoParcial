package ar.edu.ucc.arqSoft.baseService.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.ucc.arqSoft.baseService.dao.SocioDao;
import ar.edu.ucc.arqSoft.baseService.dto.SocioRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.SocioResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.Socio;



@Service
@Transactional
public class SocioService {
	
	@Autowired
	private SocioDao socioDao;

public SocioResponseDto registrarSocio (SocioRequestDto request) throws Exception {
		
		Socio socio = new Socio();
		
		socio.setNombre(request.getNombre());
		socio.setApellido(request.getApellido());
		socio.setDni(request.getDni());
		socio.setEmail(request.getEmail());
		
		socioDao.insert(socio);
		
		SocioResponseDto response = new SocioResponseDto();
		
		response.setNombre(socio.getNombre());
		response.setApellido(socio.getApellido());
		response.setEmail(socio.getEmail());
		response.setDni(socio.getDni());
		
		return response;
	}

}

