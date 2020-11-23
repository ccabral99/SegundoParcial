package ar.edu.arqSoft.jiraService.baseService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.arqSoft.jiraService.baseService.model.Proyecto;
import ar.edu.arqSoft.jiraService.common.dao.GenericDaoImp;

@Repository
public class ProyectoDaoImp extends GenericDaoImp<Proyecto, Long > implements ProyectoDao{
	
	public List<Proyecto> FindByName (String nombre){

		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Proyecto> criteria = builder.createQuery(Proyecto.class);
        Root<Proyecto> entity = criteria.from(Proyecto.class);

        criteria.select(entity).where(builder.equal(entity.get("name"), nombre));
        return em.createQuery(criteria).getResultList();
	}
	
	
}

