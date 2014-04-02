public class Condition extends Locale {
  
  // Constructor
  public Condition(int id, String name, String desc, int visitPoints) {
    super(id,name,desc,visitPoints);
  }
  
  //Getters
  //Setters
  public void setCond(String condit) {
    this.cond = condit;
  }
  public String getCond() {
    return this.cond;
  }
  
  // Other methods
  @Override
  public String toString() {
    return super.toString() + ".  \nThe condition for this dorm is: " + this.cond + ".";
  }
  
  //privates
  
  private String cond;
  
}