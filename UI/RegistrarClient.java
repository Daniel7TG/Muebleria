package UI;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class RegistrarClient extends Form{
	

	RegistrarClient() {
		super("Registrar", "Registrar Cliente");
		this.setLocationRelativeTo(null);

		verticalFormGap = 40;

//		this.revalidate();
//		this.repaint();
	}

	public static void main(String[] args) {
		new RegistrarClient();
	}
	
}
