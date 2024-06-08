package ar.edu.unju.fi.collections;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;


@Component // Anotación para que Spring lo reconozca como un componente
public class AlumnoCollection {
    // Lista de alumnos
    private List<Alumno> alumnos;

    public AlumnoCollection() {
        this.alumnos = new ArrayList<Alumno>();
        // Agrega alumnos predefinidos a la lista
        alumnos.add(new Alumno("12345678", "Juan", "Perez", "juan.perez@example.com", "123456789", "2000-01-01", "Calle Falsa 123", "LU1234"));
        alumnos.add(new Alumno("87654321", "María", "Lopez", "maria.lopez@example.com", "987654321", "2001-02-02", "Avenida Siempreviva 456", "LU5678"));
        alumnos.add(new Alumno("45678912", "Carlos", "Gomez", "carlos.gomez@example.com", "555555555", "1999-03-03", "Calle de los Girasoles 789", "LU9101"));
        alumnos.add(new Alumno("78912345", "Ana", "Martinez", "ana.martinez@example.com", "111111111", "2002-04-04", "Avenida del Bosque 1011", "LU1213"));
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}
