public class PH extends Locale {
  
  //
  // -- PRIVATE --
  //
  
  // Constructor
  public PH(int id, String name, String desc, int nextN, int nextS, int nextE, int nextW, int visitPoints) {
    super(id,name,desc,nextN,nextS,nextE,nextW,visitPoints);
  }
  
  // Getters and Setters
  public void setPH(String phL) {
    this.ph = phL;
  }
  public String getPH() {
    return this.ph;
  }
  
  // Other methods
  @Override
  public String toString() {
    return super.toString() + ".  The current PH levels of the river are: " + this.ph + ".";
  }
  
  
  //
  // -- PRIVATE --
  //
  private String ph;
  
}