package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Clases.Venta;

public class Form extends TitleFrame{
	
	public int verticalFormGap = 10;
	
	JPanel[] panels = new JPanel[] {
			new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, verticalFormGap)),
			new JPanel(new FlowLayout(FlowLayout.CENTER, 0, verticalFormGap))};
	private JLabel labelTemp = new JLabel("");
	
//	int clave, String nombre, int rfc, String fecha, String domicilio
	private JLabel[] labelsClients = new JLabel[]{
			new JLabel("Clave"),
			new JLabel("Nombre"),
			new JLabel("RFC"),			
			new JLabel("Fecha Nacimiento"),
			new JLabel("Domicilio")
	};
	public JTextArea[] textAreasClients = new JTextArea[] {
			new JTextArea("0"), 
			new JTextArea(""), 
			new JTextArea(""), 
			new JTextArea("DD-MM-AAAA"), 
			new JTextArea(""), 
	};
//	String descripcion, String color, String dimension, int existencia, int precio
	private JLabel[] labelsProductos = new JLabel[]{
			new JLabel("Descripcion"),
			new JLabel("Color"),			
			new JLabel("Dimension"),			
			new JLabel("Existencias"),			
			new JLabel("Precio")			
	};
	public JTextArea[] textAreasProductos = new JTextArea[] {
			new JTextArea(""), 
			new JTextArea(""), 
			new JTextArea("0x0"), 
			new JTextArea("0"), 
			new JTextArea("0"), 
	};
	
	private JLabel formTitle = new JLabel();
	private GridBagConstraints position = new GridBagConstraints();
	private JButton ventaButton = new JButton();
	
//	JLabel[] labels;
//	JTextArea[] textAreas;
	
	Form(String texto, String textoForm) {
		super(texto);
		
		JLabel[] labels = textoForm.equals("Registrar Cliente") ? labelsClients : labelsProductos; 
		JTextArea[] textAreas = textoForm.equals("Registrar Cliente") ? textAreasClients : textAreasProductos; 
		
		position.fill = GridBagConstraints.BOTH;

		// Tamaños en formulario
		contentLayout.rowHeights = new int[] {50, 250, 30, 100};
		panels[0].setMinimumSize(new Dimension(200, 180));
		panels[1].setMinimumSize(new Dimension(300, 180));

		// Agregar titulo del formulario
		formTitle.setText(textoForm);
		formTitle.setFont(textFont);
		contentPanel.add(formTitle, position);

		// Agregar paneles 
		position.gridy = 1;
		for(int i = 0; i < panels.length; i++) {
			position.gridx = i;
			contentPanel.add(panels[i], position);
		}

		// Estilizar labels y textAreas
		StaticUtilities.stylesLabels(this, labels, textFont, new Dimension(150, 30), JLabel.LEFT);
		StaticUtilities.stylesTextAreas(this, textAreas, textFont, new Dimension(260, 30));


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
		this.add(contentPanel, BorderLayout.CENTER);

		position.gridy = 3;
		labelTemp.setHorizontalAlignment(JLabel.CENTER);
		contentPanel.add(labelTemp, position);
		//				JLabel labelAux = new JLabel(""); 		
		//				labelAux.setPreferredSize(new Dimension(700, 200));
		//
		//				this.add(labelAux, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
//		new Form("formulario");
	}
	
	public void actionPerformed(ActionEvent e){
		super.actionPerformed(e);
		
	}

	
}
