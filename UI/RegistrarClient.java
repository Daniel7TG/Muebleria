package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import Clases.Metodos;

public class RegistrarClient extends Form{
	

	RegistrarClient() {
		super("Registrar", "Registrar Cliente");
		this.setLocationRelativeTo(null);
		this.add(contentPanel, BorderLayout.CENTER);
		panels[0].setMinimumSize(new Dimension(230, 180));
		StaticUtilities.stylesLabels(this, labelsClients, textFont, new Dimension(200, 30), JLabel.LEFT);
//		verticalFormGap = 40;

		
		
		this.revalidate();
		this.repaint();
	}

	public static void main(String[] args) {
		new RegistrarClient();
	}
	public void actionPerformed(ActionEvent e){
		super.actionPerformed(e);
		
		if(e.getSource() == ventaButton) {
			try {
				int idCliente = Integer.parseInt(textAreasClients[0].getText());
				String nombre = textAreasClients[1].getText();
				String rfc = textAreasClients[2].getText();
				String fecha = textAreasClients[3].getText();
				String domicilio = textAreasClients[4].getText();
//				registrarVenta(fecha, idCliente, idProducto, cantidad);
				if(Metodos.registrarCliente(idCliente, nombre, fecha, rfc, domicilio)) {
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
