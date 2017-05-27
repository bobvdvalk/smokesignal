package nl.mawoo.smokesignal.GUI;

import nl.mawoo.smokesignal.networking.Peer;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Controls every in and output of the application
 *
 * @author Bob van der Valk
 */
public class Cli extends Thread {
    private final Scanner scanner;
    private final List<Peer> peers = new ArrayList<>();
    private final String handle;
    private final Consumer<String> connectCallback;

    public Cli(Scanner scanner, String handle, Consumer<String> connectCallback) {
        this.scanner = scanner;
        this.handle = handle;
        this.connectCallback = connectCallback;
    }

    public void addPeer(Peer peer) {
        peer.addMessageListener(System.out::println);
        peers.add(peer);
        say("welcome in the network", peer);
    }

    private void say(String message, Peer peer) {
        peer.send(MessageFormat.format("{0,time,medium} [{1}] - {2}", new Date(), handle, message));
    }

    private void sayToAll(String message) {
        for (Peer peer : peers) {
            say(message, peer);
        }
    }

    @Override
    public void run() {
        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            // Als dit met een slash begint dan verbinden we met die host
            if (line.startsWith("/")) {
                connectCallback.accept(line.substring(1));
            } else {
                // Dus nu gaan we gewoon alle user input sturen naar alle peers
                sayToAll(line);
            }

        }
    }
}
