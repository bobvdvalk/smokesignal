package nl.mawoo.smokesignal.protocol;

import nl.mawoo.smokesignal.protocol.models.MessageType;

import java.util.Date;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class MessageProtocol {
    private String type;
    private MessageType messageType;
    private Date  datetime;

    public MessageProtocol(String type, MessageType messageType, Date datetime) {
        this.type = type;
        this.messageType = messageType;
        this.datetime = datetime;
    }

    public String constructJsonMessage() {
        
    }

}
