package nl.mawoo.smokesignal.model;

/**
 * This represents a connection node in the network
 *
 * @author Bob van der Valk
 */
public class Node {
    private String name;
    private String ip;
    private int port;

    public Node(String name, String ip, int port) {
        this.name = name;
        this.ip = ip;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
}
