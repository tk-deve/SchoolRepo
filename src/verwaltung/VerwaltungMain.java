package verwaltung;

public class VerwaltungMain {

	public static void main(String[] args) {
		VerwaltungView view = new VerwaltungView();
		VerwaltungController controller = new VerwaltungController(view);

	}

}
