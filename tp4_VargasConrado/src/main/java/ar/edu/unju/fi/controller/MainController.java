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

	@GetMapping("/nuevo_alumno")
	public String getNuevoAlumnoPage() {
		return "nuevo_alumno";
	}

	@GetMapping("/carrera")
	public String getCarrerasPage() {
		return "redirect:/carrera/listado";
	}

	@GetMapping("/nueva_carrera")
	public String getNuevaCarreraPage() {
		return "nueva_carrera";
	}

	@GetMapping("/docente")
	public String getDocentesPage() {
		return "redirect:/docente/listado";
	}

	@GetMapping("/nuevo_docente")
	public String getNuevoDocentePage() {
		return "nuevo_docente";
	}

	@GetMapping("/materia")
	public String getMateriasPage() {
		return "redirect:/materia/listado";
	}

	@GetMapping("/nueva_materia")
	public String getNuevaMateriaPage() {
		return "nueva_materia";
	}

}
