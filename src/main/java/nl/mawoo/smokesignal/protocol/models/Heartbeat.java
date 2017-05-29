package nl.mawoo.smokesignal.protocol.models;

import java.util.Date;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class Heartbeat implements MessageType {
    private Date datetime;

    public Heartbeat(Date datetime) {
        this.datetime = datetime;
    }

    public Date getDatetime() {
        return datetime;
    }
}
