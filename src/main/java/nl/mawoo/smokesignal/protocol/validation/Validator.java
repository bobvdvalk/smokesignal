package nl.mawoo.smokesignal.protocol.validation;

import nl.mawoo.smokesignal.protocol.MessageExploder;
import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;

/**
 * This class checks if messages are valid
 *
 * @author Bob van der Valk
 */
public class Validator {
    private static Logger logger = Logger.getLogger(Validator.class);

    public static boolean check(String message) throws NoSuchAlgorithmException {
        MessageExploder exploder = new MessageExploder(message);
        exploder.explodeMessage();
        MD5Generator md5Generator = new MD5Generator(exploder.getMessage());
        String newHash = md5Generator.generateMd5();
        return exploder.getMd5Hash().equals(newHash);
    }
}
