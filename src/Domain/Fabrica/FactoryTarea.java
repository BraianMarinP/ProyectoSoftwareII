package Domain.Fabrica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Domain.Modelo.Persona;
import Domain.Modelo.Proyecto;
import Domain.Modelo.Tarea;
import UI.Controller.CRUDTareaController;
import UI.Controller.SeguimientoController;
import javafx.collections.FXCollections;
import javafx.scene.input.MouseEvent;

public class FactoryTarea implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Tarea> listaTareas = new ArrayList<>();

	public FactoryTarea() {
	}

	public void agregarTarea(final CRUDTareaController formulario, List<Persona> trabajadores,
			List<Proyecto> proyectos) {
		boolean sePuedeAgregar = true;
		Proyecto proyectoSeleccionado = formulario.getTablaProyectos().getSelectionModel().getSelectedItem();
		for (Tarea tarea : listaTareas) {
			if (tarea.getId().equalsIgnoreCase(formulario.getLbIdTarea().getText())) {
				sePuedeAgregar = false;
				break;
			}
		}
		if (sePuedeAgregar && proyectoSeleccionado != null) {
			Tarea nuevaTarea = new Tarea();
			nuevaTarea.setDescripcion(formulario.getTxtADescripcion().getText());
			nuevaTarea.setEstado(formulario.getLbEstado().getText());
			nuevaTarea.setFechaFin(formulario.getLbFechaFin().getText());
			nuevaTarea.setFechaInicio(formulario.getLbFechaInicio().getText());
			nuevaTarea.setId(formulario.getLbIdTarea().getText());
			nuevaTarea.setNombre(formulario.getLbNombre().getText());
			nuevaTarea.setPorcentajeAvance(formulario.getLbPorcentaje().getText());
			for (Persona persona : trabajadores) {
				if (persona.getId().equalsIgnoreCase(formulario.getLbIdResponsable().getText())) {
					nuevaTarea.setResponsable(persona);
					for (Proyecto proyecto : proyectos) {
						if (proyecto.getId().equalsIgnoreCase(proyectoSeleccionado.getId())) {
							proyecto.getTareas().add(nuevaTarea);
							listaTareas.add(nuevaTarea);
							formulario.getTablaTareas()
									.setItems(FXCollections.observableArrayList(proyecto.getTareas()));
							break;
						}
					}
					break;
				}
			}
		}
	}

	public void eliminarTarea(final CRUDTareaController formulario, List<Proyecto> proyectos) {
		Tarea tareaEliminar = formulario.getTablaTareas().getSelectionModel().getSelectedItem();
		boolean tareaProyectoEliminada = false;
		for (Tarea tarea : listaTareas) {
			if (tarea.getId().equalsIgnoreCase(tareaEliminar.getId())) {
				listaTareas.remove(tarea);
				for (Proyecto proyecto : proyectos) {
					for (Tarea tareaProyecto : proyecto.getTareas()) {
						if (tareaProyecto.getId().equalsIgnoreCase(tareaEliminar.getId())) {
							proyecto.getTareas().remove(tareaProyecto);
							tareaProyectoEliminada = true;
							formulario.getTablaTareas()
									.setItems(FXCollections.observableArrayList(proyecto.getTareas()));
							break;
						}
					}
					if (tareaProyectoEliminada) {
						break;
					}
				}
				break;
			}
		}
	}

	public void modificarTarea(final CRUDTareaController formulario, List<Persona> trabajadores) {
		Tarea tareaSeleccionada = formulario.getTablaTareas().getSelectionModel().getSelectedItem();
		for (Tarea tarea : listaTareas) {
			if (tarea.getId().equalsIgnoreCase(tareaSeleccionada.getId())) {
				tarea.setDescripcion(formulario.getTxtADescripcion().getText());
				tarea.setEstado(formulario.getLbEstado().getText());
				tarea.setFechaFin(formulario.getLbFechaFin().getText());
				tarea.setFechaInicio(formulario.getLbFechaInicio().getText());
				tarea.setId(formulario.getLbIdTarea().getText());
				tarea.setNombre(formulario.getLbNombre().getText());
				tarea.setPorcentajeAvance(formulario.getLbPorcentaje().getText());
				for (Persona persona : trabajadores) {
					if (persona.getId().equalsIgnoreCase(formulario.getLbIdResponsable().getText())) {
						tarea.setResponsable(persona);
						break;
					}
				}
				break;
			}
		}
	}

	public void cargarProyectoAsignacionTareas(final CRUDTareaController formulario, List<Proyecto> proyectos) {
		if (!proyectos.isEmpty()) {
			formulario.getTablaProyectos().setItems(FXCollections.observableArrayList(proyectos));
		}
	}

	public void cargarTareasPoryecto(final CRUDTareaController formulario) {
		Proyecto proyectoSeleccionado = formulario.getTablaProyectos().getSelectionModel().getSelectedItem();
		if (proyectoSeleccionado != null) {
			List<Tarea> tareas = proyectoSeleccionado.getTareas();
			formulario.getTablaTareas().setItems(FXCollections.observableArrayList(tareas));
		}
	}

	// Seguimiento

	public void buscarPorId(final SeguimientoController formulario) {
		for (Tarea tarea : listaTareas) {
			if (tarea.getId().equalsIgnoreCase(formulario.getLbIdTarea().getText())) {
				formulario.getTablaTareas().setItems(FXCollections.observableArrayList(tarea));
				break;
			}
		}
	}

	public void buscarPorProyectos(final SeguimientoController formulario, List<Proyecto> proyectos) {
		for (Proyecto proyecto : proyectos) {
			if (proyecto.getId().equalsIgnoreCase(formulario.getLbIdProyecto().getText())) {
				formulario.getTablaTareas().setItems(FXCollections.observableArrayList(proyecto.getTareas()));
				break;
			}
		}
	}

	public void buscarPorResponsable(final SeguimientoController formulario) {
		List<Tarea> tareasDelResponsable = new ArrayList<>();
		for (Tarea tarea : listaTareas) {
			if (tarea.getResponsable().getId().equalsIgnoreCase(formulario.getLbIdResponsable().getText())) {
				tareasDelResponsable.add(tarea);
			}
		}
		formulario.getTablaTareas().setItems(FXCollections.observableArrayList(tareasDelResponsable));
	}

	public List<Tarea> getListaTareas() {
		return listaTareas;
	}

	public void setListaTareas(List<Tarea> listaTareas) {
		this.listaTareas = listaTareas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
