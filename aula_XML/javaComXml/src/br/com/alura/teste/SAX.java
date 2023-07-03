package br.com.alura.teste;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.alura.model.Produto;

public class SAX extends DefaultHandler{
	
	List<Produto> produtos = new ArrayList<>();
	StringBuilder conteudo;
	Produto produto;
	
	
	public  List<Produto> getProdutos() {
		return produtos;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if(qName.equals("produto")) {
			
			produto = new Produto();
			
		}
		
		conteudo = new StringBuilder();
		
		
			
		
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		conteudo.append(new String(ch, start, length)); 
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equals("produto")) {
			
			produtos.add(produto);
			
		}
		
		else if(qName.equals("nome")) {
			
			produto.setNome(conteudo.toString());
		
		}
		
		else if(qName.equals("preco")) {
			
			Double preco = Double.parseDouble(conteudo.toString());
			produto.setPreco(preco);
		}
		
	}
	
}
