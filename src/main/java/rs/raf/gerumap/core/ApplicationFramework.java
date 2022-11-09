package rs.raf.gerumap.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.errorHandling.logger.ConsoleLogger;
import rs.raf.gerumap.errorHandling.logger.FileLogger;
import rs.raf.gerumap.errorHandling.MessageGeneratorImplementation;
import rs.raf.gerumap.globalView.gui.Gui;

@Setter
@Getter
@NoArgsConstructor
public class ApplicationFramework {
    protected MessageGeneratorImplementation messageGeneratorImplementation;
    protected ConsoleLogger consoleLogger;
    protected FileLogger fileLogger;
    private static ApplicationFramework instance;
    protected Gui gui;
    protected IMapRepository iMapRepository;
    public void run(){
        this.gui.start();
    }
    public void initialise(Gui gui, IMapRepository mapRepository) {
        this.gui = gui;
        this.iMapRepository = mapRepository;
        initialiseLogger();
        manageSubscriptions();
    }
    public void initialiseLogger(){
        messageGeneratorImplementation = new MessageGeneratorImplementation();
        consoleLogger = new ConsoleLogger();
        fileLogger = new FileLogger();
    }
    public void manageSubscriptions(){
        messageGeneratorImplementation.addSubscriber(gui);
        messageGeneratorImplementation.addSubscriber(consoleLogger);
        messageGeneratorImplementation.addSubscriber(fileLogger);
    }
    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }
}
