package edu.uacm.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uacm.domain.Escala;
import edu.uacm.domain.EscalaRepository;


@Controller
@RequestMapping("/escalas")
public class EscalaController {

    @Autowired
    private EscalaRepository repository;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String listPosts(Model model) {
        model.addAttribute("escalas", repository.findAll());
        return "escalas/list";
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
        return "escalas/new";
    }
    
   // Timestamp d2 = new java.sql.Timestamp(0);
	//Timestamp d = new java.sql.Timestamp(0);
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("horasalida") Date horasalida,@RequestParam("horallegada") Date horallegada,@RequestParam("aeropuerto_idaeropuerto") Long aeropuerto_idaeropuerto,
    		@RequestParam("aeropuerto_idaeropuerto2") Long aeropuerto_idaeropuerto2,@RequestParam("vuelo_idvuelo") Long vuelo_idvuelo) {
        Escala post=new Escala();
        post.setHorallegada(horallegada);
        post.setHorasalida(horasalida);
        post.setAeropuerto_idaeropuerto(aeropuerto_idaeropuerto);
        post.setAeropuerto_idaeropuerto2(aeropuerto_idaeropuerto2);
        post.setVuelo_idvuelo(vuelo_idvuelo);
        repository.save(post);
        return new ModelAndView("redirect:/escalas");
    }

    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("post_idescala") long idescala,
    		@RequestParam("horasalida") Date horasalida,@RequestParam("horallegada") Date horallegada,@RequestParam("aeropuerto_idaeropuerto") Long aeropuerto_idaeropuerto,
    		@RequestParam("aeropuerto_idaeropuerto2") Long aeropuerto_idaeropuerto2,@RequestParam("vuelo_idvuelo") Long vuelo_idvuelo) {
        Escala post = repository.findOne(idescala);
        post.setHorallegada(horallegada);
        post.setHorasalida(horasalida);
		
        post.setAeropuerto_idaeropuerto(aeropuerto_idaeropuerto);
        post.setAeropuerto_idaeropuerto2(aeropuerto_idaeropuerto2);
        post.setVuelo_idvuelo(vuelo_idvuelo);
        repository.save(post);
        return new ModelAndView("redirect:/escalas");
    }

    @RequestMapping(value = "/{idescala}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long idescala,
                       Model model) {
        Escala post = repository.findOne(idescala);
        model.addAttribute("post", post);
        return "escalas/edit";
    }


}
