package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Clases.Metodos;

public class Tables extends TitleFrame{

	DefaultTableModel model;
	
//	String[][] matrizVentasTest = new String[][] {
//		{"Fecha", "Cliente ID", "Producto ID", "Costo"},
//		{"Fecha", "Cliente ID", "Producto ID", "Costo"},
//		{"Fecha", "Cliente ID", "Producto ID", "Costo"},
//		{"Fecha", "Cliente ID", "Producto ID", "Costo"},
//		{"Fecha", "Cliente ID", "Producto ID", "Costo"},
//		{"Fecha", "Cliente ID", "Producto ID", "Costo"},
//		{"Fecha", "Cliente ID", "Producto ID", "Costo"},
//		};
//	String[][] matrizClientesTest = new String[][] {
//		{"Clave", "Nombre", "RFC", "Fecha Nacimiento", "Domicilio"},
//		{"Clave", "Nombre", "RFC", "Fecha Nacimiento", "Domicilio"},
//		{"Clave", "Nombre", "RFC", "Fecha Nacimiento", "Domicilio"},
//		{"Clave", "Nombre", "RFC", "Fecha Nacimiento", "Domicilio"},
//		{"Clave", "Nombre", "RFC", "Fecha Nacimiento", "Domicilio"},
//		{"Clave", "Nombre", "RFC", "Fecha Nacimiento", "Domicilio"},
//		};
//	String[][] matrizProductosTest = new String[][] {
//			{"Clave", "Descripcion", "Color", "Dimensiones", "Existencias", "Precio"},
//			{"Clave", "Descripcion", "Color", "Dimensiones", "Existencias", "Precio"},
//			{"Clave", "Descripcion", "Color", "Dimensiones", "Existencias", "Precio"},
//			{"Clave", "Descripcion", "Color", "Dimensiones", "Existencias", "Precio"},
//			{"Clave", "Descripcion", "Color", "Dimensiones", "Existencias", "Precio"},
//			{"Clave", "Descripcion", "Color", "Dimensiones", "Existencias", "Precio"},
//			{"Clave", "Descripcion", "Color", "Dimensiones", "Existencias", "Precio"}			
//		};
//	String[] clientesTest = new String[] {"12"};
	
	String[][] emptyData = new String[][] {{}};
	String[] emptyColumns = new String[] {};	
	
	
	
	JTable clientsTable = new JTable();
	JTable productsTable = new JTable();	
	JTable ventasTable = new JTable();	

	JTable table = new JTable();	
	
	JPanel comboBoxesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 60));
//	JPanel tablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	JComboBox<String> objectComboBox = new JComboBox<>(new String[] {"-- Seleccionar Tabla --", "Fecha", "ID Cliente", "ID Producto"});
	JComboBox<String> elementComboBox = new JComboBox<>(new String[] {""});
	
	Tables(String texto) {
		super(texto);
		this.setLocationRelativeTo(null);
		
		model = new DefaultTableModel(emptyData, emptyColumns) {
	    	@Override
	    	public boolean isCellEditable(int row, int column){
	    		return false;
	    	}
	    };
		
		//Tamaños de tabla
		contentLayout.rowHeights = new int[]{150, 360};
		contentLayout.columnWidths = new int[]{this.getWidth() - 20 };
		
		GridBagConstraints position = new GridBagConstraints();
		position.fill = GridBagConstraints.BOTH;
		position.gridx = 0;
		
//	    String[][] data = {
//	    	 { "1", "4031", "azul", "19x2", "4", "123" },
//	    	 { "1", "4031", "azul", "19x2", "4", "123" },
//	    	 { "1", "4031", "azul", "19x2", "4", "123" },
//	    	 { "1", "4031", "azul", "19x2", "4", "123" },
//	    	 { "1", "4031", "azul", "19x2", "4", "123"  }
//	    };    
//	    String[] columnNames = { "Codigo", "Descripcion", "Color", "Dimensiones", "Existencias", "Precio" }; 
	    
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
//		tablePanel.setPreferredSize(new Dimension(300, 200));
		
		table = new JTable(model);
		
		table.setFont(tableTextFont);
//		table.setPreferredSize(new Dimension(this.getWidth() - 20, 310));
		table.setRowHeight(30);
		table.setBackground(contentBackgroundColor);
		table.setDefaultRenderer(Object.class, centerRenderer);

		JScrollPane tableScroll = new JScrollPane(table);		
		tableScroll.setBackground(contentBackgroundColor);
//		tableScroll.setPreferredSize(new Dimension(0, 0));
		tableScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		elementComboBox.setPreferredSize(new Dimension(150, 30));
		elementComboBox.addActionListener(this);
		
		objectComboBox.setPreferredSize(new Dimension(150, 30));
		objectComboBox.addActionListener(this);
		
		position.gridy = 0;
		
		comboBoxesPanel.setPreferredSize(new Dimension(300, 200));
		comboBoxesPanel.setBackground(contentBackgroundColor);
		comboBoxesPanel.add(objectComboBox);
		comboBoxesPanel.add(elementComboBox);
		contentPanel.add(comboBoxesPanel, position);

		position.gridy = 1;	
//		tablePanel.add(tableScroll);
		contentPanel.add(tableScroll, position);
		
		this.add(contentPanel, BorderLayout.CENTER);
		
		this.revalidate();
		this.repaint();
	}
	public static void main(String[] args) {
			
		new Tables("Consultar");
	}
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		String object = (String) objectComboBox.getSelectedItem();
		if(e.getSource() == objectComboBox) {			
			System.out.println("bbbbbbbbbbbbbbbb");
//			model.setDataVector(matrizVentasTest, new String[] {"Fecha", "Cliente ID", "Producto ID", "Costo"});
			elementComboBox.removeAllItems();
			elementComboBox.addItem("--Seleccionar--");
			elementComboBox.setSelectedItem("--Seleccionar--");
			if(object.equals("Fecha")) {
				for(String fecha : Metodos.retornarFechas()) {
					elementComboBox.addItem(fecha);					
				}
//				model.setDataVector(Metodos.mostrarVentasCliente(), emptyColumns);
//				model.setDataVector(functions.mostrarVentas(), new String[] {"Fecha", "Cliente ID", "Producto ID", "Costo"});
//			    model.setColumnIdentifiers(new String[] {"Fecha", "Cliente ID", "Producto ID", "Costo"});
			} else if(object.equals("ID Cliente")) {
				for(String clienteId : Metodos.retornarIdClientes()) {
					elementComboBox.addItem(clienteId);					
				}
//				model.setDataVector(matrizClientesTest, new String[] {"Clave", "Nombre", "RFC", "Fecha Nacimiento", "Domicilio"});
//				model.setColumnIdentifiers(new String[] {"Clave", "Nombre", "RFC", "Fecha Nacimiento", "Domicilio"});				
			} else if(object.equals("ID Producto")) {				
				for(String productoId : Metodos.retornarIdProductos()) {
					elementComboBox.addItem(productoId);					
				}
//				model.setDataVector(matrizProductosTest, new String[] {"Clave", "Descripcion", "Color", "Dimensiones", "Existencias", "Precio"});
//				model.setColumnIdentifiers(new String[] {"Descripcion", "Color", "Dimensiones", "Existencias", "Precio"});				
			} else {
				model.setDataVector(emptyData, emptyColumns);
			}
//			model.setDataVector(emptyData, emptyColumns);
			
//			table.setColumnModel(null);
		}
		if(e.getSource() == elementComboBox) {
			System.out.println("aaaaaaaaaaaaaaaaaaaa");
			String itemSelected = (String) elementComboBox.getSelectedItem();
			
			if(object.equals("--Seleccionar--")) {
				
			} else if(object.equals("Fecha")) {
//				model.setDataVector(Metodos.mostrarVentasDia(Integer.parseInt(itemSelected)), new String[] {"Id Producto", "Id Cliente", "Cantidad", "Costo"});								
			} else if(object.equals("ID Cliente")) {
				
				model.setDataVector(Metodos.mostrarVentasCliente(12), new String[] {"Fecha", "Id Producto", "Cantidad", "Costo"});				
			} else if(object.equals("ID Producto")) {
//				model.setDataVector(Metodos.mostrarVentasProducto(Integer.parseInt(itemSelected)), new String[] {"Fecha", "Id Cliente", "Cantidad", "Costo"});								
			} else {
				model.setDataVector(emptyData, emptyColumns);				
			}
		}
		
	}
}
