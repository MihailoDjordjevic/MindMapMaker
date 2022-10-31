package rs.raf.gerumap.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ApplicationFramework {
    private static ApplicationFramework instance;
    protected Gui gui;
    protected IGeRuMapRepository iGeRuMapRepository;

    public void run(){
        this.gui.start();
    }
    public void initialise(Gui gui, IGeRuMapRepository mapRepository) {
        this.gui = gui;
        this.iGeRuMapRepository = mapRepository;
    }
    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}
