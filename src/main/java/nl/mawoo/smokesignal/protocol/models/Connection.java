package nl.mawoo.smokesignal.protocol.models;

import java.util.List;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class Connection implements MessageType {
    private List<PeerRemote> peers;

    public Connection(List<PeerRemote> peers) {
        this.peers = peers;
    }

    public List<PeerRemote> getPeers() {
        return peers;
    }
}
