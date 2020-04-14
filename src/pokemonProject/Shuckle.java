package pokemonProject;

public class Shuckle extends pokemon {
	
	public Shuckle() {
		super(20,10,230,5,
			"BUG", "ROCK",
			"Hide","Dig","Run","NUT",
			"Shuckle");		//STATS
	}
	

	public void ACT(String move, pokemon b) {
		
		switch(move){
		case "Hide":
			setDEF(40);
			setSPD(10);
			return;
		case "Dig":
			damage(-50);
			return;
		case "Run":
			setSPD(50);
			return;
		case "NUT":
			b.damage((40 *(ATK/b.DEF))*bugType(b.TP1));			
			return;
	}

		
	}
	
	public String toString() {
		return 	"Shuckle" + super.toString();
	}



}
