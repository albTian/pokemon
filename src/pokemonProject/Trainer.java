/**
 * Authors: Albert Tian, Jocelyn Su
 * Date: June 22, 2019
 * Final Project: Pokemon Game
 * Class description: Each player is a trainer object and this class sends each players chosen pokemon to its respective class
 */

package pokemonProject;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Trainer {
  
  public ArrayList<pokemon> trainer;
  String trName="";
  boolean turn;
  Scanner scan = new Scanner(System.in);
  
  public Trainer(String nm, boolean tr) {
    trainer = new ArrayList<>();
    trName=nm;
    turn=tr;
  } 
  
  
  public void add(String d) {
    trainer.add(cor(d));
  }
  
  //sends the pokemon to the respective class
  public static pokemon cor(String p) {
    pokemon a=new Pikachu();
    switch(p){
      case "Pikachu":
        a = new Pikachu();
        return a;
      case "Shuckle":
        a =new Shuckle();
        return a;
      case "Bulbasaur":
        a=new Bulbasaur();
        return a;
      case "Psyduck":
        a=new Psyduck();
        return a;
      case "Charmander":
        a=new Charmander();
        return a;
      case "Ditto":
        a=new Ditto();
        return a;
      case "Pidgey":
        a=new Pidgey();
        return a;
      case "Cubone":
        a=new Cubone();
        return a;
      case "Jigglypuff":
        a=new Jigglypuff();
        return a;
      case "Squirtle":
        a=new Squirtle();
        return a;
    }
    return null;
  }
  
  //access to get the first pokemon in the array list
  public pokemon get() {
    return trainer.get(0);
  }
  
  //sets which pokemon moves first in each round
  public void turnover() {
    if(turn)
      turn=false;
    else
      turn=true;
  }
  
  public String toString() {
    String result="";
    for(pokemon a:trainer) {
      result += (" "+a.pokeName+", ");
    }
    return result;
  }

}
