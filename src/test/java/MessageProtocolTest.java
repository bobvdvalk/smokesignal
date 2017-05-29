import nl.mawoo.smokesignal.protocol.MessageProtocol;
import nl.mawoo.smokesignal.protocol.models.Connection;
import nl.mawoo.smokesignal.protocol.models.MessageObject;
import nl.mawoo.smokesignal.protocol.models.PeerRemote;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Test the message protocol
 *
 * @author Bob van der Valk
 */
public class MessageProtocolTest {
    private static final Logger LOGGER = Logger.getLogger(MessageProtocolTest.class);

    public static MessageObject connectionMessageObj() {
        PeerRemote peer = new PeerRemote("localhost", 5587);
        PeerRemote peer1 = new PeerRemote("localhost", 1245);
        PeerRemote peer2 = new PeerRemote("localhost", 1244);
        PeerRemote peer3 = new PeerRemote("localhost", 8512);
        List<PeerRemote> peerRemotes = new ArrayList<>();
        peerRemotes.add(peer);
        peerRemotes.add(peer1);
        peerRemotes.add(peer2);
        peerRemotes.add(peer3);

        Connection connection = new Connection(peerRemotes, new Date());
        return new MessageObject("connection", connection, new Date());
    }

    @Test
    public void objectJsonParse() {
        MessageProtocol protocol = new MessageProtocol(connectionMessageObj());
        LOGGER.info(protocol.constructJsonMessage());
    }
}
