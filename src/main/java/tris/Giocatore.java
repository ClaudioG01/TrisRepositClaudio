package tris;

public class Giocatore {
		
	private String nome;
	private Symbol simbolo;
	private Type tipo;
	
	public void setPlayer(String n, Type t, Symbol s) {
		
		this.nome=n;
		this.tipo=t;
		this.simbolo=s;
		
	}
	
	public String getPlayer(){ return this.nome;}
	public Type getType() { return this.tipo;}
	public Symbol getSimbolo(){ return this.simbolo;}
}
