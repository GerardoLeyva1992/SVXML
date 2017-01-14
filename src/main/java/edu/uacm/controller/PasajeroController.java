package edu.uacm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import edu.uacm.domain.Avion;
import edu.uacm.domain.AvionRepository;
import edu.uacm.domain.Pasajero;
import edu.uacm.domain.PasajeroRepository;

@Controller
@RequestMapping("/pasajeros")
public class PasajeroController {

    @Autowired
    private PasajeroRepository repository;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String listPosts(Model model) {
        model.addAttribute("pasajeros", repository.findAll());
        return "pasajeros/list";
    }

    @RequestMapping(value = "/{idpasajero}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long idpasajero) {
        repository.delete(idpasajero);
        return new ModelAndView("redirect:/pasajeros");
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newProject() {
        return "pasajeros/new";
    }
//modeloavion
    //capacidad
    //lineaaerea
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(
    		@RequestParam("apellidomaterno") String apellidomaterno,
    		@RequestParam("apellidopaterno") String apellidopaterno,
    		@RequestParam("fechanacimiento") String fechanacimiento,
    		@RequestParam("nacionalidad") String nacionalidad,
    		@RequestParam("nombre") String nombre,
    		@RequestParam("vuelo_idvuelo") Long vuelo_idvuelo) {
        Pasajero post=new Pasajero();
        post.setApellidomaterno(apellidomaterno);
        post.setApellidopaterno(apellidopaterno);
        post.setFechanacimiento(fechanacimiento);
        post.setNacionalidad(nacionalidad);
        post.setNombre(nombre);
        post.setVuelo_idvuelo(vuelo_idvuelo);
    	repository.save(post);
        return new ModelAndView("redirect:/pasajeros");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(
    		@RequestParam("post_idpasajero") Long idpasajero,
    		@RequestParam("apellidomaterno") String apellidomaterno,
    		@RequestParam("apellidopaterno") String apellidopaterno,
    		@RequestParam("fechanacimiento") String fechanacimiento,
    		@RequestParam("nacionalidad") String nacionalidad,
    		@RequestParam("nombre") String nombre,
    		@RequestParam("vuelo_idvuelo") Long vuelo_idvuelo){
    	  Pasajero post=repository.findOne(idpasajero);
          post.setApellidomaterno(apellidomaterno);
          post.setApellidopaterno(apellidopaterno);
          post.setFechanacimiento(fechanacimiento);
          post.setNacionalidad(nacionalidad);
          post.setNombre(nombre);
          post.setVuelo_idvuelo(vuelo_idvuelo);
      	repository.save(post);
        return new ModelAndView("redirect:/pasajeros");
    }

    @RequestMapping(value = "/{idpasajero}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable Long idpasajero,
                       Model model) {
        Pasajero post = repository.findOne(idpasajero);
        model.addAttribute("post", post);
        return "pasajeros/edit";
    }


}