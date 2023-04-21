package Domain;

import Domain.Fabrica.*;
import UI.Controller.*;

public class Domain {

	@SuppressWarnings("unused")
	private FactoryContrato factoryContrato;
	@SuppressWarnings("unused")
	private FactoryEquipoTrabajo factoryEquipoTrabajo;
	@SuppressWarnings("unused")
	private FactoryInforme factoryInforme;
	@SuppressWarnings("unused")
	private FactoryPago factoryPago;
	private FactoryPersona factoryPersona;
	@SuppressWarnings("unused")
	private FactoryProyecto factoryProyecto;
	@SuppressWarnings("unused")
	private FactoryTarea factoryTarea;
	
	public Domain() {
		factoryContrato = new FactoryContrato();
		factoryEquipoTrabajo = new FactoryEquipoTrabajo();
		factoryInforme = new FactoryInforme();
		factoryPersona = new FactoryPersona();
		factoryPago = new FactoryPago();
		factoryProyecto = new FactoryProyecto();
		factoryTarea = new FactoryTarea();
	}

	public void agregarPersona(final CRUDPersonaController formulario) {
		factoryPersona.agregarPersona(formulario);
	}

	public void modificarPersona(final CRUDPersonaController formulario) {
		factoryPersona.modificarPersona(formulario);
	}

	public void eliminarPersona(final CRUDPersonaController formulario) {
		factoryPersona.eliminarPersona(formulario);
	}
	
	public void agregarRol(final CRUDPersonaController formulario) {
		factoryPersona.agregarRol(formulario);
	}

	public void modificarRol(final CRUDPersonaController formulario) {
		factoryPersona.modificarRol(formulario);
	}

	public void eliminarRol(final CRUDPersonaController formulario) {
		factoryPersona.eliminarRol(formulario);
	}

}
