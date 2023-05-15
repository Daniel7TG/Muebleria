package Clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOOperations {
	
	/*
	 * Heredar esta clase en la clase de metodos para poder acceder a las listas, propiedades y metodos
	 * facilmente
	 * Hacer un readAll (o readFile) al momento de iniciar el programa para obtener los datos
	 * Hacer un writeAll (o writeFile) al momento de finalizar el programa para guardar los datos obtenidos
	 * o actualizar los datos ya existentes
	 * Solo readAll y writeAll son publicos para facilitar el manejo de la clase
	 */
	
	/*
	 * Definir archivos con ubicaciones relativas al proyecto
	 */
	static File fileClientes = new File("src/Clases/Clients.txt");
	static File fileProductos = new File("src/Clases/Productos.txt");
	static File fileVentas = new File("src/Clases/Ventas.txt");

	/*
	 * Definir arreglos vacios para almacenar los objetos de manera temporal
	 */
	static ArrayList<Cliente> listClientes = new ArrayList<>();
	static ArrayList<Producto> listProductos = new ArrayList<>();
	static ArrayList<Venta> listVentas = new ArrayList<>();
	
	
	/*
	 * Revisar que cada uno de los documentos exista, en caso de no existir, crea uno nuevo
	 */
	private static void checkFiles() {
		boolean checked = true;
		do {			
			try {
				if(!fileClientes.exists()) { // Verificar si no existe
					fileClientes.createNewFile(); // Crear nuevo documento
				}
				else if(!fileProductos.exists()) {
					fileProductos.createNewFile();
				}
				else if(!fileVentas.exists()) {
					fileVentas.createNewFile();
				} else {
					checked = false; // En caso de que todos existan salir del metodo
				}
			} catch (IOException e) {
				e.printStackTrace();
			}		
		} while(checked);
	}
	
	
	/*
	 * Escribir lo que exista en un arreglo para insertarlo en un documento
	 */
	private static <T> void writeFile(ArrayList<T> list, File file) {		
		checkFiles(); // Verificar archivos
		try {
			ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file)); // Crear enlace
			for(int i = 0; i < list.size(); i++) {
				objectOutput.writeObject(list.get(i)); // Escribir todos los objetos en el archivo
			}
			objectOutput.flush();
			objectOutput.close(); // Cerrar enlace
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	/*
	 * Leer individualmente cada archivo y almacenarlo en una lista
	 */
	private static void readFile(File file) {
		checkFiles(); // Verificar archivos
		try {
			ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file)); // Crear enlace
			
			if(file.equals(fileClientes)) { // Comprobar cual de los 3 archivos es el pasado como argumento
				while(true){
					listClientes.add((Cliente)objectInput.readObject()); // Agregar objetos hasta que ocurra un error
				}
			} else if(file.equals(fileProductos)) {
				while(true){
					listProductos.add((Producto)objectInput.readObject());
				}
			} else if(file.equals(fileVentas)) {				
				while(true){
					listVentas.add((Venta)objectInput.readObject());
				}
			}
			objectInput.close(); // Cerrar enlace
			
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		} catch (IOException e) {
//			System.out.println("IO Exception");
			// Al momento de terminar los objetos arrojara esta exception
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");			
		}
	}
	
	/*
	 * Leer todos los archivos 
	 */
	public static void readAll() {
		readFile(fileClientes);
		readFile(fileProductos);
		readFile(fileVentas);
	}
	
	
	public static void writeAll() {
		writeFile(listClientes, fileClientes);
		writeFile(listProductos, fileProductos);
		writeFile(listVentas, fileVentas);
	}

}
