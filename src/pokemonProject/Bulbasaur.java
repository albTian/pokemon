package pokemonProject;

public class Bulbasaur extends pokemon{

	public Bulbasaur() {
		super(46, 49, 49, 45, 
				"Grass", "Poison", 
				"Growl", "Tackle", "Vine Whip", "Leech Seed",
				"Bulbasaur");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ACT(String move, pokemon b) {
		switch(move){
		case "Growl":
			b.setATK(-20);
			return;
		case "Tackle":
			b.damage((20*(ATK/b.DEF))*(normalType(b.TP1)));
			return;
		case "Vine Whip":
			b.damage((20*(ATK/b.DEF))*(grassType(b.TP1)));
			return;
		case "Leech Seed":
			damage(-15);
			return;
	}	
	}

	@Override
	public String toString() {
		return 	"Bulbasaur" + super.toString();

	}



}
