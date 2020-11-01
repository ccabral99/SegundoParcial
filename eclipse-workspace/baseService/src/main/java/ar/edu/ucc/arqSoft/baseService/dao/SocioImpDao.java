package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.baseService.model.Socio;
import ar.edu.ucc.arqSoft.common.dao.GenericDaoImp;

@Repository
public class SocioImpDao extends GenericDaoImp<Socio, Long> implements SocioDao{

	@Override
	public List<Socio> findByName(String name) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Socio> criteria = builder.createQuery(Socio.class);
        Root<Socio> entity = criteria.from(Socio.class);

        criteria.select(entity).where(builder.equal(entity.get("name"), name));
        return em.createQuery(criteria).getResultList();
	}
}
