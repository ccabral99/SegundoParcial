package ar.edu.arqSoft.jiraService.baseService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.arqSoft.jiraService.common.model.GenericObject;


@Entity
@Table(name="COMENTARIO")
public class Comentario extends GenericObject{
	
	@NotNull
	@Size(min=1, max=250)
	@Column (name="DESCRIPTION")
	private String description;
	
	@Column(name="ESTADO_DEL_COMENTARIO") //VER
	private Boolean estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COMENTARIO_ID")
	private Tarea tarea;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COMENTARIO_ID")
	private Usuario usuario;

	public Tarea getTarea() {
		return tarea;
	}

	public static void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescription() {
		return description;
	}

	public static void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEstado() {
		return estado;
	}

	public static void setEstado(Boolean estado) {
		this.estado  = estado;
	}
	
	
}