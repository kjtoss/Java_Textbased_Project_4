//Kevin Skocypec

import java.util.Scanner;


public class Nav{      
  
  // Globals
  public static final boolean DEBUGGING = true;   // Debugging flag.
  public static final int MAX_LOCALES = 2;        // Total number of rooms/locations we have in the game.
  public static int currentLocale = 0;            // Player starts in locale 0.
  public static String command;                   // What the player types as he or she plays the game.
  public static boolean stillPlaying = true;      // Controls the game loop.
  public static int[][]  nav;                     // An uninitialized array of type int int.
  public static int moves = 0;                    // Counter of the player's moves.
  public static int score = 0;                    // Tracker of the player's score.
  public static Locale loc[] = new Locale[11];
  public static ItemLocale items[] = new ItemLocale[4];
  public static boolean mapOut = false;
  
  public static void main(String[] args) //main function
  {
    Condition loc0 = new Condition(0,  "Champagnat", "You have arrived at the largest freshman dorm.");
    loc0.setCond("Good");
    loc[0] = loc0;
    Condition loc1 = new Condition(0,  "Leo", "You have arrived at the second largest freshman dorm.");
    loc1.setCond("Decent");
    loc[1] = loc1;
    loc[2] = new Locale(2, "Student Center", "You step into the main building on campus.  Hmmm what campus is this?");
    PH loc3 = new PH(3,  "River", "You step into a large River.  It looks like the Hudson.. but what is that light on the other side?");
    loc3.setPH("about 5.  Way too low!");
    loc[3] = loc3;
    loc[4] = new Locale(4, "Football Field", "The sign says 'Tenney Stadium.'");
    loc[5] = new Locale(5,  "McCann Center", "You have arrived at the building for swimming, basketball, and workouts.");
    loc[6] = new Locale(6,  "Donnelly", "What is this? A building with both science and fashion? Odd...");
    loc[7] = new Locale(7, "Highway", "You have found yourself mistakenly walking onto a highway, where a train is heading at you. You must go back or die.");
    loc[8] = new Locale(8, "Hell", "The train runs over you, crushing ever bone in your body.\nDeath brings down his arms, forcing a scythe that tears through your body, ripping your soul from it.\n\nYou have obtained Death's Scythe!");
    loc[9] = new Locale(9, "Heaven", "You approach the light, to find out that you were not lost.  You were dead all along.  Now you have found Heaven!");
    loc[10] = new Locale(10, "Magick Shoppe", "What would you like to purchase?");
    
    //items[0] = new ItemLocale(0, "Campus Map", "A map to help navigate through the campus.  Use 'm' to display, once purchased.");
    items[0] = new ItemLocale(0, "Rags", "A bunch of old rags..");
    items[1] = new ItemLocale(1, "Wood Wand", "A piece of wood with special properties.");
    items[2] = new ItemLocale(2, "Quarter Staff", "A larger piece of wood with special properties.");
    items[3] = new ItemLocale(3, "Crystall Ball", "A glass ball used for telling the future and fortunes of visitors.");
    
    nav = new int[][]{
      //ID-Place {N, S, E, W, Untraveled}
       /*0-Champ*/  
      {2,  1, 4, 10, 0},
        /*1-Leo*/  
      {0, -1, 5, -1, 1},
        /*2-SC*/  
      {-1,  0, 6, -1, 1},
        /*3-River*/  
      {3,  3, 0, 9, 1},
        /*4-FB*/  
      {6,  5, 7, 0, 1},
        /*5-McCann*/ 
      {4,  -1, 7, 1, 1},
        /*6-Donnelly*/
      {-1,  4, 7, 2, 1},
        /*7-Highway*/ 
      {-1,  -1, 8, 4, 1},
        /*8-Hell*/  
      {-1,  -1, -1, -1, 2},
        /*9-Heaven*/ 
      {-1,  -1, -1, -1, 3},
        /*10-Magick Shoppe*/ 
      {3,  3, 0, 3, 1}
    };
  
    System.out.println("Welcome to Magical Marist!");
    updateDisplay();
    //for(int i=0;i<10;i++)
    //System.out.println(loc[i].toString());
    
    while(stillPlaying){
      getCommand();
      navigate();
      updateDisplay();
      if(currentLocale==9||currentLocale==8){
      System.out.println("[" + moves + " moves, score " + score + "] ");
      float ratio = 0;
      if(moves!=0)
        ratio = score/moves;
      System.out.println("Achievement Ratio: " + (ratio));
      String posMoves = "Possible Moves:";
        stillPlaying=false;
      }
    }
        
    System.out.println("Thank you for playing.");
    
  }    
  
  private static void updateDisplay() {
        System.out.println(loc[currentLocale].toString());
      if(currentLocale==10){
       for(int i=0; i<4;i++)
       {
         System.out.println(items[i].toString());
       }
      }
    }

    private static void getCommand() {
      System.out.println("[" + moves + " moves, score " + score + "] ");
      float ratio = 0;
      if(moves!=0)
        ratio = score/moves;
      System.out.println("Achievement Ratio: " + (ratio));
      String posMoves = "Possible Moves:";
      if(nav[currentLocale][0]!=-1)
          posMoves+="North ";
        if(nav[currentLocale][1]!=-1)
          posMoves+="South ";
        if(nav[currentLocale][2]!=-1)
          posMoves+="East ";
        if(nav[currentLocale][3]!=-1)
          posMoves+="West ";
        System.out.println(posMoves);
        Scanner inputReader = new Scanner(System.in);
        command = inputReader.nextLine();  // command is global.
    }   
    
    private static void navigate() {
      final int INVALID = -1;
      int dir = INVALID;  // This will get set to a value > 0 if a direction command was entered.
      
      if (        command.equalsIgnoreCase("north") || command.equalsIgnoreCase("n") ) {
        dir = 0;
      } else if ( command.equalsIgnoreCase("south") || command.equalsIgnoreCase("s") ) {
        dir = 1;
      } else if ( command.equalsIgnoreCase("east")  || command.equalsIgnoreCase("e") ) {
        dir = 2;
      } else if ( command.equalsIgnoreCase("west")  || command.equalsIgnoreCase("w") ) {
        dir = 3;
      } else if ( command.equalsIgnoreCase("quit")  || command.equalsIgnoreCase("q")) {
        //quit();
        System.out.println("Thank you for playing.");
        System.exit(0);
      } else if ( command.equalsIgnoreCase("help")  || command.equalsIgnoreCase("h")) {
        help();
      }else if ( command.equalsIgnoreCase("t") || command.equalsIgnoreCase("take") ){
        if(currentLocale==0)
          mapOut=true;
      } else if ( currentLocale == 10  && (command.equalsIgnoreCase("0")||command.equalsIgnoreCase("1")||command.equalsIgnoreCase("2")||command.equalsIgnoreCase("3"))){
        if(items[Integer.parseInt(command)]!=null)
             System.out.println(items[Integer.parseInt(command)].getName() + " purchased!\n");
      } else if ( command.equalsIgnoreCase("m")||command.equalsIgnoreCase("map") ) {
        if(mapOut==true){
        System.out.println("This is a map.  Some paths may only be one way, so be careful!");
System.out.println("                                 W");
System.out.println("                                   |");
System.out.println("                                   |");
System.out.println("                       S<----*---->N");
System.out.println("                                   |");
System.out.println("                                   |");
System.out.println("                                  E\n");
System.out.println("                              ( (9)--Heaven )");
System.out.println("                                  | |");
System.out.println("                            --[ (3)--River  ]--");            
System.out.println("                                  | |");
System.out.println("                               [ (10)--Shop  ]");
System.out.println("        (to river)           | |           (to river)");
System.out.println("  [ (1)--Leo         ]--[ (0)--Champ   ]--[ (2)--SC      ]");
System.out.println("                 | |              | |              | |");
System.out.println("  [ (5)--McCann ]--[ (4)--Tenney  ]--[ (6)--Donnelly]");
System.out.println("                 | |              | |              | |");
System.out.println("                              [ (7)--Highway ]");
System.out.println("                                  | |");
System.out.println("                              < (8)--HELL    >");
  
        }else{
        System.out.println("You do not own a map.");
        }
      } 
      
      if (dir > -1 && ((currentLocale == 10)&&(command.equalsIgnoreCase("0")||command.equalsIgnoreCase("1")||command.equalsIgnoreCase("2")||command.equalsIgnoreCase("3")))!=true) {  
        int newLocation = nav[currentLocale][dir];
        if (newLocation == INVALID) {
          System.out.println("You cannot go that way.");
        } else {
          currentLocale = newLocation;
          moves +=1;
          score = score + 5*nav[newLocation][4];
          nav[newLocation][4]=0;
        }
      }
    }
    private static void help() { //TODO: finish
        System.out.println("The commands are as follows:");
        System.out.println("   'h' or 'help' to display help.. but you must know that to be accessing this..");
        System.out.println("   'n' or 'north' to move north");
        System.out.println("   's' or 'south' to move south");
        System.out.println("   'e' or 'east' to move east");
        System.out.println("   'w' or 'west' to move west");
        System.out.println("   'q' or 'quit' to quit the game");
        System.out.println("   'm' or 'map' to display the map");
    }

    private static void quit() {
        stillPlaying = false;
    }

  
}

