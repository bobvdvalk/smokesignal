package nl.mawoo.smokesignal.protocol;

import com.google.gson.Gson;
import nl.mawoo.smokesignal.protocol.models.MessageObject;
import org.apache.log4j.Logger;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class MessageProtocol {
    private static Logger logger = Logger.getLogger(MessageProtocol.class);
    private MessageObject messageObject;

    public MessageProtocol(MessageObject messageObject) {
        this.messageObject = messageObject;
    }

    public String constructJsonMessage() {
        Gson gson = new Gson();
        return gson.toJson(messageObject);
    }
}
