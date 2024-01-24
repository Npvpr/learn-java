package SimpleShipGame;

public class SimpleStartupTestDrive{
    public static void main(String[] args){
        // make game object
        SimpleStartupGame game = new SimpleStartupGame();

        // Check random numbers of ships are valid?
            // ajacent? integers?
        int[] locations = {1, 2, 3};
        game.setLocationCells(locations);

        // Check user guess number is valid?
            // int?
        // Check miss
        System.out.println(game.checkYourself(5));

        // Check hit
        System.out.println(game.checkYourself(2));

        // Check hitting already lost position
        System.out.println(game.checkYourself(2));

        // Check win
        System.out.println(game.checkYourself(2));

    }
}

class SimpleStartupGame{
    private int[] locationCells;
    private int numOfHits = 0;

    public void setLocationCells(int[] locs){
        locationCells = locs;
    }

    // Check the guess number
        // Miss
        // Hit => count hit
            // final hit => Kill
    public String checkYourself(int guess){
        String result = "miss";
        for(int cell: locationCells){
            if(guess == cell){
                result = "hit";
                numOfHits++;
                break;
            }
        }
        if(numOfHits == locationCells.length){
            result = "kill";
        }
        return result;
    }
}