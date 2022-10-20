import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class CalculaPrimos {

	public static void main(String[] args) {
		String line;
		File directorio = new File(".\\bin"); //Se indica el directorio en el que está
		ProcessBuilder pb = new ProcessBuilder("java", "Primos");
		pb.directory(directorio);
		try {
			Process hijo = pb.start();
			BufferedReader lectorDelHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
			PrintStream escritorEnHijo = new PrintStream(hijo.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Escribe un numero entero: ");
			String linea = in.readLine();
			while(!linea.equals("fin")) {
				escritorEnHijo.println(linea);
				escritorEnHijo.flush(); // Asegura que los datos se han enviado
				if((line = lectorDelHijo.readLine()) != null) {
					System.out.println(line);
				}
				System.out.println("Escribe un numero entero: ");
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
