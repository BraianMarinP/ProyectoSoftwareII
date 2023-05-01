package Domain.Fabrica;

import java.io.Serializable;
import java.util.List;
import Domain.Modelo.Contrato;

public class FactoryContrato implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Contrato> listaContratos;

	public FactoryContrato() {
	}

	public List<Contrato> getListaContratos() {
		return listaContratos;
	}

	public void setListaContratos(List<Contrato> listaContratos) {
		this.listaContratos = listaContratos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
