package edu.uacm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uacm.domain.Empleado;
import edu.uacm.domain.EmpleadoRepository;


@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository repository;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String listPosts(Model model) {
        model.addAttribute("empleados", repository.findAll());
        return "empleados/list";
    }

    @RequestMapping(value = "/{codigo}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long codigo) {
        repository.delete(codigo);
        return new ModelAndView("redirect:/empleados");
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newProject() {
        return "empleados/new";
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
    		@RequestParam("nombre") String nombre) {
        Empleado post=new Empleado();
        post.setApellidomaterno(apellidomaterno);
        post.setApellidopaterno(apellidopaterno);
        post.setFechanacimiento(fechanacimiento);
        post.setNacionalidad(nacionalidad);
        post.setNombre(nombre);
    	repository.save(post);
        return new ModelAndView("redirect:/empleados");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(
    		@RequestParam("post_codigo") Long codigo,
    		@RequestParam("apellidomaterno") String apellidomaterno,
    		@RequestParam("apellidopaterno") String apellidopaterno,
    		@RequestParam("fechanacimiento") String fechanacimiento,
    		@RequestParam("nacionalidad") String nacionalidad,
    		@RequestParam("nombre") String nombre){
    	  Empleado post=repository.findOne(codigo);
          post.setApellidomaterno(apellidomaterno);
          post.setApellidopaterno(apellidopaterno);
          post.setFechanacimiento(fechanacimiento);
          post.setNacionalidad(nacionalidad);
          post.setNombre(nombre);
      	repository.save(post);
        return new ModelAndView("redirect:/empleados");
    }

    @RequestMapping(value = "/{codigo}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable Long codigo,
                       Model model) {
        Empleado post = repository.findOne(codigo);
        model.addAttribute("post", post);
        return "empleados/edit";
    }


}