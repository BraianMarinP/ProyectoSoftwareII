package Domain.Modelo;

import java.io.Serializable;

public class Rol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private String descripcion;
	private String nivelAutodidad;

	public Rol() {
	}

	public Rol(String id, String nombre, String descripcion, String nivelAutodidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivelAutodidad = nivelAutodidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNivelAutodidad() {
		return nivelAutodidad;
	}

	public void setNivelAutodidad(String nivelAutodidad) {
		this.nivelAutodidad = nivelAutodidad;
	}

}
