package Domain.Fabrica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Domain.Modelo.EquipoTrabajo;
import Domain.Modelo.Persona;
import Domain.Modelo.Rol;
import UI.Controller.CRUDEquipoTrabajoController;
import UI.Controller.CRUDPersonaController;
import application.Correo;
import javafx.collections.FXCollections;

public class FactoryPersona implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Persona> listaPersonas = new ArrayList<>();
	List<Rol> listaRoles = new ArrayList<>();
	
	public FactoryPersona() {
	}

	public void cargarPersonas(final CRUDPersonaController formulario) {
		formulario.getTablaPersonas().setItems(FXCollections.observableList(listaPersonas));
	}
	
	public void cargarRoles(final CRUDPersonaController formulario) {
		formulario.getTablaRoles().setItems(FXCollections.observableList(listaRoles));
	}

	public void agregarPersona(final CRUDPersonaController formulario) {
		boolean sePuedeAgregar = true;
		for (Persona persona : listaPersonas) {
			if (persona.getId().equalsIgnoreCase(formulario.getLbIdPersona().getText())
					|| persona.getEmail().equalsIgnoreCase(formulario.getLbEmail().getText())) {
				sePuedeAgregar = false;
				break;
			}
		}

		if (sePuedeAgregar) {
			Persona nuevaPersona = new Persona();
			nuevaPersona.setDireccion(formulario.getLbDireccion().getText());
			nuevaPersona.setEdad(formulario.getLbEdad().getText());
			nuevaPersona.setEmail(formulario.getLbEmail().getText());
			nuevaPersona.setEstadoCivil(formulario.getLbEstadoCivil().getText());
			nuevaPersona.setFechaNacimiento(formulario.getLbFechaNacimiento().getText());
			nuevaPersona.setGenero(formulario.getLbGenero().getText());
			nuevaPersona.setId(formulario.getLbIdPersona().getText());
			nuevaPersona.setNombre(formulario.getLbNombrePersona().getText());
			nuevaPersona.setRol(null);
			nuevaPersona.setTelefono(formulario.getLbTelefono().getText());
			listaPersonas.add(nuevaPersona);
			/*
			 * =================CORREO=============================
			 * Notificamos que se ha registrado en la base de datos
			 */
			Correo correo = new Correo();
			correo.crearEnviarCorreo(nuevaPersona.getEmail(), 
					"Registro en la empresa CAMU.", 
					nuevaPersona.getNombre() + " has sido agregado a la base de datos de CAMU"
							+ "\n\nNo responder este es un correo de prueba de aplicacion");
			formulario.getTablaPersonas().setItems(FXCollections.observableList(listaPersonas));
		}
	}

	public void modificarPersona(final CRUDPersonaController formulario) {
		for (Persona persona : listaPersonas) {
			if (persona.getId().equalsIgnoreCase(formulario.getLbIdPersona().getText())) {
				persona.setDireccion(formulario.getLbDireccion().getText());
				persona.setEdad(formulario.getLbEdad().getText());
				persona.setEmail(formulario.getLbEmail().getText());
				persona.setEstadoCivil(formulario.getLbEstadoCivil().getText());
				persona.setFechaNacimiento(formulario.getLbFechaNacimiento().getText());
				persona.setGenero(formulario.getLbGenero().getText());
				persona.setNombre(formulario.getLbNombrePersona().getText());
				persona.setRol(null);
				persona.setTelefono(formulario.getLbTelefono().getText());
				/*
				 * =================CORREO=============================
				 * Notificamos que se han actualizado los datos de esa persona en la base de datos
				 */
				Correo correo = new Correo();
				correo.crearEnviarCorreo(persona.getEmail(), 
						"Actualización de datos CAMU.", 
						persona.getNombre() + " tus datos de CAMU han sido actualizados"
								+ "\n\nNo responder este es un correo de prueba de aplicacion");
				formulario.getTablaPersonas().setItems(FXCollections.observableList(listaPersonas));
				break;
			}
		}
	}

	public void eliminarPersona(final CRUDPersonaController formulario, List<EquipoTrabajo> equipos) {
		Persona personaEliminar = formulario.getTablaPersonas().getSelectionModel().getSelectedItem();
		boolean integranteEliminado = false;
		if(personaEliminar != null){
			for (Persona persona : listaPersonas) {
				if (persona.getId().equalsIgnoreCase(personaEliminar.getId())) {
					listaPersonas.remove(persona);
					/*
					 * =================CORREO=============================
					 * Notificamos que se ha eliminado a esa persona en la base de datos
					 */
					Correo correo = new Correo();
					correo.crearEnviarCorreo(persona.getEmail(), 
							"Eliminacion de datos CAMU.", 
							persona.getNombre() + " has sido eliminado de la base de datos de CAMU"
									+ "\n\nNo responder este es un correo de prueba de aplicacion");
					for (EquipoTrabajo equipo : equipos) {
						for (Persona integrante : equipo.getInvolucrados()) {
							if(integrante.getId().equalsIgnoreCase(personaEliminar.getId())) {
								equipo.getInvolucrados().remove(integrante);
								integranteEliminado = true;
								break;
							}
						}
						if(integranteEliminado) {
							break;
						}
					}
					formulario.getTablaPersonas().setItems(FXCollections.observableList(listaPersonas));
					break;
				}
			}
		}
	}

	public void agregarRol(final CRUDPersonaController formulario) {
		boolean sePuedeAgregar = true;
		for (Rol rol : listaRoles) {
			if (rol.getId().equalsIgnoreCase(formulario.getLbIdRol().getText())
					|| rol.getNombre().equalsIgnoreCase(formulario.getLbNombreRol().getText())) {
				sePuedeAgregar = false;
				break;
			}
		}
		if (sePuedeAgregar) {
			Rol rolNuevo = new Rol();
			rolNuevo.setId(formulario.getLbIdRol().getText());
			rolNuevo.setDescripcion(formulario.getTxtADescripcion().getText());
			rolNuevo.setNivelAutodidad(formulario.getLbNivelAutoridad().getText());
			rolNuevo.setNombre(formulario.getLbNombreRol().getText());
			listaRoles.add(rolNuevo);
			formulario.getTablaRoles().setItems(FXCollections.observableList(listaRoles));
		}
	}

	public void modificarRol(final CRUDPersonaController formulario) {
		for (Rol rol : listaRoles) {
			if (rol.getId().equalsIgnoreCase(formulario.getLbIdRol().getText())) {
				rol.setId(formulario.getLbIdRol().getText());
				rol.setDescripcion(formulario.getTxtADescripcion().getText());
				rol.setNivelAutodidad(formulario.getLbNivelAutoridad().getText());
				rol.setNombre(formulario.getLbNombreRol().getText());
				formulario.getTablaRoles().setItems(FXCollections.observableList(listaRoles));
				break;
			}
		}
	}

	public void eliminarRol(final CRUDPersonaController formulario) {
		for (Rol rol : listaRoles) {
			if (rol.getId().equalsIgnoreCase(formulario.getLbIdRol().getText())) {
				listaRoles.remove(rol);
				formulario.getTablaRoles().setItems(FXCollections.observableList(listaRoles));
				break;
			}
		}
	}
	
	public void cargarPersonalDisponible(final CRUDEquipoTrabajoController formulario, List<EquipoTrabajo> equipos) {
		ArrayList<Persona> personalDisponible =  new ArrayList<>();
		boolean disponible = true;
		for (Persona persona : listaPersonas) {
			for (EquipoTrabajo equipo : equipos) {
				if(equipo.getInvolucrados().contains(persona)) {
					disponible = false;
					break;
				}
			}
			if(disponible) {
				personalDisponible.add(persona);
			}else {
				disponible = true;
			}
		}
		formulario.getTablaPersonalDisponible().setItems(FXCollections.observableArrayList(personalDisponible));
	}

	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public List<Rol> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
}
