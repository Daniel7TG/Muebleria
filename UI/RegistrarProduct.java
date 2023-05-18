package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import Clases.Metodos;

public class RegistrarProduct extends Form {

	RegistrarProduct(){
		super("Registrar", "Registrar Producto");
		this.setLocationRelativeTo(null);
		this.add(contentPanel, BorderLayout.CENTER);
		
		this.revalidate();
		this.repaint();
	}
	public static void main(String[] args) {
		new RegistrarProduct();
	}
	public void actionPerformed(ActionEvent e){
		super.actionPerformed(e);
		
		if(e.getSource() == ventaButton) {
			try {
				int idProducto = Integer.parseInt(textAreasProductos[0].getText());
				String descripcion = textAreasProductos[1].getText();
				String color = textAreasProductos[2].getText();
				String dimension = textAreasProductos[3].getText();
				int existencias = Integer.parseInt(textAreasProductos[4].getText());
				int precio = Integer.parseInt(textAreasProductos[5].getText());
				
//				registrarVenta(fecha, idCliente, idProducto, cantidad);
				if(Metodos.registrarMueble(idProducto, descripcion, color, dimension, existencias, precio)) {
					StaticUtilities.temporalMessage(labelTemp, "Se Registro Correctamente", textColor);
				}else{
					StaticUtilities.temporalMessage(labelTemp, "No se registro la Venta", textErrorColor);				
				}
			}catch(NumberFormatException ex) {
				StaticUtilities.temporalMessage(labelTemp, "Solo se aceptan numeros (0-10 digitos)", textErrorColor);
			}
		}
	}
}
