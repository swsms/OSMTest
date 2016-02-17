package firstwork.osmtest;

import firstwork.common.Address;
import firstwork.common.Attraction;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Артем on 17.02.2016.
 */
public class Main {

    private static final String ADDR_HOUSE_NUMBER = "addr:housenumber";
    private static final String ADDR_CITY = "addr:city";
    private static final String ADDR_STREET = "addr:street";
    private static final String ATTRACTION_NAME = "name";

    /** Создание списка достопримечательностей на основе списка way */
    public static List<Attraction> getAttractionList(List<OSMWay> osmWays) {
        List<Attraction> attractions = new ArrayList<>();
        for (OSMWay way : osmWays) {
            if (isAttraction(way)) {
                attractions.add(parseAttraction(way.getTags()));
            }
        }
        return attractions;
    }

    /** Проверка, что содержит тэг attraction */
    public static boolean isAttraction(OSMWay way) {
        Map<String, String> tags = way.getTags();
        if (tags.size() == 0)
            return false;

        for (Map.Entry<String, String> entry : tags.entrySet()) {
            if (entry.getValue().equals("attraction")) {
                return true;
            }
        }
        return false;
    }

    /** Парсинг к firstwork.common.Attraction, на входе д.б. подходящий way */
    public static Attraction parseAttraction(Map<String, String> tags) {
        Address address = new Address();

        address.setCountry("Российская Федерация");
        address.setCity(tags.get(ADDR_CITY));
        address.setStreet(tags.get(ADDR_STREET));
        address.setHouseNumber(tags.get(ADDR_HOUSE_NUMBER));

        String attractionName = tags.get(ATTRACTION_NAME);

        return new Attraction(attractionName, address);
    }

    public static void main(String[] args)
            throws IOException, SAXException, ParserConfigurationException {

        Attraction att = new Attraction("Asad", new Address());

        List<OSMWay> osmWayList =
                OSMWrapper.getOSMWaysInArea(56.2341, 58.0154, 56.2545, 58.0215);

        List<Attraction> attractions = getAttractionList(osmWayList);

        for (Attraction attraction : attractions) {
            System.out.println(attraction.toString() + "\n==========");
        }
    }
}
