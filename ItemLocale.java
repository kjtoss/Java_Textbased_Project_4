public class ItemLocale {
  
  public ItemLocale(int id, String newName, String newDesc) {
    this.id = id;
    this.name = newName;
    this.desc = newDesc;
  }
  
  // Getters and Setters
  public int getID() {
    return this.id;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getDesc() {
    return this.desc;
  }
  
  public String toString() {
    return this.id + ": " + this.name + " - " + this.desc;
  }
  
  
  //
  // -- PRIVATE --
  //
  private int id;
  private String  name;
  private String  desc;
  private boolean hasVisited = false;
}