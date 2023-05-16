package UI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class RegistrarClient extends Form{
	

	RegistrarClient() {
		super("Registrar", "Registrar Cliente");
		this.setLocationRelativeTo(null);
		this.add(contentPanel, BorderLayout.CENTER);

//		verticalFormGap = 40;

		
		
		this.revalidate();
		this.repaint();
	}

	public static void main(String[] args) {
		new RegistrarClient();
	}
	
}
