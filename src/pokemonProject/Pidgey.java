package pokemonProject;

public class Pidgey extends pokemon {

	public Pidgey() {
		super(44,48,65,43,
			"WATER", "none",
			"Tackle","Sand Attack","Gust","Mirror Move",
			"Pidgey");		//STATS
	}
	

	public void ACT(String move, pokemon b) {
		
		switch(move){
		case "Tackle":
			b.damage((20 *(ATK/b.DEF))*normalType(b.TP1));			
			return;
		case "Sand Attack":
			b.setATK(-20);
			return;
		case "Gust":
			b.damage((20 *(ATK/b.DEF))*groundType(b.TP1));			
			return;
		case "Mirror Move":
			setSPD(30);
			b.damage((10 *(ATK/b.DEF))*normalType(b.TP1));			
			return;
	}

		
	}
	
	public String toString() {
		return 	"Pidgey" + super.toString();
	}

}
