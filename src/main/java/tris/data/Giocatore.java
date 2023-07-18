package tris.data;

import java.io.Serializable;

import tris.data.Symbol;
import tris.data.Type;

public class Giocatore implements Serializable{
		
	private String nome;
	private Symbol simbolo;
	private Type tipo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Symbol getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(Symbol simbolo) {
		this.simbolo = simbolo;
	}
	public Type getTipo() {
		return tipo;
	}
	public void setTipo(Type tipo) {
		this.tipo = tipo;
	}
}
