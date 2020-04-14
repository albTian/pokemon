package pokemonProject;

public class Charmander extends pokemon{
	
	
	public Charmander() {
		super(35,55,40,90,
			"ELECTRIC", "none",
			"Scratch","Growl","Smokescreen","Ember",
			"Charmander");		//STATS
	}
	
	public void ACT(String move, pokemon b) {	//MOVES
		switch(move){
		case "Scratch":
			b.damage((20*(ATK/b.DEF))*(normalType(b.TP1)));
			return;
		case "Growl":
			b.setATK(-20);
			return;
		case "Smokescreen":
			setDEF(30);
			return;
		case "Ember":
			b.damage((20*(ATK/b.DEF))*(fireType(b.TP1)));
			return;
	}
	}
	
	public String toString() {
		return 	"Charmander" + super.toString();
	}
	


}
