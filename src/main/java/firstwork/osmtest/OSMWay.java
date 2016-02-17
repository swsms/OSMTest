package firstwork.osmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем on 17.02.2016.
 */
public class OSMWay extends OSMElement {
    private List<OSMNode> nodes;

    public OSMWay(int id, String version) {
        super(id, version);
        this.nodes = new ArrayList<>();
    }

    public List<OSMNode> getNodes() {
        return nodes;
    }
}
