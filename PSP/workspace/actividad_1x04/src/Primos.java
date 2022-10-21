import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Primos {

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps = new PrintStream(System.out);
		String linea;
		try {
			linea = in.readLine();
			while(linea != null) {
				int numero = Integer.parseInt(linea);
				ps.println(resolverPrimos(numero));
				ps.flush();
				linea = in.readLine();
				
				
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean esPrimo(int numero) {
		for(int i = 2; i < numero; i++) {
			if(numero % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static String resolverPrimos(int numero) {
		if(esPrimo(numero))
			return "El numero " + numero + " es primo.";
		else {
			String output = "Los numeros primos menores que " + numero + " son:\n";
			for (int j = 1; j < numero; j++) {
				if(esPrimo(j))
					output += j + "\n";
			}
			return output;
		}
	}
}
