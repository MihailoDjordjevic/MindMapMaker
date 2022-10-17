package rs.raf.main;


public class MyApp {
	public static void main(String[] args) {
		MainFrame mainFrame = MainFrame.getInstance();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
}