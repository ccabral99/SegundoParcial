package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.Date;
import java.util.List;

import ar.edu.ucc.arqSoft.baseService.model.Alquiler;
import ar.edu.ucc.arqSoft.common.dao.GenericDao;

public interface AlquilerDao extends GenericDao<Alquiler, Long> {
	
	public List<Alquiler> findByfechaAlquiler(Date fechaAlquiler);

}
