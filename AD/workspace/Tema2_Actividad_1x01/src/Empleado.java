
public class Empleado {
	private int codigo, salario, codigoDepartamento;
	private String nombre, fechaAlta;
	public Empleado(int codigo, int salario, int codigoDepartamento, String nombre, String fechaAlta) {
		this.codigo = codigo;
		this.salario = salario;
		this.codigoDepartamento = codigoDepartamento;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
	}
	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", salario=" + salario + ", codigoDepartamento=" + codigoDepartamento
				+ ", nombre=" + nombre + ", fechaAlta=" + fechaAlta + "]";
	}
	
	
}
