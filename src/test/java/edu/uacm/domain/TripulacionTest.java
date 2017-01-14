package edu.uacm.domain;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.uacm.Application;
import edu.uacm.domain.Tripulacion;
import edu.uacm.domain.TripulacionRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
@WebAppConfiguration
public class TripulacionTest {

	@Autowired
	TripulacionRepository tr;

	@Test
	public void TripulacionInsertar(){
		Tripulacion t=new Tripulacion();
		t.setEmpleado_codigo(419L);
		t.setVuelo_idvuelo(4140L);
		t.setPuesto("Capitan");
		tr.save(t);
		Assert.assertNotNull(t);
	
		
	
		
		
	}	

}