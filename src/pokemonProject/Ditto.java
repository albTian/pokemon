package pokemonProject;

public class Ditto extends pokemon {

	public Ditto() {
		super(44,48,65,43,
			"WATER", "none",
			"Scratch","Transform","Transform","Transform",
			"Ditto");		//STATS
	}
	

	public void ACT(String move, pokemon b) {
		
//		HP=0;
//		life=false;
		
		
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
		return 	"Ditto" + super.toString();
	}

}
