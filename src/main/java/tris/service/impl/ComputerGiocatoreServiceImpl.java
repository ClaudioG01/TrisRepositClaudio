package tris.service.impl;

import java.util.Random;
import tris.data.Symbol;
import tris.data.Giocatore;
import tris.data.Mossa;
import tris.data.Partita;
import tris.service.GiocatoreService;
import tris.service.MossaErrataException;

public class ComputerGiocatoreServiceImpl implements GiocatoreService {

	private Giocatore giocatore;
	
	
	public ComputerGiocatoreServiceImpl(Giocatore giocatore) {
		this.setGiocatore(giocatore);
	}
	public Mossa getMossa(Partita p) throws MossaErrataException {
		
		Mossa mossa = new Mossa();
		Random rand = new Random();
		int er;
		
		do {
			int ped1 = rand.nextInt(3);
			int ped2 = rand.nextInt(3);
			if (!(p.getPedina(ped1, ped2) == Symbol._)) {
				er=0;
			} else {
				mossa.setX(ped1);
				mossa.setY(ped2);
				er=90;
			}
			
			}while (er==0);
		
		return mossa;
		
	}
	
	public static Symbol getSymbolo () {
		Symbol simbolo;
		Random rand = new Random();
		int X = rand.nextInt(2);
		if (X==0) {simbolo = Symbol.X;}
		else{simbolo = Symbol.O;}	
		
		return simbolo;
	}
	public Giocatore getGiocatore() {
		return giocatore;
	}
	private void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

}
