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

        System.out.println("Welcome to Z-Inventory System!");
        System.out.println("------------------------------");
        System.out.println("""
                1. Add a new animal
                2. View all animals
                3. Search animal by name
                4. Count animals by species
                5. View animals by enclosure
                6. Exit
                """); //Used txt block - cleaner code.

        while (repeaterFlag) {
            userChoice = scanInt("Enter your choice: ");
            sc.nextLine();
            switch (userChoice) {
                case 1:
                    addAnimals(counter);
                    counter++;
                    break;
                case 2:
                    viewAnimals();
                    break;
                case 3:
                    searchAnimals();
                    break;
                case 4:
                    countAnimals();
                    break;
                case 5:
                    viewAnimalsEnclosure();
                    break;
                case 6:
                    System.out.println("\nThank you for using our system!");
                    repeaterFlag = false;
                    break;
                default:
                    System.out.println("Invalid input. Choose within the choices.\n");
                    break;

            }
        }

    }//end of main
//  METHODS FOR THE OPTIONS -- Dissolves the workload into multiple respective methods for a readable and manageable code.

    public static void addAnimals(int counter) {
        int enclosureNumValid;
        int animalAgeValid;

        System.out.print("Enter an animal name: ");
        animalNames[counter] = sc.nextLine();
        System.out.print("Enter species: ");
        animalSpecies[counter] = sc.nextLine();

        do {
            animalAgeValid = scanInt("Enter animal age: ");

            if(animalAgeValid < 0){
                System.out.println("Invalid age. Try again.\n");
                continue;
            }else {
                animalAges[counter] = animalAgeValid;
            }

            enclosureNumValid = scanInt("Enter enclosure number: ");

            if (enclosureNumValid > 4 || enclosureNumValid < 0)
                System.out.println("Invalid enclosure number! Input numbers from (0 - 4).\n");
            else {
                animalEnclosureNum[counter] = enclosureNumValid;
                break;
            }
        }while(true);

        System.out.println("\nAnimal added successfully!\n");

    }//method for adding animal.

    public static void viewAnimals() {
//      DO: Method for viewing the animals...
//      - 2nd to Work on
    }

    public static void searchAnimals() {
//      DO: Method for searching the animals...
//      - 3rd to Work on
    }

    public static void countAnimals() {
//      DO: Method for counting the animals...
//      - 4th to Work on
    }

    public static void viewAnimalsEnclosure() {
//      DO: Method for viewing the animals based on their enclosure...
//      - 5th and Final Work
    }

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
    }//     Method dedicated for checking the input validation. (String X - int 0)

}//end of class