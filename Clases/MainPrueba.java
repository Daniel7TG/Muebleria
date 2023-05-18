package Clases;

import javax.swing.JOptionPane;

public class MainPrueba {

	public static void main(String[] args) {
		Metodos m = new Metodos();
		
		int resp; 
		do {
			resp = Integer.parseInt(JOptionPane.showInputDialog("Desea registrar un juguete: \n1.Si \n2.No"));
			m.registrarCliente(resp, null, null, null, null);
		}while(resp!=2);
		
		

		
	}

}
