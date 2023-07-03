package br.com.alura.teste;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.alura.model.Produto;

public class DOM {
    public static void main(String[] args) throws Exception, SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = fabrica.newDocumentBuilder();
        Document document = builder.parse("src/vendas.xml");

        fabrica.setValidating(true);
        fabrica.setNamespaceAware(true);
        fabrica.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        
        Element venda = document.getDocumentElement();
        String moeda = venda.getAttribute("moeda");
        System.out.println(moeda);
        
        NodeList produtos = document.getElementsByTagName("produto");
       
        
        for(int i = 0;i<produtos.getLength(); i++ ) {
        	
        	Element produto = (Element) produtos.item(i);
        	String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
        	Double preco = Double.parseDouble(produto.getElementsByTagName("preco").item(0).getTextContent());
        	Produto prod = new Produto(nome, preco);
        	System.out.println(prod);
        	
        }
        
        
    }

}