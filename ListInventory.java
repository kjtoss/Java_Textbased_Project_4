public class ListInventory {
  
  // Constructor
  public ListInventory(int id, String newName, String newDesc) {
    this.id = id;
    this.name = newName;
    this.desc = newDesc;
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
  
  
  public ListInventory getNext() {
    return this.next;
  }
  
  public void setNext(ListInventory newNext) {
    this.next = newNext;
  }
  
  public void buy(){
    this.name = "";
    this.desc = "";
  }
  
  public String toString() {
    return this.id + ": " + this.name + " - " + this.desc;
  }
  
  //privates:
  
  private int id;
  private String  name;
  private String  desc;
  private ListInventory next = null;
}