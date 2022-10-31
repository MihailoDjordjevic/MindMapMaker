package rs.raf.gerumap;

import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.core.Gui;
import rs.raf.gerumap.core.IGeRuMapRepository;
import rs.raf.gerumap.gui.swing.SwingGui;
import rs.raf.gerumap.model.geRuMapRepository.GeRuMapRepositoryImplementation;

public class Main {
	public static void main(String[] args) {
		ApplicationFramework applicationFramework = ApplicationFramework.getInstance();
		Gui gui = new SwingGui();
		IGeRuMapRepository iGeRuMapRepository = new GeRuMapRepositoryImplementation();
		applicationFramework.initialise(gui, iGeRuMapRepository);
		applicationFramework.run();
	}
}