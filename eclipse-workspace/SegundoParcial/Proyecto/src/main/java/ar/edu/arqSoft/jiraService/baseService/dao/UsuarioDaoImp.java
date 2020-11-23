package ar.edu.arqSoft.jiraService.baseService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.arqSoft.jiraService.baseService.model.Usuario;
import ar.edu.arqSoft.jiraService.common.dao.*;

@Repository 
public class UsuarioDaoImp extends GenericDaoImp<Usuario, Long > implements UsuarioDao{
	
	public List<Usuario> FindByName (String nombre){

		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
        Root<Usuario> entity = criteria.from(Usuario.class);

        criteria.select(entity).where(builder.equal(entity.get("name"+" "+"lastName"), nombre));
        return em.createQuery(criteria).getResultList();
	}
}
