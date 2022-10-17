package actividad_1x03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class PasaMayusculas {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps = new PrintStream(System.out);
		String linea = in.readLine();
		while(linea != null) {
			ps.println(linea.toUpperCase());
			ps.flush();
			linea = in.readLine();
		}
		System.exit(0);
	}

}
