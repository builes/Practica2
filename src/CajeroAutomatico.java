//En esta clase crearemos los metodos solicitados en el ejercicio los cuales llamaremos desde la clase main
//Todos los metodos creados fueron estaticos para poder llamarlos sin la necesidad de crear un objeto de esta clase en Main

import java.util.*;

public class CajeroAutomatico {
	
	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Cliente> clientes = Cliente.getClientes();
	
//	Este metodo verifica que la cedula ingresada no se encuente en el sistema para poder registrar el usuario
	public static void registrarCliente() {
		
		System.out.println("                  //---------------------//--------------------//---------------------//");
	    System.out.println("                  //---------------------//--------------------//---------------------//");
		System.out.println("Ingrese la cedula del cliente");
		String cedula = entrada.next();
		entrada.nextLine(); 
		boolean verificarCedula = false;
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getCedula().equals(cedula)) {
				verificarCedula = true;
			}
		}
		if(verificarCedula) {
			System.out.println("La cedula que ingresaste ya se encuentra registrada en el sistema");
		}
		else {
			System.out.println("                  //---------------------//--------------------//---------------------//");
			System.out.println("Ingrese el nombre del cliente");
			String nombre = entrada.nextLine();
			System.out.println("                  //---------------------//--------------------//---------------------//");
			System.out.println("Ingrese el saldo del cliente");
			double saldo = entrada.nextInt();
			Cliente cliente = new Cliente(cedula, nombre, saldo);
			System.out.println("                  //---------------------//--------------------//---------------------//");
		    System.out.println("                  //---------------------//--------------------//---------------------//");
		}
		
	}
	
	//Este metodo verifica que la cedula exista, en caso de que si solicita el monto a consignar y hace la consignacion
	public static void realizarConsignacion() {
		System.out.println("                  //---------------------//--------------------//---------------------//");
		System.out.println("Ingresa la cedula del cliente a quien le deseas realizar la consignacion");
		String cedula = entrada.next();
		for(int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getCedula().equals(cedula)) {
				Cliente cliente = clientes.get(i);
				System.out.println("                  //---------------------//--------------------//---------------------//");
				System.out.println("Cuanto dinero deseas consignar");
				double dinero = entrada.nextDouble();
				cliente.setSaldo(cliente.getSaldo() + dinero);
				System.out.println("La consignacion se ha realizado exitosamente");
				System.out.println("                  //---------------------//--------------------//---------------------//");
				break;
			}
			else if(i == clientes.size() - 1) {
				System.out.println("La cedula ingresada no se encuentra registrada en el sistema");		
				System.out.println("Transaccion fallida");			
			}
		}		
	}
	
	
	/*Este metodo le resta dinero al cliente 1 y se la transfiere al cliente2, esta es una manera aunque si todo se desea realizar por consola 
	se debe de realizar un metodo donde pida los datos por consola creeria yo */	
//	public static void tranferenciaSaldo(Cliente cliente1, Cliente cliente2) {
//		System.out.println("                  //---------------------//--------------------//---------------------//");
//		System.out.println("Cuanto dinero deseas transferir ");
//		double dinero = entrada.nextDouble();
//		cliente1.setSaldo(cliente1.getSaldo() - dinero);
//		cliente2.setSaldo(cliente2.getSaldo() + dinero);
//		System.out.println("La transferencia se ha realizado exitosamente");
//		System.out.println("                  //---------------------//--------------------//---------------------//");
//	}
	
	/*Este metodo verifica que tanto la cedula del depositante como el receptor exista y luego verifica que el depositante si tenga los fondos suficientes 
	para realizar la tranferencia*/
	public static void tranferenciaSaldo() {
		System.out.println("                  //---------------------//--------------------//---------------------//");
		System.out.println("Ingrese la cedula del depositante ");
		String cedula1 = entrada.next();
		System.out.println("Ingrese la cedula del cliente a quien se le va a realizar el deposito ");
		String cedula2 = entrada.next();
		Cliente depositante = null;
		Cliente receptor = null;
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getCedula().equals(cedula1)) {
				depositante = clientes.get(i);
			}
			else if(clientes.get(i).getCedula().equals(cedula2)) {
				receptor = clientes.get(i);;
			}
		}
		if(depositante != null && receptor != null) {
			System.out.println("Ingrese la cantidad de dinero que deseas transferir ");
			double dinero = entrada.nextDouble();
			if(depositante.getSaldo() >= dinero) {
				depositante.setSaldo(depositante.getSaldo() - dinero);
				receptor.setSaldo(receptor.getSaldo() + dinero);
				System.out.println("La transferencia se ha realizado exitosamente");
				System.out.println("                  //---------------------//--------------------//---------------------//");				
			}
			else {
				System.out.println("El usuario no cuenta con fondos suficientes para realizar el deposito");
			}
			
		}
		else if(depositante == null && receptor != null) {
			System.out.println("La cedula " + cedula1 + " no se encuentra registrada en el sistema");
			System.out.println("Transaccion fallida");
		}
		else if(depositante != null && receptor == null) {
			System.out.println("La cedula " + cedula2 + " no se encuentra registrada en el sistema");
			System.out.println("Transaccion fallida");			
		}
		else if(depositante == null && receptor == null) {
			System.out.println("La cedula " + cedula1 + " no se encuentra registrada en el sistema");
			System.out.println("La cedula " + cedula2 + " no se encuentra registrada en el sistema");
			System.out.println("Transaccion fallida");			
		}
	}
	
	
	//Este metodo se encarga de mostrar el saldo si la cedula se encuentra en el sistema
	public static void mostrarSaldo() {
		System.out.println("                  //---------------------//--------------------//---------------------//");
		System.out.println("Ingresa la cedula del cliente de quien deseas ver el saldo");
		String cedula = entrada.next();
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getCedula().equals(cedula)) {
				System.out.println("                  //---------------------//--------------------//---------------------//");
				System.out.println(String.format("El saldo del cliente %s es %g", clientes.get(i).getNombre(), clientes.get(i).getSaldo()));
				System.out.println("                  //---------------------//--------------------//---------------------//");
				break;
			}
			else if(i == clientes.size() - 1) {
				System.out.println("La cedula ingresada no se encuentra registrada en el sistema");	
				System.out.println("Transaccion fallida");			
			}
		}
	}
	
	
	//Con este metodo mostramos todos los clientes registrados
	public static void mostrarClientes() {
		System.out.println("Informacion de los clientes");
		for(Cliente cliente: Cliente.getClientes()) {
			System.out.println("                  //---------------------//--------------------//---------------------//");
			System.out.println("cedula: " + cliente.getCedula());
			System.out.println("nombre: " + cliente.getNombre());
			System.out.println("saldo: " + cliente.getSaldo());
			System.out.println("                  //---------------------//--------------------//---------------------//");
		}
	}
	
	
	//Este metodo elimina un cliente si el numero de cedula ingresado existe
	public static void eliminarCliente() {
		System.out.println("                  //---------------------//--------------------//---------------------//");
		System.out.println("Ingresa la cedula del cliente a quien deseas eliminar");
		String cedula = entrada.next();
		for (int i = 0; i < clientes.size(); i++) {
			if(clientes.get(i).getCedula().equals(cedula)) {
				System.out.println("                  //---------------------//--------------------//---------------------//");
				clientes.remove(i);
				System.out.println("EL usuario se ha eliminado correctamente");
				System.out.println("                  //---------------------//--------------------//---------------------//");
				break;
			}
			else if(i == clientes.size() - 1) {
				System.out.println("La cedula ingresada no se encuentra registrada en el sistema");		
				System.out.println("Transaccion fallida");			
			}
		}
	}
	
}


















