package ar.edu.arqSoft.jiraService.baseService.dao;

import java.util.List;

import ar.edu.arqSoft.jiraService.baseService.model.Proyecto;
import ar.edu.arqSoft.jiraService.common.dao.GenericDao;

public interface ProyectoDao extends GenericDao<Proyecto, Long>{
	
	public List<Proyecto> FindByName (String nombre);
}