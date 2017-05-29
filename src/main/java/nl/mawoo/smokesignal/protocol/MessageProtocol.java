package nl.mawoo.smokesignal.protocol;

import com.google.gson.Gson;
import nl.mawoo.smokesignal.protocol.models.MessageObject;
import nl.mawoo.smokesignal.protocol.validation.MD5Generator;
import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;

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

    /**
     * This method generates a message that can be send through the correct protocol
     * @return String with md5~{json}
     */
    public String constructMessage() {
        String json = constructJson();
        MD5Generator md5Generator = new MD5Generator(json);
        String md5 = null;
        try {
            md5 = md5Generator.generateMd5();
        } catch (NoSuchAlgorithmException e) {
            logger.error("Cannot parse json to md5", e);
        }
        return md5 +"~"+ json;
    }

    /**
     * This class converts a messageObject to a json format.
     * @return String in json format
     */
    public String constructJson() {
        Gson gson = new Gson();
        return gson.toJson(messageObject);
    }
}
