package UI;

public class Tables extends TitleFrame{

	Tables(String texto) {
		super(texto);
		this.setLocationRelativeTo(null);

	}
	public static void main(String[] args) {
		new Tables("Consultar");
	}
}
