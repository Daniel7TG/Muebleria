package Clases;

import java.io.Serializable;

public class Venta implements Serializable{
	
	private static final long serialVersionUID = -924573656419088919l;

	private String fecha;
	private int codigoCliente;
	private int codigoProducto;
	private int cantidad;
	private int costo;
	
	public Venta(){
	}
	Venta(String fecha, int codigoCliente, int codigoProducto, int cantidad){
		this.fecha = fecha;
		this.codigoCliente = codigoCliente;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
//		this.costo = costo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	@Override
	public String toString() {
		return "Venta [fecha=" + fecha + ", codigoCliente=" + codigoCliente + ", codigoProducto=" + codigoProducto
				+ ", cantidad=" + cantidad + ", costo=" + costo + "]";
	}

}
