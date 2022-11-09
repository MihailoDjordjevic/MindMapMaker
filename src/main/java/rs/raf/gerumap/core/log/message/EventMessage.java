package rs.raf.gerumap.core.log.message;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventMessage {
    private String text;
    private EventType eventType;
    private Timestamp timestamp;
    private MessageDescription messageDescription;
    @Override
    public String toString() {
        return String.format("Event type: [%s]\nTimestamp: [%s]\nText: [%s]\n", this.eventType, this.timestamp, this.text);
    }
    public EventMessage(final EventType eventType){
        this.eventType = eventType;
        timestamp = new Timestamp(System.currentTimeMillis());
    }
}