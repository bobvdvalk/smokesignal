package nl.mawoo.smokesignal.protocol;

/**
 * This class explodes the messages to parts we can validate and use it as JSON
 *
 * @author Bob van der Valk
 */
public class MessageExploder {
    private String incomingMsg;
    private String md5Hash;
    private String message;

    public MessageExploder(String incomingMsg) {
        this.incomingMsg = incomingMsg;
    }

    public void explodeMessage() {
        String[] explodedMsg = incomingMsg.split("~");
        this.md5Hash = explodedMsg[0];
        this.message = explodedMsg[1];
    }

    public String getMd5Hash() {
        return md5Hash;
    }

    public String getMessage() {
        return message;
    }
}
