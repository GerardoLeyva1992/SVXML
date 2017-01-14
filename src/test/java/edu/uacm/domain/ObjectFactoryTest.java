package edu.uacm.domain;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.uacm.Application;
import edu.uacm.domain.Aeropuertos.Aeropuerto;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
@WebAppConfiguration
public class ObjectFactoryTest {
	@Autowired
	AeropuertoRepository ae;
	@Test
	public void testCreateClientes() throws JAXBException {
		Aeropuertos aeropuertos = new ObjectFactory().createAeropuertos();
	
		Aeropuerto aero = new Aeropuerto();
		aero.setNombreaeropuerto("Aero");
		aero.setCiudad("s");
		aero.setPais("ss");
		
		aeropuertos.getAeropuerto();//Si la lista es null, crea un ArrayList
		ae.save(aero);
		
		aeropuertos.aeropuerto.add(aero);
		
		Aeropuerto cliente2 = new Aeropuerto();
		cliente2.setNombreaeropuerto("LALALA");
		cliente2.setCiudad("s");
		cliente2.setPais("ss");
		aeropuertos.aeropuerto.add(cliente2);
		ae.save(cliente2);
		JAXBContext jaxbContext = JAXBContext.newInstance(Aeropuertos.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		jaxbMarshaller.marshal(aeropuertos, System.out);
		
		jaxbMarshaller.marshal(aeropuertos, new File("C:/Users/GerardoPC/Desktop/SVXML/src/main/java/data/prueba.xml"));
	}
}
