package model;

import android.provider.DocumentsContract;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DAO {
    private static final String url = "http://gaemedecins.appspot.com/Controleur/medParDep/listeDep";
    private static List<String> lesDep = new ArrayList<>();
    private static final String url2 = "http://gaemedecins.appspot.com/Controleur/medParDep/listeMed/";


    public static List<String> getLesDep() {
        URL myURL = null;
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            doc = db.parse(myURL.openStream());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element racine = doc.getDocumentElement();

        NodeList listeDep = racine.getElementsByTagName("Departement");

        for (int i = 0; i < listeDep.getLength(); i++) {
            Node medecin = listeDep.item(i);
            NodeList lesProprietes = medecin.getChildNodes();

            for (int j = 0; j < lesProprietes.getLength(); j++) {
                if (lesProprietes.item(j).getNodeName().equals("num")) {
                    lesDep.add(lesProprietes.item(j).getTextContent().trim());
                    break;
                }
            }
        }
        return lesDep;
    }

    public static List<Medecin> getLesMeds(String num) {
        List<Medecin> lesMed = new ArrayList<>();
        URL myURL = null;
        try {
            myURL = new URL(url2 + num);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            doc = db.parse(myURL.openStream());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element racine = doc.getDocumentElement();

        NodeList listeDep = racine.getElementsByTagName("Medecin");

        for (int i = 0; i < listeDep.getLength(); i++) {
            Node medecin = listeDep.item(i);
            NodeList lesProprietes = medecin.getChildNodes();
            String nom = "";
            String prenom = "";
            String tel = "";
            String adresse = "";
            String specialiteComplementaire = "";

            for (int j = 0; j < lesProprietes.getLength(); j++) {
                if (lesProprietes.item(j).getNodeName().equals("nom")) {
                    nom = lesProprietes.item(j).getTextContent().trim();

                }
                if (lesProprietes.item(j).getNodeName().equals("prenom")) {
                    prenom = lesProprietes.item(j).getTextContent().trim();
                }
                if (lesProprietes.item(j).getNodeName().equals("tel")) {
                    tel = lesProprietes.item(j).getTextContent().trim();
                }
                if (lesProprietes.item(j).getNodeName().equals("adresse")) {
                    adresse = lesProprietes.item(j).getTextContent().trim();
                }
                if (lesProprietes.item(j).getNodeName().equals("specialiteComplementaire")) {
                    specialiteComplementaire = lesProprietes.item(j).getTextContent().trim();
                }


            }
            lesMed.add(new Medecin(nom, prenom, tel, adresse, specialiteComplementaire));
        }
        return lesMed;
    }
}