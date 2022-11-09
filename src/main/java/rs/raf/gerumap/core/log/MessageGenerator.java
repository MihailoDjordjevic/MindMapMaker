package rs.raf.gerumap.core.log;

import rs.raf.gerumap.core.log.message.MessageDescription;

import java.io.IOException;

public interface MessageGenerator {
    void generateMessage(MessageDescription messageDescription) throws IOException;
}