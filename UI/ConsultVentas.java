package UI;

public class ConsultVentas extends TitleFrame{

	ConsultVentas(String text){
		super(text);
		this.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new ConsultVentas("Consultar Ventas");
	}
}
