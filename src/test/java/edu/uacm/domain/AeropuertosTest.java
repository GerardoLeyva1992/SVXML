package edu.uacm.domain;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.uacm.Application;
import edu.uacm.dao.AeropuertoDao;
import edu.uacm.domain.Aeropuertos.Aeropuerto;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
@WebAppConfiguration
public class AeropuertosTest {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	AeropuertoDao dao;
	@Autowired
	AeropuertoRepository ar;
	
	@Test
	public void TripulacionInsertar(){
	
		log.debug("objeto: "+dao.getById(500L).toString());
	//	Aeropuertos aeropuertos = new ObjectFactory().createAeropuertos();
/*
		Aeropuerto a=new Aeropuerto();
		a.setCiudad("a");
		a.setNombreaeropuerto("as");
		a.setPais("mex");
		aeropuertos.getAeropuerto();//Si la lista es null, crea un ArrayList
		aeropuertos.aeropuerto.add(a);
		ar.save(a);
		
	*/
		//System.out.println("Aeroloco"+a.getNombreaeropuerto());
		
		
		//Tripulacion t=new Tripulacion();
		//tr.findAll();
		//Assert.assertNotNull(a);	
		//*/
	}	

}