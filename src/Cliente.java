import java.util.ArrayList;

public class Cliente {
	private String cedula;
	private String nombre;
	private double saldo;
	private static ArrayList<Cliente> clientes = new ArrayList<>();;
	
	
	/*Creamos 2 constructores, para que se pueda crear un cliente de 2 maneras diferentes, 
	cuando no se le pone un saldo llama al otro constructor y pone por defecto el saldo en 0*/
	
	
	public Cliente(String cedula, String nombre) {
		this(cedula, nombre, 0);
	}	

	public Cliente(String cedula, String nombre, double saldo) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.saldo = saldo;	
		clientes.add(this);
		System.out.println(" ");
		System.out.println("Cliente añadido exitosamente");
		
	}
	
	
	//Getters y Setters

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
		
//	public void setCliente(Cliente cliente) {
//		
//	}
	
	public static void setClientes(ArrayList<Cliente> clientes) {
		Cliente.clientes = clientes;
	}	
	
	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

}
