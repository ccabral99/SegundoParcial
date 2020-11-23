package ar.edu.arqSoft.jiraService.baseService.dao;

import java.util.List;

import ar.edu.arqSoft.jiraService.baseService.model.Tarea;
import ar.edu.arqSoft.jiraService.common.dao.*;

public interface TareaDao extends GenericDao<Tarea, Long>{
	
	public List<Tarea> FindByName (String nombre);
	
}