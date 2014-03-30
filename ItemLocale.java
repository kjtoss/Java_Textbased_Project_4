public class ItemLocale {
  
  // Constructor
  public ItemLocale(int id, String newName, String newDesc, double newCost, int newNext) {
    this.id = id;
    this.name = newName;
    this.desc = newDesc;
    this.cost = newCost;
    this.next = newNext;
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

    public double getCost() {
        return this.cost;
    }
  
  public int getNext() {
    return this.next;
  }
  
  public void setNext(int newNext) {
        this.next = newNext;
    }
  
  public void buy(){
    this.name = "";
    this.desc = "";
  }
  
  public String toString() {
    return this.id + ": " + this.name + " - " + this.desc + " cost = " + this.cost;
  }
  
  //privates:
  
  private int id;
  private String  name;
  private String  desc;
  private double cost;
  private int next = 0;
}