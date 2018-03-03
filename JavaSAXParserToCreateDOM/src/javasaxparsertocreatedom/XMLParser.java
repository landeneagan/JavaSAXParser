/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasaxparsertocreatedom;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author lande
 */
public class XMLParser {
    
    public static String[] load(File xmlCourseFile) throws Exception {
        String[] strings = null;

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        DefaultHandler handler = new DefaultHandler() {

            String line = null;
            int index = 0;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {

                if (qName != null) {
                    line = attributes.toString();
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                strings[index] = line;
                index++;
            }

        };

        saxParser.parse(xmlCourseFile.getAbsoluteFile(), handler);

        
        return strings;
        
    }
}
