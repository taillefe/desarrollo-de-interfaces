package ejercicio1;

import java.io.FileNotFoundException;
import java.io.FileReader;

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
	//en la interfaz con un actionPerformed  en el seleccionar texto envia un setText() desde el TextArea
	
	
	
	//escribirFichero()
	public static void guardarFichero(String fichero, String texto) {
		
		// guarda el contenido de areaDeTexto(texto) en el ficheroAbrir(fichero)
		
		
	}
	
	
	
	

}
