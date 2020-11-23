package ar.edu.arqSoft.jiraService.baseService.dao;

import java.util.List;

import ar.edu.arqSoft.jiraService.baseService.model.Estado;
import ar.edu.arqSoft.jiraService.common.dao.GenericDao;

public interface EstadoDao extends GenericDao<Estado, Long>{

	public List<Estado> FindByName (String nombre);
}