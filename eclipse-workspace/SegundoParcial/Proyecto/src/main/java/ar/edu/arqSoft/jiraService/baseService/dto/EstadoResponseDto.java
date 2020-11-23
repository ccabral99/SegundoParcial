package ar.edu.arqSoft.jiraService.baseService.dto;

import ar.edu.arqSoft.jiraService.common.dto.*;

public class EstadoResponseDto implements DtoEntity{
	
	private String name;
	
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}