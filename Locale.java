public class Locale {
  
  // Constructor
  public Locale(int id, String name, String desc, ListItem newNext) {
    this.id = id;
    this.name = name;
    this.desc = desc;
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
  
  public void setNext(ListItem newNext) {
        this.next = newNext;
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
  private ListItem next = null;
}