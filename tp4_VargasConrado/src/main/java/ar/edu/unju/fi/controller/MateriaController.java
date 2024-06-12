package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.MateriaCollection;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.collections.DocenteCollection;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/materia")
public class MateriaController {

	@Autowired
	private MateriaCollection materiaCollection;

	@Autowired
	private DocenteCollection docenteCollection;

	@GetMapping("/listado")
	public String getListaMateriasPage(Model model) {
		model.addAttribute("materias", materiaCollection.listarMaterias());
		return "materias";
	}

	@GetMapping("/nuevo")
	public String getNuevaMateriaPage(Model model) {
		model.addAttribute("materia", new Materia());
		model.addAttribute("edicion", false);

		model.addAttribute("docentes", docenteCollection.getDocentes());
		return "nueva_materia";
	}

	@PostMapping("/guardar")
	public String guardarMateria(@ModelAttribute("materia") Materia materia, Model model) {
		Docente docenteSeleccionado = docenteCollection.buscarDocentePorLegajo(materia.getDocente().getLegajo());

		if (docenteSeleccionado != null) {
			materia.setDocente(docenteSeleccionado);
			materiaCollection.guardarMateria(materia);
			return "redirect:/materia/listado";
		} else {
			model.addAttribute("errorDocente", "No se encontró el docente seleccionado.");
			model.addAttribute("docentes", docenteCollection.getDocentes());
			return "nueva_materia";
		}
	}

	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable("codigo") String codigo) {
		Materia materia = materiaCollection.buscarMateriaPorCodigo(codigo);
		model.addAttribute("materia", materia);
		model.addAttribute("edicion", true);
		model.addAttribute("docentes", docenteCollection.getDocentes());
		return "nueva_materia";
	}

	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("materia") Materia materia, Model model) {
		materiaCollection.modificarMateria(materia);
		Docente docenteSeleccionado = docenteCollection.buscarDocentePorLegajo(materia.getDocente().getLegajo());

		if (docenteSeleccionado != null) {
			materia.setDocente(docenteSeleccionado);
			materiaCollection.modificarMateria(materia);
			return "redirect:/materia/listado";
		} else {
			model.addAttribute("errorDocente", "No se encontró el docente seleccionado.");
			model.addAttribute("docentes", docenteCollection.getDocentes());
			return "nueva_materia";
		}
	}

	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable("codigo") String codigo) {
		materiaCollection.eliminarMateria(codigo);

		return "redirect:/materia/listado";
	}

}