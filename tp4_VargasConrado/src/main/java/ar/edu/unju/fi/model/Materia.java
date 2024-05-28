package ar.edu.unju.fi.model;

public class Materia {
	private String codigo;
	private String nombre;
	private String curso;
	private String cantidadHoras;
	private String modalidad;
	private String docente;

	public Materia(String codigo, String nombre, String curso, String cantidadHoras, String modalidad, String docente) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.docente = docente;
	}

	// Constructor por defecto
	public Materia() {
		super();
	}

	// Métodos de acceso y modificación
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(String cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	@Override
	public String toString() {
		return "Materia [codigo=" + codigo + ", nombre=" + nombre + ", curso=" + curso + ", cantidadHoras="
				+ cantidadHoras + ", modalidad=" + modalidad + ", docente=" + docente + ", getCodigo()=" + getCodigo()
				+ ", getNombre()=" + getNombre() + ", getCurso()=" + getCurso() + ", getCantidadHoras()="
				+ getCantidadHoras() + ", getModalidad()=" + getModalidad() + ", getDocente()=" + getDocente()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
