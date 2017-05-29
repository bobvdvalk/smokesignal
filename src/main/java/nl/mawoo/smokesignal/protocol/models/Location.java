package nl.mawoo.smokesignal.protocol.models;

/**
 * {message}
 *
 * @author Bob van der Valk
 */
public class Location implements MessageType {
    private String latitude;
    private String longitude;

    public Location(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
