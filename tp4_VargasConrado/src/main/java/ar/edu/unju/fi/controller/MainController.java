package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage() {
		return "index";
	}

	@GetMapping("/alumno")
	public String getAlumnosPage() {
		return "redirect:/alumno/listado";
	}

	@RequestMapping(value = "/principal", method = RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("/carrera")
	public String getCarrerasPage() {
        return "redirect:/carrera/listado";
	}

	@RequestMapping(value = "/nueva_carrera", method = RequestMethod.GET)
	public String getNuevaCarreraPage() {
		return "nueva_carrera";
	}
}
