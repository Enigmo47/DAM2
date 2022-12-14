import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Arrays;

public class GeneraAleatorio {

	public static void main(String[] args) {
		String line;
		File directorio = new File(".\\bin"); //Se indica el directorio en el que está
		ProcessBuilder pb = new ProcessBuilder("java", "Aleatorios"); // Process representa a la clase hijo
		pb.directory(directorio);
		pb.redirectErrorStream(true);
		BufferedReader bf = null; // Leer la info del hijo
		try{
			Process shell = pb.start();
			PrintStream ps = new PrintStream(shell.getOutputStream()); // Salida de padre
			InputStream is = shell.getInputStream();
			bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			System.out.print("Salida del proceso: ");
			while((line = bf.readLine()) != null) {
				
			}
				
			is.close();
		}
		catch (IOException ex){
			System.err.println("Error de Entrada/Salida" + ex.toString());
			System.exit(-1);
		}

	}

}
