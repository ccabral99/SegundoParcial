package ar.edu.arqSoft.jiraService.common.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import ar.edu.arqSoft.jiraService.baseService.model.Estado;
import ar.edu.arqSoft.jiraService.baseService.model.Proyecto;

@MappedSuperclass
public abstract class GenericObject {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Proyecto id;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Estado id1;

	public Proyecto getId() {
		return id;
	}

	public void setId(Proyecto id) {
		this.id = id;
	}

	public Estado getId1() {
		return id1;
	}

	public void setId1(Estado id1) {
		this.id1 = id1;
	}
	
	

	
		
}