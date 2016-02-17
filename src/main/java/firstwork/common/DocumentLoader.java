package firstwork.common;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Артем on 17.02.2016.
 */
public class DocumentLoader {

    public static Document getXML(String url) throws IOException, SAXException,
            ParserConfigurationException {

        URL osmUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) osmUrl.openConnection();

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        return docBuilder.parse(connection.getInputStream());
    }
}
