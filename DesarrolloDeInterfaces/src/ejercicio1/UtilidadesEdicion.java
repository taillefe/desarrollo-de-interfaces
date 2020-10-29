package ejercicio1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class UtilidadesEdicion {
	
	// obtenerTexto("fichero.txt") del contenido del fichero  (lo llama en la parte de la interfaz)
	public static String obtenerTexto (String fichero) {
	
	//crear flujo contra el fichero
		String texto =  "";
		try {
				FileReader fr = new FileReader(fichero);
				//lee caracteres y los pega en un string
				int t;
				while (( t = fr.read()) != -1 ) {
					texto = texto + (char)t;
					//cuando los tenga todos los devuelve como un string
					//lo devuelve a la parte de la interfaz 
				}
				fr.close();
		}catch (Exception e) {
				e.printStackTrace();
		}
		
		return texto;
		
		
	}	
	
	
	//guardarTexto  guarda el contenido de areaDeTexto(texto) en el fichero seleccionado (fichero)
	public static void guardarTexto(String fichero, String texto) {
	
		// abre fichero para escribir para copiar el texto 
		try
				{
				FileWriter fw = new FileWriter(fichero);

					fw.write(texto);

					fw.close();
			}catch(
				IOException e)
				{
					 e.printStackTrace();

				}
	}
}
