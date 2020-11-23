package ar.edu.arqSoft.jiraService.baseService.dao;

import java.util.List;

import ar.edu.arqSoft.jiraService.baseService.model.Usuario;
import ar.edu.arqSoft.jiraService.common.dao.GenericDao;

public interface UsuarioDao extends GenericDao<Usuario, Long>{

	public List<Usuario> FindByName (String nombre);
}