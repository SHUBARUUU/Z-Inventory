import java.util.Scanner;

public class Main {
    //  Global Variables
    final int fixed_Size = 50;
    static Scanner sc = new Scanner(System.in);
    int[] animals = new int[fixed_Size];

    public static void main(String[] args) {
        //Instantiation.
        Main main = new Main();
        //Variables.
        int userChoice;
        boolean repeaterFlag = true;

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
            userChoice = main.scanInt("Enter your choice: ");

            switch (userChoice) {
                case 1:
                    main.addAnimals();
                    break;
                case 2:
                    main.viewAnimals();
                    break;
                case 3:
                    main.searchAnimals();
                    break;
                case 4:
                    main.countAnimals();
                    break;
                case 5:
                    main.viewAnimalsEnclosure();
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

    public void addAnimals() {
//       DO: Method for adding the animals...
//       - Focus on adding the animals and adding the counters for them
//       - Accounts their names, age, species, enclosure num...

    }//method for adding animal.

    public void viewAnimals() {
//      DO: Method for viewing the animals...
//      - 2nd to Work on
    }

    public void searchAnimals() {
//      DO: Method for searching the animals...
//      - 3rd to Work on
    }

    public void countAnimals() {
//      DO: Method for counting the animals...
//      - 4th to Work on
    }

    public void viewAnimalsEnclosure() {
//      DO: Method for viewing the animals based on their enclosure...
//      - 5th and Final Work
    }

    //  Exception Handling Methods
    public int scanInt(String inputPrompt) {
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