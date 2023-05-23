package Domain;

import java.io.Serializable;
import Domain.Fabrica.*;
import UI.Controller.*;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class Domain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private FactoryContrato factoryContrato;
	@SuppressWarnings("unused")
	private FactoryInforme factoryInforme;
	@SuppressWarnings("unused")
	private FactoryPago factoryPago;
	private FactoryEquipoTrabajo factoryEquipoTrabajo = new FactoryEquipoTrabajo();
	private FactoryPersona factoryPersona = new FactoryPersona();
	private FactoryProyecto factoryProyecto = new FactoryProyecto();
	private FactoryTarea factoryTarea = new FactoryTarea();

	public Domain() {
	}

	// _________________CRUD Persona métodos_________________

	public void cargarPersonas(final CRUDPersonaController formulario) {
		factoryPersona.cargarPersonas(formulario);
		formulario.actualizarVista();
	}

	public void cargarRoles(final CRUDPersonaController formulario) {
		factoryPersona.cargarRoles(formulario);
		formulario.actualizarVista();
	}

	public void agregarPersona(final CRUDPersonaController formulario) {
		factoryPersona.agregarPersona(formulario);
		formulario.actualizarVista();
	}

	public void modificarPersona(final CRUDPersonaController formulario) {
		factoryPersona.modificarPersona(formulario);
		formulario.actualizarVista();
	}

	public void eliminarPersona(final CRUDPersonaController formulario) {
		factoryPersona.eliminarPersona(formulario, factoryEquipoTrabajo.getListaEquipoTrabajo());
		formulario.actualizarVista();
	}

	public void agregarRol(final CRUDPersonaController formulario) {
		factoryPersona.agregarRol(formulario);
		formulario.actualizarVista();
	}

	public void modificarRol(final CRUDPersonaController formulario) {
		factoryPersona.modificarRol(formulario);
		formulario.actualizarVista();
	}

	public void eliminarRol(final CRUDPersonaController formulario) {
		factoryPersona.eliminarRol(formulario);
		formulario.actualizarVista();
	}

	// _________________CRUD Equipo Trabajo metodos_________________

	public void agregarEquipo(final CRUDEquipoTrabajoController formulario) {
		factoryEquipoTrabajo.agregarEquipo(formulario, factoryPersona.getListaPersonas());
		formulario.actualizarVista();
	}

	public void agregarIntegrante(final CRUDEquipoTrabajoController formulario) {
		factoryEquipoTrabajo.agregarIntegrante(formulario, factoryPersona.getListaPersonas());
		formulario.actualizarVista();
	}

	public void eliminarEquipo(final CRUDEquipoTrabajoController formulario) {
		factoryEquipoTrabajo.eliminarEquipo(formulario);
		formulario.actualizarVista();
	}

	public void modificarEquipo(final CRUDEquipoTrabajoController formulario) {
		factoryEquipoTrabajo.modificarEquipo(formulario);
		formulario.actualizarVista();
	}

	public void eliminarIntegrante(final CRUDEquipoTrabajoController formulario) {
		factoryEquipoTrabajo.eliminarIntegrante(formulario);
		formulario.actualizarVista();
	}

	public void cargarEquipos(final CRUDEquipoTrabajoController formulario) {
		factoryEquipoTrabajo.cargarEquipos(formulario);
		formulario.actualizarVista();
	}

	public void cargarPersonalDisponible(final CRUDEquipoTrabajoController formulario) {
		factoryPersona.cargarPersonalDisponible(formulario, factoryEquipoTrabajo.getListaEquipoTrabajo());
		formulario.actualizarVista();
	}

	public void cargarIntegrantes(final CRUDEquipoTrabajoController formulario) {
		factoryEquipoTrabajo.cargarIntegrantes(formulario);
		formulario.actualizarVista();
	}

	// _________________CRUD Proyecto metodos_________________

	public void agregarProyecto(final CRUDProyectoController formulario) {
		factoryProyecto.agregarProyecto(formulario, factoryEquipoTrabajo.getListaEquipoTrabajo(),
				factoryPersona.getListaPersonas());
		formulario.actualizarVista();
	}

	public void eliminarProyecto(final CRUDProyectoController formulario) {
		factoryProyecto.eliminarProyecto(formulario, factoryEquipoTrabajo.getListaEquipoTrabajo());
		formulario.actualizarVista();
	}

	public void modificarProyecto(final CRUDProyectoController formulario) {
		factoryProyecto.modificarProyecto(formulario, factoryEquipoTrabajo.getListaEquipoTrabajo(),
				factoryPersona.getListaPersonas());
		formulario.actualizarVista();
	}

	public void cargarProyectos(final CRUDProyectoController formulario) {
		factoryProyecto.cargarProyectos(formulario);
		formulario.actualizarVista();
	}

	public void mostrarInformacionProyecto(final CRUDProyectoController formulario) {
		factoryProyecto.mostrarInformacionProyecto(formulario, factoryEquipoTrabajo.getListaEquipoTrabajo(),
				factoryPersona.getListaPersonas());
		formulario.actualizarVista();
	}

	// _________________CRUD Tarea metodos_________________

	public void agregarTarea(final CRUDTareaController formulario) {
		factoryTarea.agregarTarea(formulario, factoryPersona.getListaPersonas(), factoryProyecto.getListaProyectos());
		formulario.actualizarVista();
	}

	public void eliminarTarea(final CRUDTareaController formulario) {
		factoryTarea.eliminarTarea(formulario, factoryProyecto.getListaProyectos(), factoryPersona.getListaPersonas());
		formulario.actualizarVista();
	}

	public void modificarTarea(final CRUDTareaController formulario) {
		factoryTarea.modificarTarea(formulario, factoryPersona.getListaPersonas());
		formulario.actualizarVista();
	}

	public void cargarProyectoAsignacionTareas(final CRUDTareaController formulario) {
		factoryTarea.cargarProyectoAsignacionTareas(formulario, factoryProyecto.getListaProyectos());
		formulario.actualizarVista();
	}

	public void cargarTareasPoryecto(final CRUDTareaController formulario) {
		factoryTarea.cargarTareasPoryecto(formulario);
		formulario.actualizarVista();
	}
	
	//_________________Seguimiento metodos_________________
	
	public void buscarPorId(final SeguimientoController formulario) {
		factoryTarea.buscarPorId(formulario);
		formulario.actualizarVista();
	}
	
	public void buscarPorProyectos(final SeguimientoController formulario) {
		factoryTarea.buscarPorProyectos(formulario, factoryProyecto.getListaProyectos());
		formulario.actualizarVista();
	}
	
	public void buscarPorResponsable(final SeguimientoController formulario) {
		factoryTarea.buscarPorResponsable(formulario);
		formulario.actualizarVista();
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public FactoryContrato getFactoryContrato() {
		return factoryContrato;
	}

	public void setFactoryContrato(FactoryContrato factoryContrato) {
		this.factoryContrato = factoryContrato;
	}

	public FactoryInforme getFactoryInforme() {
		return factoryInforme;
	}

	public void setFactoryInforme(FactoryInforme factoryInforme) {
		this.factoryInforme = factoryInforme;
	}

	public FactoryPago getFactoryPago() {
		return factoryPago;
	}

	public void setFactoryPago(FactoryPago factoryPago) {
		this.factoryPago = factoryPago;
	}

	public FactoryEquipoTrabajo getFactoryEquipoTrabajo() {
		return factoryEquipoTrabajo;
	}

	public void setFactoryEquipoTrabajo(FactoryEquipoTrabajo factoryEquipoTrabajo) {
		this.factoryEquipoTrabajo = factoryEquipoTrabajo;
	}

	public FactoryPersona getFactoryPersona() {
		return factoryPersona;
	}

	public void setFactoryPersona(FactoryPersona factoryPersona) {
		this.factoryPersona = factoryPersona;
	}

	public FactoryProyecto getFactoryProyecto() {
		return factoryProyecto;
	}

	public void setFactoryProyecto(FactoryProyecto factoryProyecto) {
		this.factoryProyecto = factoryProyecto;
	}

	public FactoryTarea getFactoryTarea() {
		return factoryTarea;
	}

	public void setFactoryTarea(FactoryTarea factoryTarea) {
		this.factoryTarea = factoryTarea;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
