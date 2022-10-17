import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Aleatorios {
	
	public static void main (String []args) {
		
		// recibir dato usuario
		// hacer un do while not equals "fin"
		// y luego meter todo lo de abajo
		
		
		
		String line;
		File directorio = new File(".\\bin"); //Se indica el directorio en el que está
		ProcessBuilder pb = new ProcessBuilder("java", "GeneraAleatorio");
		pb.directory(directorio);
		pb.redirectErrorStream(true);
		
		try{
			Process shell = pb.start();
			
			PrintStream ps= new PrintStream(shell.getOutputStream()); // para comunicarse con el proceso hijo
			
			InputStream is = shell.getInputStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			System.out.print("Salida del proceso: ");
			
			while((line = bf.readLine()) != null)
				System.out.println(line);
			is.close();
		}
		catch (IOException ex){
			System.err.println("Error de Entrada/Salida" + ex.toString());
			System.exit(-1);
		}
		
		
		
	}
}
