import java.util.Scanner;

public class PublicAdministrationApp {
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
                    countPositiveNumbers(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 2:
                    countNegativeNumbers(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 3:
                    positiveNumbersSum(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 4:
                    negativeNumbersSum(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 5:
                    getSecondLargeNumber(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 6:
                    maxDiffNumber(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 7:
                    absoluteValuesSum(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 8:
                    multiplesOfThreeNumbersSum(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 9:
                    sumOfAdjacentElements(arrayNums);
                    System.out.println("--------------------------------------------------------------------------------------");
                    sc.nextLine();
                    returnToMenu();
                    break;
                case 10:
                    modeOfNumbers(arrayNums);
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
        System.out.println("(1) Derivation of the positive numbers, as well as their count");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(2) Derivation of the negative numbers, as well as their count");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(3) Derivation of the sum of the positive numbers");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(4) Derivation of the sum of the negative numbers");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(5) Output of the second largest number");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(6) Output the number that is maximally different from the mean of the numbers entered");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(7) Output the sum of the absolute value of the entered numbers");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(8) Output the sum of all numbers that are multiples of 3 but greater than 15");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(9) Output the sums of any two adjacent elements");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("(10) Deriving the mode of numbers");
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

    public static void countPositiveNumbers(int[] arrayNums) {
        int count = 0;
        System.out.print("Positive numbers in the array: ");
        for (int i = 0; i < arrayNums.length; i++) {
            if (arrayNums[i] > 0) {
                System.out.print(arrayNums[i] + "; ");
                count++;
            }
        }
        System.out.println("\nCount of positive numbers: " + count);
    }

    public static void countNegativeNumbers(int[] arrayNums) {
        int count = 0;
        System.out.print("Negative numbers in the array: ");
        for (int i = 0; i < arrayNums.length; i++) {
            if (arrayNums[i] < 0) {
                System.out.print(arrayNums[i] + "; ");
                count++;
            }
        }
        System.out.println("\nCount of negative numbers: " + count);
    }

    public static void positiveNumbersSum(int [] arrayNums){
        int sum = 0;
        for(int i = 0; i < arrayNums.length; i++){
            if (arrayNums[i] > 0) {
                sum += arrayNums[i];
            }
        }
        System.out.println("The sum of the positive numbers in the array: " + sum);
    }

    public static void negativeNumbersSum(int [] arrayNums){
        int sum = 0;
        for(int i = 0; i < arrayNums.length; i++){
            if (arrayNums[i] < 0) {
                sum += arrayNums[i];
            }
        }
        System.out.println("The sum of the negative numbers in the array: " + sum);
    }

    public static void getSecondLargeNumber(int [] arrayNums){
        int first = arrayNums[0];
        int second = arrayNums[0];
        for (int i = 1; i < arrayNums.length; i++) {
            if (arrayNums[i] > first) {
                second = first;
                first = arrayNums[i];
            } else if (arrayNums[i] > second && arrayNums[i] != first) {
                second = arrayNums[i];
            }
        }
        System.out.println("The second largest number in the array: " + second);
    }

    public static void maxDiffNumber(int[] arrayNums){
        double averageValue = 0;
        for (int i = 0; i < arrayNums.length; i++) {
            averageValue += arrayNums[i];
        }
        averageValue /= arrayNums.length;

        double maxDiff = Double.MIN_VALUE;
        double maxDiffNum = arrayNums[0];
        for (int i = 0; i < arrayNums.length; i++) {
            double diff = Math.abs(arrayNums[i] - averageValue);
            if (diff > maxDiff) {
                maxDiff = diff;
                maxDiffNum = arrayNums[i];
            }
        }
        System.out.println("Maximally different from the mean of the numbers entered: " + maxDiffNum);
    }

    public static void absoluteValuesSum(int [] arrayNums){
        double sum = 0;
        for (int i = 0; i < arrayNums.length; i++) {
            sum += Math.abs(arrayNums[i]);
        }
        System.out.println("The sum of the absolute values of the numbers in the array: " + sum);
    }

    public static void multiplesOfThreeNumbersSum(int [] arrayNums){
        int sum = 0;
        for (int num : arrayNums) {
            if (num > 15 && num % 3 == 0) {
                sum += num;
            }
        }
        System.out.println("The sum of all numbers that are multiples of 3 but greater than 15: " + sum);
    }

    public static void sumOfAdjacentElements(int [] arrayNums){
        for (int i = 0; i < arrayNums.length - 1; i++) {
            int sum = arrayNums[i] + arrayNums[i+1];
            System.out.println("Sum of " + arrayNums[i] + " and " + arrayNums[i+1] + " is " + sum);
        }
    }

    public static void modeOfNumbers(int [] arrayNums){
        int mode = arrayNums[0];
        int maxCount = 0;

        for (int i = 0; i < arrayNums.length; i++) {
            int count = 0;

            for (int j = 0; j < arrayNums.length; j++) {
                if (arrayNums[j] == arrayNums[i]) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                mode = arrayNums[i];
            }
        }
        System.out.println("The mode of the numbers in the array: " + mode);
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
