import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class EjecutaComando {
	public static void main (String[]args) throws IOException{
		if(args.length<1){
			System.out.println("Se necesita algún argumento para ejecutar el programa");
			System.exit(-1);
		}
		Runtime runtime = Runtime.getRuntime();
		try{
			Process process = runtime.exec(args);
			int espera = process.waitFor();
			BufferedReader berr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String line;
			System.out.println("Error al ejecutar " + Arrays.toString(args) + " :");
			while((line = berr.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch (InterruptedException ie) {
			System.out.println("Error de interrupción");
		}
		catch (IOException ex){
			System.err.println("Error de Entrada/Salida");
			System.exit(-1);
		}
	}
	
}
