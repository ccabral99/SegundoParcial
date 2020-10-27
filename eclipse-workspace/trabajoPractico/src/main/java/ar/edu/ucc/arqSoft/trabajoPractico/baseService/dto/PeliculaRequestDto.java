package ar.edu.ucc.arqSoft.trabajoPractico.baseService.dto;

import ar.edu.ucc.arqSoft.trabajoPractico.baseService.model.Genero;
import ar.edu.ucc.arqSoft.trabajoPractico.common.dto.DtoEntity;


public class PeliculaRequestDto implements DtoEntity {

	 
	private String titulo;

	private Genero genero;

	private String sinopsis;

	private String anio;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	

}