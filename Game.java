/*
State info:
var studyName. This variable will be a static variable. The studyName variable will be used to let the user input the name of their study set.



terms = HashMap<String, String>
This creates the private instance variables to store the terms the user sets



Method info:
public studySet. This will be the constuctor in order to initialize the variables in the HashMap.



public void modifyTerms
This will be a method to output phrases for the user to input their actions.



public void inputTerms
This will be a method using a switch case in order to allow the user to have options if they want to view, set, or delete terms
*/

/*
Game class 


Author - Alicia Wu
*/

import java.util.HashMap;

public class Game {
  private String fullname;  // person's name
  private int points=0;      // number of players
  private int randNum;  // Favorite number (picked randomly)
  private String randadjective; // Favorite flavor (picked randomly)
  private String randnoun; // Favorite flavor (picked randomly)
  private static String[] adjectives = {"cool", "silly", "tiny", "huge", "old", "young"};
  private static String[] nouns = {"worm", "chair", "pillow", "slime", "kid", "dog", "cat"};
  private HashMap<String, Game> users; // Info on all users
  private HashMap<String, String> questions; //
  private int score;
  private int playernum=0;
  private int newpoints;

  // Play the game
  public void play () {
    System.out.println("");
    System.out.println("");
    System.out.println ("Game Loading...");
    System.out.println("");
    System.out.println("WELCOME");

    users = new HashMap<String, Game>();
    
    while (true) {
      fullname = Utils.inputStr ("\nWhat's your name? ");
      if (!users.keySet().contains(fullname)) {
        randNum = Utils.randInt (1, 100);
        randnoun = Utils.randChoice(nouns);
        randadjective = Utils.randChoice(adjectives);
        users.put(fullname, this);
        points = 0;
        System.out.println("You currently have " + points+ " points.");
        newpoints = Utils.inputNum ("How many more points did you earn? ");
        points = newpoints + points;
        playernum++;
        users.put(fullname, this);

        
      } else {
        System.out.println ("Welcome back!");
        points = users.get(fullname).points;
        playernum = users.get(fullname).playernum;
        randNum = users.get(fullname).randNum;
        randadjective = users.get(fullname).randadjective;
        randnoun = users.get(fullname).randnoun;
        System.out.println ("Your username is: " + randadjective + randnoun+ randNum);
        System.out.println("You currently have " + points+ " points.");
        newpoints = Utils.inputNum ("How many more points did you earn? ");
        points = newpoints + points;

      }
      print();

      String command = Utils.inputStr("\nWhat do you want to do next (q=quit, f=forget my data, anything else to continue)? ");
      switch (command) {
        case "q":
          return;
        case "f":
          users.remove(fullname);
      }
      
    }
  }

  public void print() {
      System.out.println("");
      System.out.println ("Hello " + fullname +".");
      System.out.println("You are player number "+playernum+".");
      System.out.println ("You currently have " + points + " points.");
      System.out.println ("Your randomly assigned username is: " + randadjective + randnoun+ randNum);
     
  }
}