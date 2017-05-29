package nl.mawoo.smokesignal.protocol.models;

import java.util.Date;
import java.util.List;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class Connection implements MessageType {
    private List<PeerRemote> peers;
    private Date datetime;

    public Connection(List<PeerRemote> peers, Date datetime) {
        this.peers = peers;
        this.datetime = datetime;
    }

    public List<PeerRemote> getPeers() {
        return peers;
    }

    public Date getDatetime() {
        return datetime;
    }
}
