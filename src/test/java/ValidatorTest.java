import nl.mawoo.smokesignal.comminucation.Validator;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertTrue;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class ValidatorTest {
    private static Logger logger = Logger.getLogger(ValidatorTest.class);
    private static String exampleMessage = "311f80a8ae1ea75f199701af0fde2ead~{\"message\":\"De geit is gemolken\",\"datetime\":\"2017/05/26\"}";

    @Test
    public void CheckMessage() throws NoSuchAlgorithmException {
        assertTrue(Validator.check(exampleMessage));
    }
}
