package nl.mawoo.smokesignal.networking;

import nl.mawoo.smokesignal.comminucation.Validator;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * This class is to report when there is a incoming message and he can send messages.
 *
 * @author Bob van der Valk
 */
public class Peer extends Thread {
    private static Logger logger = Logger.getLogger(Peer.class);

    private final Socket socket;
    private final PrintWriter writer;
    private final Scanner scanner;
    private final List<Consumer<String>> messageListeners = new ArrayList<>();

    public Peer(Socket socket) throws IOException {
        this.socket = socket;
        this.writer = new PrintWriter(socket.getOutputStream());
        this.scanner = new Scanner(socket.getInputStream());
    }

    /**
     * Send a message to a peer
     * @param text
     */
    public void send(String text) {
        writer.println(text);
        writer.flush();
    }

    public void addMessageListener(Consumer<String> messageListener) {
        messageListeners.add(messageListener);
    }

    private void notifyMessageListeners(String message) {
        for(Consumer<String> listener : messageListeners) {
            listener.accept(message);
        }
    }

    @Override
    public void run() {
        while(scanner.hasNextLine()) {
            String message = scanner.nextLine();
            //todo: add protocol
            notifyMessageListeners(message);
        }
    }
}
