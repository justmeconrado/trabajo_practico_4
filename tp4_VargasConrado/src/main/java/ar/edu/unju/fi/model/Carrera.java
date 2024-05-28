package ar.edu.unju.fi.model;

public class Carrera {
	private String codigo;
	private String nombre;
	private String cantidadAnios;
	private String estado;

	public Carrera(String codigo, String nombre, String cantidadAnios, String estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadAnios = cantidadAnios;
		this.estado = estado;
	}

	// Constructor por defecto
	public Carrera() {
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

	public String getCantidadAnios() {
		return cantidadAnios;
	}

	public void setCantidadAnios(String cantidadAnios) {
		this.cantidadAnios = cantidadAnios;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Carrera [codigo=" + codigo + ", nombre=" + nombre + ", cantidadAnios=" + cantidadAnios + ", estado="
				+ estado + ", getCodigo()=" + getCodigo() + ", getNombre()=" + getNombre() + ", getCantidadAnios()="
				+ getCantidadAnios() + ", getEstado()=" + getEstado() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
