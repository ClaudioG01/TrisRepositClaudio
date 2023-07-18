package tris.service.impl;

import java.util.InputMismatchException;
import java.util.Scanner;

import tris.data.Giocatore;
import tris.data.Mossa;
import tris.data.Partita;
import tris.data.Symbol;
import tris.service.GiocatoreService;
import tris.service.MossaErrataException;

public class UmanoGiocatoreServiceImpl implements GiocatoreService {

	
	private Giocatore giocatore;
	private Scanner scan;
	public UmanoGiocatoreServiceImpl(Giocatore giocatore, Scanner gamer) {
		this.setGiocatore(giocatore);
		scan = gamer;
	}

	public Mossa getMossa(Partita p) throws MossaErrataException {
		
		Mossa mossa = new Mossa();
		int ped1=9;
		int ped2=0;
		int ch=0;
		int cs=0;

		try {
			System.out.println("Insert new valid pedina position (Verticale: 0 to 2) (Orizontale: 0 to 2)):");
			System.out.println("(Insert 123 to stop game)");
			
			do {	
			if (ch>0) {
				ch--;
				System.out.println("Invalid position, retry");
			}
			if (cs>0) {
				cs--;
				System.out.println("Occupied position, retry");
			}
			
				try{
					String ped1d = scan.nextLine();
					ped1 = Integer.parseInt(ped1d);
					if (ped1==123) {
						
					}else {
					String ped2d = scan.nextLine();
					ped2 = Integer.parseInt(ped2d);
					}
					  // is an integer!
					} catch (NumberFormatException e) {
					  // not an integer!
						System.out.println("Invalid values, retry");
						ch--;
					}
			
			
		
			
			if (ped1==123){
				mossa.setX(ped1);
			}else {
			
			if (ped2==123){
				mossa.setX(ped1);
			}else {
			
			if (ped1<0 || ped1>2 || ped2<0 || ped2>2) {
				ch++;
				ped1=9;
			}else {
			if (p.getPedina(ped1, ped2) == Symbol._) {
				mossa.setX(ped1);
				mossa.setY(ped2);
			}else {
				cs++;
				ped1=9;
			}
			}
			}
			}
			
			
			}while (ped1==9 && !(ped1==123));
			
		} finally {
//			scan.close();
		}
		
		return mossa;
	}
	
	public static String getNome(Scanner s) {
		System.out.println("Name?");
		String userN = s.nextLine();
		
		return userN;
		}
	
	public static Symbol getSymbolo (Scanner s) {
		Symbol sl;
		String chec = null;
		int err=0;
		
		do {
		if (err>0) System.out.println("Invalid Symbol");	
		err++;
		System.out.println("Symbol? (X/O)");
		chec = s.nextLine();
		}while (!(chec.equals("X") || chec.equals("x") || chec.equals("o") || (chec.equals("O"))));
		
		if ("X".equals(chec) || ("x".equals(chec))) 
			sl = Symbol.X;
		
		else 
			sl = Symbol.O;
	
	return sl;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	private void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

}
