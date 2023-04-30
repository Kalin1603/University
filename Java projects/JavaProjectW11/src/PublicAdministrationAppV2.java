import java.util.Scanner;
import java.util.Random;

public class PublicAdministrationAppV2 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        mainOperation();
    }

    public static void mainOperation(){
        int [] arrayNums = addNumbers();
        while (true){
            addMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    sortNumbersAsc(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 2:
                    sortNumbersDesc(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 3:
                    searchNumber(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 4:
                    shuffleArray(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 5:
                    numbersSum(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 6:
                    largestNumber(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 7:
                    smallestNumber(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 8:
                    averageNumber(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 9:
                    symmetricNumbers(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 10:
                    arrayReverseNumbers(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 11:
                    printNumbers(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 12:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number from the menu!");
                    break;
            }
        }
    }

    public static int[] addNumbers(){
        System.out.print("How many numbers do you want: ");
        int numbersCount = sc.nextInt();
        int [] arrayNums = new int[numbersCount];

        for(int i = 0; i < numbersCount; i++){
            System.out.print("Enter number: ");
            int number = sc.nextInt();

            while (number < -100 || number > 100){
                System.out.println("Number out of range! Please enter a number between -100 and 100!");
                System.out.print("Enter number: ");
                number = sc.nextInt();
            }
            arrayNums[i] = number;
        }
        return arrayNums;
    }

    public static void addMenu(){
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(1) Sort the entered numbers in ascending order");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(2) Sort the entered numbers in descending order");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(3) Search for the position of a specific number");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(4) Shuffle the numbers");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(5) Calculating the sum of all numbers");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(6) Finding the largest number");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(7) Finding the smallest number");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(8) Finding the arithmetic mean of numbers");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(9) Check for symmetry of the array of numbers");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(10) Reverse the array of numbers");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(11) Visualize the entered numbers");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(12) Exit");
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static int getUserChoice() {
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        return choice;
    }

    public static int linearSearch(int[] arrayNums, int numberToFind) {

        for (int index = 0; index < arrayNums.length; index++) {
            if (arrayNums[index] == numberToFind) {
                return index;
            }
        }

        return -1;
    }


    public static void sortNumbersAsc(int[] arrayNums) {
        int temp;

        for (int i = 0; i < arrayNums.length; i++) {
            for (int j = arrayNums.length - 1; j > i ; j--) {
                if (arrayNums[j-1] > arrayNums[j]) {
                    temp = arrayNums[j-1];
                    arrayNums[j-1] = arrayNums[j];
                    arrayNums[j] = temp;
                }
            }
        }
        System.out.print("Ascending numbers in the array: ");
        for (int i = 0; i < arrayNums.length; i++) {
            System.out.print(arrayNums[i] + " ");
        }
        System.out.println();
    }

    public static void sortNumbersDesc(int[] arrayNums) {
        int temp;

        for (int i = 0; i < arrayNums.length; i++) {
            for (int j = arrayNums.length - 1; j > i ; j--) {
                if (arrayNums[j-1] < arrayNums[j]) {
                    temp = arrayNums[j-1];
                    arrayNums[j-1] = arrayNums[j];
                    arrayNums[j] = temp;
                }
            }
        }
        System.out.print("Descending numbers in the array: ");
        for (int i = 0; i < arrayNums.length; i++) {
            System.out.print(arrayNums[i] + " ");
        }
        System.out.println();
    }

    public static void searchNumber(int[] numbers) {
        System.out.print("Enter element that you want to search for: " );
        int numberToFind = sc.nextInt();
        int numberToFindIndex = linearSearch(numbers, numberToFind);

        if (numberToFindIndex == -1) {
            System.out.println("The number is not found in the array! \n");
        }
        else {
            System.out.printf(
                    "The number: %d is on index: %d, and on position: %d \n",
                    numberToFind, numberToFindIndex, numberToFindIndex + 1
            );
        }
    }

    public static void numbersSum(int [] arrayNums){
        int sum = 0;
        for(int i = 0; i < arrayNums.length; i++){
                sum += arrayNums[i];
        }
        System.out.println("The sum of the numbers in the array: " + sum);
    }

    public static void shuffleArray(int[] arrayNums) {
        Random random = new Random();
        for (int i = arrayNums.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = arrayNums[i];
            arrayNums[i] = arrayNums[j];
            arrayNums[j] = temp;
        }
        System.out.print("Shuffled numbers in array: ");
        for (int num : arrayNums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void largestNumber(int[] arrayNums) {
        int max = arrayNums[0];
        for (int i = 1; i < arrayNums.length; i++) {
            if (arrayNums[i] > max) {
                max = arrayNums[i];
            }
        }
        System.out.println("The largest number in the array: " + max);
    }

    public static void smallestNumber(int[] arrayNums) {
        int min = arrayNums[0];
        for (int i = 1; i < arrayNums.length; i++) {
            if (arrayNums[i] < min) {
                min = arrayNums[i];
            }
        }
        System.out.println("The smallest number in the array: " + min);
    }

    public static void averageNumber(int[] arrayNums){
        double averageValue = 0;
        for (int i = 0; i < arrayNums.length; i++) {
            averageValue += arrayNums[i];
        }
        averageValue /= arrayNums.length;

        System.out.println("The average of the numbers entered: " + averageValue);
    }


    public static void symmetricNumbers(int[] arrayNums) {
        boolean isSymmetric = true;

        for (int i = 0; i < arrayNums.length/2; i++) {
            if (arrayNums[i] != arrayNums[arrayNums.length-i-1]) {
                isSymmetric = false;
                break;
            }
        }

        if (isSymmetric) {
            System.out.println("The array is symmetric");
        } else {
            System.out.println("The array is not symmetric");
        }
    }

    public static void arrayReverseNumbers(int[] arrayNums) {
        int left = 0, right = arrayNums.length - 1;
        while (left < right) {
            int temp = arrayNums[left];
            arrayNums[left] = arrayNums[right];
            arrayNums[right] = temp;
            left++;
            right--;
        }
        System.out.print("Reversed array: ");
        for (int num : arrayNums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printNumbers(int [] arrayNums){
        System.out.print("Numbers in the array: ");
        for (int i = 0; i < arrayNums.length; i++) {
            System.out.print(arrayNums[i] + "; ");
        }
        System.out.println();
    }

    public static void returnToMenu() {
        System.out.print("Type (Return) to return to the main menu: ");
        String returnOption = sc.nextLine();
        while (!returnOption.equals("Return")) {
            System.out.print("Type (Return) to return to the main menu: ");
            returnOption = sc.nextLine();
        }
    }
}
