package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.baseService.model.Socio;
import ar.edu.ucc.arqSoft.common.dao.GenericDao;

@Repository
public interface SocioDao extends GenericDao<Socio, Long> {

	    public List<Socio> findByName(String name);
}
