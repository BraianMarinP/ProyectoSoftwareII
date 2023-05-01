package Domain.Modelo;

import java.io.Serializable;

public class Pago implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Double monto;
	private String fechaCreacion;
	private String referencia;
	private String metodoPago;
	private String comprobante;
	private String estado;
	private Persona cliente;
	private Proyecto proyecto;

	public Pago() {
	}

	public Pago(String id, Double monto, String fechaCreacion, String referencia, String metodoPago, String comprobante,
			String estado, Persona cliente, Proyecto proyecto) {
		super();
		this.id = id;
		this.monto = monto;
		this.fechaCreacion = fechaCreacion;
		this.referencia = referencia;
		this.metodoPago = metodoPago;
		this.comprobante = comprobante;
		this.estado = estado;
		this.cliente = cliente;
		this.proyecto = proyecto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getComprobante() {
		return comprobante;
	}

	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}
