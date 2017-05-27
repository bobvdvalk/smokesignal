package nl.mawoo.smokesignal.networking;

import nl.mawoo.smokesignal.model.Node;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * Listen and send messages through sockets
 *
 * @author Bob van der Valk
 */
public class P2P extends Thread implements AutoCloseable {
    private final ServerSocket serverSocket;
    private List<Node> connList = new ArrayList<>();


    public P2P(ServerSocket serverSocket) {
        super("P2PConnectionClass");
        this.serverSocket = serverSocket;
    }

    /**
     * Close any connection
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        serverSocket.close();
    }
}
