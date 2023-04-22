package Domain.Fabrica;

import java.util.ArrayList;
import java.util.List;
import Domain.Modelo.EquipoTrabajo;
import Domain.Modelo.Persona;
import UI.Controller.CRUDEquipoTrabajoController;
import javafx.collections.FXCollections;

public class FactoryEquipoTrabajo {
	
	private List<EquipoTrabajo> listaEquipoTrabajo = new ArrayList<>();

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
			nuevoEquipoTrabajo.setDescripcion(formulario.getLbIdGrupo().getText());
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
					break;
				}
			}
		}
	}

	public void eliminarEquipo(final CRUDEquipoTrabajoController formulario) {
		EquipoTrabajo equipoSeleccionado = formulario.getTablaEquipos().getSelectionModel().getSelectedItem();
		if(equipoSeleccionado != null) {
			for (EquipoTrabajo equipoEliminar : listaEquipoTrabajo) {
				listaEquipoTrabajo.remove(equipoEliminar);
				break;
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
}
