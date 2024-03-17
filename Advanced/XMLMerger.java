import java.io.File;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLMerger {
    public static void main(String[] args) {
        try {
            // Load and parse XML files
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc1 = builder.parse(new File("License1.xml"));
            Document doc2 = builder.parse(new File("License2.xml"));

            // Normalize XML structures
            doc1.getDocumentElement().normalize();
            doc2.getDocumentElement().normalize();

            // Merge data from both XML files
            Map<String, Element> mergedData = mergeData(doc1, doc2);

            // Write merged data to a new XML file
            writeMergedDataToFile(mergedData, "MergedLicense.xml");

            System.out.println("Merging completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Element> mergeData(Document doc1, Document doc2) throws ParseException {
        Map<String, Element> mergedData = new HashMap<>();

        // Merge data from License1.xml
        NodeList producerNodes1 = doc1.getElementsByTagName("CSR_Producer");
        for (int i = 0; i < producerNodes1.getLength(); i++) {
            Element producer = (Element) producerNodes1.item(i);
            NodeList licenseNodes = producer.getElementsByTagName("License");
            for (int j = 0; j < licenseNodes.getLength(); j++) {
                Element license = (Element) licenseNodes.item(j);
                String key = getKey(producer, license);
                mergedData.put(key, license);
            }
        }

        // Merge data from License2.xml
        NodeList producerNodes2 = doc2.getElementsByTagName("CSR_Producer");
        for (int i = 0; i < producerNodes2.getLength(); i++) {
            Element producer = (Element) producerNodes2.item(i);
            NodeList licenseNodes = producer.getElementsByTagName("License");
            for (int j = 0; j < licenseNodes.getLength(); j++) {
                Element license = (Element) licenseNodes.item(j);
                String key = getKey(producer, license);
                mergedData.put(key, license);
            }
        }

        return mergedData;
    }

    private static String getKey(Element producer, Element license) {
        String niprNumber = producer.getAttribute("NIPR_Number");
        String stateCode = license.getAttribute("State_Code");
        String licenseNumber = license.getAttribute("License_Number");
        String effectiveDate = license.getAttribute("License_Issue_Date");
        return niprNumber + "_" + stateCode + "_" + licenseNumber + "_" + effectiveDate;
    }

    private static void writeMergedDataToFile(Map<String, Element> mergedData, String fileName) {
        try {
            // Create a new Document to store merged data
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document mergedDoc = docBuilder.newDocument();

            // Create root element
            Element rootElement = mergedDoc.createElement("Merged_Licenses");
            mergedDoc.appendChild(rootElement);

            // Append merged licenses to the root element
            for (Element license : mergedData.values()) {
                Element mergedLicense = (Element) mergedDoc.importNode(license, true);
                rootElement.appendChild(mergedLicense);
            }

            // Write the merged XML document to a file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(mergedDoc);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);

            System.out.println("Merged licenses saved to " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
