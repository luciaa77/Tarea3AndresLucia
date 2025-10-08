package ejercicio3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Hijo {

	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.out.println("No se han recibido argumentos");
			return;
		}
		
		String fecha = args[0]; //guardamos la fecha recibida como argumento
		System.out.println("Fecha recibida del padre: " + fecha);

		
		/*
		 * HACER LA FECHA ACTUAL
		 */
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //formateador de fechas
		LocalDate fechaRecibida = LocalDate.parse(fecha, formato); //parseamos la fecha recibida con el formato indicado
		LocalDate fechaActual = LocalDate.now(); //obtenemos la fecha actual
		
		/*
		 * Calculamos la diferencia entre las dos fechas
		 */
		long diasDiferencia = ChronoUnit.DAYS.between(fechaRecibida, fechaActual);
		
		if(diasDiferencia < 0) {
			System.out.println("La fecha introducida es posterior a la fecha actual");
		} else if(diasDiferencia == 0) {
			System.out.println("La fecha introducida es la fecha actual");
		}else {
			System.out.println("La diferencia entre la fecha introducida y la fecha actual es de " + diasDiferencia + " dias");
		}
	}

}
