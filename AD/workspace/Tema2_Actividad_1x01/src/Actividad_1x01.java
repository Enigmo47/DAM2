import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.sqlite.SQLiteException;

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
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException sqle) {
			System.err.println("El departamento está referenciado en un empleado de la base de datos.");
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
	public static void consultar1Departamento() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("Codigo: ");
		Departamento departamento = AccesoDepartamento.consultar1Departamento(codigo);
		if(departamento != null)
			System.out.println(departamento.toString());
		else
			System.out.println("No existe ningún departamento con ese código en la base de datos.");
		
	}
	// Opcion 4 del menu
	public static void actualizarDepartamento() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("Código: ");
		String nombre = Teclado.leerCadena("Nombre: ");
		String ubicacion = Teclado.leerCadena("Ubicación: ");
		int filasActualizadas = AccesoDepartamento.actualizarDepartamento(codigo, nombre, ubicacion);
		if (filasActualizadas == 0) {
			System.out.println("No existe ningún departamento con ese código en la base de datos.");
		}
		else {
			System.out.println("Se ha actualizado un departamento de la base de datos.");
		}
	}
	// Opcion 5 del menu
	public static void eliminarDepartamento() throws ClassNotFoundException, SQLException {
		int codigo = Teclado.leerEntero("Código: ");
		int filasEliminadas = AccesoDepartamento.eliminarDepartamento(codigo);
		if (filasEliminadas == 0) {
			System.out.println("No existe ningún departamento con ese código en la base de datos.");
		}
		else {
			System.out.println("Se ha eliminado un departamento de la base de datos.");
		}
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
			consultar1Departamento();
			break;
		case 4: 
			actualizarDepartamento();
			break;
		case 5:
			eliminarDepartamento();
			break;
		default:
			System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
		}
	}

}
