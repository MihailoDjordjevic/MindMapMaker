package rs.raf.gerumap;

import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.gui.IGui;
import rs.raf.gerumap.core.IMapRepository;
import rs.raf.gerumap.globalView.gui.SwingGui;
import rs.raf.gerumap.model.repository.MapRepositoryImplementation;

public class Main {
	public static void main(String[] args) {
		ApplicationFramework applicationFramework = ApplicationFramework.getInstance();
		IGui IGui = new SwingGui();
		IMapRepository iMapRepository = new MapRepositoryImplementation();
		applicationFramework.initialise(IGui, iMapRepository);
		applicationFramework.run();
	}
}