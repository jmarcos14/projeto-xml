package test;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import models.Professor;

public class DOM {
	
			public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/turma.xml");
		
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		
		NodeList professores = document.getElementsByTagName("professor");
		
		for(int i = 0; i<professores.getLength(); i++) {
			
			Element professor = (Element) professores.item(i);
			String nome = professor.getElementsByTagName("nome").item(0).getTextContent();
			String materia = professor.getElementsByTagName("materia").item(0).getTextContent();
			Professor prof = new Professor(nome, materia);
			System.out.println(prof);
		}
	}
}
