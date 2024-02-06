package csc8011;
import java.util.ArrayList;

//Museum class holding the arraylist of exhibits//
public class Museum {
    private ArrayList<Exhibit> exhibits = new ArrayList<>();              //arraylist of Exhibit objects//
    private String name;

    public Museum() {
        this.name = "The Street Fighter Fan Museum";              //setting the name attribute to a default name
    }

    //Methods to add and remove exhibit objects from the exhibits ArrayList//

    //function to check if an exhibit object exists in the arraylist//
    //If it does not it adds the object parameter to the arraylist//
    public boolean addExhibit(Exhibit i) {
        if (!exhibits.contains(i)) {
            exhibits.add(i);
        }
        return true;
    }

    //function to remove an exhibit object that is entered as a parameter//
    public boolean removeExhibit(Exhibit i) {
        return exhibits.remove(i);
    }

    //function getters and setters for Museum name//

    public String getMuseumName() {                     //gets the museum name//
        return name;
    }
    public void setMuseumName(String newName) {         //sets the museum name to a new value from the parameters//
        this.name = newName;
    }

    //function getter for the arraylist//

    public ArrayList<Exhibit> getArrayList() {          //function to get the arraylist//
        return exhibits;
    }

    //function to the find the highest value of all objects in the arraylist//
    //then returns each object as a string of its concatenated attributes//

    public String objectToString(int index) {
        String objectString =  "ID: " + (exhibits.get(index).getExhibitId())
                + ", " + "Description: " + (exhibits.get(index).getDescription())
                + ", " + "Year acquired: " + (exhibits.get(index).getYearAcquired())
                + ", " + "Value: " + (exhibits.get(index).getValue());
        return objectString;
    }

    //function to find the exhibit with the highest value//
    public String findHighestValue() {
        int length = exhibits.size();         //init an int variable called length to the length of the arraylist//
        double max = 0.0;                         //init a default variable to track the largest value//
        String exhibitString = "";                //init empty string variable//

        for (int i = 0; i < length; i++) {              //for loop to iterate over each object in arraylist//
            if (exhibits.get(i).getValue() > max) {     //using the value getter to find the value of each exhibit//
                max = exhibits.get(i).getValue();       //assigns max to value of exhibit if exhibit value is higher//
                exhibitString = objectToString(i);      /*objectToString function sets each attribute of the i object
                                                          to a concatenated string as the exhibit string variable*/
            }
        }
        return exhibitString;                           //returns the concatenated string of the highest value exhibit//
    }

    //function to find object representing the first item acquired//

    public String findFirstAdded() {
        int length = exhibits.size();               //sets the length of the arraylist//
        int year = 9999;                            //init a variable used to track the current lowest year number//
        String firstString = "";                        //empty string for the return object as a string//

        for (int i = 0; i < length; i++) {                      //for loop to iterate through exhibits in arraylist//
            if (exhibits.get(i).getYearAcquired() < year) {     //If the year of the exhibit is lower than year,//
                year = exhibits.get(i).getYearAcquired();       //set year to the new lower number//
                firstString = objectToString(i);                /*use the objectToString method to change exhibit object
                                                                  into a single string*/
            }
        }
        return firstString;                                     //return the string of the object which was first added//
    }

    //function to find the average of all exhibit values//

    public Double findAverageValue() {
        double sum = 0.00;                           //init sum variable to be used to track the sum of all exhibit values//
        double average;                              //init average variable to be used to assign the average value//
        int length = exhibits.size();                //init length variable to length of arraylist containing exhibits//

        for (int i = 0; i < length; i++) {           //for loop to iterate through each exhibit in arraylist//
            sum += exhibits.get(i).getValue();       //adds the current exhibit value to the sum variable//
        }
        average = sum/length;                        //divides the sum variable by the number of objects in the arraylist//
        return average;                              //sum/length assigned to average variable and returned//
    }
}
