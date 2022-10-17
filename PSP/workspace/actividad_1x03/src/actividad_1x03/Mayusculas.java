package actividad_1x03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Mayusculas {

	public static void main(String[] args) {
		String line = null;
		try {
			File directorio = new File(".\\bin"); //Se indica el directorio en el que está
			ProcessBuilder pb = new ProcessBuilder("java", "PasaMayusculas");
			pb.directory(directorio);
			Process hijo = pb.start();
			BufferedReader lectorDelHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			PrintStream escritorEnHijo = new PrintStream(hijo.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Escribe una linea: ");
			String linea = in.readLine();
			while((linea.compareTo("fin") != 0)) {
				escritorEnHijo.println(linea); // No es necesario escribir nada
				escritorEnHijo.flush(); // Asegura que los datos se han enviado
				if(!linea.equals("fin")) {
					System.out.println(line);
				}
				linea = in.readLine();
			}
			hijo.destroy();
			System.out.println("Finalizado");
			
		}
		catch (IOException ex){
			System.out.println("Error cocurrió durante la ejecución");
		}
		
	}

}
