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

@Controller
@RequestMapping("/avions")
public class AvionController {

    @Autowired
    private AvionRepository repository;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String listPosts(Model model) {
        model.addAttribute("avions", repository.findAll());
        return "avions/list";
    }

    @RequestMapping(value = "/{idavion}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long idavion) {
        repository.delete(idavion);
        return new ModelAndView("redirect:/avions");
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newProject() {
        return "avions/new";
    }
//modeloavion
    //capacidad
    //lineaaerea
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("modeloavion") String modeloavion,@RequestParam("capacidad") int capacidad,@RequestParam("lineaaerea") String lineaaerea) {
        Avion post=new Avion();
        post.setModeloavion(modeloavion);
        post.setCapacidad(capacidad);
        post.setLineaaerea(lineaaerea);
    	repository.save(post);
        return new ModelAndView("redirect:/avions");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("post_idavion") long idavion,
                               @RequestParam("modeloavion") String modeloavion,@RequestParam("capacidad") int capacidad,@RequestParam("lineaaerea") String lineaaerea) {
        Avion post = repository.findOne(idavion);
        post.setModeloavion(modeloavion);
        post.setCapacidad(capacidad);
        post.setLineaaerea(lineaaerea);
        repository.save(post);
        return new ModelAndView("redirect:/avions");
    }

    @RequestMapping(value = "/{idavion}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long idavion,
                       Model model) {
        Avion post = repository.findOne(idavion);
        model.addAttribute("post", post);
        return "avions/edit";
    }


}
