package Domain.Fabrica;

import java.io.Serializable;
import java.util.List;

import Domain.Modelo.Informe;

public class FactoryInforme implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	List<Informe> listaInformes;

	public FactoryInforme() {
		super();
	}

	public List<Informe> getListaInformes() {
		return listaInformes;
	}

	public void setListaInformes(List<Informe> listaInformes) {
		this.listaInformes = listaInformes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
