package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CarreraCollection;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

	@Autowired 
	private CarreraCollection carreraCollection;

	@GetMapping("/listado")
	public String getListaCarreraPage(Model model) {
		model.addAttribute("carreras", carreraCollection.getCarreras());
		return "carreras";
	}

	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		boolean edicion = false;
		model.addAttribute("carrera", new Carrera());
		model.addAttribute("edicion", edicion);
		return "nueva_carrera";
	}

	@PostMapping("/guardar")
	public ModelAndView guardarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		ModelAndView modelView = new ModelAndView("redirect:/carrera/listado");
		carreraCollection.getCarreras().add(carrera);
		modelView.addObject("carreras", carreraCollection.getCarreras());
		return modelView;
	}

	@GetMapping("/modificar/{codigo}")
	public String getModificarCarreraPage(Model model, @PathVariable(value = "codigo") String codigo) {
		Carrera carreraEncontrada = new Carrera();
		boolean edicion = true;
		for (Carrera car : carreraCollection.getCarreras()) {
			if (car.getCodigo().equals(codigo)) {
				carreraEncontrada = car;
				break;
			}
		}
		model.addAttribute("carrera", carreraEncontrada);
		model.addAttribute("edicion", edicion);
		return "nueva_carrera";
	}

	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		for (Carrera car : carreraCollection.getCarreras()) {
			if (car.getCodigo().equals(carrera.getCodigo())) {
				car.setCodigo(carrera.getCodigo());
				car.setNombre(carrera.getNombre());
				car.setCantidadAnios(carrera.getCantidadAnios());
				car.setEstado(carrera.getEstado());
				break;
			}
		}
		return "redirect:/carrera/listado";
	}

	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value = "codigo") String codigo) {
		for (Carrera car : carreraCollection.getCarreras()) {
			if (car.getCodigo().equals(codigo)) {
				carreraCollection.getCarreras().remove(car);
				break;
			}
		}
		return "redirect:/carrera/listado";
	}
}
