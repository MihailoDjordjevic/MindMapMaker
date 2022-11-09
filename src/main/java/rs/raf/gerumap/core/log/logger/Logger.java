package rs.raf.gerumap.core.log.logger;

import rs.raf.gerumap.core.log.message.EventMessage;
import rs.raf.gerumap.observer.ISubscriber;

import java.io.IOException;

public interface Logger extends ISubscriber {
     void log(final EventMessage eventMessage) throws IOException;

}