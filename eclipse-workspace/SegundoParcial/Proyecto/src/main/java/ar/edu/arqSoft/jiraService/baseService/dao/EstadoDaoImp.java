package ar.edu.arqSoft.jiraService.baseService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.arqSoft.jiraService.baseService.model.Estado;
import ar.edu.arqSoft.jiraService.common.dao.GenericDaoImp;

@Repository
public class EstadoDaoImp extends GenericDaoImp<Estado, Long> implements EstadoDao{
	
	public List<Estado> FindByName (String nombre){

		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Estado> criteria = builder.createQuery(Estado.class);
        Root<Estado> entity = criteria.from(Estado.class);

        criteria.select(entity).where(builder.equal(entity.get("name"), nombre));
        return em.createQuery(criteria).getResultList();
	}
}