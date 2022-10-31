package rs.raf.gerumap.gui.general;

public class AppCore {
    private static AppCore instance;
    private SwingGui swingGui;
    public AppCore(){

    }
    public static AppCore getInstance(){
        if(instance == null){
            instance = new AppCore();
        }
        return instance;
    }
    public void startApp(){
        swingGui = new SwingGui();
        swingGui.start(swingGui);
    }
}