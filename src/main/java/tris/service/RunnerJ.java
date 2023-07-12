package tris.service;

import java.util.Scanner;

import tris.data.GameState;
import tris.data.Giocatore;
import tris.service.impl.PartitaServiceImpl;

public class RunnerJ {

	private PartitaService partitaService;

	public static void main(String[] args) {
		RunnerJ rj = new RunnerJ();
		Scanner gamer = new Scanner(System.in);
		rj.partitaService = new PartitaServiceImpl(gamer);
		//Partita p = rj.initPartita(gamer);
		System.out.println(
				rj.partitaService.getPartita().getGiocatore1().getNome() + " " + 
						rj.partitaService.getPartita().getGiocatore1().getTipo() + " " + 
						rj.partitaService.getPartita().getGiocatore1().getSimbolo());
		System.out.println(
				rj.partitaService.getPartita().getGiocatore2().getNome() + " " + 
						rj.partitaService.getPartita().getGiocatore2().getTipo() + " " + 
						rj.partitaService.getPartita().getGiocatore2().getSimbolo());

		
		Giocatore gsn = rj.partitaService.gioca(gamer);
		
		if (gsn == null) {
			System.out.println("Game Over");
			System.out.println("Draw");
		} else {
			System.out.println("Game Over");
			System.out.println("(" + gsn.getNome() + " " + gsn.getTipo() + " " + gsn.getSimbolo() + ") wins!!");
		}
		gamer.close();

	}

	

}
