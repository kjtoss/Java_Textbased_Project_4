public class Condition extends Locale {

   //
   // -- PRIVATE --
   //

   // Constructor
   public Condition(int id, String name, String desc) {
    super(id,name,desc);
   }

   // Getters and Setters
   public void setCond(String condit) {
      this.cond = condit;
   }
   public String getCond() {
      return this.cond;
   }

   // Other methods
   @Override
   public String toString() {
      return super.toString() + ".  The condition for this dorm is: " + this.cond + ".";
   }


   //
   // -- PRIVATE --
   //
   private String cond;

}