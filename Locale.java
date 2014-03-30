public class Locale {
  
  // Constructor
  public Locale(int id, String name, String desc, ListItem newNextN, ListItem newNextS, ListItem newNextE, ListItem newNextW, int newVisitPoints) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.nextN=newNextN;
    this.nextS=newNextS;
    this.nextE=newNextE;
    this.nextW=newNextW;
    this.visitPoints=newVisitPoints
  }
  
  //Getters
  //Setters
  public int getID() {
    return this.id;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getDesc() {
    return this.desc;
  }
  
  public String getNext() {
    return this.next;
  }
  
  public void setNextN(ListItem newNextN) {
        this.nextN = newNextN;
    }
  public void setNextS(ListItem newNextS) {
        this.nextS = newNextS;
    }
  public void setNextE(ListItem newNextE) {
        this.nextE = newNextE;
    }
  public void setNextW(ListItem newNextW) {
        this.nextW = newNextW;
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
  
  public String toString() {
    return "(ID=" + this.id + ") You are at "+ this.name + "\n" + this.desc + this.itemPhrase;
  }
  
//privates:
  
  private int id;
  private String  name;
  private String  desc;
  private String itemThere;
  private String itemPhrase="";
  private ListItem nextN = null;
  private ListItem nextS = null;
  private ListItem nextE = null;
  private ListItem nextW = null;
  private int visitPoints;
}