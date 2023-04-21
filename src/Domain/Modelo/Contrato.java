package Domain.Modelo;

public class Contrato {
String id;
String fechaInicio;
String fechaFinalizacion;
String descripcion;
String objetivo;
String titulo;
Persona cliente;
Persona contratista;


public Contrato() {
}
public Contrato(String id, String fechaInicio, String fechaFinalizacion, String descripcion, String objetivo,
		String titulo, Persona cliente, Persona contratista) {
	super();
	this.id = id;
	this.fechaInicio = fechaInicio;
	this.fechaFinalizacion = fechaFinalizacion;
	this.descripcion = descripcion;
	this.objetivo = objetivo;
	this.titulo = titulo;
	this.cliente = cliente;
	this.contratista = contratista;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFechaInicio() {
	return fechaInicio;
}
public void setFechaInicio(String fechaInicio) {
	this.fechaInicio = fechaInicio;
}
public String getFechaFinalizacion() {
	return fechaFinalizacion;
}
public void setFechaFinalizacion(String fechaFinalizacion) {
	this.fechaFinalizacion = fechaFinalizacion;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getObjetivo() {
	return objetivo;
}
public void setObjetivo(String objetivo) {
	this.objetivo = objetivo;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public Persona getCliente() {
	return cliente;
}
public void setCliente(Persona cliente) {
	this.cliente = cliente;
}
public Persona getContratista() {
	return contratista;
}
public void setContratista(Persona contratista) {
	this.contratista = contratista;
}






}
