package nl.mawoo.smokesignal.util;

/**
 * Util class with functions you use but they are small functions
 *
 * @author Bob van der Valk
 */
public class Util {
    public static String random4DigitNumber() {
        return String.valueOf((int)(Math.random()*9000)+1000);
    }
}
