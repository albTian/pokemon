package pokemonProject;

public class Squirtle extends pokemon{
	public Squirtle() {
		super(44,48,65,43,
			"WATER", "none",
			"Tackle","Tail Whip","Bubble","Withdraw",
			"Squirtle");		//STATS
	}
	

	public void ACT(String move, pokemon b) {
		
		switch(move){
		case "Tackle":
			b.damage((20 *(ATK/b.DEF))*normalType(b.TP1));			
			return;
		case "Tail Whip":
			b.setDEF(-30);
			return;
		case "Bubble":
			b.damage((20 *(ATK/b.DEF))*waterType(b.TP1));			
			return;
		case "Withdraw":
			setDEF(40);
			return;
	}

		
	}
	
	public String toString() {
		return 	"Squirtle" + super.toString();
	}
}
