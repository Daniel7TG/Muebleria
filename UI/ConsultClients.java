package UI;

public class ConsultClients extends TitleFrame{

	ConsultClients(String text){
		super(text);
		this.setLocationRelativeTo(null);

	}
	
	public static void main(String[] args) {
		new ConsultClients("Clientes");
	}
	
}
