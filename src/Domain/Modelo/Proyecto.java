package Domain.Modelo;

import java.io.Serializable;
import java.util.List;

public class Proyecto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private String fechaInicio;
	private String fechaLimite;
	private String porcentajeAvance;
	private String descripcion;
	private List<Tarea> tareas;
	private Persona supervisor;
	private EquipoTrabajo equipoAsignado;
	private Contrato contrato;

	public Proyecto() {
	}

	public Proyecto(String id, String nombre, String fechaInicio, String fechaLimite, String porcentajeAvance,
			String descripcion, List<Tarea> tareas, Persona supervisor, EquipoTrabajo equipoAsignado,
			Contrato contrato) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaLimite = fechaLimite;
		this.porcentajeAvance = porcentajeAvance;
		this.descripcion = descripcion;
		this.tareas = tareas;
		this.supervisor = supervisor;
		this.equipoAsignado = equipoAsignado;
		this.contrato = contrato;
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

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(String fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public String getPorcentajeAvance() {
		return porcentajeAvance;
	}

	public void setPorcentajeAvance(String porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Persona getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Persona supervisor) {
		this.supervisor = supervisor;
	}

	public EquipoTrabajo getEquipoAsignado() {
		return equipoAsignado;
	}

	public void setEquipoAsignado(EquipoTrabajo equipoAsignado) {
		this.equipoAsignado = equipoAsignado;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

}
