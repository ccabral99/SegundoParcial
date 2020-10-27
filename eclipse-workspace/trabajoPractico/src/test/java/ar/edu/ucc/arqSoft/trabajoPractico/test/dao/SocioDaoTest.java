package ar.edu.ucc.arqSoft.trabajoPractico.test.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.trabajoPractico.baseService.dao.SocioDao;
import ar.edu.ucc.arqSoft.trabajoPractico.baseService.model.Socio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath: spring/applicationContext.xml" })
@Transactional
public class SocioDaoTest {

	private static final Logger Logger = LogManager.getLogger(SocioDaoTest.class);
	
	@Autowired
	private SocioDao socioDao;
	
	@Test
	public void testfindById() {
		Logger.info("Test de busqueda de Socio por ID");
		Socio socio = socioDao.load((long) 2);
		Assert.assertEquals("Juan", socio.getNombre());
		
	}
	
	@Test
	public void testRegister() {
		Logger.info("Test de busqueda de Socio por ID");
		Socio socio = new Socio();
		socio.setNombre("Camila");
		socio.setApellido("Cabral");
		socio.setDni("42159014");
		socioDao.insert(socio);
		Assert.assertEquals(3, socio.getId().longValue());
		return;
		
		
	}
	
	@Test
	public void GetAll() {
		
	}
}


















