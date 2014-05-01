//Kevin Skocypec

import java.util.Scanner;


public class JavaGame{      
  
  //Globals
  public static Locale currentLocale = new Locale(0,  "Champagnat", "You have arrived at the largest freshman dorm.", 0);            //starting lcaole
  public static String command;                   //player inputs
  public static boolean stillPlaying = true;      //game loop.
  public static int[][]  nav;                     //an uninitialized array for navigating (int int)
  public static int moves = 0;                    //moves.
  public static int score = 0;                    //score.
  public static Locale loc[] = new Locale[11];
  public static ListInventory items[] = new ListInventory[15];
  public static boolean mapOut = false;
  public static String inventory[] = new String[8];
  public static int currentItem = 0;
  public static double currency = 50;
  public static boolean atShop = false;
  public static ListTester magicShop = new ListTester();
  public static int in = 0; //current number of items in list
  public static boolean boatBuilt = false;
  public static String[] trackMoves = new String[99];
  public static int iMove = 0;
  
  public static void main(String[] args) //main function
  {    
    //inventory.add();
    items[in] = new ListInventory(in , "Weights", "\nYou found a Weights and (c)11! Do you even lift bro? Type 't' or 'take' to pick up!");
    items[in].setNext(null);//Next is null due to being unnecessary
    in++;
    items[in] = new ListInventory(in, "Campus Map", "\nYou found a Campus Map and (c)11! Type 't' or 'take' to pick up!");
    items[in].setNext(null);//Next is null due to being unnecessary
    in++;
    items[in] = new ListInventory(in, "Pencil", "\nYou found a Pencil! Type 't' or 'take' to pick up!");
    items[in].setNext(null);//Next is null due to being unnecessary
    in++;
    items[in] = new ListInventory(in, "Football", "\nYou found a Football and (c)11! Type 't' or 'take' to pick up!");
    items[in].setNext(null);//Next is null due to being unnecessary
    in++;
    items[in] = new ListInventory(in, "Death's Scythe", "\nThe Scythe of Death!");
    items[in].setNext(null);//Next is null due to being unnecessary
    in++;
    
    Condition loc0 = new Condition(0,  "Champagnat", "You have arrived at the largest freshman dorm.", 0);//2,  1, 4, 10
    loc0.setCond("Good");
    loc[0] = loc0;
    loc[0].setItem(items[1].getName(),items[1].getDesc());
    Condition loc1 = new Condition(1,  "Leo", "You have arrived at the second largest freshman dorm.", 1);//0, -1, 5, -1
    loc1.setCond("Decent");
    loc[1] = loc1;
    loc[2] = new Locale(2, "Student Center", "You step into the main building on campus.  Hmmm what campus is this?", 1);//-1,  0, 6, -1
    loc[2].setItem(items[2].getName(),items[2].getDesc());
    PH loc3 = new PH(3,  "River", "You step upto a large River.  It looks like the Hudson.. but what is that light on the other side?\nA large man appears, exclaiming: 'I will provide you with a boat to cross it.. if you can answer one question'....\n'What always runs but never walks, often murmurs, never talks, has a bed but never sleeps, has a mouth but never eats?'", 1);//3,  3, 0, 9
    loc3.setPH("about 5.  Way too low!");
    loc[3] = loc3;
    loc[4] = new Locale(4, "Football Field", "The sign says 'Tenney Stadium.'", 1);//6,  5, 7, 0
    loc[4].setItem(items[3].getName(),items[3].getDesc());
    loc[5] = new Locale(5,  "McCann Center", "You have arrived at the building for swimming, basketball, and workouts.", 1);//4,  -1, 7, 1
    loc[5].setItem(items[0].getName(),items[0].getDesc());
    loc[6] = new Locale(6,  "Donnelly", "What is this? A building with both science and fashion? Odd...", 1);//-1,  4, 7, 2
    loc[7] = new Locale(7, "Highway", "You have found yourself mistakenly walking onto a highway, where a train is heading at you. You must go back or die.", 1);//-1,  -1, 8, 4
    loc[8] = new Locale(8, "Hell", "The train runs over you, crushing ever bone in your body.\nDeath brings down his arms, forcing a scythe that tears through your body, ripping your soul from it.\n\nYou have obtained Death's Scythe!", 2);//-1,  -1, -1, -1
    loc[9] = new Locale(9, "Heaven", "You approach the light, to find out that you were not lost.  You were dead all along.  Now you have found Heaven!", 3);//-1,  -1, -1, -1
    loc[10] = new Locale(10, "The Magick Shoppe", "What would you like to purchase? (type a directional to leave)", 1);//3,  3, 0, 3
    //New Navigation:
    loc[0].setNextN(loc[2]);
    loc[0].setNextS(loc[1]);
    loc[0].setNextE(loc[4]);
    loc[0].setNextW(loc[10]);
    loc[1].setNextN(loc[0]);
    loc[1].setNextE(loc[5]);
    loc[2].setNextS(loc[0]);
    loc[2].setNextE(loc[6]);
    loc[3].setNextN(loc[3]);
    loc[3].setNextS(loc[3]);
    loc[3].setNextE(loc[0]);
    loc[3].setNextW(loc[3]);
    loc[4].setNextN(loc[6]);
    loc[4].setNextS(loc[5]);
    loc[4].setNextE(loc[7]);
    loc[4].setNextW(loc[0]);
    loc[5].setNextN(loc[4]);
    loc[5].setNextE(loc[7]);
    loc[5].setNextW(loc[1]);
    loc[6].setNextS(loc[4]);
    loc[6].setNextE(loc[7]);
    loc[6].setNextW(loc[2]);
    loc[7].setNextE(loc[8]);
    loc[7].setNextW(loc[4]);
    loc[10].setNextN(loc[3]);
    loc[10].setNextS(loc[3]);
    loc[10].setNextE(loc[0]);
    loc[10].setNextW(loc[3]);
    
    //nav = new int[][]{
    ////ID-Place {N, S, E, W, Untraveled}
    ///*0-Champ*/  
    //{2,  1, 4, 10, 0},
    ///*1-Leo*/  
    //{0, -1, 5, -1, 1},
    ///*2-SC*/  
    //{-1,  0, 6, -1, 1},
    ///*3-River*/  
    //{3,  3, 0, 9, 1},
    ///*4-FB*/  
    //{6,  5, 7, 0, 1},
    ///*5-McCann*/ 
    //{4,  -1, 7, 1, 1},
    ///*6-Donnelly*/
    //{-1,  4, 7, 2, 1},
    ///*7-Highway*/ 
    //{-1,  -1, 8, 4, 1},
    ///*8-Hell*/  
    //{-1,  -1, -1, -1, 2},
    ///*9-Heaven*/ 
    //{-1,  -1, -1, -1, 3},
    ///*10-Magick Shoppe*/ 
    //{3,  3, 0, 3, 1}
    //};
    
    System.out.println("Welcome to Magical Marist!");
    updateDisplay();
    
    while(stillPlaying){
      getCommand();
      navigate();
      updateDisplay();
      if(currentLocale.getID()==9||currentLocale.getID()==8){
        System.out.println("[" + moves + " moves, score " + score + "] ");
        float ratio = 0;
        if(moves!=0)
          ratio = score/moves;
        System.out.println("Achievement Ratio: " + (ratio));
        String posMoves = "Possible Moves:";
        stillPlaying=false;
      }
    }
    
    Scanner inputReader = new Scanner(System.in);
    System.out.println("Would you like to view your tracks used to get to the end of the game?");
    System.out.println("Type 'forward' to view from beginning, 'backward' to view from the end, or 'no' to just end the game.");    
    command = inputReader.nextLine();
    boolean loop = true;
    while(loop){
    if ( command.equalsIgnoreCase("forward") ){
    for(int i = 0; i< trackMoves.length; i++){
      if(trackMoves[i]!=null)
        System.out.println(trackMoves[i]);
    }
    loop=false;
    }else if(command.equalsIgnoreCase("backward")){
      for(int i = 99; i>-1; i++){
        if(trackMoves[i]!=null)
          System.out.println(trackMoves[i]);
      }
      loop=false;
    }else if(command.equalsIgnoreCase("no"))
    {
      loop=false;
    }
    }
    
    System.out.println("Thank you for playing.");
    
  }    
  
  private static void updateDisplay() {
    System.out.println(loc[currentLocale.getID()].toString());
    // if(currentLocale.getID()==10){
    //for(int i=0; i<4;i++)
    //  {
    // System.out.println(items[i].toString());
    //}
    // }
    if(currentLocale.getID()==10){System.out.println("[" + moves + " moves, score " + score + "] ");
      float ratio = 0;
      if(moves!=0)
        ratio = score/moves;
      System.out.println("Achievement Ratio: " + (ratio));
      String posMoves = "Possible Moves: North, South, East, West";
      System.out.println(posMoves);
      atShop=true;
    }
    
    while(atShop){
      magicShop.run();
      if(magicShop.getDirection()!=-1){
        currentLocale=loc[magicShop.getDirection()];
        moves +=1;
        score = score + 5*loc[currentLocale.getID()].getVisitPoints();
        loc[currentLocale.getID()].setVisitPoints(0);
        System.out.println("You have left the Magick Shoppe.");
        System.out.println(loc[currentLocale.getID()].toString());
        atShop=false;
      }else if(magicShop.purchased()==true){
        if(currency-magicShop.getCost()>0){
          currency-=magicShop.getCost();
          items[in] = new ListInventory(in, magicShop.getName(),"Cost: (c)" + magicShop.getCost());
          inventory[currentItem] = items[in].getName();
          items[in].setNext(null);//Next is null due to being unnecessary
          currentItem++;
          in++;
          System.out.println("Current Balance: (c)"+currency);
        }else{
          System.out.println("Not enough money.  \nCurrent Balance: (c)"+currency);
        }
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
    if(loc[currentLocale.getID()].getNextN()!=null)
      posMoves+=" North ";
    if(loc[currentLocale.getID()].getNextS()!=null)
      posMoves+=" South ";
    if(loc[currentLocale.getID()].getNextE()!=null)
      posMoves+=" East ";
    if(loc[currentLocale.getID()].getNextW()!=null)
      posMoves+=" West ";
    System.out.println(posMoves);
    Scanner inputReader = new Scanner(System.in);
    command = inputReader.nextLine();
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
    }else if(command.equalsIgnoreCase("river") && currentLocale==loc[3]){
      if(boatBuilt!=true)
        boatBuilt = true;
      if(boatBuilt==true && loc[3].getNextW()!=loc[9] ){
        loc[3].setNextW(loc[9]);
        loc[3].setDesc("You step upto a large River.  It looks like the Hudson.. but what is that light on the other side?");
        System.out.println("You have successfully built a boat!");
      }
    }else if ( command.equalsIgnoreCase("quit")  || command.equalsIgnoreCase("q")) {
      //quit();
      System.out.println("Thank you for playing.");
      System.exit(0);
    } else if ( command.equalsIgnoreCase("help")  || command.equalsIgnoreCase("h")) {
      help();
    }else if ( command.equalsIgnoreCase("t") || command.equalsIgnoreCase("take") ){
      if(loc[currentLocale.getID()].getItem()!=""){
        inventory[currentItem] = loc[currentLocale.getID()].getItem();
        currentItem++;
        if(currentLocale.getID()==0||currentLocale.getID()==4||currentLocale.getID()==5){
          System.out.println("You have picked up a " + loc[currentLocale.getID()].pickUp()+" and 11 coins! [(c)11].");
          currency+=11;
        }else{
          System.out.println("You have picked up a " + loc[currentLocale.getID()].pickUp()+".");
        }
      }else{
        System.out.println("No items to take here!");
      }
      if(currentLocale.getID()==0)
        mapOut=true;
      //  } else if ( currentLocale.getID() == 10  && (command.equalsIgnoreCase("n")||command.equalsIgnoreCase("s")||command.equalsIgnoreCase("e")||command.equalsIgnoreCase("w"))!=true && (command.equalsIgnoreCase("north")||command.equalsIgnoreCase("south")||command.equalsIgnoreCase("east")||command.equalsIgnoreCase("west"))!=true){
      // if(items[Integer.parseInt(command)]!=null){
      //    inventory[currentItem] = items[Integer.parseInt(command)].getName();
      //      currentItem++;
      //    System.out.println(items[Integer.parseInt(command)].getName() + " purchased!\n");
      //  items[Integer.parseInt(command)].buy();
      //  }
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
        System.out.println("        (to river)           | |           (to river)");
        System.out.println("  [ (1)--Leo         ]--[ (0)--Champ   ]--[ (2)--SC      ]");
        System.out.println("                 | |              | |              | |");
        System.out.println("  [ (5)--McCann ]--[ (4)--Tenney  ]--[ (6)--Donnelly]");
        System.out.println("                 | |              | |              | |");
        System.out.println("                              [ (7)--Highway ]");
        System.out.println("                                  | |");
        System.out.println("                              < (8)--HELL    >");
        System.out.println("#10 - Shop is hidden somewhere on campus.. however it is too secretive to be mapped out!");
        
      }else{
        System.out.println("You do not own a map.");
      }
    } else if (command.equalsIgnoreCase("i")){
      System.out.println("\nCurrent Balance: (c)"+currency+"\nInventory: ");
      for( int i = 0; i < inventory.length; i++){
        if(inventory[i]!=null)
          System.out.println(inventory[i]);
      }
      System.out.println("");
    }else{
      System.out.println("Invalid Command.  Type 'h' or 'help' to view available commands.");
    }
    
    if (dir > -1){
      Locale newLocation=null;
      switch(dir){
        case 0: 
          if(loc[currentLocale.getID()].getNextN()!=null)
          newLocation = loc[loc[currentLocale.getID()].getNextN().getID()];
          break;
        case 1: 
          if(loc[currentLocale.getID()].getNextS()!=null)
          newLocation = loc[loc[currentLocale.getID()].getNextS().getID()];
          break;
        case 2: 
          if(loc[currentLocale.getID()].getNextE()!=null)
          newLocation = loc[loc[currentLocale.getID()].getNextE().getID()];
          break;
        case 3: 
          if(loc[currentLocale.getID()].getNextW()!=null)
            newLocation = loc[loc[currentLocale.getID()].getNextW().getID()];
          break;
      }
      trackMoves[iMove]=loc[currentLocale.getID()].getName();
      iMove++;
      if (newLocation == null) {
        System.out.println("You cannot go that way.");
      } else {
        currentLocale = newLocation;
        moves +=1;
        score = score + 5*loc[newLocation.getID()].getVisitPoints();
        loc[newLocation.getID()].setVisitPoints(0);
      }
    }
    
  }
  private static void help() {
    System.out.println("The commands are as follows:");
    System.out.println("   'h' or 'help' to display help.. but you must know that to be accessing this..");
    System.out.println("   'n' or 'north' to move north");
    System.out.println("   's' or 'south' to move south");
    System.out.println("   'e' or 'east' to move east");
    System.out.println("   'w' or 'west' to move west");
    System.out.println("   'q' or 'quit' to quit the game");
    System.out.println("   'm' or 'map' to display the map");
    System.out.println("   't' or 'take' will pick up items");
    System.out.println("   'i' will display your inventory");
  }
  
  private static void quit() {
    stillPlaying = false;
  }
  
  
}

