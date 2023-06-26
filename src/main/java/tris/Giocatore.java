package tris;

public class Giocatore {
		
	protected String nome;
	protected Symbol simbolo;
	protected Type tipo;
	
	public void setPlayer(String n, Type t, Symbol s) {
		
		this.nome=n;
		this.tipo=t;
		this.simbolo=s;
		
	}
	
	public String getPlayer(){ return this.nome;}
	public Type getType() { return this.tipo;}
	public Symbol getSimbolo(){ return this.simbolo;}
}