package nl.mawoo.smokesignal.networking;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Listen and send messages through sockets
 *
 * @author Bob van der Valk
 */
public class P2P extends Thread implements AutoCloseable {
    private static Logger logger = Logger.getLogger(P2P.class);

    private final ServerSocket serverSocket;
    private List<Consumer<Socket>> connList = new ArrayList<>();


    public P2P(ServerSocket serverSocket) {
        super("P2PConnectionClass");
        this.serverSocket = serverSocket;
    }

    public void addNodeListener(Consumer<Socket> nodeListener) {
        if(nodeListener != null) {
            connList.add(nodeListener);
        }
    }

    private void notifyNewClient(Socket socket) {
        logger.info("New connection with "+ socket.getInetAddress());
        Runnable notification = () -> {
            for (Consumer<Socket> clientListener : connList) {
                clientListener.accept(socket);
            }
        };

        Thread notifyThread = new Thread(notification, "Client Notify Thread");
        notifyThread.setDaemon(true);
        notifyThread.start();
    }

    @Override
    public void run() {
        while(!serverSocket.isClosed()) {
            try {
                Socket newSocket = serverSocket.accept();
                notifyNewClient(newSocket);
            } catch (IOException e) {
                logger.error("Cannot accept the connection", e);
            }
        }
    }

    public void connect(String host) {
        int portIndex = host.indexOf(':');
        connect(host.substring(0, portIndex), Integer.parseInt(host.substring(portIndex + 1)));
    }

    public void connect(String host, int port) {
        try {
            connect(InetAddress.getByName(host), port);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void connect(InetAddress host, int port) {
        try {
            Socket socket = new Socket(host, port);
            notifyNewClient(socket);
        } catch (IOException e) {
            throw new IllegalStateException("There went something wrong", e);
        }
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
