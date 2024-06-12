package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteController {

	@Autowired
	private DocenteCollection alumnoCollection;

	@GetMapping("/listado")
	public String getListaDocentesPage(Model model) {
		model.addAttribute("docentes", alumnoCollection.listarDocentes());
		return "docentes";
	}

	@GetMapping("/nuevo")
	public String getNuevoDocentePage(Model model) {
		model.addAttribute("docente", new Docente());
		model.addAttribute("edicion", false);
		return "nuevo_docente";
	}

	@PostMapping("/guardar")
	public String guardarDocente(@ModelAttribute("docente") Docente docente) {
		alumnoCollection.getDocentes().add(docente);
		return "redirect:/docente/listado";
	}

	@GetMapping("/modificar/{legajo}")
	public String getModificarDocentePage(Model model, @PathVariable("legajo") String legajo) {
		Docente docente = alumnoCollection.buscarDocentePorLegajo(legajo);
		if (docente != null) {
			model.addAttribute("docente", docente);
			model.addAttribute("edicion", true);
			return "nuevo_docente";
		}
		return "redirect:/docente/listado";
	}

	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("docente") Docente docente, Model model) {
		try {
			alumnoCollection.modificarDocente(docente);
			return "redirect:/docente/listado";
		} catch (IllegalArgumentException e) {
			model.addAttribute("docente", docente);
			model.addAttribute("edicion", true);
			model.addAttribute("errorMessage", e.getMessage());
			return "nuevo_docente";
		}
	}

	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable("legajo") String legajo) {
		alumnoCollection.eliminarDocente(legajo);
		return "redirect:/docente/listado";
	}

}