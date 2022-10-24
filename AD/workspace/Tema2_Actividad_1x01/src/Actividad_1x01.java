import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import entrada.Teclado;

public class Actividad_1x01 {

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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException sqle) {
			System.out.println("Error al cerrar la base de datos: " + sqle.getMessage());
			sqle.printStackTrace();
		}

	}
	// Opcion 1 del menu
	public static void insertarDepartamento() throws ClassNotFoundException, SQLException {
		String nombre = Teclado.leerCadena("Nombre: ");
		String ubicacion = Teclado.leerCadena("Ubicación: ");
		AccesoDepartamento.InsertarDepartamento(nombre, ubicacion);
		System.out.println("Se ha insertado un departamento en la base de datos.");
		
	}
	// Opcion 2 del menu
	public static void consultarDepartamentos() throws ClassNotFoundException, SQLException {
		List<Departamento> listaDepartamentos = AccesoDepartamento.consultarDepartamentos();
		if(listaDepartamentos.size() == 0)
			System.out.println("No se ha encontrado ningún departamento en la base de datos.");
		else {
			for(Departamento departamento: listaDepartamentos) {
				System.out.println(departamento.toString());
			}
				System.out.println("Se han consultado " + listaDepartamentos.size() + " departamentos de la base de datos.");
		}
	}
	// Opcion 3 del menu
	public static void consultarDepartamento() {
		int codigo = Teclado.leerEntero("Codigo: ");
		
	}
	public static void imprimirMenu() {
		System.out.println("0) Salir del programa.\n1) Insertar un departamento en la base de datos.\n"
				+ "2) Consultar todos los departamentos de la base de datos.\n"
				+ "3) Consultar un departamento, por código, de la base de datos.\n"
				+ "4) Actualizar un departamento, por código, de la base de datos.\n"
				+ "5) Eliminar un departamento, por código, de la base de datos.");
	}
	public static void menu(int opcion) throws IOException, ClassNotFoundException, SQLException {
		switch (opcion) {
		case 0:
			break;
		case 1: 
			insertarDepartamento();
			break;
		case 2: 
			consultarDepartamentos();
			break;
		case 3: 
			
			break;
		case 4: 
			
			break;
		case 5:
			
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
		}
	}

}
