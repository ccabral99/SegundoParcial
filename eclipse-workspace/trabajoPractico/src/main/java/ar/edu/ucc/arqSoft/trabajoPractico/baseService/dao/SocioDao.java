package ar.edu.ucc.arqSoft.trabajoPractico.baseService.dao;

import org.springframework.stereotype.Repository;

//import java.util.List;

import ar.edu.ucc.arqSoft.trabajoPractico.baseService.model.Socio;
import ar.edu.ucc.arqSoft.trabajoPractico.common.dao.GenericDao;

@Repository
public interface SocioDao  extends GenericDao<Socio, Long> {
    
   // public List<Socio> findByName(String name);

}