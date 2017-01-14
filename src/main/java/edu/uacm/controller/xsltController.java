package edu.uacm.controller;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/xslt")
public class xsltController {
	 @RequestMapping(value="/aeropuertos", method = RequestMethod.GET)
	    public String newProject() {
			try{
				TransformerFactory tff=TransformerFactory.newInstance();
				Transformer tf=tff.newTransformer(new StreamSource(new File("src\\main\\java\\data\\aeropuertos.xslt")));
				StreamSource ss=new StreamSource(new File("src\\xmls\\aeropuertos.xml"));
				StreamResult sr=new StreamResult(new File("src\\main\\resources\\templates\\xslt\\aeropuertos.html"));
				tf.transform(ss,sr);
				System.out.print("Logrado");
			} 
			catch(Exception e){
				System.out.print(e.getMessage());
				
			}
	        return "xslt/aeropuertos";
	    }

}
