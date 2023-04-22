package Domain.Fabrica;

import java.util.ArrayList;
import java.util.List;

import Domain.Modelo.EquipoTrabajo;
import Domain.Modelo.Persona;
import Domain.Modelo.Proyecto;
import Domain.Modelo.Tarea;
import UI.Controller.CRUDProyectoController;
import javafx.collections.FXCollections;

public class FactoryProyecto {

	List<Proyecto> listaProyectos = new ArrayList<>();

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
					break;
				}
			}
			for (Persona supervisor : personal) {
				if (supervisor.getId().equalsIgnoreCase(formulario.getLbIdSupervisor().getText())) {
					nuevoProyecto.setSupervisor(supervisor);
					break;
				}
			}
			listaProyectos.add(nuevoProyecto);
			formulario.getTablaProyectos().setItems(FXCollections.observableArrayList(listaProyectos));
		}
	}

	public void eliminarProyecto(final CRUDProyectoController formulario) {
		Proyecto proyectoEliminar = formulario.getTablaProyectos().getSelectionModel().getSelectedItem();
		if (proyectoEliminar != null) {
			for (Proyecto proyecto : listaProyectos) {
				if (proyecto.getId().equalsIgnoreCase(proyectoEliminar.getId())) {
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
							break;
						}
					}
					for (Persona supervisor : personal) {
						if (supervisor.getId().equalsIgnoreCase(formulario.getLbIdSupervisor().getText())) {
							proyecto.setSupervisor(supervisor);
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
}
