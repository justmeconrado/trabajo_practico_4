package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
public class CarreraCollection {
	private List<Carrera> carreras;

	public CarreraCollection() {
		carreras = new ArrayList<Carrera>();
		carreras.add(new Carrera("FCA001", "Ingeniería Agronómica", "5", "ACTIVO"));
		carreras.add(new Carrera("FCA002", "Licenciatura en Ciencias Biológica", "5", "ACTIVO"));
		carreras.add(new Carrera("FCA003", "Licenciatura en Bromatología", "5", "ACTIVO"));
		carreras.add(new Carrera("FCA004", "Licenciatura en Desarrollo Rural", "5", "ACTIVO"));
		carreras.add(new Carrera("FCA005", "Licenciatura en Gestión Ambiental", "5", "ACTIVO"));
		carreras.add(new Carrera("FCA006", "Tecnicatura Universitaria en Producción Lechera", "3", "ACTIVO"));
		carreras.add(new Carrera("FCA007", "Tecnicatura Universitaria en Transformación de la Producción Agropecuaria",
				"3", "ACTIVO"));
		carreras.add(
				new Carrera("FCA008", "Tecnicatura Universitaria en Producción de Animales de Granja", "3", "ACTIVO"));
		carreras.add(new Carrera("FCA009", "Tecnicatura Universitaria Forestal", "3", "ACTIVO"));
		carreras.add(new Carrera("FCA010", "Tecnicatura Universitaria en mecanización Agrícola", "3", "ACTIVO"));

	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}
}
