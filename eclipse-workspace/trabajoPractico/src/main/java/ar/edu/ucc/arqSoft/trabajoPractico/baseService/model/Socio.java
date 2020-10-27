package ar.edu.ucc.arqSoft.trabajoPractico.baseService.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import ar.edu.ucc.arqSoft.trabajoPractico.common.model.GenericObject;
@Entity
@Table(name = "SOCIO")
public class Socio extends GenericObject {
   
	@NotNull
	@Size(min = 1, max = 400)
	@Column(name = "NOMBRE")
	private String nombre;
	
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "APELLIDO")
	private String apellido;
	
	@NotNull
	@Size(min = 1, max = 12)
	@Column(name = "DNI")
	private String dni;
	
	@NotNull
	@Size(min = 1, max = 400)
	@Column(name = "EmAIL")
	private String email;
	
	@OneToMany(mappedBy="socio", fetch = FetchType.LAZY)
	private Set<Alquiler> alquilers;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Alquiler> getAlquilers() {
		return alquilers;
	}

	public void setAlquilers(Set<Alquiler> alquilers) {
		this.alquilers = alquilers;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	

}