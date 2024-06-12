package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

	@Autowired
	private CarreraCollection carreraCollection;

	@GetMapping("/listado")
	public String getListaCarreraPage(Model model) {
		model.addAttribute("carreras", carreraCollection.listarCarreras());
		return "carreras";
	}

	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		model.addAttribute("carrera", new Carrera());
		model.addAttribute("edicion", false);
		return "nueva_carrera";
	}

	@PostMapping("/guardar")
	public String guardarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		carreraCollection.getCarreras().add(carrera);
		return "redirect:/carrera/listado";
	}

	@GetMapping("/modificar/{codigo}")
	public String getModificarCarreraPage(Model model, @PathVariable("codigo") String codigo) {
		Carrera carrera = carreraCollection.buscarCarreraPorCodigo(codigo);
		if (carrera != null) {
			model.addAttribute("carrera", carrera);
			model.addAttribute("edicion", true);
			return "nueva_carrera";
		}
		return "redirect:/carrera/listado";
	}

	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") Carrera carrera, Model model) {
		carreraCollection.modificarCarrera(carrera);
		return "redirect:/carrera/listado";
	}

	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable("codigo") String codigo) {
		carreraCollection.eliminarCarrera(codigo);
		return "redirect:/carrera/listado";
	}
}
