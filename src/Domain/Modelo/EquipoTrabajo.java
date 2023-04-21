package Domain.Modelo;

import java.util.List;

public class EquipoTrabajo {

	String id;
	String cargo;
	String descripcion;
	int numeroIntegrantes;
	List<Persona> involucrados;

	public EquipoTrabajo() {
	}

	public EquipoTrabajo(String id, String cargo, String descripcion, int numeroIntegrantes,
			List<Persona> involucrados) {
		super();
		this.id = id;
		this.cargo = cargo;
		this.descripcion = descripcion;
		this.numeroIntegrantes = numeroIntegrantes;
		this.involucrados = involucrados;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumeroIntegrantes() {
		return numeroIntegrantes;
	}

	public void setNumeroIntegrantes(int numeroIntegrantes) {
		this.numeroIntegrantes = numeroIntegrantes;
	}

	public List<Persona> getIdInvolucrados() {
		return involucrados;
	}

	public void setIdInvolucrados(List<Persona> involucrados) {
		this.involucrados = involucrados;
	}

}
