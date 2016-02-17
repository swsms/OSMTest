package firstwork.osmtest;

/**
 * Created by Артем on 17.02.2016.
 */
public class OSMNode  extends OSMElement {
    /** Широта */
    private double lat;
    /** Долгота */
    private double lon;

    public OSMNode(int id, String version, double lat, double lon) {
        super(id, version);
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
