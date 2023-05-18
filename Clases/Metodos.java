package Clases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Metodos extends IOOperations{

	public static boolean consultarFecha(String texto, ArrayList<String> al) {
		for(String text : al) {
			if(text.equals(texto)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<String> retornarFechas() {
		ArrayList<String> fechasArray = new ArrayList<>();
		
		for(Venta venta : listVentas) {
			if(!consultarFecha(venta.getFecha(), fechasArray)) {
				fechasArray.add(venta.getFecha());
			} 
		}
		
		return fechasArray;
	}
	public static ArrayList<String> retornarIdProductos() {
		ArrayList<String> idArray = new ArrayList<>();
		
		for(Producto producto : listProductos) {
			idArray.add(String.valueOf(producto.getCodigo()));
		}
		
		return idArray;
	}
	public static ArrayList<String> retornarIdClientes() {
		ArrayList<String> idArray = new ArrayList<>();
		
		for(Cliente cliente : listClientes) {
			idArray.add(String.valueOf(cliente.getClave()));
		}
		
//		String[] ids = new String[idArray.size()];
//		for(int i = 0; i < idArray.size(); i++) {
//			ids[i] = idArray.get(i);
//		}
		
		return idArray;
	}

	public static boolean registrarCliente(int clave, String nombre,String rfc,String domicilio, String fecha) {

		boolean existe = false;
		for (int i = 0; i < listClientes.size(); i++) {
			if (listClientes.get(i).getClave() == clave) {
				existe = true;
				break;
			}
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, "Clave existente");
			return false;

		} else {
			Cliente c1 = new Cliente(clave, rfc, nombre, fecha, domicilio);
			listClientes.add(c1);
			JOptionPane.showMessageDialog(null, "Cliente registrado con éxito");
		}
		return true;
	}

	public static boolean registrarMueble(int codigo, String descripcion, String color, String dimension, int existencia, int precio) {

		boolean existe = false;
		for (int i = 0; i < listProductos.size(); i++) {
			Producto mueble = listProductos.get(i);
			if (mueble.getCodigo() == codigo) {
				existe = true;
			}
		}
		if (existe) {
			JOptionPane.showMessageDialog(null, "Codigo existente");
			return false;
		} else {
			Producto m1 = new Producto(codigo, descripcion, color, dimension, existencia, precio);
			listProductos.add(m1);
			JOptionPane.showMessageDialog(null, "Mueble registrado con éxito");
		}
		return true;
	}

	public static boolean registrarVenta(int cantidad, int codigoProducto, int codigoCliente, String fecha) {

		Cliente cliente = null;
		
		for (int i = 0; i < listClientes.size(); i++) {
			if (listClientes.get(i).getClave() == codigoCliente) {
				cliente = listClientes.get(i);
				break;
			}
		}

		if (cliente == null) {
			JOptionPane.showMessageDialog(null, "Cliente inexistente");
			return false;
		}

		Producto producto = null;
		for (int i = 0; i < listProductos.size(); i++) {
			if (listProductos.get(i).getCodigo() == codigoProducto) {
				producto = listProductos.get(i);
				break;
			}
		}

		if (producto == null) {
			JOptionPane.showMessageDialog(null, "Código inexistente");
			return false;
		}

		if (producto.getExistencia() < cantidad) {
			JOptionPane.showMessageDialog(null, "Cantidad insuficiente");
			return false;
		}
		if( cantidad == 0) {
			return false;
		}

		producto.setExistencia(producto.getExistencia() - cantidad);
		int costo = cantidad * producto.getPrecio();

		Venta v1 = new Venta(fecha, codigoCliente, codigoProducto, cantidad, costo);
		listVentas.add(v1);
		return true;
	}

	public static String[][] mostrarVentaDia(String fecha) {
		ArrayList<Venta> ventasDia = new ArrayList<>();

		for (int i = 0; i < listVentas.size(); i++) {
			Venta venta = listVentas.get(i);

			if (venta.getFecha() != null && venta.getFecha().equals(fecha)) {
				ventasDia.add(venta);

			}
		}
		if (ventasDia.size() == 0) {
			JOptionPane.showMessageDialog(null, "No existen ventas en la fecha");
			return new String[][] {{"", "", "", ""}};
		} else {
			String[][] matrizReturn = new String[ventasDia.size()][4];
			String mensaje = "Ventas del día " + fecha + ":\n";

			for (int i = 0; i < ventasDia.size(); i++) {
				Venta venta = ventasDia.get(i);
				matrizReturn[i][0] = String.valueOf(venta.getCodigoCliente());
				matrizReturn[i][1] = String.valueOf(venta.getCodigoProducto());
				matrizReturn[i][2] = String.valueOf(venta.getCantidad());
				matrizReturn[i][3] = String.valueOf(venta.getCosto());
				
				mensaje += "Cliente: " + venta.getCodigoCliente() +
						"\n Producto: " + venta.getCodigoProducto() +
						"\n Cantidad: " + venta.getCantidad() +
						"\n Costo: " + venta.getCosto() + "\n";
			}

			JOptionPane.showMessageDialog(null, mensaje);
			return matrizReturn;
		}
	}
	public static String[][] mostrarVentaProducto(int id) {
		ArrayList<Venta> ventasProducto = new ArrayList<>();
		
		for (int i = 0; i < listVentas.size(); i++) {
			Venta venta = listVentas.get(i);
			
			if (venta.getFecha() != null && venta.getCodigoProducto() == id ) {
				ventasProducto.add(venta);		
			}
			
		}
//		int codigo,String descripcion, String color, String dimension, int existencia, int precio
		if (ventasProducto.size() == 0) {
			JOptionPane.showMessageDialog(null, "No existen ventas con ese id");
			return new String[][] {{"", "", "", ""}};
		} else {
			String[][] matrizReturn = new String[ventasProducto.size()][4];
			String mensaje = "Ventas con id " + id + ":\n";
			
			for (int i = 0; i < ventasProducto.size(); i++) {
				Venta venta = ventasProducto.get(i);
				matrizReturn[i][0] = venta.getFecha();
				matrizReturn[i][1] = String.valueOf(venta.getCodigoCliente());
				matrizReturn[i][2] = String.valueOf(venta.getCantidad());
				matrizReturn[i][3] = String.valueOf(venta.getCosto());
				
				mensaje += "Cliente: " + venta.getCodigoCliente() +
						"\n Producto: " + venta.getCodigoProducto() +
						"\n Cantidad: " + venta.getCantidad() +
						"\n Costo: " + venta.getCosto() + "\n";
			}
			
			JOptionPane.showMessageDialog(null, mensaje);
			return matrizReturn;
		}
	}

	public static String[][] mostrarVentasCliente(int claveCliente) {
		Cliente cliente = null;
		boolean clienteEncontrado = false;
		
		for (int i = 0; i < listClientes.size(); i++) {
			if (listClientes.get(i).getClave() == claveCliente) {
				cliente = listClientes.get(i);
				clienteEncontrado = true;
				break;
			}
		}
		if (!clienteEncontrado) {
			JOptionPane.showMessageDialog(null, "Cliente inexistente");
			return new String[][] {{"", "", "", ""}};
		}

		ArrayList<Venta> ventasCliente = new ArrayList<>();
		for (int i = 0; i < listVentas.size(); i++) {
			Venta venta = listVentas.get(i);
			
			if (venta.getCodigoCliente() == claveCliente) {
				ventasCliente.add(venta);
			}
		}

		if (ventasCliente.size() == 0) {
			JOptionPane.showMessageDialog(null, "El cliente no ha realizado ventas");
			return new String[][] {{"", "", "", ""}};
		} else {
			String[][] matrizReturn = new String[ventasCliente.size()][4];

			String mensaje = "Ventas del cliente: " + cliente.getNombre() + "\n";

			for (int i = 0; i < ventasCliente.size(); i++) {
				Venta venta = ventasCliente.get(i);
				
				matrizReturn[i][0] = venta.getFecha();
				matrizReturn[i][1] = String.valueOf(venta.getCodigoProducto());
				matrizReturn[i][2] = String.valueOf(venta.getCantidad());
				matrizReturn[i][3] = String.valueOf(venta.getCosto());
				
				mensaje += "\n Fecha: " + venta.getFecha() +
						"\n Producto: " + venta.getCodigoProducto() +
						"\n Cantidad: " + venta.getCantidad() +
						"\n Costo: " + venta.getCosto() + "\n";
			}
			JOptionPane.showMessageDialog(null, mensaje);
			return matrizReturn;
		}
		
	}
	public static void consultarClienteClave(int clave) {
	    Cliente cliente = null;
	    boolean enc = false;

	    for (int i = 0; i < listClientes.size(); i++) {
	        if (listClientes.get(i).getClave() == clave) {
	            cliente = listClientes.get(i);
	            enc = true;
	            break;
	        }
	    }

	    if (enc) {
	        String mensaje = "Datos del cliente:\n" +
	                "Nombre: " + cliente.getNombre() + "\n" +
	                "RFC: " + cliente.getRfc() + "\n" +
	                "Domicilio: " + cliente.getDomicilio() + "\n" +
	                "Fecha de nacimiento: " + cliente.getFecha() + "\n" +
	                "Ventas registradas:\n";

	        ArrayList<Venta> ventasCliente = new ArrayList<>();
	        for (int i = 0; i < listVentas.size(); i++) {
	            Venta venta = listVentas.get(i);
	            if (venta.getCodigoCliente() == clave) {
	                ventasCliente.add(venta);
	            }
	        }

	        if (ventasCliente.size() == 0) {
	            mensaje += "No existen ventas con el cliente";
	        } else {
	            for (int i = 0; i < ventasCliente.size(); i++) {
	                Venta venta = ventasCliente.get(i);
	                mensaje += "Fecha: " + venta.getFecha() +
	                        ", Código de producto: " + venta.getCodigoProducto() +
	                        ", Cantidad: " + venta.getCantidad() +
	                        ", Costo: " + venta.getCosto() + "\n";
	            }
	        }

	        JOptionPane.showMessageDialog(null, mensaje);
	    } else {
	        JOptionPane.showMessageDialog(null, "Cliente inexistente");
	    }
	}
	 public static boolean consultarClienteNombre(String nombre) {
	        Cliente enc = null;

	        for (int i = 0; i < listClientes.size(); i++) {
	            Cliente cliente = listClientes.get(i);
	            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
	                enc = cliente;
	                break;
	            }
	        }

	        if (enc != null) {
	            String mensaje = "Datos del cliente:\n" +
	                    "Nombre: " + enc.getNombre() + "\n" +
	                    "RFC: " + enc.getRfc() + "\n" +
	                    "Domicilio: " + enc.getDomicilio() + "\n" +
	                    "Fecha de nacimiento: " + enc.getFecha() + "\n" +
	                    "Ventas registradas:\n";

	            ArrayList<Venta> ventasCliente = new ArrayList<>();
	            for (int i = 0; i < listVentas.size(); i++) {
	                Venta venta = listVentas.get(i);
	                if (venta.getCodigoCliente() == enc.getClave()) {
	                    ventasCliente.add(venta);
	                }
	            }

	            if (ventasCliente.size() == 0) {
	                mensaje += "No existen ventas con el cliente";
	            } else {
	                for (int i = 0; i < ventasCliente.size(); i++) {
	                    Venta venta = ventasCliente.get(i);
	                    mensaje += "Fecha: " + venta.getFecha() +
	                            ", Código de producto: " + venta.getCodigoProducto() +
	                            ", Cantidad: " + venta.getCantidad() +
	                            ", Costo: " + venta.getCosto() + "\n";
	                }
	            }

	            JOptionPane.showMessageDialog(null, mensaje);
	            return true;
	        } else {
	            JOptionPane.showMessageDialog(null, "Cliente inexistente");
	            return false;
	        }
	    }

	public static void main(String[] args) {

//		registrarCliente(22, "Karla", "rfck", "AV.Morelos","13-05-2023");
////		registrarCliente(22, "jduf", null, null, null);
//
//		registrarMueble(34, "Mesa", "cafe", "20x20", 5, 500);
////		registrarMueble(34, null, null, null, 0, 0);
//
////		registrarVenta(3, 34, 22, "13-05-2023");
//		registrarVenta(1, 34, 22, "13-05-2023");
//		registrarVenta(1, 34, 22, "13-05-2022");
//		registrarVenta(1, 34, 22, "13-05-2022");
//		registrarVenta(1, 34, 22, "13-05-2022");
//		registrarVenta(1, 34, 22, "13-05-2000");
////		registrarVenta(1, 34, 22, "13-05-2023");
//		consultarClienteClave(22);
//		consultarClienteNombre("Karla");

		
//		mostrarVentaDia("13-05-2023");
//		String[][] matriz = mostrarVentasCliente(22);
//		
//		for (String[] strings : matriz) {
//			for (String string : strings) {
//				System.out.println(string);
//			}
//		}
//		String[][] matriz1 = mostrarVentaDia("13-05-2023");
//		for (String[] strings : matriz1) {
//			for (String string : strings) {
//				System.out.println(string);
//			}
//		}
//		String [][] matriz1 = mostrarVentaProducto(34);
//		for (String[] strings : matriz1) {
//			for (String string : strings) {
//				System.out.println(string);
//			}
//		}
//		System.out.println("a");
//		ArrayList<String> fechas = retornarFechas();
//		for(String fecha : fechas) {
//			System.out.println(fecha);
//		}
	}

	
}

