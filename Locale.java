public class Locale {
  
  // Constructor
  public Locale(int id, String name, String desc, int newNextN, int newNextS, int newNextE, int newNextW, int newVisitPoints) {
    this.id = id;
    this.name = name;
    this.desc = desc;
    this.nextN=newNextN;
    this.nextS=newNextS;
    this.nextE=newNextE;
    this.nextW=newNextW;
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
  
  public String getDesc() {
    return this.desc;
  }
 
  public void setNextN(int newNextN) {
        this.nextN = newNextN;
    }
  public void setNextS(int newNextS) {
        this.nextS = newNextS;
    }
  public void setNextE(int newNextE) {
        this.nextE = newNextE;
    }
  public void setNextW(int newNextW) {
        this.nextW = newNextW;
    }
  
  public int getNextN() {
       return this.nextN;
    }
  public int getNextS() {
       return this.nextS;
    }
  public int getNextE() {
       return this.nextE;
    }
  public int getNextW() {
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
  private int nextN = -1;
  private int nextS = -1;
  private int nextE = -1;
  private int nextW = -1;
  private int visitPoints;
}