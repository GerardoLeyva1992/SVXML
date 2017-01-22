package edu.uacm.controller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uacm.dao.AeropuertoDao;
import edu.uacm.domain.AeropuertoRepository;
import edu.uacm.domain.Aeropuertos;
import edu.uacm.domain.Aeropuertos.Aeropuerto;
import edu.uacm.domain.ObjectFactory;

@Controller
@RequestMapping("/posts")
public class PostController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AeropuertoDao dao;

    @Autowired
    private AeropuertoRepository repository;

    /*
    @RequestMapping(value="", method=RequestMethod.GET)
    public String listPosts(Model model,long idaeropuerto) {
    	//Aeropuerto a=dao.getById(idaeropuerto);
		log.debug("Entrando a DAOS");

    	model.addAttribute("posts", dao.getById(idaeropuerto));
        //model.addAttribute("posts", repository.findAll());
		log.debug("Saliendo de DAOS");

        return "posts/list2";
    }
    */
    
    @RequestMapping(value="", method=RequestMethod.GET)
    public String lisPosts(Model model) {
    //	Aeropuerto a=dao.getById(ideaeropuerto);
    	model.addAttribute("posts", repository.findAll());
      //  model.
    	return "posts/list";
    }
    @RequestMapping(value = "/ByIdC", method = RequestMethod.POST)
    public String ByIdC(Model model,@RequestParam("idaeropuerto") long idaeropuerto){
//    	Aeropuerto a=dao.getById(idaeropuerto);
    	model.addAttribute("posts", dao.getById(idaeropuerto));
    	return  "posts/list2";
    }
    
    /*
    @RequestMapping(value="/listPostsByID", method=RequestMethod.POST)
    public ModelAndView listPostsByID(@PathVariable long idaeropuerto) {
    	Aeropuerto a=dao.getById(idaeropuerto);
        return new ModelAndView("redirect:/posts/list2");
    }
    */
    
    @RequestMapping(value = "/{idaeropuerto}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long idaeropuerto) {
        repository.delete(idaeropuerto);
        return new ModelAndView("redirect:/posts");
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newProject() {
        return "posts/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("nombreaeropuerto") String nombreaeropuerto,
    		@RequestParam("ciudad") String ciudad,
    		@RequestParam("pais") String pais) throws JAXBException {
		log.debug("Entrando a AeropuertoXML Insertar");

		Aeropuertos aeropuertos = new ObjectFactory().createAeropuertos();

        Aeropuerto post=new Aeropuerto();;
        post.setNombreaeropuerto(nombreaeropuerto);
        post.setCiudad(ciudad);
        post.setPais(pais);
    	aeropuertos.getAeropuerto();//Si la lista es null, crea un ArrayList
		aeropuertos.aeropuerto.add(post);
		repository.save(post);
		JAXBContext jaxbContext = JAXBContext.newInstance(Aeropuertos.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(aeropuertos, System.out);

		jaxbMarshaller.marshal(aeropuertos, new File("src\\xmls\\Aeropuertos.xml"));
        return new ModelAndView("redirect:/posts");
    }
   

    
    
    
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("post_idaeropuerto") long idaeropuerto,
                               @RequestParam("nombreaeropuerto") String nombreaeropuerto,
                               @RequestParam("ciudad") String ciudad,
                               @RequestParam("pais") String pais) {
        Aeropuerto post = repository.findOne(idaeropuerto);
        post.setNombreaeropuerto(nombreaeropuerto);
        post.setCiudad(ciudad);
        post.setPais(pais);
        repository.save(post);
        return new ModelAndView("redirect:/posts");
    }

    @RequestMapping(value = "/{idaeropuerto}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long idaeropuerto,
                       Model model) {
        Aeropuerto post = repository.findOne(idaeropuerto);
        model.addAttribute("post", post);
        return "posts/edit";
    }
    
    @RequestMapping(value = "/new2", method = RequestMethod.GET)
    public String ById(Model model) {
        return "posts/new2";
    }

}
