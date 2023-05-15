package Clases;


public class Main extends IOOperations{

	public static void main(String[] args) {

		readAll(); // Lee todos los archivos y los guarda en los arrayList
		
		// Se leen todos los arrayList
		System.out.println("Cantidad de clientes: " + listClientes.size()); 
		for(int i = 0; i < listClientes.size(); i++) {
			System.out.println(listClientes.get(i).toString());
		}
		System.out.println("Cantidad de productos: " + listProductos.size());
		for(int i = 0; i < listProductos.size(); i++) {
			System.out.println(listProductos.get(i).toString());
		}
		System.out.println("Cantidad de ventas: " + listVentas.size());
		for(int i = 0; i < listVentas.size(); i++) {
			System.out.println(listVentas.get(i).toString());
		}
	
//      clear vacia una lista
//		listClientes.clear();
		

		Cliente cliente = new Cliente();
		cliente.setClave(listClientes.size()); //Asignar el ultimo elemento a la clave, solo para diferenciar
		
		listClientes.add(cliente); // Agregar el nuevo cliente a la lista
		writeAll(); // Reescribir todas las listas
		
	}

}
