package firstwork.osmtest;

/**
 * Created by Артем on 17.02.2016.
 */

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import firstwork.common.DocumentLoader;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class OSMWrapper {
    private static final String OPENSTREETMAP_API_06 =
            "http://www.openstreetmap.org/api/0.6/map?bbox=";

    /** Получение всех объектов way из документа */
    public static List<OSMWay> getWays(Document xmlDocument) {
        List<OSMWay> osmWays = new ArrayList<>();

        Node osmRoot = xmlDocument.getFirstChild();
        NodeList osmXMLNodes = osmRoot.getChildNodes();

        for (int i = 1; i < osmXMLNodes.getLength(); i++) {
            Node item = osmXMLNodes.item(i);

            if (item.getNodeName().equals("way")) {
                NamedNodeMap attributes = item.getAttributes();
                NodeList tagXMLNodes = item.getChildNodes();
                Map<String, String> tags = new HashMap<>();

                for (int j = 1; j < tagXMLNodes.getLength(); j++) {
                    Node tagItem = tagXMLNodes.item(j);
                    if (!(tagItem.getNodeName().equals("tag"))) continue;
                    NamedNodeMap tagAttributes = tagItem.getAttributes();
                    if (tagAttributes != null) {
                        tags.put(
                                tagAttributes.getNamedItem("k").getNodeValue(),
                                tagAttributes.getNamedItem("v").getNodeValue()
                        );
                    }
                }
                Node namedItemID = attributes.getNamedItem("id");;
                Node namedItemVersion = attributes.getNamedItem("version");

                String id = namedItemID.getNodeValue();
                String version = "0";
                if (namedItemVersion != null) {
                    version = namedItemVersion.getNodeValue();
                }

                OSMWay way = new OSMWay(Integer.parseInt(id), version);
                if (tags != null) {
                    way.setTags(tags);
                }
                osmWays.add(way);
            }
        }
        return osmWays;
    }

    /** Получение всех way в заданной прямоугольной области */
    public static List<OSMWay> getOSMWaysInArea(double left, double bottom, double right, double top)
            throws IOException, SAXException, ParserConfigurationException {
        DecimalFormat decimalFormat =
                new DecimalFormat("##0.0000000", DecimalFormatSymbols.getInstance(Locale.ENGLISH)); //$NON-NLS-1$

        String l = decimalFormat.format(left);
        String b = decimalFormat.format(bottom);
        String r = decimalFormat.format(right);
        String t = decimalFormat.format(top);
        String query = OPENSTREETMAP_API_06 + l + "," + b + "," + r + "," + t;

        return OSMWrapper.getWays(DocumentLoader.getXML(query));
    }
}
