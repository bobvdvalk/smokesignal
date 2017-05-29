package nl.mawoo.smokesignal;


import nl.mawoo.smokesignal.GUI.Cli;
import nl.mawoo.smokesignal.networking.P2P;
import nl.mawoo.smokesignal.networking.Peer;
import nl.mawoo.smokesignal.util.Util;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 * Boot up the p2p application and listen for in and output
 *
 * @author Bob van der Valk
 */
public class SmokeSignal {
    private static final Logger LOGGER = Logger.getLogger(SmokeSignal.class);
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        LOGGER.info(" ----- Starting SmokeSignal application -----");
        LOGGER.info("Building socket");
        ServerSocket serverSocket = buildSocket();
        LOGGER.info("generating name");
        String handleName = getRandomName();

        P2P backend = new P2P(serverSocket);
        Cli cli = new Cli(SCANNER, handleName, backend::connect);

        backend.addNodeListener(socket -> {
            try {
                Peer peer = new Peer(socket);
                cli.addPeer(peer);
                peer.start();
            } catch (IOException e) {
                LOGGER.error("cannot start the peer. ", e);
            }
        });

        backend.start();
        cli.start();
        LOGGER.info("Connect to other clients typing: /host:port . Like /localhost:8080");
    }


    /**
     * Generate a random name for the client
     * @return client-{randomnumber}
     */
    private static String getRandomName() {
        return "client-"+ Util.random4DigitNumber();
    }

    /**
     * Use a random port number to build the socket
     * @return Active server socket
     */
    private static ServerSocket buildSocket() {
        ServerSocket result = null;
        while(result == null) {
            try {
                result = new ServerSocket(Util.random4DigitNumber());
            } catch (IOException e) {
                LOGGER.error("Could not connect to port. "+ port, e);
            }
        }
        LOGGER.info("connection found on port: "+ result.getLocalPort());
        return result;
    }
}
