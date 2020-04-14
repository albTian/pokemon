package pokemonProject;

public class Cubone extends pokemon {
	
	public Cubone() {
		super(35,55,40,90,
			"ELECTRIC", "none",
			"Growl","Tail Whip","Leer","Bone Club",
			"Cubone");		//STATS
	}
	
	public void ACT(String move, pokemon b) {	//MOVES
		switch(move){
		case "Growl":
			b.setATK(-20);
			return;
		case "Tain Whip":
			b.setDEF(-20);
			return;
		case "Dig":
			setDEF(30);
			return;
		case "Bone Club":
			setSPD(30);
			b.damage((30 *(ATK/b.DEF))*groundType(b.TP1));
			return;
	}
	}
	
	public String toString() {
		return 	"Cubone" + super.toString();
	}
	


}
