package Clases;

import java.io.Serializable;

public class Producto implements Serializable{
	
	private static final long serialVersionUID = -924573656419088919l;

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", color=" + color + ", dimension="
				+ dimension + ", existencia=" + existencia + ", precio=" + precio + "]";
	}
	int codigo;
	private String descripcion;
	private String color;
	private String dimension;
	private int existencia;
	private int precio;
	
	Producto(){
	}
	Producto(String descripcion, String color, String dimension, int existencia, int precio){
		this.descripcion = descripcion;
		this.color = color;
		this.dimension = dimension;
		this.existencia = existencia;
		this.precio = precio;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public int getExistencia() {
		return existencia;
	}
	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
