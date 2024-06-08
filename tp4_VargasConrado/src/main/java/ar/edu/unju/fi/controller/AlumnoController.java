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

import ar.edu.unju.fi.collections.AlumnoCollection;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoCollection alumnoCollection;

    @GetMapping("/listado")
    public String getListaAlumnosPage(Model model) {
        model.addAttribute("alumnos", alumnoCollection.getAlumnos());
        return "alumnos";
    }

    @GetMapping("/nuevo")
    public String getNuevoAlumnoPage(Model model) {
        boolean edicion = false;
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("edicion", edicion);
        return "nuevo_alumno";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        ModelAndView modelView = new ModelAndView("redirect:/alumno/listado");
        alumnoCollection.getAlumnos().add(alumno);
        modelView.addObject("alumnos", alumnoCollection.getAlumnos());
        return modelView;
    }

    @GetMapping("/modificar/{dni}")
    public String getModificarAlumnoPage(Model model, @PathVariable(value = "dni") String dni) {
        Alumno alumnoEncontrado = new Alumno();
        boolean edicion = true;
        for (Alumno alu : alumnoCollection.getAlumnos()) {
            if (alu.getDni().equals(dni)) {
                alumnoEncontrado = alu;
                break;
            }
        }
        model.addAttribute("alumno", alumnoEncontrado);
        model.addAttribute("edicion", edicion);
        return "nuevo_alumno";
    }

    @PostMapping("/modificar")
    public String modificarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        for (Alumno alu : alumnoCollection.getAlumnos()) {
            if (alu.getDni().equals(alumno.getDni())) {
                alu.setNombre(alumno.getNombre());
                alu.setApellido(alumno.getApellido());
                alu.setEmail(alumno.getEmail());
                alu.setTelefono(alumno.getTelefono());
                alu.setFechaNacimiento(alumno.getFechaNacimiento());
                alu.setDomicilio(alumno.getDomicilio());
                alu.setLu(alumno.getLu());
                break;
            }
        }
        return "redirect:/alumno/listado";
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminarAlumno(@PathVariable(value = "dni") String dni) {
        for (Alumno alu : alumnoCollection.getAlumnos()) {
            if (alu.getDni().equals(dni)) {
                alumnoCollection.getAlumnos().remove(alu);
                break;
            }
        }
        return "redirect:/alumno/listado";
    }
}
