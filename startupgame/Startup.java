package startupgame;

import java.util.ArrayList;

public class Startup {
    // name
    private String name;
    // locations
    private ArrayList<String> locationCells;

    // set name
    public void setName(String n){
        name = n;
    }

    // get name
    public String getName(){
        return name;
    }

    // set locations
    public void setLocationCells(ArrayList<String> locs){
        locationCells = locs;
    }

    // check guess
    public String checkYourself(String userInput){
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if(index >= 0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result = "kill";
            }else{
                result = "hit";
            }
        }
        return result;
    }
}
