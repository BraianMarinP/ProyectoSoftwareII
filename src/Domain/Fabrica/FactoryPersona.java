package Domain.Fabrica;

import java.util.ArrayList;
import java.util.List;
import Domain.Modelo.Persona;
import Domain.Modelo.Rol;
import UI.Controller.CRUDPersonaController;
import javafx.collections.FXCollections;

public class FactoryPersona {
	List<Persona> listaPersonas = new ArrayList<>();
	List<Rol> listaRoles = new ArrayList<>();

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
			formulario.getTablaPersonas().setItems(FXCollections.observableList(listaPersonas));
			formulario.actualizarVista();
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
				formulario.getTablaPersonas().setItems(FXCollections.observableList(listaPersonas));
				formulario.actualizarVista();
				break;
			}
		}
	}

	public void eliminarPersona(final CRUDPersonaController formulario) {
		for (Persona persona : listaPersonas) {
			if (persona.getId().equalsIgnoreCase(formulario.getLbIdPersona().getText())) {
				listaPersonas.remove(persona);
				break;
			}
		}
	}

	public void agregarRol(final CRUDPersonaController formulario) {

	}

	public void modificarRol(final CRUDPersonaController formulario) {

	}

	public void eliminarRol(final CRUDPersonaController formulario) {

	}
}
