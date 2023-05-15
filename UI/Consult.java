package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Consult extends ButtonsFrame {
	
	private JLabel label = new JLabel("Productos escazos");
	private JScrollPane tableScroll;
	private JTable table;
	private DefaultTableCellRenderer centerRenderer;
	
	Consult(String textTittle, String textButtonLeft, String textButtonRight) {
		super(textTittle, textButtonLeft, textButtonRight);		
//		StaticUtilities.temporalMessage(this, "TEXTO", 0, 0);		
		this.setLocationRelativeTo(null);

		contentPanel.setLayout(new FlowLayout());
		contentPanel.setPreferredSize(new Dimension(0, 230));
		
		label.setFont(textFont);

		this.add(buttonsContainer, BorderLayout.CENTER);
			
		
        String[][] data = {
            { "1", "4031", "azul", "19x2", "4", "123" },
            { "1", "4031", "azul", "19x2", "4", "123"  }
        };
 
        String[] columnNames = { "Codigo", "Descripcion", "Color", "Dimensiones", "Existencias", "Precio" };
        
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        	@Override
			public boolean isCellEditable(int row, int column){
        		return false;
        	}
        };
        
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table = new JTable(model);
        table.setFont(tableTextFont);
        table.setRowHeight(30);
        table.setBackground(contentBackgroundColor);
        table.setDefaultRenderer(Object.class, centerRenderer);
      
        tableScroll = new JScrollPane(table);		
        tableScroll.setBackground(contentBackgroundColor);
        tableScroll.setPreferredSize(new Dimension(this.getWidth() - 20, 185));
        tableScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        contentPanel.add(label);
        contentPanel.add(tableScroll);
        
        this.add(contentPanel, BorderLayout.SOUTH);
  
        this.revalidate();
        this.repaint();	
	}

	@Override
	public void actionLeft() {
		System.out.println("Left");
		new ConsultClients("Clientes");
		StaticUtilities.returnButton.push(this);
		this.setVisible(false);
	}

	@Override
	public void actionRight() {
		System.out.println("Right");
		new ConsultVentas("Ventas");
		StaticUtilities.returnButton.push(this);
		this.dispose();
	}

	public static void main(String[] args) {
		new Consult("Consultar", "Clientes", "Productos");
	}

	
}
