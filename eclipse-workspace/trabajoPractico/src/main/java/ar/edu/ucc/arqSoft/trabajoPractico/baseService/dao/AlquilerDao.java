package ar.edu.ucc.arqSoft.trabajoPractico.baseService.dao;

import java.util.List;

import ar.edu.ucc.arqSoft.trabajoPractico.baseService.model.Alquiler;
import ar.edu.ucc.arqSoft.trabajoPractico.common.dao.GenericDao;

public interface AlquilerDao extends GenericDao<Alquiler, Long> {
    
    public List<Alquiler> findByfechaAlquiler(Float fechaAlquiler);
}
