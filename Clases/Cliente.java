package Clases;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = -924573656419088919l;

	@Override
	public String toString() {
		return "Cliente [clave=" + clave + ", nombre=" + nombre + ", rfc=" + rfc + ", fecha=" + fecha + ", domicilio="
				+ domicilio + "]";
	}
	private int clave;
	private String nombre;
	private int rfc;
	private String fecha;
	private String domicilio;
	
	Cliente() {
	}
	Cliente(int clave, String nombre, int rfc, String fecha, String domicilio ) {
		this.clave = clave;
		this.nombre = nombre;
		this.rfc = rfc;
		this.fecha = fecha;
		this.domicilio = domicilio;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getRfc() {
		return rfc;
	}
	public void setRfc(int rfc) {
		this.rfc = rfc;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
}
