package Domain.Modelo;

public class Informe {

	String id;
	String fechaCreacion;
	String descripcion;
	String contenido;
	String titulo;
	Persona autor;

	public Informe() {
	}

	public Informe(String id, String fechaCreacion, String descripcion, String contenido, String titulo,
			Persona autor) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.descripcion = descripcion;
		this.contenido = contenido;
		this.titulo = titulo;
		this.autor = autor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Persona getAutor() {
		return autor;
	}

	public void setAutor(Persona autor) {
		this.autor = autor;
	}

}
