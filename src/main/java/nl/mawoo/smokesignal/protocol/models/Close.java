package nl.mawoo.smokesignal.protocol.models;

import java.util.Date;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class Close implements MessageType {
    private Date datetime;

    public Close(Date datetime) {
        this.datetime = datetime;
    }

    public Date getDatetime() {
        return datetime;
    }
}
