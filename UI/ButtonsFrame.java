package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public abstract class ButtonsFrame extends TitleFrame{

	public JButton buttonLeft = new JButton();
	public JButton buttonRight = new JButton();
	
	public JPanel buttonsContainer = new JPanel();
//	JLabel label = new JLabel();
	public int buttonHeight = 150;
	private int buttonWidth = 250;
	public int verticalGap = 50;
	public int horizontalGap = 150;
	private Dimension buttonSize = new Dimension(buttonWidth, buttonHeight);

	public FlowLayout buttonsLayout = new FlowLayout(FlowLayout.CENTER, horizontalGap, verticalGap);
	
	ButtonsFrame(String textTittle, String textButtonLeft, String textButtonRight) {
		super(textTittle);


		
		buttonLeft = StaticUtilities.createButton(this, this, textButtonLeft ,buttonSize, textFont, buttonStaticColor);
		buttonRight = StaticUtilities.createButton(this, this, textButtonRight ,buttonSize, textFont, buttonStaticColor);
		buttonsContainer.add(buttonLeft);
		buttonsContainer.add(buttonRight);
		
//		buttonsLayout.setAlignment(FlowLayout.CENTER);
//		buttonsLayout.setVgap(verticalGap);
//		buttonsLayout.setHgap(verticalGap);
		buttonsContainer.setLayout(buttonsLayout);
		buttonsContainer.setBackground(null);		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		if( e.getSource() == buttonLeft ) {
			actionLeft();
		}
		else if( e.getSource() == buttonRight) {
			actionRight();			
		}
	}
	
	public abstract void actionLeft();
	public abstract void actionRight();
	
}
