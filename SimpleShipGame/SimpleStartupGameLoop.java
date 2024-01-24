package SimpleShipGame;

public class SimpleStartupGameLoop {
    public static void main(String[] args) {
        // make game object
        SimpleStartupGame game = new SimpleStartupGame();

        // make gamehelper object for user input
        GameHelper helper = new GameHelper();

        // Initiate guess count
        int numOfGuesses = 0;

        // COM will set random location of ship
        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum+1, randomNum+2};
        game.setLocationCells(locations);

        // Start Game
        boolean isAlive = true;
        while (isAlive) {
            // COM will ask Player to guess a number
            int guess = helper.getUserInput("Enter a number");
            numOfGuesses++;

            // Check the guess number
            String result = game.checkYourself(guess);
            System.out.println(result);

            if(result == "kill"){
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            }
            
        }

        
    }
}
