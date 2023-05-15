package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Clases.Cliente;
import Clases.Venta;

public class MuebleriaCopia extends ButtonsFrame {
	
	private JPanel borderAuxPanel = new JPanel(new BorderLayout());
	private JPanel panelLabels = new JPanel();
	private FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
	private JButton ventaButton;
	JPanel pane;
	JPanel panelAuxRight;
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
	
	MuebleriaCopia(String textTittle, String textButtonLeft, String textButtonRight) {
		super(textTittle, textButtonLeft, textButtonRight);
		this.setLocationRelativeTo(null);

		this.titlePanel.remove(titleButton);

		
//		String fecha = calendario.getTime().toLocaleString();
		pane = new JPanel();
		BoxLayout box = new BoxLayout(pane, BoxLayout.Y_AXIS);
		
		
//		pane.setMinimumSize(new Dimension(100, 100));
//		box.minimumLayoutSize(pane);
		pane.setLayout(new FlowLayout(FlowLayout.CENTER));
//		textAreas[0].setText(StaticUtilities.time(this, calendario));
		
//		panelLabels.setLayout(flowLayout);
//		panelLabels.setBackground(Color.black);
		StaticUtilities.time(this);
		
		for(JLabel label : labels) {
			label.setFont(textFont);
			pane.add(label);
			label.setPreferredSize(new Dimension(350, 30));
			label.setHorizontalAlignment(JLabel.CENTER);
		}
//		textAreas[0].setBackground(Color.white);
//		textAreas[0].setText(fecha);
		textAreas[0].setEditable(false);
//		contentPanel.add(textAreas[0]);
		
	
		contentPanel.setLayout(flowLayout);
		for(int i = 0; i < labels.length; i++) {
			textAreas[i].setAlignmentX(JTextArea.CENTER_ALIGNMENT);
			textAreas[i].setPreferredSize(new Dimension(350, 30));
			textAreas[i].setFont(textFont);
			pane.add(labels[i]);
			pane.add(textAreas[i]);
		}
		
		JPanel panelAux = new JPanel();
		panelAux.setPreferredSize(new Dimension(125, 200));
		JPanel panelAuxTop = new JPanel();
		panelAuxTop.setPreferredSize(new Dimension(250,15));
		panelAuxRight = new JPanel();
		panelAuxRight.setPreferredSize(new Dimension(375, 200));
		
		ventaButton = StaticUtilities.createButton(this, this, "Registrar Venta", new Dimension(200, 100), textFont, buttonStaticColor);
		ventaButton.setBounds(0, 0, 100, 100);
		
		panelAuxRight.add(ventaButton);
		borderAuxPanel.add(panelAux, BorderLayout.WEST);
		borderAuxPanel.add(panelAuxRight, BorderLayout.EAST);
		borderAuxPanel.add(panelAuxTop, BorderLayout.NORTH);
		borderAuxPanel.add(pane, BorderLayout.CENTER);
		
		borderAuxPanel.setBackground(null);
//		panelLabels.setBackground(null);
		panelAuxRight.setBackground(null);
		panelAux.setBackground(null);
//		pane.setBackground(null);
		pane.setBackground(titleBackgroundColor);
		
		buttonsLayout.setVgap(00);
		buttonsContainer.setPreferredSize(new Dimension(0, 210));
		this.add(buttonsContainer, BorderLayout.SOUTH);
		this.add(borderAuxPanel, BorderLayout.CENTER);
		
		this.revalidate();
		this.repaint();
	}

	public void actionPerformed(ActionEvent e){
		super.actionPerformed(e);
		
		if(e.getSource() == ventaButton) {
			if(StaticUtilities.registerTest(true)) {
				StaticUtilities.temporalMessage(this, panelAuxRight, "aaaaaaaaaaaaaaaaaaaaaa");
				pane.setBackground(Color.black);
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
		new ConsultClients("Registro");
		StaticUtilities.returnButton.push(this);
		this.dispose();
	}
	
	public static void main(String[] args) {
		new MuebleriaCopia("Muebleria", "ButtonLeft", "ButtonRight");
	}
}
