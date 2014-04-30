public class Locale {
  
  // Constructor
  public Locale(int id, String name, String desc, int newVisitPoints) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.visitPoints=newVisitPoints;
  }
  
  //Getters
  //Setters
  public int getID() {
    return this.id;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String namee) {
    this.name = namee;
  }
  
  public String getDesc() {
    return this.desc;
  }
  
  public void setDesc(String descc) {
    this.desc = descc;
  }
  
  public void setNextN(Locale newNextN) {
    this.nextN = newNextN;
  }
  public void setNextS(Locale newNextS) {
    this.nextS = newNextS;
  }
  public void setNextE(Locale newNextE) {
    this.nextE = newNextE;
  }
  public void setNextW(Locale newNextW) {
    this.nextW = newNextW;
  }
  
  public Locale getNextN() {
    return this.nextN;
  }
  public Locale getNextS() {
    return this.nextS;
  }
  public Locale getNextE() {
    return this.nextE;
  }
  public Locale getNextW() {
    return this.nextW;
  }
  
  public void setItem(String item, String phrase){
    this.itemThere = item; 
    this.itemPhrase = phrase;
  }
  public String getItem(){
    return this.itemThere;
  }
  
  public String pickUp(){
    String item = itemThere;
    this.itemThere = "";
    this.itemPhrase = "";
    return item;
  }
  
  public void setVisitPoints(int newVisitPoints) {
    this.visitPoints = newVisitPoints;
  }
  
  public int getVisitPoints() {
    return this.visitPoints;
  }
  
  public String toString() {
    return "(ID=" + this.id + ") You are at "+ this.name + "\n" + this.desc + this.itemPhrase;
  }
  
//privates:
  
  private int id;
  private String  name;
  private String  desc;
  private String itemThere;
  private String itemPhrase="";
  private Locale nextN = null;
  private Locale nextS = null;
  private Locale nextE = null;
  private Locale nextW =null;
  private int visitPoints;
}