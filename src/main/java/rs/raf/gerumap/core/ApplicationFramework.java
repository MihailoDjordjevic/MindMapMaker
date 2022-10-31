package rs.raf.gerumap.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.view.gui.Gui;

@Setter
@Getter
@NoArgsConstructor
public class ApplicationFramework {
    private static ApplicationFramework instance;
    protected Gui gui;
    protected IMapRepository iMapRepository;

    public void run(){
        this.gui.start();
    }
    public void initialise(Gui gui, IMapRepository mapRepository) {
        this.gui = gui;
        this.iMapRepository = mapRepository;
    }
    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}
