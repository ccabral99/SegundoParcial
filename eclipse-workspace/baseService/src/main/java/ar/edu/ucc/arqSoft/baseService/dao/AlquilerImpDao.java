package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.baseService.model.Alquiler;
import ar.edu.ucc.arqSoft.common.dao.GenericDaoImp;

@Repository
public class AlquilerImpDao extends GenericDaoImp<Alquiler, Long> implements AlquilerDao{

@Override
public List<Alquiler> findByfechaAlquiler(Date fechaAlquiler) {
	CriteriaBuilder builder = em.getCriteriaBuilder();
	CriteriaQuery<Alquiler> criteria = builder.createQuery(Alquiler.class);
	Root<Alquiler> entity = criteria.from(Alquiler.class);

	criteria.select(entity).where(builder.equal(entity.get("fechaAlquiler"), fechaAlquiler));
	return em.createQuery(criteria).getResultList();
}
}