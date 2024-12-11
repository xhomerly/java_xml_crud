package com.xhomerly.kartoteka;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler {
    private static final String FILE_PATH = "people.xml";

    public static List<Person> readUsers() throws Exception {
        List<Person> people = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return people;

        DocumentBuilderFactory factory;
        factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        NodeList nodeList = document.getElementsByTagName("user");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
            String fname = element.getElementsByTagName("fname").item(0).getTextContent();
            String lname = element.getElementsByTagName("lname").item(0).getTextContent();
            String description = element.getElementsByTagName("description").item(0).getTextContent();
            people.add(new Person(id, fname, lname, description));
        }

        return people;
    }

    public static void saveUsers(List<Person> people) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("users");
        document.appendChild(root);

        for (Person person : people) {
            Element userElement = document.createElement("person");

            Element id = document.createElement("id");
            id.setTextContent(String.valueOf(person.getId()));
            userElement.appendChild(id);

            Element fname = document.createElement("fname");
            fname.setTextContent(person.getFname());
            userElement.appendChild(fname);

            Element lname = document.createElement("lname");
            lname.setTextContent(person.getLname());
            userElement.appendChild(lname);

            Element description = document.createElement("description");
            description.setTextContent(person.getDescription());
            userElement.appendChild(description);

            root.appendChild(userElement);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(FILE_PATH));

        transformer.transform(source, result);
    }
}
