package csc8011;

//Exhibit class and constructor to create Exhibit objects for the Street Fighter game museum//
public class Exhibit {

    //creation of the class attributes to be accessed by getter/setter functions for the exhibit class//
    private Integer exhibitId;
    private String description;
    private Integer yearAcquired;
    private Double value;

//function to set the exhibit class attributes to input parameters when called by constructor//
    public Exhibit(Integer id, String description, Integer year, Double value) {
        this.exhibitId = id;
        this.description = description;
        this.yearAcquired = year;
        this.value = value;
    }

//defined setter and getter methods for the Exhibit class constructor//

    public Integer getExhibitId() {                    //gets the exhibit ID//
        return exhibitId;
    }

    public void setExhibitId(Integer id) {             //sets the exhibit ID to parameters//
        this.exhibitId = id;
    }

    public String getDescription() {                    //gets the description//
        return description;
    }

    public void setDescription(String description) {    //sets the description to parameters//
        this.description = description;
    }

    public Integer getYearAcquired() {                  //gets the year acquired//
        return yearAcquired;
    }

    public void setYearAcquired(Integer year) {         //sets the year acquired//
        this.yearAcquired = year;
    }

    public double getValue() {                          //gets the value attribute//
        return value;
    }

    public void setValue(Double value) {                //sets the value attribute to parameters//
        this.value = value;
    }
}
