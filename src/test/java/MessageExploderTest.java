import nl.mawoo.smokesignal.protocol.MessageExploder;
import org.apache.log4j.Logger;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * This checks if the message checker fully works
 *
 * @author Bob van der Valk
 */
public class MessageExploderTest {
    private static Logger logger = Logger.getLogger(MessageExploderTest.class);
    private static String exampleMessage = "311f80a8ae1ea75f199701af0fde2ead~{\"message\":\"De geit is gemolken\",\"datetime\":\"2017/05/26\"}";

    @Test
    public void checkMd5() {
        MessageExploder messageExploder = new MessageExploder(exampleMessage);
        messageExploder.explodeMessage();
        assertEquals("311f80a8ae1ea75f199701af0fde2ead", messageExploder.getMd5Hash());
        logger.info("311f80a8ae1ea75f199701af0fde2ead - "+ messageExploder.getMd5Hash());

    }

    @Test
    public void checkMessage() {
        MessageExploder messageExploder = new MessageExploder(exampleMessage);
        messageExploder.explodeMessage();
        assertEquals("{\"message\":\"De geit is gemolken\",\"datetime\":\"2017/05/26\"}", messageExploder.getMessage());
        logger.info("{\"message\":\"De geit is gemolken\",\"datetime\":\"2017/05/26\"} - "+ messageExploder.getMessage());
    }

}
