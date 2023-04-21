package Domain.Modelo;

public class Persona {

	String id;
	String nombre;
	String edad;
	String telefono;
	String fechaNacimiento;
	String genero;
	String direccion;
	String estadoCivil;
	String email;
	Rol rol;

	public Persona() {
	}

	public Persona(String id, String nombre, String edad, String telefono, String fechaNacimiento, String genero,
			String direccion, String estadoCivil, String email, Rol rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.email = email;
		this.rol = rol;
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Rol getRol() {
		return rol;	
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}