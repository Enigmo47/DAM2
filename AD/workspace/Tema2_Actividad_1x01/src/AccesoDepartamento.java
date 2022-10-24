import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoDepartamento {
	public static final String URL = "jdbc:sqlite:db\\\\personal.db";
	public static final String DRIVER = "org.sqlite.JDBC";
	/*
	 * input: Nombre y ubicación del departamento
	 * Descripción: Crea la conexión con la base de datos e inserta un nuevo departamento con el nombre y ubicación
	 * que entra por parámetros.
	 */
	public static void InsertarDepartamento(String nombre, String ubicacion) throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			System.out.println("Conectado");
			String sentenciaInsertar = "INSERT INTO departamento (nombre, ubicacion) VALUES ('" + nombre + "', '" + ubicacion + "')";
			Statement sentencia = conexion.createStatement();
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
	}
	public static List<Departamento> consultarDepartamentos() throws ClassNotFoundException, SQLException {
		Connection conexion = null;
		List<Departamento> listaDepartamentos = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			String sentenciaConsultar = "SELECT * FROM departamento";
			Statement sentencia = conexion.createStatement();
			ResultSet resultados = sentencia.executeQuery(sentenciaConsultar);	
			while (resultados.next()) {
				Departamento departamento = 
					new Departamento(resultados.getInt("codigo"),
					                 resultados.getString("nombre"),
					                 resultados.getString("ubicacion"));
				listaDepartamentos.add(departamento);
			}
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		return listaDepartamentos;
	}
}
