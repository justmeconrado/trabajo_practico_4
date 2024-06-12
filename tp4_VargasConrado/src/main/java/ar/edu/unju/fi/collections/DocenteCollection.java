package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;

@Component
public class DocenteCollection {
	private List<Docente> docentes = new ArrayList<>();

	public DocenteCollection() {
		this.docentes = new ArrayList<Docente>();
		docentes.add(new Docente("L12345", "Juan", "González", "juan.gonzalez@fca.unju.edu.ar", "+54 9 11 12345678"));
		docentes.add(
				new Docente("L54321", "María", "Rodríguez", "maria.rodriguez@fca.unju.edu.ar", "+54 9 11 87654321"));
		docentes.add(new Docente("L67890", "Carlos", "Pérez", "carlos.perez@fca.unju.edu.ar", "+54 9 11 23456789"));
		docentes.add(new Docente("L09876", "Ana", "Fernández", "ana.fernandez@fca.unju.edu.ar", "+54 9 11 98765432"));
	}

	public List<Docente> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<Docente> docentes) {
		this.docentes = docentes;
	}

	public List<Docente> listarDocentes() {
		return docentes;
	}

	public Docente buscarDocentePorLegajo(String legajo) {
		for (Docente docente : docentes) {
			if (docente.getLegajo().equals(legajo)) {
				return docente;
			}
		}
		return null;
	}

	public void modificarDocente(Docente docenteModificado) {
		Docente docenteExistente = buscarDocentePorLegajo(docenteModificado.getLegajo());
		if (docenteExistente != null) {
			docenteExistente.setLegajo(docenteModificado.getLegajo());
			docenteExistente.setNombre(docenteModificado.getNombre());
			docenteExistente.setEmail(docenteModificado.getEmail());
			docenteExistente.setApellido(docenteModificado.getApellido());
			docenteExistente.setTelefono(docenteModificado.getTelefono());
		}
	}

	public void eliminarDocente(String legajo) {
		docentes.remove(buscarDocentePorLegajo(legajo));
	}

	public void guardarDocente(Docente docente) {
		docentes.add(docente);
	}

}