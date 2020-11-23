package ar.edu.arqSoft.jiraService.baseService.dao;

import org.springframework.stereotype.Repository;
import ar.edu.arqSoft.jiraService.baseService.model.Comentario;
import ar.edu.arqSoft.jiraService.common.dao.GenericDaoImp;

@Repository
public class ComentarioDaoImp extends GenericDaoImp<Comentario, Long> implements ComentarioDao{
	
}