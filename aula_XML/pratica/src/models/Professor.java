package models;

public class Professor {

	private String nome;
	private String materia;
	
	public Professor(String nome, String materia) {
		
		this.nome = nome;
		this.materia = materia;
		
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getMateria() {
		return materia;	}
	
	@Override
	public String toString() {
		return "nome: " +nome+"\nmateria: " +materia;
	}
}
