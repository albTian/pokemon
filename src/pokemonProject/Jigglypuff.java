package pokemonProject;

public class Jigglypuff extends pokemon{
	
	
	public Jigglypuff() {
		super(35,55,40,90,
			"ELECTRIC", "none",
			"Sing","Pound","Defense Curl","Bide",
			"Jigglypuff");		//STATS
	}
	
	public void ACT(String move, pokemon b) {	//MOVES
		switch(move){
		case "Sing":
			damage(-20);
			return;
		case "Pound":
			b.damage((20 *(ATK/b.DEF))*normalType(b.TP1));			
			return;
		case "Defense Curl":
			setDEF(30);			
			return;
		case "Bide":
			b.damage((HP *(ATK/b.DEF))*normalType(b.TP1));
			return;

	}
	}
	
	public String toString() {
		return 	"Jiglypuff" + super.toString();
	}
	


}
