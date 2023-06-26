package tris;


public class Partita {

	private Giocatore giocatore1 = new Giocatore();
	private Giocatore giocatore2 = new Giocatore();
	
	private Symbol[][] grid= new Symbol[3][3];
	
    
	public void setGiocatore(String na, Type ti, Symbol si, int fi) {
		
		if (fi==1) { this.giocatore1.setPlayer(na, ti, si);}
		
		if (fi==2) {this.giocatore2.setPlayer(na, ti, si);}
		
	}
	public void setPedina(int x, int y, Symbol SA) {
		this.grid[x][y] = SA;
	}
	
	public Symbol getPedina(int x, int y) {
		return this.grid[x][y];
	}
	
	public String gamestate(Symbol turn){
		String gmst;
		Symbol sr = turn;
	
			  if (this.grid[0][0] == sr) {
				  if (this.grid[1][0] == sr) {
					  if (this.grid[2][0] == sr) {
						  gmst = "win";
						  return gmst;
					  }
				  }
				  if (this.grid[0][1] == sr) {
					  if (this.grid[0][2] == sr) {
						  gmst = "win";
						  return gmst;
					  }
				  }
				  if (this.grid[1][1] == sr) {
					  if (this.grid[2][2] == sr) {
						  gmst = "win";
						  return gmst;
					  }
				  }  
			  }
			  if (this.grid[0][1] == sr) {
				  if (this.grid[1][1] == sr) {
					  if (this.grid[2][1] == sr) {
						  gmst = "win";
						  return gmst;
					  }
				  }
			  }
			  
			  if (this.grid[0][2] == sr) {
				  if (this.grid[1][2] == sr) {
					  if (this.grid[2][2] == sr) {
						  gmst = "win";
						  return gmst;
					  }
				  }
				  if (this.grid[1][1] == sr) {
					  if (this.grid[2][0] == sr) {
						  gmst = "win";
						  return gmst;
					  }
				  }  
			  }
			  
			  if (this.grid[1][0] == sr && this.grid[1][1] == sr && this.grid[1][2] == sr) {
				  gmst = "win";
				  return gmst;
			  }
			  
			  if (this.grid[2][0] == sr && this.grid[2][1] == sr && this.grid[2][2] == sr) {
				  gmst = "win";
				  return gmst;
			  } 
		gmst = "continue";
		return gmst;
	}
	
	public void getGrid(){System.out.println(this.grid[0][0] + " " + this.grid[0][1] + " " + this.grid[0][2] );
	System.out.println(this.grid[1][0] + " " + this.grid[1][1] + " " + this.grid[1][2]);
	System.out.println(this.grid[2][0] + " " + this.grid[2][1] + " " + this.grid[2][2] );}
	public String getG1() {return this.giocatore1.getPlayer();}
	public Type getT1() {return this.giocatore1.getType();}
	public Symbol getS1() {return this.giocatore1.getSimbolo();}
	public String getG2() {return this.giocatore2.getPlayer();}
	public Type getT2() {return this.giocatore2.getType();}
	public Symbol getS2() {return this.giocatore2.getSimbolo();}

}
