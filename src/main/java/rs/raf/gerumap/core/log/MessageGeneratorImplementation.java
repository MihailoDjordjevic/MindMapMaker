package rs.raf.gerumap.core.log;

import rs.raf.gerumap.core.log.message.CannotRemoveNodeMessage;
import rs.raf.gerumap.core.log.message.MessageDescription;
import rs.raf.gerumap.observer.IPublisher;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;
import java.util.ArrayList;
import java.util.List;

public class MessageGeneratorImplementation implements MessageGenerator, IPublisher {
    private List<ISubscriber> subscribers;
    public MessageGeneratorImplementation(){
        subscribers = new ArrayList<>();
    }
    @Override
    public void addSubscriber(final ISubscriber sub) {
        subscribers.add(sub);
    }
    @Override
    public void removeSubscriber(final ISubscriber sub) {
        subscribers.remove(sub);
    }
    @Override
    public void notifySubscribers(final Object notification, final NotificationType notificationType) {
        for (ISubscriber subscriber : subscribers){
            subscriber.update(notification, notificationType);
        }
    }
    @Override
    public void generateMessage(MessageDescription messageDescription) {
        switch (messageDescription){
            case CANNOT_REMOVE_NODE -> notifySubscribers(new CannotRemoveNodeMessage(), NotificationType.MESSAGE);
        }
    }
}