package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.AlumnoCollection;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoCollection alumnoCollection;

	@GetMapping("/listado")
	public String getListaAlumnosPage(Model model) {
		model.addAttribute("alumnos", alumnoCollection.listarAlumnos());
		return "alumnos";
	}

	@GetMapping("/nuevo")
	public String getNuevoAlumnoPage(Model model) {
		model.addAttribute("alumno", new Alumno());
		model.addAttribute("edicion", false);
		return "nuevo_alumno";
	}

	@PostMapping("/guardar")
	public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		alumnoCollection.getAlumnos().add(alumno);
		return "redirect:/alumno/listado";
	}

	@GetMapping("/modificar/{dni}")
	public String getModificarAlumnoPage(Model model, @PathVariable("dni") String dni) {
		Alumno alumno = alumnoCollection.buscarAlumnoPorDni(dni);
		if (alumno != null) {
			model.addAttribute("alumno", alumno);
			model.addAttribute("edicion", true);
			return "nuevo_alumno";
		}
		return "redirect:/alumno/listado";
	}

	@PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("alumno") Alumno alumno, Model model) {
		try {
			alumnoCollection.modificarAlumno(alumno);
			return "redirect:/alumno/listado";
		} catch (IllegalArgumentException e) {
			model.addAttribute("alumno", alumno);
			model.addAttribute("edicion", true);
			model.addAttribute("errorMessage", e.getMessage());
			return "nuevo_alumno";
		}
	}

	@GetMapping("/eliminar/{dni}")
	public String eliminarAlumno(@PathVariable("dni") String dni) {
		alumnoCollection.eliminarAlumno(dni);
		return "redirect:/alumno/listado";
	}
}
