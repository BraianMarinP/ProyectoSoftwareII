package Domain.Fabrica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Domain.Modelo.EquipoTrabajo;
import Domain.Modelo.Persona;
import UI.Controller.CRUDEquipoTrabajoController;
import application.Correo;
import javafx.collections.FXCollections;

public class FactoryEquipoTrabajo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<EquipoTrabajo> listaEquipoTrabajo = new ArrayList<>();
	
	public FactoryEquipoTrabajo() {
	}

	public void agregarEquipo(final CRUDEquipoTrabajoController formulario, List<Persona> personas) {
		boolean sePuedeAgregar = true;
		for (EquipoTrabajo equipo : listaEquipoTrabajo) {
			if(equipo.getId().equalsIgnoreCase(formulario.getLbIdGrupo().getText())) {
				sePuedeAgregar = false;
			}
		}
		if(sePuedeAgregar) {
			EquipoTrabajo nuevoEquipoTrabajo = new EquipoTrabajo();
			nuevoEquipoTrabajo.setId(formulario.getLbIdGrupo().getText());
			nuevoEquipoTrabajo.setCargo(formulario.getLbCargo().getText());
			nuevoEquipoTrabajo.setDescripcion(formulario.getLbDescripcion().getText());
			List<Persona> integrantes = new ArrayList<>();
			nuevoEquipoTrabajo.setInvolucrados(integrantes);
			nuevoEquipoTrabajo.setNumeroIntegrantes(integrantes.size());
			listaEquipoTrabajo.add(nuevoEquipoTrabajo);
			
			formulario.getTablaEquipos().setItems(FXCollections.observableArrayList(listaEquipoTrabajo));
		}
		
	}

	public void agregarIntegrante(final CRUDEquipoTrabajoController formulario, List<Persona> personas) {
		EquipoTrabajo equipoSeleccionado = formulario.getTablaEquipos().getSelectionModel().getSelectedItem();
		if(equipoSeleccionado != null) {
			for (EquipoTrabajo equipo : listaEquipoTrabajo) {
				if(equipo.getId().equalsIgnoreCase(equipoSeleccionado.getId())) {
					Persona personaSeleccionada = formulario.getTablaPersonalDisponible().getSelectionModel().getSelectedItem();
					if(personaSeleccionada != null) {
						for (Persona persona : personas) {
							if(persona.getId().equalsIgnoreCase(personaSeleccionada.getId())) {
								equipo.getInvolucrados().add(persona);
								/*
								 * =================CORREO=============================
								 * Notificamos que esa persona se agregó como integrante  a un grupo
								 */
								Correo correo = new Correo();
								correo.crearEnviarCorreo(persona.getEmail(), 
										"Asignacion de grupo de trabajo.", 
										persona.getNombre() + " Ahora formas parte del equipo"
												+ " de trabajo " + equipo.getId()
												+ "\n\nNo responder este es un correo de prueba de aplicacion");
								break;
							}
						}
					}
					break;
				}
			}
		}
	}
	
	public void modificarEquipo(final CRUDEquipoTrabajoController formulario) {
		EquipoTrabajo equipoSeleccionado = formulario.getTablaEquipos().getSelectionModel().getSelectedItem();
		if(equipoSeleccionado != null) {
			for (EquipoTrabajo equipoModificar : listaEquipoTrabajo) {
				if(equipoModificar.getId().equalsIgnoreCase(equipoSeleccionado.getId())) {
					equipoModificar.setDescripcion(formulario.getLbDescripcion().getText());
					equipoModificar.setCargo(formulario.getLbCargo().getText());
					for (Persona persona : equipoModificar.getInvolucrados()) {
						/*
						 * =================CORREO=============================
						 * Notificamos que se ha modificó el grupo a los integrantes
						 */
						Correo correo = new Correo();
						correo.crearEnviarCorreo(persona.getEmail(), 
								"Modificacion de tu grupo de trabajo.", 
								persona.getNombre() + " se ha actualizado la información de tu equipo"
										+ " de trabajo " + equipoModificar.getId()
										+ "\n\nNo responder este es un correo de prueba de aplicacion");
					}
					break;
				}
			}
		}
	}

	public void eliminarEquipo(final CRUDEquipoTrabajoController formulario) {
		EquipoTrabajo equipoSeleccionado = formulario.getTablaEquipos().getSelectionModel().getSelectedItem();
		if(equipoSeleccionado != null) {
			for (EquipoTrabajo equipoEliminar : listaEquipoTrabajo) {
				if(equipoSeleccionado.getId().equalsIgnoreCase(equipoEliminar.getId())) {
					for (Persona persona : equipoEliminar.getInvolucrados()) {
						/*
						 * =================CORREO=============================
						 * Notificamos que se eliminó el grupo completo a los antiguos integrantes
						 */
						Correo correo = new Correo();
						correo.crearEnviarCorreo(persona.getEmail(), 
								"Eliminacion grupo de trabajo.", 
								persona.getNombre() + " se ha eliminado tu equipo"
										+ " de trabajo " + equipoEliminar.getId()
										+ "\n\nNo responder este es un correo de prueba de aplicacion");
					}
					listaEquipoTrabajo.remove(equipoEliminar);
					break;
				}
			}
		}
	}

	public void eliminarIntegrante(final CRUDEquipoTrabajoController formulario) {
		EquipoTrabajo equipoSeleccionado = formulario.getTablaEquipos().getSelectionModel().getSelectedItem();
		Persona integranteSeleccionado = formulario.getTablaIntegrantes().getSelectionModel().getSelectedItem();
		if(equipoSeleccionado != null && integranteSeleccionado != null) {
			for (EquipoTrabajo equipoModificar : listaEquipoTrabajo) {
				if(equipoModificar.getId().equalsIgnoreCase(equipoSeleccionado.getId())) {
					for (Persona integrante : equipoModificar.getInvolucrados()) {
						if(integrante.getId().equalsIgnoreCase(integranteSeleccionado.getId())) {
							/*
							 * =================CORREO=============================
							 * Notificamos que se elimina el integrante del grupo
							 */
							Correo correo = new Correo();
							correo.crearEnviarCorreo(integrante.getEmail(), 
									"Eliminacion integrante de equipo.", 
									integrante.getNombre() + " has sido desasignado del equipo"
											+ " de trabajo " + equipoModificar.getId()
											+ "\n\nNo responder este es un correo de prueba de aplicacion");
							equipoModificar.getInvolucrados().remove(integrante);
							break;
						}
					}
				}
			}
		}
	}
	
	public void cargarEquipos(final CRUDEquipoTrabajoController formulario) {
		if(!listaEquipoTrabajo.isEmpty()) {
			formulario.getTablaEquipos().setItems(FXCollections.observableArrayList(listaEquipoTrabajo));
		}
	}
	
	public void cargarIntegrantes(final CRUDEquipoTrabajoController formulario) {
		EquipoTrabajo equipo = formulario.getTablaEquipos().getSelectionModel().getSelectedItem();
		if(equipo != null) {
			List<Persona> integrantes = equipo.getInvolucrados();
			formulario.getTablaIntegrantes().setItems(FXCollections.observableArrayList(integrantes));
		}
		
	}

	public List<EquipoTrabajo> getListaEquipoTrabajo() {
		return listaEquipoTrabajo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setListaEquipoTrabajo(List<EquipoTrabajo> listaEquipoTrabajo) {
		this.listaEquipoTrabajo = listaEquipoTrabajo;
	}
	
}
