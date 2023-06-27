package tris;
import java.util.Random;

public class ComAI extends Giocatore{
	
	public void getAI(int a, Symbol v1) {
		
		tipo = Type.Com;
		Random rand = new Random();
		if (a==1) {
		nome = "trisAI";
		int X = rand.nextInt(2);
		if (X==0) {simbolo = Symbol.X;}
		else{simbolo = Symbol.O;}	
		} else {
			nome = "trisAI[2]";
			simbolo = v1;
		}
	}
	
	public int getP() {
		Random rand = new Random();
		int AX = rand.nextInt(3);
		return (AX);
	}
	}


	
	



