package tris.service;

import java.io.IOException;

import java.util.Scanner;

import tris.data.GameState;
import tris.data.Giocatore;
import tris.data.Partita;

public interface PartitaService  {
	public GameState isPartitaFinita(Partita p, int i);
	public Giocatore gioca(Scanner gamer) throws IOException;
	public Partita getPartita();
}
