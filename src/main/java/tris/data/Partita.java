package tris.data;


import java.io.Serializable;

import tris.data.Symbol;

public class Partita implements Serializable{

	private Giocatore giocatore1 = new Giocatore();
	private Giocatore giocatore2 = new Giocatore();
	
	private int turno;
	
	private Symbol[][] grid= new Symbol[3][3];

	public Giocatore getGiocatore1() {
		return giocatore1;
	}

	public void setGiocatore1(Giocatore giocatore1) {
		this.giocatore1 = giocatore1;
	}

	public Giocatore getGiocatore2() {
		return giocatore2;
	}

	public void setGiocatore2(Giocatore giocatore2) {
		this.giocatore2 = giocatore2;
	}

	public Symbol[][] getGrid() {
		return grid;
	}

	public void setGrid(Symbol[][] grid) {
		this.grid = grid;
	}
	
	public Symbol getPedina(int X, int Y) {
		Symbol pedina = grid[X][Y];
		if (pedina == null) pedina = Symbol._;
		return pedina;
	}
	
	public void setPedina(int X, int Y, Symbol S) {
		this.grid[X][Y] = S;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}
	
}
