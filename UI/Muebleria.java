package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Clases.Cliente;
import Clases.Venta;

public class Muebleria extends ButtonsFrame {
	
	JPanel[] panels = new JPanel[] {
			new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 10)),
			new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10))};
	
	private JLabel labelTemp = new JLabel("");
	private JLabel labelAux = new JLabel();
	private JLabel ventaTitle = new JLabel();

	private GridBagConstraints position = new GridBagConstraints();
	
	private JButton ventaButton = new JButton();
		
	private JLabel[] labels = new JLabel[]{
			new JLabel("Fecha"),
			new JLabel("ID Cliente"),
			new JLabel("ID Producto"),			
			new JLabel("Cantidad")			
	};
	public JTextArea[] textAreas = new JTextArea[] {
			new JTextArea(), 
			new JTextArea("0"), 
			new JTextArea("0"), 
			new JTextArea("0"), 
	};
	Venta venta;
	
	Muebleria(String textTittle, String textButtonLeft, String textButtonRight) {
		super(textTittle, textButtonLeft, textButtonRight);
		this.setLocationRelativeTo(null);
		this.titlePanel.remove(titleButton);

		position.fill = GridBagConstraints.BOTH;

		// Cambiar espacio vertical en botones
		buttonsLayout.setVgap(0);
		labelAux.setPreferredSize(new Dimension(700, 200));

		// Crear label para el mensaje temporal 
		labelTemp.setPreferredSize(new Dimension(700, 40));
		labelTemp.setFont(tableTextFont);
		labelTemp.setVerticalAlignment(JLabel.TOP);
		labelTemp.setHorizontalAlignment(JLabel.CENTER);
		
		// Agregar ambos labels
		buttonsContainer.add(labelTemp, 0);
		buttonsContainer.add(labelAux);
		
		// Tamaños en formulario
		contentLayout.rowHeights = new int[] {150, 200, 30, 150};
		panels[0].setMinimumSize(new Dimension(200, 180));
		panels[1].setMinimumSize(new Dimension(300, 180));
		
		// Agregar titulo del formulario
		ventaTitle.setText("Registrar Venta");
		ventaTitle.setFont(textFont);
		contentPanel.add(ventaTitle, position);
		
		// Agregar paneles 
		position.gridy = 1;
		for(int i = 0; i < panels.length; i++) {
			position.gridx = i;
			contentPanel.add(panels[i], position);
		}
		
		// Estilizar labels y textAreas
		StaticUtilities.stylesLabels(this, labels, textFont, new Dimension(150, 30), JLabel.LEFT);
		StaticUtilities.stylesTextAreas(this, textAreas, textFont, new Dimension(260, 30));
		StaticUtilities.time(textAreas[0]);
		textAreas[0].setEditable(false);
		// Añadir Labels y TextAreas
		for(int i = 0; i < labels.length; i++) {
			panels[0].add(labels[i]);
			panels[1].add(textAreas[i]);
		}
		
		position.gridy = 2;
		position.gridx = 0;
		position.gridwidth = 2;
		ventaButton = StaticUtilities.createButton(this, this, "Registrar", new Dimension(300, 30), textFont, buttonStaticColor);

		contentPanel.add(ventaButton, position);
		
		this.add(buttonsContainer, BorderLayout.SOUTH);
		this.add(contentPanel, BorderLayout.CENTER);
				
		this.revalidate();
		this.repaint();
	}

	public void actionPerformed(ActionEvent e){
		super.actionPerformed(e);
		
		if(e.getSource() == ventaButton) {
			try {
				String fecha = textAreas[0].getText();
				int idCliente = Integer.parseInt(textAreas[1].getText());
				int idProducto = Integer.parseInt(textAreas[2].getText());
				int cantidad = Integer.parseInt(textAreas[3].getText().toString());
//				registrarVenta(fecha, idCliente, idProducto, cantidad);
				if(StaticUtilities.registerTest(true)) {
					StaticUtilities.temporalMessage(labelTemp, "Se Registro Correctamente", Color.BLUE);
				}else{
					StaticUtilities.temporalMessage(labelTemp, "No se registro la Venta", Color.RED);				
				}
			}catch(NumberFormatException ex) {
				StaticUtilities.temporalMessage(labelTemp, "Solo se aceptan numeros (0-10 digitos)", Color.RED);
			}
		}
	}
	
	@Override
	public void actionLeft() {
		System.out.println("Left");
		new Consult("Consultar", "Left", "Right");
		StaticUtilities.returnButton.push(this);
		this.dispose();
	}

	@Override
	public void actionRight() {
		System.out.println("Right");
		new Registrar("Registro", "Left", "Right");
		StaticUtilities.returnButton.push(this);
		this.dispose();
	}
	
	public static void main(String[] args) {
		new Muebleria("Muebleria", "ButtonLeft", "ButtonRight");
	}
}
