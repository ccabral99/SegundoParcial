package ar.edu.ucc.arqSoft.trabajoPractico.baseService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.trabajoPractico.baseService.dao.PeliculaDao;
import ar.edu.ucc.arqSoft.trabajoPractico.baseService.dto.PeliculaResponseDto;
import ar.edu.ucc.arqSoft.trabajoPractico.baseService.model.Pelicula;
import ar.edu.ucc.arqSoft.trabajoPractico.common.dto.ModelDtoConverter;


@Service
@Transactional
public class PeliculaService {
	
	@Autowired
	private PeliculaDao PeliculaDao;

    
	public PeliculaResponseDto getPeliculaById(Long id) {
       Pelicula pelicula = Pelicula.load(id);
		
		PeliculaResponseDto dto = new PeliculaResponseDto();
		
		dto.setTitulo(pelicula.getTitulo());
		dto.setGenero(pelicula.getGenero());
		dto.setSinopsis(pelicula.getSinopsis());
		dto.setAnio(pelicula.getAnio());

		return dto;
		
	}
	

	

	public List<PeliculaResponseDto> getAllMovies() {
		List<Pelicula> peliculas = PeliculaDao.getAll();

		List<PeliculaResponseDto> response = new ArrayList<PeliculaResponseDto>();

		for (Pelicula pelicula : peliculas) {
			response.add((PeliculaResponseDto) new ModelDtoConverter().convertToDto(movie, new MovieResponseDto()));
		}

		return response;
	}
}
