package rs.raf.gerumap.core.log.logger;

import lombok.NoArgsConstructor;
import rs.raf.gerumap.core.log.message.EventMessage;
import rs.raf.gerumap.observer.NotificationType;
@NoArgsConstructor
public class ConsoleLogger implements Logger{
    @Override
    public void log(final EventMessage eventMessage) {
        System.out.println(eventMessage);
    }
    @Override
    public void update(final Object notification, NotificationType notificationType) {
        log((EventMessage) notification);
    }
}