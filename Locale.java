public class Locale {
  
  public Locale(int id, String newName, String newDesc) {
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
    return "[Locale object: id=" + this.id + " name="+ this.name + " desc=" + this.desc + "]";
  }
  
  
  //
  // -- PRIVATE --
  //
  private int id;
  private String  name;
  private String  desc;
  private boolean hasVisited = false;
}