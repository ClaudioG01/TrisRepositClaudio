package tris;

import java.util.Scanner;

public class Runner {


	public static void main(String[] args){

		
		Partita game = new Partita();
		

		Scanner gamer = new Scanner(System.in);  
		Symbol us = null;
		try{
			
		for (int i=1; i<3; i++) {
		System.out.println("Player "+ i + " select: ");
		System.out.println("Name?");
	    String userName = gamer.nextLine();
	    
	    Type userType;
    	System.out.println("Human? (Yes/No)");
    	String check = gamer.nextLine();
    	
    	if (check.equals("No") || check.equals("no")) {
    		userType = Type.Com;
    	} else {
    		userType = Type.Human;
    	}
    	
    	Symbol userSymbol;
    	String chec;
    	
    	if (i==1) {
    	do {
    	System.out.println("Symbol? (X/O)");
    	chec = gamer.nextLine();
    	} while (!(chec.equals("X")  || chec.equals("x") || chec.equals("o")  || (chec.equals("O") )));
    			
    	
    	if (chec.equals("X") || chec.equals("x")) {
    		userSymbol = Symbol.X;
    		us = Symbol.O;
    	} else {
    		userSymbol = Symbol.O;
    		us = Symbol.X;
    	}
    	}else {userSymbol = us;
    	System.out.println("Symbol Player 2 = " + us);
    	}
	    
    	int fthis=i;
		game.setGiocatore(userName, userType, userSymbol, fthis);
		}
		
		System.out.println("Giocatore " + 1 + " : " + game.getG1() + " " + game.getT1() + " " + game.getS1());
		System.out.println("Giocatore " + 2 + " : " + game.getG2() + " " + game.getT2() + " " + game.getS2());
		
		
		for (int j=0; j<9; j++) {
	    int ped1;
	    int ped2;
	    Symbol turne = null;
	    String puyar;
	    

	    if ((j+1)%2==1) {
	    	puyar = game.getG1();
	    }else {
	    	puyar = game.getG2();
	    }
	    
	    do {
	    System.out.println("Insert new valid pedina position (0 to 2) (0 to 2): " + puyar + "'s turn");
	    ped1 = gamer.nextInt();
	    ped2 = gamer.nextInt();
	    if (!(game.getPedina(ped1, ped2) == null)) {
	    	System.out.println("Error: posizione gia usata");
	    	ped1=9;
	    	ped2=9;
	    }
	    
	    }while (ped1<0 || ped1> 2 || ped2<0 || ped2 >2 );
	    
	    if ((j+1)%2==1) {
	    	game.setPedina(ped1, ped2, game.getS1());
	    	turne = game.getS1();
	    }else {
	    	game.setPedina(ped1, ped2, game.getS2());
	    	turne = game.getS1();
	    }
		game.getGrid();
		
		if (!(game.gamestate(turne).equals("continue")) || j==8) {
			if (game.gamestate(turne).equals("win")) {
				if (turne == game.getS1()) {
					System.out.println("Player 1 wins");
					j=10;
				}else {
					System.out.println("Player 2 wins");
					j=10;
				}
			} else {
				System.out.println("Game Draw");
			}
		}
		}
		
		
		} finally {
			gamer.close();
		}  
		System.out.println("Game End");
		
		
	}
}