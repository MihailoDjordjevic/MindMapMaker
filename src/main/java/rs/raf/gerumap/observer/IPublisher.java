package rs.raf.gerumap.observer;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public interface IPublisher {

    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscribers(Object notification, NotificationType notificationType);
}
