import java.util.Scanner;

public class Main {
    //  Global Variables
    static Scanner sc = new Scanner(System.in);
    int[] animals = new int[50];

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

    public void addAnimals() {

    }//method for adding animal.

    public void viewAnimals() {

    }

    public void searchAnimals() {

    }

    public void countAnimals() {

    }

    public void viewAnimalsEnclosure() {

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
    }

}//end of class