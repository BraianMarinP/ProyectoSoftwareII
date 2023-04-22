package Domain;

import Domain.Fabrica.*;
import UI.Controller.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class Domain {

	@SuppressWarnings("unused")
	private final FactoryContrato factoryContrato;
	private final FactoryEquipoTrabajo factoryEquipoTrabajo;
	@SuppressWarnings("unused")
	private final FactoryInforme factoryInforme;
	@SuppressWarnings("unused")
	private final FactoryPago factoryPago;
	private final FactoryPersona factoryPersona;
	private final FactoryProyecto factoryProyecto;
	@SuppressWarnings("unused")
	private final FactoryTarea factoryTarea;
	
	public Domain() {
		factoryContrato = new FactoryContrato();
		factoryEquipoTrabajo = new FactoryEquipoTrabajo();
		factoryInforme = new FactoryInforme();
		factoryPersona = new FactoryPersona();
		factoryPago = new FactoryPago();
		factoryProyecto = new FactoryProyecto();
		factoryTarea = new FactoryTarea();
	}
	
	//_________________CRUD Persona métodos_________________
	
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
		factoryPersona.eliminarPersona(formulario);
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
	
	//_________________CRUD Equipo Trabajo metodos_________________
	
	
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
	
	//_________________CRUD Proyecto metodos_________________
	
	
	public void agregarProyecto(final CRUDProyectoController formulario) {
		factoryProyecto.agregarProyecto(formulario, factoryEquipoTrabajo.getListaEquipoTrabajo(), factoryPersona.getListaPersonas());
		formulario.actualizarVista();
    }
    
	public void eliminarProyecto(final CRUDProyectoController formulario) {
		factoryProyecto.eliminarProyecto(formulario);
		formulario.actualizarVista();
    }
    
	public void modificarProyecto(final CRUDProyectoController formulario) {
		factoryProyecto.modificarProyecto(formulario, factoryEquipoTrabajo.getListaEquipoTrabajo(), factoryPersona.getListaPersonas());
		formulario.actualizarVista();
    }
	
	public void cargarProyectos(final CRUDProyectoController formulario) {
		factoryProyecto.cargarProyectos(formulario);
		formulario.actualizarVista();
	}
	
	public void mostrarInformacionProyecto(final CRUDProyectoController formulario) {
		factoryProyecto.mostrarInformacionProyecto(formulario, factoryEquipoTrabajo.getListaEquipoTrabajo(), factoryPersona.getListaPersonas());
		formulario.actualizarVista();
	}
	
	//_________________CRUD Tarea metodos_________________
	
	public void agregarTarea(final CRUDTareaController formulario) {
		//factoryTarea.metodo...
		formulario.actualizarVista();
	}


	public void eliminarTarea(final CRUDTareaController formulario) {
		//factoryTarea.metodo...
		formulario.actualizarVista();
	}

	public void modificarTarea(final CRUDTareaController formulario) {
		//factoryTarea.metodo...
		formulario.actualizarVista();
	}

}
