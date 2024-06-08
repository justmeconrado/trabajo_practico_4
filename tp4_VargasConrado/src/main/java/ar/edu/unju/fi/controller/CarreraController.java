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

/**
 * Controlador que maneja las operaciones relacionadas con las carreras.
 */
@Controller
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired // Inyecta la instancia de CarreraCollection precargada
    private CarreraCollection carreraCollection;
    
    @GetMapping("/listado")
    public String getListaCarreraPage(Model model) {
        model.addAttribute("carreras", carreraCollection.getCarreras());
        return "carreras";
    }

    /**
     * Maneja las solicitudes GET para mostrar la página de creación de una nueva carrera.
     * 
     * @param model el modelo utilizado para pasar los datos a la vista
     * @return la vista "nueva_carrera"
     */
    @GetMapping("/nuevo")
    public String getNuevaCarreraPage(Model model) {
        boolean edicion = false;
        model.addAttribute("carrera", new Carrera());
        model.addAttribute("edicion", edicion);
        return "nueva_carrera";
    }

    /**
     * Maneja las solicitudes POST para guardar una nueva carrera.
     * 
     * @param carrera el objeto Carrera recibido del formulario
     * @return un objeto ModelAndView que redirige a la página de listado de carreras
     */
    @PostMapping("/guardar")
    public ModelAndView guardarCarrera(@ModelAttribute("carrera") Carrera carrera) {
        ModelAndView modelView = new ModelAndView("redirect:/carrera/listado");
        carreraCollection.getCarreras().add(carrera);
        modelView.addObject("carreras", carreraCollection.getCarreras());
        return modelView;
    }

    /**
     * Maneja las solicitudes GET para mostrar la página de modificación de una carrera existente.
     * 
     * @param model  el modelo utilizado para pasar los datos a la vista
     * @param codigo el código de la carrera a modificar
     * @return la vista "nueva_carrera"
     */
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

    /**
     * Maneja las solicitudes POST para modificar una carrera existente.
     * 
     * @param carrera el objeto Carrera recibido del formulario
     * @return un String que redirige a la página de listado de carreras
     */
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

    /**
     * Maneja las solicitudes GET para eliminar una carrera existente.
     * 
     * @param codigo el código de la carrera a eliminar
     * @return un String que redirige a la página de listado de carreras
     */
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
