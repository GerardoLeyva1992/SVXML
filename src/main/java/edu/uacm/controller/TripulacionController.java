package edu.uacm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uacm.domain.Aeropuertos.Aeropuerto;
import edu.uacm.domain.AeropuertoRepository;
import edu.uacm.domain.Tripulacion;
import edu.uacm.domain.TripulacionRepository;

@Controller
@RequestMapping("/tripulaciones")
public class TripulacionController {

    @Autowired
    private TripulacionRepository repository;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String listPosts(Model model) {
        model.addAttribute("tripulaciones", repository.findAll());
        return "tripulaciones/list";
    }
/*
    @RequestMapping(value = "/{idaeropuerto}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long idaeropuerto) {
        repository.delete(idaeropuerto);
        return new ModelAndView("redirect:/posts");
    }
*/
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newProject() {
        return "tripulaciones/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("vuelo_idvuelo") long vuelo_idvuelo,
			@RequestParam("empleado_codigo") long empleado_codigo,
            @RequestParam("puesto") String puesto) {
        Tripulacion post=new Tripulacion();
        post.setVuelo_idvuelo(vuelo_idvuelo);
        post.setEmpleado_codigo(empleado_codigo);
        post.setPuesto(puesto);
    	repository.save(post);
        return new ModelAndView("redirect:/tripulaciones");
    }

    /*
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("post_vuelo_idvuelo") long vuelo_idvuelo,
    							@RequestParam("post_empleado_codigo") long empleado_codigo,
                               @RequestParam("nombreaeropuerto") String nombreaeropuerto,
                               @RequestParam("puesto") String puesto
                              ) {
        Tripulacion post = repository.findOne(idaeropuerto);
        post.setNombreaeropuerto(nombreaeropuerto);
        post.setCiudad(ciudad);
        post.setPais(pais);
        repository.save(post);
        return new ModelAndView("redirect:/posts");
    }
*/
    /*
    @RequestMapping(value = "/{idaeropuerto}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long idaeropuerto,
                       Model model) {
        Aeropuerto post = repository.findOne(idaeropuerto);
        model.addAttribute("post", post);
        return "posts/edit";
    }
*/

}