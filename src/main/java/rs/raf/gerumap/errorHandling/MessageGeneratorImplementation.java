package rs.raf.gerumap.errorHandling;

import rs.raf.gerumap.errorHandling.message.CannotRemoveNodeMessage;
import rs.raf.gerumap.errorHandling.message.NoNodeSelectedMessage;
import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.MessageDescription;
import rs.raf.gerumap.errorHandling.message.WrongNodeSelectedMessage;
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
    public void generateMessage(MessageDescription messageDescription, Object source) {
        switch (messageDescription){
            case CANNOT_REMOVE_NODE -> notifySubscribers(new CannotRemoveNodeMessage(source), NotificationType.MESSAGE);
            case WRONG_NODE_SELECTED -> notifySubscribers(new WrongNodeSelectedMessage(source), NotificationType.MESSAGE);
            case NO_NODE_SELECTED -> notifySubscribers(new NoNodeSelectedMessage(source), NotificationType.MESSAGE);
        }
    }
}