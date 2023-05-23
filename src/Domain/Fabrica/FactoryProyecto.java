package Domain.Fabrica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Domain.Modelo.EquipoTrabajo;
import Domain.Modelo.Persona;
import Domain.Modelo.Proyecto;
import Domain.Modelo.Tarea;
import UI.Controller.CRUDProyectoController;
import application.Correo;
import javafx.collections.FXCollections;

public class FactoryProyecto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Proyecto> listaProyectos = new ArrayList<>();
	
	public FactoryProyecto() {
	}

	public void agregarProyecto(final CRUDProyectoController formulario, List<EquipoTrabajo> equipos,
			List<Persona> personal) {
		boolean sePuedeAgregar = true;
		for (Proyecto proyecto : listaProyectos) {
			if (proyecto.getId().equalsIgnoreCase(formulario.getLbIdProyecto().getText())) {
				sePuedeAgregar = false;
				break;
			}
		}
		if (sePuedeAgregar) {
			Proyecto nuevoProyecto = new Proyecto();
			nuevoProyecto.setId(formulario.getLbIdProyecto().getText());
			nuevoProyecto.setNombre(formulario.getLbNombre().getText());
			nuevoProyecto.setFechaInicio(formulario.getLbFchInicio().getText());
			nuevoProyecto.setFechaLimite(formulario.getLbFchLimite().getText());
			nuevoProyecto.setPorcentajeAvance(formulario.getLbPorcentaje().getText());
			nuevoProyecto.setDescripcion(formulario.getTxtADescripcion().getText());
			nuevoProyecto.setId(formulario.getLbIdProyecto().getText());
			List<Tarea> tareas = new ArrayList<>();
			nuevoProyecto.setTareas(tareas);
			for (EquipoTrabajo equipo : equipos) {
				if (equipo.getId().equalsIgnoreCase(formulario.getLbIdEquipo().getText())) {
					nuevoProyecto.setEquipoAsignado(equipo);
					for (Persona persona : equipo.getInvolucrados()) {
						/*
						 * =================CORREO=============================
						 * Notificamos que se ha asignado un projecto a ese equipo de trabajo
						 */
						Correo correo = new Correo();
						correo.crearEnviarCorreo(persona.getEmail(), 
								"Asignacion de proyecto.", 
								persona.getNombre() + " se ha asignado a tu equipo"
										+ " de trabajo " + equipo.getId()
										+ " el nuevo proyecto " + nuevoProyecto.getNombre()
										+ "\n\nNo responder este es un correo de prueba de aplicacion");
					}
					break;
				}
			}
			for (Persona supervisor : personal) {
				if (supervisor.getId().equalsIgnoreCase(formulario.getLbIdSupervisor().getText())) {
					nuevoProyecto.setSupervisor(supervisor);
					listaProyectos.add(nuevoProyecto);
					/*
					 * =================CORREO=============================
					 * Notificamos que un supervisor se le ha agregado un nuevo proyecto
					 */
					Correo correo = new Correo();
					correo.crearEnviarCorreo(supervisor.getEmail(), 
							"Asignacion de proyecto.", 
							supervisor.getNombre() + " ahora eres supervisor"
									+ " del nuevo proyecto " + nuevoProyecto.getNombre() + "."
									+ "\n\nNo responder este es un correo de prueba de aplicacion");
					formulario.getTablaProyectos().setItems(FXCollections.observableArrayList(listaProyectos));
					break;
				}
			}
		}
	}

	public void eliminarProyecto(final CRUDProyectoController formulario, List<EquipoTrabajo> equipos) {
		Proyecto proyectoEliminar = formulario.getTablaProyectos().getSelectionModel().getSelectedItem();
		if (proyectoEliminar != null) {
			for (Proyecto proyecto : listaProyectos) {
				if (proyecto.getId().equalsIgnoreCase(proyectoEliminar.getId())) {
					for (EquipoTrabajo equipo : equipos) {
						if (equipo.getId().equalsIgnoreCase(proyectoEliminar.getEquipoAsignado().getId())) {
							for (Persona persona : equipo.getInvolucrados()) {
								/*
								 * =================CORREO=============================
								 * Notificamos que se ha eliminado dicho proyecto
								 * a cada integrante que estaba involucrado
								 */
								Correo correo = new Correo();
								correo.crearEnviarCorreo(persona.getEmail(), 
										"Eliminacion de proyecto.", 
										persona.getNombre() + " se ha eliminado el proyecto "
												+ proyecto.getNombre() + " ya no haces parte de dicho proyecto."
												+ "\n\nNo responder este es un correo de prueba de aplicacion");
							}
							break;
						}
					}
					listaProyectos.remove(proyecto);
					formulario.getTablaProyectos().setItems(FXCollections.observableArrayList(listaProyectos));
					break;
				}
			}
		}
	}

	public void modificarProyecto(final CRUDProyectoController formulario, List<EquipoTrabajo> equipos,
			List<Persona> personal) {
		Proyecto proyectoSeleccionado = formulario.getTablaProyectos().getSelectionModel().getSelectedItem();
		if (proyectoSeleccionado != null) {
			for (Proyecto proyecto : listaProyectos) {
				if (proyecto.getId().equalsIgnoreCase(proyectoSeleccionado.getId())) {
					proyecto.setNombre(formulario.getLbNombre().getText());
					proyecto.setFechaInicio(formulario.getLbFchInicio().getText());
					proyecto.setFechaLimite(formulario.getLbFchLimite().getText());
					proyecto.setPorcentajeAvance(formulario.getLbPorcentaje().getText());
					proyecto.setDescripcion(formulario.getTxtADescripcion().getText());
					for (EquipoTrabajo equipo : equipos) {
						if (equipo.getId().equalsIgnoreCase(formulario.getLbIdEquipo().getText())) {
							proyecto.setEquipoAsignado(equipo);
							for (Persona persona : equipo.getInvolucrados()) {
								/*
								 * =================CORREO=============================
								 * Notificamos que se ha modificado un proyecto a las personas
								 * involucradas
								 */
								Correo correo = new Correo();
								correo.crearEnviarCorreo(persona.getEmail(), 
										"Modificacion de proyecto.", 
										persona.getNombre() + " se ha modificado el proyecto "
												+ proyecto.getNombre() + " estar pendiente de actualizaciones."
												+ "\n\nNo responder este es un correo de prueba de aplicacion");
							}
							break;
						}
					}
					for (Persona supervisor : personal) {
						if (supervisor.getId().equalsIgnoreCase(formulario.getLbIdSupervisor().getText())) {
							proyecto.setSupervisor(supervisor);
							/*
							 * =================CORREO=============================
							 * Notificamos que un supervisor se le ha agregado un nuevo proyecto
							 */
							Correo correo = new Correo();
							correo.crearEnviarCorreo(supervisor.getEmail(), 
									"Asignacion de proyecto.", 
									supervisor.getNombre() + " ahora eres supervisor"
											+ " del proyecto " + proyecto.getNombre() + " (MODIFICADO)."
											+ "\n\nNo responder este es un correo de prueba de aplicacion");
							break;
						}
					}
					formulario.getTablaProyectos().setItems(FXCollections.observableArrayList(listaProyectos));
					break;
				}
			}
		}
	}

	public void cargarProyectos(final CRUDProyectoController formulario) {
		formulario.getTablaProyectos().setItems(FXCollections.observableArrayList(listaProyectos));
	}

	public void mostrarInformacionProyecto(final CRUDProyectoController formulario, List<EquipoTrabajo> equipos,
			List<Persona> personal) {
		Proyecto proyectoSeleccionado = formulario.getTablaProyectos().getSelectionModel().getSelectedItem();
		if (proyectoSeleccionado != null) {
			for (Proyecto proyecto : listaProyectos) {
				if (proyecto.getId().equalsIgnoreCase(proyectoSeleccionado.getId())) {
					formulario.getLbNombre().setText(proyecto.getNombre());
					formulario.getLbFchInicio().setText(proyecto.getFechaInicio());
					formulario.getLbFchLimite().setText(proyecto.getFechaLimite());
					formulario.getLbPorcentaje().setText(proyecto.getPorcentajeAvance());
					formulario.getTxtADescripcion().setText(proyecto.getDescripcion());
					formulario.getLbIdProyecto().setText(proyecto.getId());
					EquipoTrabajo equipoProyecto = proyectoSeleccionado.getEquipoAsignado();
					if (equipoProyecto != null) {
						for (EquipoTrabajo equipo : equipos) {
							if (equipo.getId().equalsIgnoreCase(equipoProyecto.getId())) {
								formulario.getLbIdEquipo().setText(equipo.getId());
								break;
							}
						}
					} else {
						formulario.getLbIdEquipo().setText("");
					}
					Persona supervisorProyecto = proyectoSeleccionado.getSupervisor();
					if (supervisorProyecto != null) {
						for (Persona supervisor : personal) {
							if (supervisor.getId().equalsIgnoreCase(supervisorProyecto.getId())) {
								formulario.getLbIdSupervisor().setText(supervisor.getId());
								break;
							}
						}
					} else {
						formulario.getLbIdSupervisor().setText("");
					}
					break;
				}
			}
		}
	}

	public List<Proyecto> getListaProyectos() {
		return listaProyectos;
	}

	public void setListaProyectos(List<Proyecto> listaProyectos) {
		this.listaProyectos = listaProyectos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
