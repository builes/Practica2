import java.util.Scanner;

public class Main {

	static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		Creamos un objeto de la la clase text para poder usar los metodos ya que no los defini estaticos
		Text text = new Text();
		
		
		//Desde aca en el manin crearemos algunos clientes 
		Cliente cliente1 = new Cliente("1", "Mauricio");
		Cliente cliente2 = new Cliente("2", "Juan", 150000);
		Cliente cliente3 = new Cliente("3", "Luis", 50000);
		Cliente cliente4 = new Cliente("4", "Julian", 10000);
		
	
		text.presentacion();
		while(true) {
			text.opciones();
			String eleccion = entrada.next();
			if(eleccion.equals("1")) {
				CajeroAutomatico.registrarCliente();
				 System.out.println("                  //---------------------//--------------------//---------------------//");
				System.out.println("Si deseas realizar alguna otra operacion escribe S  de lo contrario presiona cualquier tecla");
				String respuesta = entrada.next();
				if(respuesta.equalsIgnoreCase("s")) {
					text.opciones();
				}
				else {
					System.out.println("Fue un gusto atenderte que estes bien");
					 System.out.println("                  //---------------------//--------------------//---------------------//");
					break;
				}				
			}
			else if(eleccion.equals("2")) {
				CajeroAutomatico.realizarConsignacion();
				 System.out.println("                  //---------------------//--------------------//---------------------//");
				System.out.println("Si deseas realizar alguna otra operacion escribe S  de lo contrario presiona cualquier tecla");
				String respuesta = entrada.next();
				if(respuesta.equalsIgnoreCase("s")) {
					text.opciones();
				}
				else {
					System.out.println("Fue un gusto atenderte que estes bien");
					 System.out.println("                  //---------------------//--------------------//---------------------//");
					break;
				}	
			}
			else if(eleccion.equals("3")) {
				CajeroAutomatico.tranferenciaSaldo();
				System.out.println("                  //---------------------//--------------------//---------------------//");
				System.out.println("Si deseas realizar alguna otra operacion escribe S  de lo contrario presiona cualquier tecla");
				String respuesta = entrada.next();
				if(respuesta.equalsIgnoreCase("s")) {
					text.opciones();
				}
				else {
					System.out.println("Fue un gusto atenderte que estes bien");
					 System.out.println("                  //---------------------//--------------------//---------------------//");
					break;
				}	
			}
			else if(eleccion.equals("4")) {
				CajeroAutomatico.mostrarSaldo();
				 System.out.println("                  //---------------------//--------------------//---------------------//");
				System.out.println("Si deseas realizar alguna otra operacion escribe S  de lo contrario presiona cualquier tecla");
				String respuesta = entrada.next();
				if(respuesta.equalsIgnoreCase("s")) {
					text.opciones();
				}
				else {
					System.out.println("Fue un gusto atenderte que estes bien");
					 System.out.println("                  //---------------------//--------------------//---------------------//");
					break;
				}	
			}
			else if(eleccion.equals("5")) {
				CajeroAutomatico.mostrarClientes();
				 System.out.println("                  //---------------------//--------------------//---------------------//");
				System.out.println("Si deseas realizar alguna otra operacion escribe S  de lo contrario presiona cualquier tecla");
				String respuesta = entrada.next();
				if(respuesta.equalsIgnoreCase("s")) {
					text.opciones();
				}
				else {
					System.out.println("Fue un gusto atenderte que estes bien");
					 System.out.println("                  //---------------------//--------------------//---------------------//");
					break;
				}	
				
			}
			else if(eleccion.equals("6")) {
				CajeroAutomatico.eliminarCliente();
				 System.out.println("                  //---------------------//--------------------//---------------------//");
				System.out.println("Si deseas realizar alguna otra operacion escribe S  de lo contrario presiona cualquier tecla");
				String respuesta = entrada.next();
				if(respuesta.equalsIgnoreCase("s")) {
					text.opciones();
				}
				else {
					System.out.println("Fue un gusto atenderte que estes bien");
					 System.out.println("                  //---------------------//--------------------//---------------------//");
					break;
				}	
			}
			else if(eleccion.equals("0")) {
				System.out.println("Fue un gusto atenderte que estes bien");
				System.out.println("                  //---------------------//--------------------//---------------------//");
				break;
			}
			else {
				System.out.println("No has ingresado una opcion valida intentalo nuevamente");
				text.opciones();
			}
		}	

	}

}
