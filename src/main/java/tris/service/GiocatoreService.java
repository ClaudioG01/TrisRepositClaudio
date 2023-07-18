package tris.service;

import tris.data.Giocatore;
import tris.data.Mossa;
import tris.data.Partita;

public interface GiocatoreService {
	public Mossa getMossa(Partita p) throws MossaErrataException;
	public Giocatore getGiocatore();
}
