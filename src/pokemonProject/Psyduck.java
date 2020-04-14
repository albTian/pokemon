package pokemonProject;

public class Psyduck extends pokemon {

	public Psyduck() {
		super(44,48,65,43,
			"WATER", "none",
			"Scratch","Tail Whip","Water Gun","Confusion",
			"Psyduck");		//STATS
	}
	

	public void ACT(String move, pokemon b) {
		
		switch(move){
		case "Scratch":
			b.damage((10 *(ATK/b.DEF))*normalType(b.TP1));			
			return;
		case "Tail Whip":
			b.setDEF(-20);
			return;
		case "Water Gun":
			b.damage((20 *(ATK/b.DEF))*waterType(b.TP1));			
			return;
		case "Confusion":
			setSPD(30);
			b.damage((10 *(ATK/b.DEF))*waterType(b.TP1));			
			return;
	}

		
	}
	
	public String toString() {
		return 	"Psyduck" + super.toString();
	}

}
