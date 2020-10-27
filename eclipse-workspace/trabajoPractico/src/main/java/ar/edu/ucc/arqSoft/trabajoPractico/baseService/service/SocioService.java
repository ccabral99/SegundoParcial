package ar.edu.ucc.arqSoft.trabajoPractico.baseService.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ucc.arqSoft.trabajoPractico.baseService.dao.SocioDao;
import ar.edu.ucc.arqSoft.trabajoPractico.baseService.dto.SocioRequestDto;
import ar.edu.ucc.arqSoft.trabajoPractico.baseService.dto.SocioResponseDto;
import ar.edu.ucc.arqSoft.trabajoPractico.baseService.model.Socio;

@Service
@Transactional
public class SocioService {
	
	@Autowired
	private SocioDao SocioDao;

	public SocioResponseDto registerMember(SocioRequestDto dto) {

		Socio socio = new Socio();

	    SocioDao.insert(socio);

		SocioResponseDto response = new SocioResponseDto();

		response.setNombre(socio.getNombre());
		response.setApellido(socio.getApellido());
		response.setDni(socio.getDni());
		response.setEmail(socio.getEmail());

		return response;

	}
	
	

}
