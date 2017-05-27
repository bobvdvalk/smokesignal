package nl.mawoo.smokesignal.comminucation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class checks through MD5 if the message is valid.
 *
 * @author Bob van der Valk
 */
public class MD5Generator {
    private String bareMsg;

    public MD5Generator(String bareMsg) {
        this.bareMsg = bareMsg;
    }

    public String generateMd5() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(bareMsg.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
}
