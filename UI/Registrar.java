package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.NumberFormat.Style;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Registrar extends ButtonsFrame{

	JButton rest = new JButton();
	JButton sum = new JButton();
	JButton confirm = new JButton();
	JTextArea idProduct = new JTextArea();
	JLabel quantity = new JLabel("0");
	int elementsHeight = 50;
	
	JPanel addExistencesContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
	JPanel productArea = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	JPanel productQuantity = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
	
	Registrar(String textTittle, String textButtonLeft, String textButtonRight) {
		super(textTittle, textButtonLeft, textButtonRight);
		this.setLocationRelativeTo(null);

		buttonsLayout.setVgap(120);
		this.add(buttonsContainer, BorderLayout.CENTER);
		
		addExistencesContainer.setBackground(null);
		productQuantity.setBackground(null);
		productArea.setBackground(null);
		addExistencesContainer.setPreferredSize(new Dimension(0, 150));
		
//		idProduct.setPreferredSize(new Dimension(120, elementsHeight));
//		quantity.setPreferredSize(new Dimension(40, elementsHeight));
	     
		confirm = StaticUtilities.createButton(this, this, "Add", new Dimension(70, elementsHeight), tableTextFont, buttonStaticColor);
		rest = StaticUtilities.createButton(this, this, "-", new Dimension(elementsHeight, elementsHeight), tableTextFont, buttonStaticColor);
//		quantity.setEditable(false);
		sum = StaticUtilities.createButton(this, this, "+", new Dimension(elementsHeight, elementsHeight), tableTextFont, buttonStaticColor);
		
		StaticUtilities.stylesTextAreas(this, new JTextArea[]{idProduct}, new Font("Maiandra GD", Font.PLAIN, elementsHeight), new Dimension(160, elementsHeight));
		idProduct.setBackground(null);
		idProduct.setBorder(BorderFactory.createLineBorder(Color.gray, 1, true));
		
		StaticUtilities.stylesLabels(this, new JLabel[]{quantity}, textFont, new Dimension(90, elementsHeight), JLabel.CENTER);
		
		productArea.add(idProduct);
		productArea.add(confirm);
		productQuantity.add(rest);
		productQuantity.add(quantity);
		productQuantity.add(sum);
		
		addExistencesContainer.add(productArea);
		addExistencesContainer.add(productQuantity);
		
		this.add(addExistencesContainer, BorderLayout.SOUTH);
		this.revalidate();
		this.repaint();

	}

	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		if(e.getSource() == sum) {
			int number = 1 + Integer.parseInt(quantity.getText());
			quantity.setText(String.valueOf(number));
		} else if(e.getSource() == rest) {
			
			int number = Integer.parseInt(quantity.getText()) - 1;
			if(number >= 0) {
				quantity.setText(String.valueOf(number));				
			}
			
		} else if(e.getSource() == confirm) {
			
		} 
	}
	@Override
	public void actionLeft() {
		System.out.println("Left");
		new RegistrarClient();
		StaticUtilities.returnButton.push(this);
		this.dispose();	
	}

	@Override
	public void actionRight() {
		System.out.println("Left");
		new RegistrarProduct();
		StaticUtilities.returnButton.push(this);
		this.dispose();	
	}

	public static void main(String[] args) {
		new Registrar("Registrar", "Clientes", "Productos");
	}
}
