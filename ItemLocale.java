public class ItemLocale {
  
  // Constructor
  public ItemLocale(int id, String newName, String newDesc) {
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
}