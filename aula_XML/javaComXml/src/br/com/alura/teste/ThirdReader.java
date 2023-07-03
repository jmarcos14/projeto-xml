package br.com.alura.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import br.com.alura.model.Produto;

public class ThirdReader {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		
		InputStream ips = new FileInputStream("src/vendas.xml");
		XMLInputFactory fabrica = XMLInputFactory.newInstance();
		XMLEventReader evento = fabrica.createXMLEventReader(ips); 
		
		List<Produto> produtos = new ArrayList<>();
		
		Produto produto = null;
		
		while(evento.hasNext()) {
		
			XMLEvent event = evento.nextEvent();
		
			if(event.isStartElement()  && event.asStartElement().getName().getLocalPart().equals("produto")) {
			
				
				produto = new Produto();
			
			}
			
			else if(event.isStartElement()  && event.asStartElement().getName().getLocalPart().equals("nome")) {
				
				event = evento.nextEvent();
				String conteudo = event.asCharacters().getData();
				produto.setNome(conteudo);
				
			}
			
			else if(event.isStartElement()  && event.asStartElement().getName().getLocalPart().equals("preco")) {
				
				event = evento.nextEvent();
				Double conteudo = Double.parseDouble(event.asCharacters().getData());
				produto.setPreco(conteudo);
				
			}
			
			else if(event.isEndElement()  && event.asEndElement().getName().getLocalPart().equals("produto")) {
				
				produtos.add(produto);
				
			}
			
			
	
		}
		
		System.out.println(produtos);
		
	}
	
}
