package nl.mawoo.smokesignal.util;

/**
 * Looks like a unit test but just a temp area
 *
 * @author Bob van der Valk
 */
public class Util {
    public static String random4DigitNumber() {
        return String.valueOf((int)(Math.random()*9000)+1000);
    }
}
