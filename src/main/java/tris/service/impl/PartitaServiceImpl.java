package tris.service.impl;

import java.util.Scanner;

import tris.data.GameState;
import tris.data.Giocatore;
import tris.data.Type;
import tris.data.Symbol;
import tris.data.Partita;
import tris.data.Mossa;
import tris.service.GiocatoreService;
import tris.service.MossaErrataException;
import tris.service.PartitaService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PartitaServiceImpl implements PartitaService {

	private GiocatoreService giocatore1;
	private GiocatoreService giocatore2;
	private Partita partita;
	private Scanner gamer;

	public PartitaServiceImpl(Scanner scanner) throws ClassNotFoundException, CloneNotSupportedException, IOException {
		gamer = scanner;
		setPartita(initPartita());
		if (getPartita().getGiocatore1().getTipo() == Type.Com)
			giocatore1 = new ComputerGiocatoreServiceImpl(getPartita().getGiocatore1());
		else
			giocatore1 = new UmanoGiocatoreServiceImpl(getPartita().getGiocatore1(), gamer);

		if (getPartita().getGiocatore2().getTipo() == Type.Com)
			giocatore2 = new ComputerGiocatoreServiceImpl(getPartita().getGiocatore2());
		else
			giocatore2 = new UmanoGiocatoreServiceImpl(getPartita().getGiocatore2(), gamer);
	}

	public GameState isPartitaFinita(Partita p, int i) {

		Giocatore giocatore = getGiocatoreDiTurno(getPartita().getTurno()).getGiocatore();
		Symbol sr = giocatore.getSimbolo();
		GameState gm = GameState.Continue;

		if (p.getPedina(0, 0) == sr) {
			if (p.getPedina(1, 0) == sr) {
				if (p.getPedina(2, 0) == sr) {
					gm = GameState.Win;
					return gm;
				}
			}
			if (p.getPedina(0, 1) == sr) {
				if (p.getPedina(0, 2) == sr) {
					gm = GameState.Win;
					return gm;
				}
			}
			if (p.getPedina(1, 1) == sr) {
				if (p.getPedina(2, 2) == sr) {
					gm = GameState.Win;
					return gm;
				}
			}
		}
		if (p.getPedina(0, 1) == sr) {
			if (p.getPedina(1, 1) == sr) {
				if (p.getPedina(2, 1) == sr) {
					gm = GameState.Win;
					return gm;
				}
			}
		}

		if (p.getPedina(0, 2) == sr) {
			if (p.getPedina(1, 2) == sr) {
				if (p.getPedina(2, 2) == sr) {
					gm = GameState.Win;
					return gm;
				}
			}
			if (p.getPedina(1, 1) == sr) {
				if (p.getPedina(2, 0) == sr) {
					gm = GameState.Win;
					return gm;
				}
			}
		}

		if (p.getPedina(1, 0) == sr && p.getPedina(1, 1) == sr && p.getPedina(1, 2) == sr) {
			gm = GameState.Win;
			return gm;
		}

		if (p.getPedina(2, 0) == sr && p.getPedina(2, 1) == sr && p.getPedina(2, 2) == sr) {
			gm = GameState.Win;
			return gm;
		}

		if (i > 8)
			gm = GameState.Draw;
		return gm;
	}

	private GiocatoreService getGiocatoreDiTurno(int turno) {
		if (turno == 1)
			return giocatore1;
		else
			return giocatore2;
	}

	public Giocatore gioca(Scanner scanner) throws IOException {
		Giocatore sample = null;
		boolean dummy = true;
		int dum = 0;
		while (dummy) {
			try {
				dum++;
				System.out.println(getGiocatoreDiTurno(getPartita().getTurno()).getGiocatore().getNome() + "'s turn");
				Mossa mossa = getGiocatoreDiTurno(getPartita().getTurno()).getMossa(getPartita());
				Giocatore giocatore = getGiocatoreDiTurno(getPartita().getTurno()).getGiocatore();

				if (mossa.getX() == 123) {
					System.out.println("-Game Stopped--");
					System.out.println("Salvare partita? (Yes/No)");
					int l=0;
					do{
					String chep = gamer.nextLine();
					
					if (chep.equals("No") || chep.equals("no") || chep.equals("n") || chep.equals("N") ) {
						
					
					} else {
						if (chep.equals("Yes") || chep.equals("yes") || chep.equals("y") || chep.equals("Y") ) {
							l=0;
							FileOutputStream fos = new FileOutputStream("xyz.txt");
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(getPartita());
							oos.close();
						}else {
							l=9;
							System.out.println("ERR, retry");
						}
					}
					}while (l>0);
					
					dummy = false;
				} else {
					getPartita().setPedina(mossa.getX(), mossa.getY(), giocatore.getSimbolo());

					System.out.println("----------------");
					System.out.println(getPartita().getPedina(0, 0) + " " + getPartita().getPedina(0, 1) + " "
							+ getPartita().getPedina(0, 2));
					System.out.println(getPartita().getPedina(1, 0) + " " + getPartita().getPedina(1, 1) + " "
							+ getPartita().getPedina(1, 2));
					System.out.println(getPartita().getPedina(2, 0) + " " + getPartita().getPedina(2, 1) + " "
							+ getPartita().getPedina(2, 2));
					System.out.println("----------------");

					if (isPartitaFinita(getPartita(), dum) == GameState.Continue) {
						getPartita().setTurno(getPartita().getTurno() == 1 ? 2 : 1);
					} else {
						dummy = false;
					}
				}
			} catch (MossaErrataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (isPartitaFinita(getPartita(), 9) == GameState.Draw)
			sample = null;
		else {
			if (isPartitaFinita(getPartita(), 9) == GameState.Win) {
				sample = getGiocatoreDiTurno(getPartita().getTurno()).getGiocatore();
			}
		}
		return sample;

	}

	public GiocatoreService getGiocatore1() {
		return giocatore1;
	}

	public void setGiocatore1(GiocatoreService giocatore1) {
		this.giocatore1 = giocatore1;
	}

	public GiocatoreService getGiocatore2() {
		return giocatore2;
	}

	public void setGiocatore2(GiocatoreService giocatore2) {
		this.giocatore2 = giocatore2;
	}

	public Partita initPartita() throws CloneNotSupportedException, IOException, ClassNotFoundException {
		Partita game = new Partita();
		game.setTurno(1);
		try {
			System.out.println("Nuova Partita o recupero partitie precedenti? (1/2)");
			String firstc;
			do {
			firstc = gamer.nextLine();
			if (firstc.equals("2") || firstc.equals("1")) {
				
			}else {
				System.out.println("ERR, retry");
			}		
			}while(!(firstc.equals("2") || firstc.equals("1")));
			
			if (firstc.equals("2")) {
				FileInputStream fis = new FileInputStream("xyz.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				partita = (Partita) ois.readObject();// down-casting object

				System.out.println(partita.getGiocatore1() + " " + partita.getGiocatore2() + " " + partita.getGrid());
				ois.close();
				return partita;
			} else {

				Giocatore giocatore1 = new Giocatore();
				System.out.println("Is Player1 Human? (Yes/No)");
				String check;

				int v=0;
				do{
					check = gamer.nextLine();
					
					if (check.equals("No") || check.equals("no") || check.equals("n") || check.equals("N") ) {
						giocatore1.setTipo(Type.Com);
						v=0;
					} else {
						if (check.equals("Yes") || check.equals("yes") || check.equals("y") || check.equals("Y") ) {
						giocatore1.setTipo(Type.Human);
						v=0;
						}else {
							v=9;
							System.out.println("ERR, retry");
						}

					}
					}while (v>0);
				
				if (giocatore1.getTipo() == Type.Human) {

					giocatore1.setNome(UmanoGiocatoreServiceImpl.getNome(gamer));
					giocatore1.setSimbolo(UmanoGiocatoreServiceImpl.getSymbolo(gamer));

				} else {
					giocatore1.setNome("COM 1");
					giocatore1.setSimbolo(ComputerGiocatoreServiceImpl.getSymbolo());

				}

				game.setGiocatore1(giocatore1);

				Giocatore giocatore2 = new Giocatore();
				System.out.println("Is Player2 Human? (Yes/No)");
				v=0;
				do{
				check = gamer.nextLine();
				
				if (check.equals("No") || check.equals("no") || check.equals("n") || check.equals("N") ) {
					giocatore2.setTipo(Type.Com);
					v=0;
				} else {
					if (check.equals("Yes") || check.equals("yes") || check.equals("y") || check.equals("Y") ) {
					giocatore2.setTipo(Type.Human);
					v=0;
					}else {
						v=9;
						System.out.println("ERR, retry");
					}
				}
				}while (v>0);
				

				if (giocatore2.getTipo() == Type.Human) {

					giocatore2.setNome(UmanoGiocatoreServiceImpl.getNome(gamer));

				} else
					giocatore2.setNome("COM 2");

				giocatore2.setSimbolo(
						giocatore1.getSimbolo() == tris.data.Symbol.O ? tris.data.Symbol.X : tris.data.Symbol.O);

				game.setGiocatore2(giocatore2);
			}
		} finally {
//			gamer.close();
		}

		return game;
	}

	public Partita getPartita() {
		return partita;
	}

	public void setPartita(Partita partita) {
		this.partita = partita;
	}

	public GameState isPartitaFinita(Partita p) {
		// TODO Auto-generated method stub
		return null;
	}
}
