package pokemonProject;

public class Pikachu extends pokemon {
	
	
	public Pikachu() {
		super(35,55,40,90,
			"ELECTRIC", "none",
			"Growl","Thunder Shock","Tail Whip","Quick Attack",
			"Pikachu");		//STATS
	}
	
	public void ACT(String move, pokemon b) {	//MOVES
		switch(move){
		case "Growl":
			b.setATK(-20);
			return;
		case "Thunder Shock":
			b.damage((20 *(ATK/b.DEF))*electricType(b.TP1));			
			return;
		case "Tail Whip":
			b.setDEF(-20);
			return;
		case "Quick Attack":
			setSPD(30);
			b.damage((10 *(ATK/b.DEF))*normalType(b.TP1));			
			return;
	}
	}
	
	public String toString() {
		return 	"Pikachu" + super.toString();
	}
	


}
