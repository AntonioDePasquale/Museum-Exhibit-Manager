package csc8011;
import java.io.File;
import java.util.Scanner;

//MuseumIO class for the input output functions and main function//
public class MuseumIO {
    public static void main(String[] args) {            //main function//
        Museum museum = new Museum();                   //constructs a new museum class to be used//
        Scanner scan = new Scanner(System.in);          //creates a new scanner class called scan//
        start(museum, scan);                            /*a start function shown below that takes the museum class
                                                          and scanner scan as parameters*/
    }

    public static void start(Museum museum, Scanner scan) {         //start function described above//
        read(museum);                                               //reader function called read, uses museum as param//

        System.out.println("\nWelcome to the the street fighter museum portal!" +
                "\nPlease enter a new museum name");                //welcoming message that asks input for new museum name//
        String input = scan.next();
        museum.setMuseumName(input);

        while (museumOptionMenu(museum, scan)) {                    //while loop to launch the program, returns true until exit is selected//
            museumOptionMenu(museum, scan);                         //will run the menu switch function on repeat//
        }
    }

    //reader function to read lines from the csv file as exhibit objects to be added to the arraylist//
    public static void read(Museum museum) {
        try {
            Scanner reader = new Scanner(new File("src/csc8011/exhibits.csv"));  //reads csv file location//
            while (reader.hasNextLine()) {                                      //while there is a nextline assign it to line//
                String line = reader.nextLine();
                if (line.isEmpty()) {                                           //if the line is empty continue out of while loop//
                continue;
                }
                String[] attributes = line.split(",");                    //splits each line into an array of attributes//

                Integer tempId = Integer.parseInt(attributes[0].trim());        //parses index[0] to int, assigns own variable//
                String tempDesc = attributes[1].trim();                         //index[1] is already string, assigns own variable//
                Integer tempYear = Integer.parseInt(attributes[2].trim());      //parses index[2] to int, assigns own variable//
                Double tempValue = Double.parseDouble(attributes[3].trim());    //parses index[3] to double, assigns own variable//

                //individual attributes can now be passed into the Exhibit constructor to create an exhibit object//
                Exhibit tempExhibit = new Exhibit(tempId,tempDesc,tempYear,tempValue);
                museum.addExhibit(tempExhibit);               //adds the newly created exhibit object to the arraylist in museum//
            }
        }
        catch (Exception e) {                                 //if the try is unsuccessful prints the error message to the console//
            System.out.println("Error " + e.getMessage());
        }
    }

    //museum option menu function using a switch expression//

    public static boolean museumOptionMenu(Museum museum, Scanner scan) {

        //try and catch for the switch method with if else statement to check if the input is a valid number//

        try {
            System.out.println("\nWelcome to the the " + museum.getMuseumName() + "!");
            System.out.println("Please enter the number for the corresponding option\n");
            System.out.println("""
                    1: Change the name of the Museum
                    2: A list of all current exhibits and their information
                    3: Details of exhibit with the highest value
                    4: Details of the first exhibit acquired
                    5: The average value of all exhibits
                    6: Exit the Program
                    """);

            if (!scan.hasNextInt()) {
                System.out.println("Please select a valid number");
                scan.nextLine();

            } else {
                switch (scan.nextInt()) {

                    //case 1 asks for an input set to a variable called nameInput and sets it as the museum name//
                    case 1 -> {
                        System.out.println(museum.getMuseumName());
                        System.out.println("Enter a new museum name");
                        String nameInput = scan.next();
                        museum.setMuseumName(nameInput);
                    }

                    //case 2 prints all attributes of an object in the arraylist one by one separated by a comma and descriptor//
                    case 2 -> {
                        System.out.println(museum.getMuseumName());
                        int length = museum.getArrayList().size();
                        for (int i = 0; i < length; i++) {                  //iterates over each exhibit object attribute//
                            System.out.print("ID: " + museum.getArrayList().get(i).getExhibitId() + ", ");
                            System.out.print("Description: " + museum.getArrayList().get(i).getDescription() + ", ");
                            System.out.print("Year acquired: " + museum.getArrayList().get(i).getYearAcquired() + ", ");
                            System.out.print("Value: " + museum.getArrayList().get(i).getValue() + "\n");
                        }
                    }

                    //case 3 highest value is printed from the findHighestValue function//
                    case 3 -> {
                        System.out.println("The highest value exhibit is shown below");
                        System.out.println(museum.findHighestValue() + "\n");
                    }

                    //case 4 first acquired is printed from the findFirstAcquired function//
                    case 4 -> {
                        System.out.println("The first acquired exhibit is shown below");
                        System.out.println(museum.findFirstAdded() + "\n");
                    }

                    //case 5 prints average value found by the findFirstAdded function//
                    case 5 -> System.out.println("The average value of all exhibits is " + museum.findAverageValue() + "\n");

                    //returns false which exits the while loop//
                    case 6 -> {
                        System.out.println("Exiting the program");
                        return false;
                    }

                    default -> {
                        break;
                    }
                }
            }
            //exception that prints the error message//
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return true;
    }
}
