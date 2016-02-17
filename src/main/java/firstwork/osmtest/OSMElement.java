package firstwork.osmtest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Артем on 17.02.2016.
 */
public abstract class OSMElement {
    /** Уникальный идентификатор объекта */
    private int id;
    /** Версия объекта */
    private String version;
    /** Набор тэгов */
    private Map<String, String> tags = new HashMap<>();

    public OSMElement(int id, String version) {
        this.id = id;
        this.version = version;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

}
