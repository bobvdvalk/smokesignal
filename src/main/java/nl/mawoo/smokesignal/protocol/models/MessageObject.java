package nl.mawoo.smokesignal.protocol.models;

import java.util.Date;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class MessageObject {
    private String type;
    private Object data;
    private Date datetime;

    public MessageObject(String type, Object data, Date datetime) {
        this.type = type;
        this.data = data;
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public Object getData() {
        return data;
    }

    public Date getDatetime() {
        return datetime;
    }
}
