package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Docente;

@Component
public class MateriaCollection {
	private List<Materia> materias = new ArrayList<>();
	private DocenteCollection docenteCollection;

	public MateriaCollection(DocenteCollection docenteCollection) {
		this.docenteCollection = docenteCollection;
		List<Docente> docentes = docenteCollection.getDocentes();
		materias.add(
				new Materia("MAT001", "Botánica", "Ingeniería Agronómica", "60 horas", "Presencial", docentes.get(0)));
		materias.add(new Materia("MAT002", "Zoología", "Licenciatura en Ciencias Biológicas", "60 horas", "Presencial",
				docentes.get(1)));
		materias.add(new Materia("MAT003", "Microbiología", "Licenciatura en Bromatología", "60 horas", "Presencial",
				docentes.get(2)));
		materias.add(new Materia("MAT004", "Sociología Rural", "Licenciatura en Desarrollo Rural", "60 horas",
				"Virtual", docentes.get(3)));
		materias.add(new Materia("MAT005", "Ecología", "Licenciatura en Gestión Ambiental", "60 horas", "Presencial",
				docentes.get(0)));
		materias.add(new Materia("MAT006", "Producción Animal", "Tecnicatura Universitaria en Producción Lechera",
				"45 horas", "Presencial", docentes.get(1)));
		materias.add(new Materia("MAT007", "Procesos Agroindustriales",
				"Tecnicatura Universitaria en Transformación de la Producción Agropecuaria", "45 horas", "Presencial",
				docentes.get(2)));
		materias.add(
				new Materia("MAT008", "Avicultura", "Tecnicatura Universitaria en Producción de Animales de Granja",
						"45 horas", "Presencial", docentes.get(3)));
		materias.add(new Materia("MAT009", "Silvicultura", "Tecnicatura Universitaria Forestal", "45 horas",
				"Presencial", docentes.get(0)));
		materias.add(new Materia("MAT010", "Maquinaria Agrícola", "Tecnicatura Universitaria en Mecanización Agrícola",
				"45 horas", "Presencial", docentes.get(1)));
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public List<Materia> listarMaterias() {
		return materias;
	}

	public Materia buscarMateriaPorCodigo(String codigo) {
		for (Materia materia : materias) {
			if (materia.getCodigo().equals(codigo)) {
				return materia;
			}
		}
		return null;
	}

	public void modificarMateria(Materia materiaModificada) {
		Materia materiaExistente = buscarMateriaPorCodigo(materiaModificada.getCodigo());
		if (materiaExistente != null) {
			materiaExistente.setCodigo(materiaModificada.getCodigo());
			materiaExistente.setNombre(materiaModificada.getNombre());
			materiaExistente.setDocente(materiaModificada.getDocente());
			materiaExistente.setCurso(materiaModificada.getCurso());
			materiaExistente.setCantidadHoras(materiaModificada.getCantidadHoras());
			materiaExistente.setModalidad(materiaModificada.getModalidad());
		}
	}

	public void eliminarMateria(String codigo) {
		Materia materia = buscarMateriaPorCodigo(codigo);
		if (materia != null) {
			materias.remove(materia);
		}
	}

	public void guardarMateria(Materia materia) {
		materias.add(materia);
	}

	public DocenteCollection getDocenteCollection() {
		return docenteCollection;
	}

	public void setDocenteCollection(DocenteCollection docenteCollection) {
		this.docenteCollection = docenteCollection;
	}

}
