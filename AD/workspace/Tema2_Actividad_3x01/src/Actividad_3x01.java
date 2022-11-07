import java.io.IOException;
import java.sql.SQLException;

import entrada.Teclado;

public class Actividad_3x01 {

	public static void main(String[] args) {
		try {
			int opcion = -1;
			do {
				imprimirMenu();
				opcion = Teclado.leerEntero("Opcion: ");
				menu(opcion);
			}while(opcion != 0);
			
		}
		catch (IOException ioe) {
			System.out.println("Error al leer del fichero:");
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException sqle) {
			System.err.println("El departamento está referenciado en un departamento de la base de datos.");
		}

	}
	/*
	 * Descripción: Describe las opciones del menú
	 */
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n"
				+ "1) Insertar todos los departamentos de un fichero de texto en la base de datos.\n"
				+ "2) Insertar todos los empleados de un fichero de texto en la base de datos.\n"
				+ "3) Actualizar los salarios de los empleados, por departamento, de la base de datos.\n"
				+ "4) Eliminar un departamento, por código, de la base de datos.");
	}
	/*
	 * Input: opción a elegir del menú
	 * Descrición: Tras obtener la opción introducidas por parámetro, entra en el switch y ejecuta la opción pertinente
	 */
	public static void menu(int opcion) throws IOException, ClassNotFoundException, SQLException {
		switch (opcion) {
		case 0:
			break;
		case 1:
			insertar();
			break;
		case 2: 
			eliminar();
			break;
		case 3: 
			consultarTodos();
			break;
		case 4: 
			consultarVarios();
			break;
		case 5:
			consultarNoPrestados();
			break;
		case 6:
			consultarFecha();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 6.");
		}
	}
}
