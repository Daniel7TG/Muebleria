package UI;

import java.awt.BorderLayout;

public class Registrar extends ButtonsFrame{

	Registrar(String textTittle, String textButtonLeft, String textButtonRight) {
		super(textTittle, textButtonLeft, textButtonRight);
		this.add(buttonsContainer, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);

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

}
