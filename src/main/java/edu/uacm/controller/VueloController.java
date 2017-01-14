package edu.uacm.controller;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import edu.uacm.domain.Vuelo;
import edu.uacm.domain.VueloRepository;

@Controller
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private VueloRepository repository;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String listPosts(Model model) {
        model.addAttribute("vuelos", repository.findAll());
        return "vuelos/list";
    }
/*
    @RequestMapping(value = "/{idvuelo}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long idvuelo) {
        repository.delete(idvuelo);
        return new ModelAndView("redirect:/vuelos");
    }
  */  

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newProject() {
        return "vuelos/new";
    }
    
   // Timestamp d2 = new java.sql.Timestamp(0);
	//Timestamp d = new java.sql.Timestamp(0);
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("horasalida") Date horasalida,@RequestParam("horallegada") Date horallegada,@RequestParam("aeropuerto_idaeropuerto") Long aeropuerto_idaeropuerto,
    		@RequestParam("aeropuerto_idaeropuerto2") Long aeropuerto_idaeropuerto2,@RequestParam("avion_idavion") Long avion_idavion) {
        Vuelo post=new Vuelo();
        post.setHorallegada(horallegada);
        post.setHorasalida(horasalida);
		
        post.setAeropuerto_idaeropuerto(aeropuerto_idaeropuerto);
        post.setAeropuerto_idaeropuerto2(aeropuerto_idaeropuerto2);
        post.setAvion_idavion(avion_idavion);
        repository.save(post);
        return new ModelAndView("redirect:/vuelos");
    }

    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("post_idvuelo") long idvuelo,
    		@RequestParam("horasalida") Date horasalida,@RequestParam("horallegada") Date horallegada,@RequestParam("aeropuerto_idaeropuerto") Long aeropuerto_idaeropuerto,
    		@RequestParam("aeropuerto_idaeropuerto2") Long aeropuerto_idaeropuerto2,@RequestParam("avion_idavion") Long avion_idavion) {
        Vuelo post = repository.findOne(idvuelo);
        post.setHorallegada(horallegada);
        post.setHorasalida(horasalida);
		
        post.setAeropuerto_idaeropuerto(aeropuerto_idaeropuerto);
        post.setAeropuerto_idaeropuerto2(aeropuerto_idaeropuerto2);
        post.setAvion_idavion(avion_idavion);
        repository.save(post);
        return new ModelAndView("redirect:/vuelos");
    }

    @RequestMapping(value = "/{idvuelo}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long idvuelo,
                       Model model) {
        Vuelo post = repository.findOne(idvuelo);
        model.addAttribute("post", post);
        return "vuelos/edit";
    }


}
