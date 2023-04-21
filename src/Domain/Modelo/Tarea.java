package Domain.Modelo;

public class Tarea {
	String id;
	String nombre;
	String fechaInicio;
	String fechaFin;
	String estado;
	String porcentajeAvance;
	String descripcion;
	Persona responsable;

	public Tarea() {
	}

	public Tarea(String id, String nombre, String fechaInicio, String fechaFin, String estado, String porcentajeAvance,
			String descripcion, Persona responsable) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.porcentajeAvance = porcentajeAvance;
		this.descripcion = descripcion;
		this.responsable = responsable;
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

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public Persona getResponsable() {
		return responsable;
	}

	public void setResponsable(Persona responsable) {
		this.responsable = responsable;
	}

}
