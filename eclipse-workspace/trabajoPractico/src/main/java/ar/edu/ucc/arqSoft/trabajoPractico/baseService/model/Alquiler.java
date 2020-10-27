package ar.edu.ucc.arqSoft.trabajoPractico.baseService.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import ar.edu.ucc.arqSoft.trabajoPractico.common.model.GenericObject;



@Entity
@Table(name = "ALQUILER")
public class Alquiler extends GenericObject{
 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PELICULA_ID")
	private Pelicula pelicula;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="SOCIO_ID")
	private Socio socio;
	
	@NotNull
	@Column(name="FECHA_ALQUILER")
	private Date FechaAlquiler;

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Date getFechaAlquiler() {
		return FechaAlquiler;
	}

	public void setFechaAlquiler(Date fechaAlquiler) {
		FechaAlquiler = fechaAlquiler;
	}

	
	
	
}
