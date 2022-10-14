import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Random;

public class Aleatorios {

	public static void main(String[] args) {
		BufferedReader br = null;
		Random num = new Random();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			PrintStream ps = new PrintStream(System.out);
			while(br.readLine() != null){
				//System.out.println(num.nextInt(10));
				ps.println(num.nextInt(10));
				ps.flush(); // empujón para el ps
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
	}

}
