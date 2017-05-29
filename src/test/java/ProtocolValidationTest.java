import nl.mawoo.smokesignal.protocol.MessageProtocol;
import nl.mawoo.smokesignal.protocol.models.MessageObject;
import nl.mawoo.smokesignal.protocol.validation.Validator;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertTrue;
/**
 * This is a integration test to see if the protocol and the validation are correct
 *
 * @author Bob van der Valk
 */
public class ProtocolValidationTest {
    private static Logger logger = Logger.getLogger(ProtocolValidationTest.class);

    @Test
    public void validateProtocol() throws NoSuchAlgorithmException {
        MessageObject messageObject = MessageProtocolTest.connectionMessageObj();
        MessageProtocol protocol = new MessageProtocol(messageObject);
        String generatedMessage = protocol.constructMessage();
        logger.info(generatedMessage);
        boolean valid = Validator.check(generatedMessage);
        logger.info("valid message: "+ valid);
        assertTrue(valid);
    }
}
