public class Locale {
  
  public Locale(int id, String name, String desc) {
    this.id = id;
    this.name = name;
    this.desc = desc;
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
    return "(ID=" + this.id + ") You are at "+ this.name + "\n" + this.desc;
  }
  
  
  //
  // -- PRIVATE --
  //
  private int id;
  private String  name;
  private String  desc;
  private boolean hasVisited = false;
}