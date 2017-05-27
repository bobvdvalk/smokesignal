import nl.mawoo.smokesignal.util.Util;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class RandomPortTest {
    private static Logger logger = Logger.getLogger(RandomPortTest.class);


    @Test
    public void randomNumberTest() {
        logger.info(Util.random4DigitNumber());
    }
}
