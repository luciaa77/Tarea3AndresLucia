package ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Padre {

	public static void main(String[] args) throws IOException {


		File path = new File("./bin");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean fechaCorrecta = false;
		String fecha =  "";
		
		while(!fechaCorrecta) {
			System.out.println("dime la fecha en formanto dd/mm/aaaa");
			fecha = br.readLine();

			if (fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
				System.out.println("Fecha introducida correctamente");
				fechaCorrecta = true;
			} else {
				System.out.println("Fecha incorrecta");
			}
			
		}
		
		/*
		 * CREAR EL PROCESO 
		 */
		
		ProcessBuilder pb = new ProcessBuilder("java", "ejercicio3.Hijo", fecha);
		pb.directory(path);
		pb.redirectErrorStream(true); //tipo de excepciones
		Process hijo = pb.start();

		 /**
		  * LEER LA SALIDA DEL PROCESO HIJO
		  */
		
		BufferedReader hijoOut = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
		String respuesta = "";
		
		while((respuesta = hijoOut.readLine()) != null) {
			System.out.println(respuesta);
		}
	}

}
