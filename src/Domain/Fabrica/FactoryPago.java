package Domain.Fabrica;

import java.io.Serializable;
import java.util.List;

import Domain.Modelo.Pago;

public class FactoryPago implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Pago> listaPagos;

	public FactoryPago() {
	}

	public List<Pago> getListaPagos() {
		return listaPagos;
	}

	public void setListaPagos(List<Pago> listaPagos) {
		this.listaPagos = listaPagos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
