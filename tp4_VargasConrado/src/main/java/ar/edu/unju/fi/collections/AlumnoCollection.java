package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class AlumnoCollection {
	private List<Alumno> alumnos;

	public AlumnoCollection() {
		this.alumnos = new ArrayList<Alumno>();
		alumnos.add(new Alumno("12345678", "Juan", "Perez", "juan.perez@fca.unju.edu.ar", "01123456789", "2000-01-01",
				"Calle Corrientes 123", "LU1234"));
		alumnos.add(new Alumno("87654321", "María", "González", "maria.gonzalez@fca.unju.edu.ar", "01198765432",
				"2001-02-02", "Avenida Santa Fe 456", "LU5678"));
		alumnos.add(new Alumno("45678912", "Carlos", "Fernández", "carlos.fernandez@fca.unju.edu.ar", "01155555555",
				"1999-03-03", "Calle San Martín 789", "LU9101"));
		alumnos.add(new Alumno("78912345", "Ana", "Rodríguez", "ana.rodriguez@fca.unju.edu.ar", "01111111111",
				"2002-04-04", "Avenida Rivadavia 1011", "LU1213"));
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public List<Alumno> listarAlumnos() {
		return alumnos;
	}

	public Alumno buscarAlumnoPorDni(String dni) {
		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni)) {
				return alumno;
			}
		}
		return null;
	}

	public void modificarAlumno(Alumno alumnoModificado) {
		Alumno alumnoExistente = buscarAlumnoPorDni(alumnoModificado.getDni());

		if (alumnoExistente != null) {
			if (!alumnoExistente.getDni().equals(alumnoModificado.getDni())) {
				Alumno alumnoConNuevoDni = buscarAlumnoPorDni(alumnoModificado.getDni());
				if (alumnoConNuevoDni != null) {
					throw new IllegalArgumentException("El nuevo DNI ya está en uso.");
				}
			}
			alumnoExistente.setDni(alumnoModificado.getDni());
			alumnoExistente.setNombre(alumnoModificado.getNombre());
			alumnoExistente.setApellido(alumnoModificado.getApellido());
			alumnoExistente.setEmail(alumnoModificado.getEmail());
			alumnoExistente.setTelefono(alumnoModificado.getTelefono());
			alumnoExistente.setFechaNacimiento(alumnoModificado.getFechaNacimiento());
			alumnoExistente.setDomicilio(alumnoModificado.getDomicilio());
			alumnoExistente.setLu(alumnoModificado.getLu());
		}
	}

	public void eliminarAlumno(String dni) {
		Alumno alumnoAEliminar = buscarAlumnoPorDni(dni);
		if (alumnoAEliminar != null) {
			alumnos.remove(alumnoAEliminar);
		}
	}
}
