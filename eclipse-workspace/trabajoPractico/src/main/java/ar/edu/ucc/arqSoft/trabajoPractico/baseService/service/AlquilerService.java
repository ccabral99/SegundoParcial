package ar.edu.ucc.arqSoft.trabajoPractico.baseService.service;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ucc.arqSoft.trabajoPractico.baseService.dao.AlquilerDao;
import ar.edu.ucc.arqSoft.trabajoPractico.baseService.dao.PeliculaDao;
import ar.edu.ucc.arqSoft.trabajoPractico.baseService.dao.SocioDao;
import ar.edu.ucc.arqSoft.trabajoPractico.baseService.dto.AlquilerRequestDto;
import ar.edu.ucc.arqSoft.trabajoPractico.baseService.dto.AlquilerResponseDto;
import ar.edu.ucc.arqSoft.trabajoPractico.baseService.model.Alquiler;

@Service
@Transactional
public class AlquilerService {
	
	@Autowired
	private AlquilerDao alquilerDao;
	
	@Autowired
	private PeliculaDao peliculaDao;
	
	@Autowired
	private SocioDao socioDao;
	
	
	public AlquilerResponseDto registrarAlquiler (AlquilerRequestDto dto) {
		
		Alquiler alquiler = new Alquiler();
		
		alquiler.setFechaAlquiler(Calendar.getInstance().getTime());
		alquiler.setPelicula(peliculaDao.load(dto.getPeliculaId()));
		alquiler.setSocio(socioDao.load(dto.getSocioId()));
		
		alquilerDao.insert(alquiler);
		
		AlquilerResponseDto response = new AlquilerResponseDto();
		
		response.setApellido(alquiler.getSocio().getApellido());
		response.setTitulo(alquiler.getPelicula().getTitulo());
		response.setFecha(alquiler.getFechaAlquiler());
		
		return response;
		
	}
	

	
}
