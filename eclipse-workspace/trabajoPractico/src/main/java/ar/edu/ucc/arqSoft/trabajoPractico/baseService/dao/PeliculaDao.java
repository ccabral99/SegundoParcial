package ar.edu.ucc.arqSoft.trabajoPractico.baseService.dao;

//import java.util.List;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.trabajoPractico.baseService.model.Pelicula;
import ar.edu.ucc.arqSoft.trabajoPractico.common.dao.GenericDao;


@Repository
public interface PeliculaDao extends GenericDao<Pelicula, Long> {
    
    //public List<Pelicula> findByName(String titulo);
}
