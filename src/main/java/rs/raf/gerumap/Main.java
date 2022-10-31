package rs.raf.gerumap;

import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.view.gui.Gui;
import rs.raf.gerumap.core.IMapRepository;
import rs.raf.gerumap.view.gui.SwingGui;
import rs.raf.gerumap.model.repository.MapRepositoryImplementation;

public class Main {
	public static void main(String[] args) {
		ApplicationFramework applicationFramework = ApplicationFramework.getInstance();
		Gui gui = new SwingGui();
		IMapRepository iMapRepository = new MapRepositoryImplementation();
		applicationFramework.initialise(gui, iMapRepository);
		applicationFramework.run();
	}
}