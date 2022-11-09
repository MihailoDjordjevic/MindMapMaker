package rs.raf.gerumap.errorHandling.logger;

import org.apache.commons.io.FileUtils;
import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.AbstractMessageEvent;
import rs.raf.gerumap.observer.NotificationType;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileLogger implements Logger{
    //private static final Path loggingParentPath = Paths.get(System.getProperty("user.dir")).resolve("Logging");
    private Path fileLogPath;
    private File file;
    public FileLogger() {
        URL fileLogPathString = this.getClass().getResource("log.txt");
        file = new File(fileLogPathString.getFile());
        fileLogPath = file.toPath();
    }
    @Override
    public void log(final AbstractMessageEvent eventMessage) {
        try{
            if(!Files.exists(fileLogPath)){
                Files.createFile(fileLogPath);
            }
            FileUtils.writeStringToFile(file, eventMessage.toString() + "\n", "UTF-8", true);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void update(final Object notification, NotificationType notificationType) {
        log((AbstractMessageEvent) notification);
    }
}