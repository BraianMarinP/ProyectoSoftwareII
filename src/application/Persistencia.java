package application;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Persistencia {

	public static void serializarObjectoXML(String nombreArchivo, Object objeto) throws IOException {
		XMLEncoder codificador;

		codificador = new XMLEncoder(new FileOutputStream(nombreArchivo));
		codificador.writeObject(objeto);
		codificador.close();

	}

	public static Object deserializadorObjetoXML(String nombreArchivo) throws IOException {
		XMLDecoder decodificador;
		Object objeto;

		decodificador = new XMLDecoder(new FileInputStream(nombreArchivo));
		objeto = decodificador.readObject();
		decodificador.close();

		return objeto;
	}

}
