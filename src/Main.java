import java.util.Scanner;

public class Main {
//  Global Variables
    static final int FIXED_SIZE = 50;
    static Scanner sc = new Scanner(System.in);
    static String[] animalNames = new String[FIXED_SIZE];
    static String[] animalSpecies = new String[FIXED_SIZE];
    static int[] animalAges = new int[FIXED_SIZE];
    static int[] animalEnclosureNum = new int[FIXED_SIZE];

    public static void main(String[] args) {
        //Variables.
        int userChoice;
        boolean repeaterFlag = true;
        int counter = 0;
        
        //Display menu 
        while (repeaterFlag) {
            System.out.println("Welcome to Z-Inventory System!");
            System.out.println("------------------------------");
            System.out.println("""
                    1. Add a new animal
                    2. View all animals
                    3. Search animal by name
                    4. Count animals by species
                    5. View animals by enclosure
                    6. Exit
                    """); //Used text block - cleaner code.

            userChoice = scanInt("Enter your choice: ");
            sc.nextLine();

            //Navigates to method based on user input
            switch (userChoice) {
                case 1 -> {
                    addAnimals(counter);
                    counter++;
                }
                case 2 -> viewAnimals(counter);
                case 3 -> searchAnimals(counter);
                case 4 -> countAnimals(counter);
                case 5 -> viewAnimalsEnclosure(counter);
                case 6 -> {
                    System.out.println("\nThank you for using our system!");
                    repeaterFlag = false;
                }
                default -> System.out.println("Invalid input. Choose within the choices.");

            }
        }

    }//end of main

//  METHODS FOR THE OPTIONS -- Dissolves the workload into multiple respective methods for a readable and manageable code.

    public static void addAnimals(int counter) {
        int enclosureNumValid;
        int animalAgeValid;

//      Condition checks if the arrays are full - in case of scenarios that exceeds 50 animal inputs.
        if (counter >= animalNames.length) {
            System.out.println("Zoo is full!");
            return;
        }

        animalNames[counter] = scanString("Enter animal name: ");
        animalSpecies[counter] = scanString("Enter species: ");

        do {
            animalAgeValid = scanInt("Enter animal age: ");

            if (animalAgeValid < 0) {
                System.out.println("Invalid age. Try again.\n");
                continue;
            } else {
                animalAges[counter] = animalAgeValid;
            }
            do {
                enclosureNumValid = scanInt("Enter enclosure number: ");

                if (enclosureNumValid > 4 || enclosureNumValid < 0)
                    System.out.println("Invalid enclosure number! Input numbers from (0 - 4).\n");

                else {
                    animalEnclosureNum[counter] = enclosureNumValid;
                    break;
                }
            } while (true);
            break;

        } while (true);

        System.out.println("\nAnimal added successfully!");

    }//method for adding animals.

    public static void viewAnimals(int counter) {
        
        //Checks if there are values in the database
        if (animalNames[0] == null) {
            System.out.println("No animals in the zoo. Add an animal first.\n");
            return;
        }

        //Displays list of animals 
        System.out.println("List of animals: ");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < counter; i++) {
            System.out.printf("""
                            Name: %s | Species: %s | Age: %d | Enclosure: %d
                            """,
                    animalNames[i], animalSpecies[i], animalAges[i], animalEnclosureNum[i]);

        }
        System.out.println();//Spacing

    }//method for viewing the animals.

    public static void searchAnimals(int counter) {
        boolean isFound = false;

        //Checks if inventory has values
        if (animalNames[0] == null) {
            System.out.println("No animals in the zoo. Add an animal first.\n");
            return;
        }

        System.out.print("Search for animal named: ");
        String targetAnimalName = sc.nextLine();

        //Tranverses the array to find user search input
        for (int i = 0; i < counter; i++) {
            if (targetAnimalName.equalsIgnoreCase(animalNames[i])) {
                //Displays matched search item
                System.out.println("Animal founded!");
                System.out.printf("""
                                Name: %s | Species: %s | Age: %d | Enclosure: %d 
                                """,
                        animalNames[i], animalSpecies[i], animalAges[i], animalEnclosureNum[i]);
                System.out.println();//Spacing
                isFound = true; 
                break;
            }

        }
        if (!isFound)
            System.out.println("No animal named: " + targetAnimalName + "\n");

    }//method for searching an animal by name.

    public static void countAnimals(int counter) {
        String targetSpecie;
        int specieCounter = 0;
        boolean isFound = false;

        //Checks if inventory has values
        if (animalNames[0] == null) {
            System.out.println("No animals in the zoo. Add an animal first.\n");
            return;
        }

        targetSpecie = scanString("Enter species to count: ");

        //Transverses the array to check matched user input in the inventory
        for (int i = 0; i < counter; i++) {
            if (targetSpecie.equalsIgnoreCase(animalSpecies[i])) {
                specieCounter++;
                isFound = true;
            }
        }

        if (!isFound)
            System.out.printf("%s is not found in the zoo.", targetSpecie);
        else
            System.out.printf("%s counter  in the zoo: %d", targetSpecie, specieCounter);

        System.out.println("\n");//Spacing

    }// method for counting animals by species.

    public static void viewAnimalsEnclosure(int counter) {

        //Checks if inventory has values
        if (animalNames[0] == null) {
            System.out.println("No animals in the zoo. Add an animal first.\n");
            return;
        }

        //Checks user input validity
        while (true) {
            int targetEnclosureNum = scanInt("Enter enclosure number (0-4): ");

            if (targetEnclosureNum > 4 || targetEnclosureNum < 0) {
                System.out.println("Invalid enclosure number! Input numbers from (0 - 4).\n");
                continue;
            }

            boolean isFound = false;

            //Tranvers the array to check if enclosure is occupied
            for (int i = 0; i < counter; i++) {
                if (targetEnclosureNum == animalEnclosureNum[i]) {

                    //Displays macthed variable details
                    System.out.printf("""
                                    Name: %s | Species: %s | Age: %d | Enclosure: %d
                                    """,
                            animalNames[i], animalSpecies[i], animalAges[i], animalEnclosureNum[i]);
                    isFound = true;
                }
            }

            if (!isFound) {
                System.out.println("No animals present in enclosure " + targetEnclosureNum);
            }

            System.out.println();//Spacing
            break;

        }


    }// method for viewing animals by enclosure.

//  Exception Handling Methods

    public static int scanInt(String inputPrompt) {
        int numTemp;

        while (true) {
            try {
                System.out.print(inputPrompt);
                numTemp = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input. Try again!\n");
                sc.nextLine();
            }
        }

        return numTemp;
    }//Method dedicated for checking the input validation. (String X - int 0)

    public static String scanString(String inputPrompt) {
        String temp;

        while (true) {
            System.out.print(inputPrompt);
            temp = sc.nextLine();

            if (temp.matches(".*\\d.*")) {
                System.out.println("Input contains numbers. Try again!\n");
            } else if (temp.isEmpty()) {
                System.out.println("Input is blank. Try again!\n");
            } else {
                break;
            }
        }

        return temp;

    }//Method dedicated for checking the String if contains w numbers and if blank.

}//end of class