package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}

	@GetMapping("/alumno")
	public String getAlumnosPage() {
		return "redirect:/alumno/listado";
	}

	@GetMapping("/principal")
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("/carrera")
	public String getCarrerasPage() {
		return "redirect:/carrera/listado";
	}

	@GetMapping("/nueva_carrera")
	public String getNuevaCarreraPage() {
		return "nueva_carrera";
	}
}
