package rs.raf.gerumap;

import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.globalView.gui.IGui;
import rs.raf.gerumap.core.IMapRepository;
import rs.raf.gerumap.globalView.gui.SwingGui;
import rs.raf.gerumap.globalView.popUpPanes.editElementsPane.EditElementsPane;
import rs.raf.gerumap.model.repository.MapRepositoryImplementation;
import rs.raf.gerumap.model.repository.implementation.Term;

public class Main {
	public static void main(String[] args) {
		if(args.length > 0){
			if(args[0].equals("debug")){

			}
		}


		ApplicationFramework applicationFramework = ApplicationFramework.getInstance();
		IGui IGui = new SwingGui();
		IMapRepository iMapRepository = new MapRepositoryImplementation();
		applicationFramework.initialise(IGui, iMapRepository);
		applicationFramework.run();

	}
}