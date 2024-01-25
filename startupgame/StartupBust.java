package startupgame;

import java.util.ArrayList;

public class StartupBust {
    // import helper
    private GameHelper helper = new GameHelper();

    // Make startups array for all startups
    private ArrayList<Startup> startups = new ArrayList<Startup>();

    private int numOfGuesses = 0;
    
    private void setUpGame(){

        // Make 3 startups
            // Name them
            // Set random locations
        Startup one = new Startup();
        one.setName("One");
        Startup two = new Startup();
        two.setName("Two");
        Startup three = new Startup();
        three.setName("Three");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        System.out.println("Your goal is to sink three Startups.");
        System.out.println("one, two, three");
        System.out.println("Try to sink them all in the fewest number of guesses");

        for(Startup startup: startups){
            ArrayList<String> newlocs = helper.placeStartup(3);
            startup.setLocationCells(newlocs);
        }
    }

    private void startPlaying(){
        while(!startups.isEmpty()){
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuesses(userGuess);
        }
        finishGame();
    }

    // Check guess
    private void checkUserGuesses(String userGuess){
        numOfGuesses++;
        String result = "miss";

        for(Startup startup: startups){
            result = startup.checkYourself(userGuess);

            if(result.equals("hit")){
                break;
            }

            if(result.equals("kill")){
                System.out.println("Ouch! You sunk " + startup.getName() + " :(");
                startups.remove(startup);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("All Startups are dead! Your stock is now worthless");
        if (numOfGuesses <= 18) {
          System.out.println("It only took you " + numOfGuesses + " guesses.");
          System.out.println("You got out before your options sank.");
        } else {
          System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
          System.out.println("Fish are dancing with your options");
        }
    }

    public static void main(String[] args) {
        StartupBust game = new StartupBust();
        game.setUpGame();
        game.startPlaying();
    }
}
