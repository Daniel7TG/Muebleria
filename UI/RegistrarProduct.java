package UI;

import java.awt.BorderLayout;

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
}
