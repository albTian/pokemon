/**
 *  Authors: Albert Tian, Jocelyn Su
 * Date: June 22, 2019
 * Final Project: Pokemon Game
 * Class Description: Calculates the effectiveness of each move depending on what pokemon the opponent is
 * 
 *
 */
package pokemonProject;
public abstract class pokemon {
  public double HP, ATK, DEF, SPD;
  public String TP1, TP2;
  public String MV1;
  public String MV2;
  public String MV3;
  public String MV4;
  public String[] moveArr= new String[4];
  public boolean life;
  String pokeName="";
  
  public pokemon(double H, double A, double D, double S, 
        String T1, String T2,
        String M1, String M2, String M3, String M4, String pk) {
    HP = H;   
    ATK = A;  
    DEF=D;    
    SPD=S;    

    TP1=T1;TP2=T2;
    MV1 = M1;MV2 = M2;MV3=M3;MV4=M4;
    
    moveArr[0] = MV1;
    moveArr[1] = MV2;
    moveArr[2] = MV3;
    moveArr[3] = MV4;
    
    pokeName=pk;
    
    life=true;
  }
  
  public void damage(double boy) {
//    HP = HP-boy;

    HP=HP-boy;
    if(HP<=0) {
      life=false;
//      kill();
      System.out.println(pokeName+" fainted!");
    }
  }
  
  
  public void setATK(int ya) {
    ATK += ya;
  }
  public void setDEF(int ya) {
    DEF += ya;
  }
  public void setSPD(int ya) {
    SPD += ya;
  }

  

  
  abstract void ACT(String move, pokemon b);
  
  public  String toString() {
    return  "\n"+
        "HP: " +HP+ " ATK: "+ATK+"  DEF: "+DEF+"  SPD: "+SPD+
        "\n"+
        "Move 1: "+MV1+"      Move 2: "+MV2+
        "\n"+
        "Move 3: "+MV3+"      Move 4: "+MV4;
  }
  
  //takes in move type and pokemon type to determine if theres a resistance or bonus 


  //returns .75, 1, or 1.25
  //if theres a resistance to grass then .75
  //neutral then 1.0
  //super effective then 1.25
  public double grassType(String a) {
    if(a.equals("Water")||a.equals("Ground")||a.equals("Rock")) {
      return 1.25;
    }
    else if(a.equals("Fire")||a.equals("Grass")||a.equals("Poison")||
        a.equals("Flying")||a.equals("Bug")||a.equals("Dragon")||
        a.equals("Steel")) {
      return .75;
    }
    else {
      return 1.0;
    }
  }
  
  public double normalType(String a) {
    if(a.equals(null)) {
      return 1.25;
    }
    else if(a.equals("Rock")||a.equals("Steel")) {
      return .75;
    }
    else if(a.equals("Ghost")) {
      return 0.0;
    }
    else {
      return 1.0;
    }
  }
  
  public double fireType(String a) {
    if(a.equals("Grass")||a.equals("Ice")||a.equals("Bug")||a.equals("Steel")) {
      return 1.25;
    }
    else if(a.equals("Fire")||a.equals("Water")||a.equals("Rock")||
        a.equals("Dragon")) {
      return .75;
    }
    else {
      return 1.0;
    }
  }
  
  public double waterType(String a) {
    if(a.equals("Fire")||a.equals("Ground")||a.equals("Rock")) {
      return 1.25;
    }
    else if(a.equals("Water")||a.equals("Grass")||a.equals("Dragon")) {
      return .75;
    }
    else {
      return 1.0;
    }
  }
  
  public double electricType(String a) {
    if(a.equals("Water")||a.equals("Flying")) {
      return 1.25;
    }
    else if(a.equals("Electric")||a.equals("Grass")||a.equals("Dragon")) {
      return .75;
    }
    else if(a.equals("Ground")) {
      return 0.0;
    }
    else {
      return 1.0;
    }
  }
  
  public double iceType(String a) {
    if(a.equals("Grass")||a.equals("Ground")||a.equals("Flying")||a.equals("Dragon")) {
      return 1.25;
    }
    else if(a.equals("Fire")||a.equals("Water")||a.equals("Ice")||
        a.equals("Steel")) {
      return .75;
    }
    else {
      return 1.0;
    }
  }
  
  public double fightingType(String a) {
    if(a.equals("Normal")||a.equals("Ice")||a.equals("Rock")||
      a.equals("Dark")||a.equals("Steel")) {
      return 1.25;
    }
    else if(a.equals("Poison")||a.equals("Flying")||a.equals("Psychic")||
        a.equals("Bug")||a.equals("Fairy")) {
      return .75;
    }
    else if(a.equals("Ghost")){
      return 0.0;
    }
    else {
      return 1.0;
    }
  }
  
  public double poisonType(String a) {
    if(a.equals("Grass")||a.equals("Fairy")) {
      return 1.25;
    }
    else if(a.equals("Poison")||a.equals("Ground")||a.equals("Rock")||
        a.equals("Ghost")) {
      return .75;
    }
    else if(a.equals("Steel")){
      return 0.0;
    }
    else {
      return 1.0;
    }
  }
  
  public double groundType(String a) {
    if(a.equals("Fire")||a.equals("Electric")||a.equals("Poison")||
        a.equals("Rock")||a.equals("Steel")) {
      return 1.25;
    }
    else if(a.equals("Grass")||a.equals("Bug")) {
      return .75;
    }
    else if(a.equals("Flying")){
      return 0.0;
    }
    else {
      return 1.0;
    }
  }
  
  public double flyingType(String a) {
    if(a.equals("Grass")||a.equals("Fighting")||a.equals("Bug")) {
      return 1.25;
    }
    else if(a.equals("Electric")||a.equals("Rock")||a.equals("Steel")) {
      return .75;
    }
//    else if(a.equals("Flying")){
//      return 0.0;
//    }
    else {
      return 1.0;
    }
  }
  
  public double bugType(String a) {
    if(a.equals("Grass")||a.equals("Psychic")||a.equals("Dark")) {
      return 1.25;
    }
    else if(a.equals("Fire")||a.equals("Fighting")||a.equals("Poison")||a.equals("Flying")||a.equals("Ghost")
        ||a.equals("Steel")||a.equals("Fairy")) {
      return .75;
    }
//    else if(a.equals("Flying")){
//      return 0.0;
//    }
    else {
      return 1.0;
    }
  }
  
  public double rockType(String a) {
    if(a.equals("Fire")||a.equals("Ice")||a.equals("Flying")||a.equals("Bug")) {
      return 1.25;
    }
    else if(a.equals("Fighting")||a.equals("Ground")||a.equals("Steel")) {
      return .75;
    }
//    else if(a.equals("Flying")){
//      return 0.0;
//    }
    else {
      return 1.0;
    }
  }
  
  public double steelType(String a) {
    if(a.equals("Ice")||a.equals("Rock")||a.equals("Fairy")) {
      return 1.25;
    }
    else if(a.equals("Fire")||a.equals("Water")||a.equals("Electric")||a.equals("Steel")) {
      return .75;
    }
//    else if(a.equals("Flying")){
//      return 0.0;
//    }
    else {
      return 1.0;
    }
  }
  
  public double fairyType(String a) {
    if(a.equals("Fighting")||a.equals("Dragon")||a.equals("Dark")) {
      return 1.25;
    }
    else if(a.equals("Fire")||a.equals("Poison")||a.equals("Steel")||a.equals("Steel")) {
      return .75;
    }
//    else if(a.equals("Flying")){
//      return 0.0;
//    }
    else {
      return 1.0;
    }
  }
}












