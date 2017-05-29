package nl.mawoo.smokesignal.protocol.models;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class PeerRemote {
    private String ip;
    private int port;

    public PeerRemote(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
}
