package com.tiagooliveira.manchallange.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

/**
 * This is a class that will generate the database data by reading
 * a xml file that contains a set of coordinates generated using the
 * http://map.project-osrm.org application.
 *
 * The H2 database will look for two specific files, data.sql and schema.sql
 * The schema.sql contains the tables and relations schema.
 * The data.sql contains the data to be inserted whenever the database is created
 *
 * @author Tiago Oliveira
 */
public class DatabaseValuesGenerator {

    public static void generateData(String sqlFilePath, String xmlFilePath) {
        try (FileReader fileReader = new FileReader(sqlFilePath)) {
        } catch (FileNotFoundException e) {
            createFile(sqlFilePath, xmlFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Using the xml.dom this function will go through all the nodes that contain
     * coordinate values and create the SQL insert queries needed to insert those
     * values in the database.
     *
     * Note: This is only an auxiliary process to quickly create data for the purpose
     * of this challenge. The license is currently added manually and this process
     * is obviously not robust and should be improved if it were to be reused.
     *
     * @see org.w3c.dom
     * @param sqlFilePath path of the data.sql file
     * @param xmlFilePath path of the route.xml file
     */
    private static void createFile(String sqlFilePath, String xmlFilePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(sqlFilePath))) {

            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            NodeList nList = doc.getElementsByTagName("trkpt");

            String previousLat = "";
            String previousLng = "";

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String currentLat = eElement.getAttribute("lat");
                    String currentLng = eElement.getAttribute("lon");

                    if(!(currentLat.equals(previousLat) && currentLng.equals(previousLng))){
                        String insert = "INSERT INTO VEHICLE (LICENSE, LAT, LNG) VALUES ('AA-00-DD', '"
                                + currentLat + "', '"
                                + currentLng + "'); \n";

                        previousLat = currentLat;
                        previousLng = currentLng;

                        bufferedWriter.write(insert);
                    }
                }
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }
}
