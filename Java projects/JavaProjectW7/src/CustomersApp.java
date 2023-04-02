import java.util.Random;
import java.util.Scanner;

public class CustomersApp {
    final static int CURRENT_YEAR = 2023;
    final static int FRUITS_AND_VEGETABLES = 1;
    final static int MEAT = 2;
    final static int CIGARETTES_AND_ALCOHOL = 3;
    final static int DAIRY_PRODUCTS = 4;
    final static int SWEETS = 5;
    final static int RARELY = 1;
    final static int SOMETIMES = 2;
    final static int OFTEN = 3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random generator = new Random();
        int firstNum;

        System.out.print("Enter your year of born: ");
        int yearOfBorn = sc.nextInt();

        if (yearOfBorn < 1965){
            int year = CURRENT_YEAR - yearOfBorn;
            int firstRandomNum = generator.nextInt(8);
            System.out.println("Your first random generated number is: " + firstRandomNum);
            int firstRandomNumberResult = firstRandomNum % 2 == 0 ? firstRandomNum + 1 : firstRandomNum;
            firstNum = year / firstRandomNumberResult;
        }
        else if (yearOfBorn > 1965) {
            int year = CURRENT_YEAR - yearOfBorn;
            int firstRandomNum = generator.nextInt(8);
            System.out.println("Your first random generated number is: " + firstRandomNum);
            int firstRandomNumberResult = firstRandomNum % 2 == 1 ? firstRandomNum + 1 : firstRandomNum;
            firstNum = year / firstRandomNumberResult;
        }
        else {
            firstNum = 0;
        }
        if (firstNum >= 10 && firstNum <= 99) {
            System.out.println("First number is: " + firstNum / 10);
        }
        else if (firstNum >= 100 && firstNum <= 999) {
            System.out.println("First number is: " + firstNum / 100);
        }
        else {
            System.out.println("First number is: " + firstNum);
        }

        System.out.println("-------------------------------------------");

        int secondNum = 0;
        sc.nextLine();
        if (firstNum != 0) {
            System.out.print("What is your gender? Type Male or Female: ");
            String gender = sc.nextLine();
            if (gender.equals("Male")) {
                secondNum = 1;
                System.out.println("Second number is: " + secondNum);
            }
            else if (gender.equals("Female")) {
                secondNum = 3;
                System.out.println("Second number is: " + secondNum);
            }
            else {
                int secondRandomNum = generator.nextInt(10);
                System.out.println("Second number is: " + secondRandomNum);
            }
        }
        else {
            secondNum = 9;
            System.out.println("Second number is: " + secondNum);
        }

        System.out.println("-------------------------------------------");

        int thirdNum;
        System.out.print("Are you of legal age? Type Yes or No: ");
        String legalAge = sc.nextLine();
        if (legalAge.equals("No")) {
            System.out.print("Enter your mother's year of birth: ");
            int motherBirth = sc.nextInt();
            System.out.print("Enter your father's year of birth: ");
            int fatherBirth = sc.nextInt();
            if (motherBirth > fatherBirth) {
                thirdNum = 1;
                System.out.println("Third number is: " + thirdNum);
            }
            else if (motherBirth < fatherBirth) {
                thirdNum = 2;
                System.out.println("Third number is: " + thirdNum);
            }
            else {
                thirdNum = 3;
                System.out.println("Third number is: " + thirdNum);
            }
        }
        else {
            thirdNum = 0;
            System.out.println("Third number is: " + thirdNum);
        }

        System.out.println("-------------------------------------------");

        int fourthNum;
        int heightSquare = 2;
        System.out.print("Enter your height in cm: ");
        double height = sc.nextDouble();
        System.out.print("Enter your weight in kg: ");
        double weight = sc.nextDouble();
        double bodyMassIndex = weight / (Math.pow(height,heightSquare));
        System.out.printf("Your body mass index is: %.2f \n", bodyMassIndex);
        if (bodyMassIndex < 16.00) {
            System.out.println("You are below normal.");
            fourthNum = 1;
            System.out.println("Fourth number is: " + fourthNum);
        }
        else if (bodyMassIndex >= 16.00 && bodyMassIndex <= 16.99) {
            System.out.println("You are normal.");
            fourthNum = 2;
            System.out.println("Fourth number is: " + fourthNum);
        }
        else if (bodyMassIndex >= 17.00 && bodyMassIndex <= 18.49) {
            System.out.println("You are normal - athletic.");
            fourthNum = 3;
            System.out.println("Fourth number is: " + fourthNum);
        }
        else if (bodyMassIndex >= 18.50 && bodyMassIndex <= 24.99) {
            System.out.println("You are normal.");
            fourthNum = 4;
            System.out.println("Fourth number is: " + fourthNum);
        }
        else if (bodyMassIndex >= 25.00 && bodyMassIndex <= 29.99) {
            System.out.println("You are before excessive.");
            fourthNum = 5;
            System.out.println("Fourth number is: " + fourthNum);
        }
        else if (bodyMassIndex >= 30.00 && bodyMassIndex <= 34.99) {
            System.out.println("You are excessively fat.");
            fourthNum = 6;
            System.out.println("Fourth number is: " + fourthNum);
        }
        else if (bodyMassIndex >= 35.00 && bodyMassIndex <= 39.99) {
            System.out.println("You are morbidly obese.");
            fourthNum = 7;
            System.out.println("Fourth number is: " + fourthNum);
        }
        else {
            System.out.println("You are super mega obese.");
            fourthNum = 8;
            System.out.println("Fourth number is: " + fourthNum);
        }

        System.out.println("-------------------------------------------");

        int fifthNum = 0;
        sc.nextLine();
        System.out.println("Choose one from the type of goods.");
        System.out.println("(1) Fruits and vegetables");
        System.out.println("(2) Meat");
        System.out.println("(3) Cigarettes and alcohol");
        System.out.println("(4) Dairy products");
        System.out.println("(5) Sweets");
        System.out.print("Enter number: ");
        String type = sc.nextLine();
        System.out.println("How often do you buy it?");
        System.out.println("(1) Rarely");
        System.out.println("(2) Sometimes");
        System.out.println("(3) Often");
        System.out.print("Enter number: ");
        String frequency = sc.nextLine();
        if (type.equals("1") && frequency.equals("1")) {
            fifthNum = FRUITS_AND_VEGETABLES + RARELY;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("1") && frequency.equals("2")) {
            fifthNum = FRUITS_AND_VEGETABLES + SOMETIMES;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("1") && frequency.equals("3")){
            fifthNum = FRUITS_AND_VEGETABLES + OFTEN;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("2") && frequency.equals("1")) {
            fifthNum = MEAT + RARELY;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("2") && frequency.equals("2")) {
            fifthNum = MEAT + SOMETIMES;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("2") && frequency.equals("3")) {
            fifthNum = MEAT + OFTEN;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("3") && frequency.equals("1")) {
            fifthNum = CIGARETTES_AND_ALCOHOL + RARELY;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("3") && frequency.equals("2")) {
            fifthNum = CIGARETTES_AND_ALCOHOL + SOMETIMES;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("3") && frequency.equals("3")) {
            fifthNum = CIGARETTES_AND_ALCOHOL + OFTEN;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("4") && frequency.equals("1")) {
            fifthNum = DAIRY_PRODUCTS + RARELY;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("4") && frequency.equals("2")) {
            fifthNum = DAIRY_PRODUCTS + SOMETIMES;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("4") && frequency.equals("3")) {
            fifthNum = DAIRY_PRODUCTS + OFTEN;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("5") && frequency.equals("1")) {
            fifthNum = SWEETS + RARELY;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("5") && frequency.equals("2")) {
            fifthNum = SWEETS + SOMETIMES;
            System.out.println("Fifth number is: " + fifthNum);
        }
        else if (type.equals("5") && frequency.equals("3")) {
            fifthNum = SWEETS + OFTEN;
            System.out.println("Fifth number is: " + fifthNum);
        }

        System.out.println("-------------------------------------------");

        int sixthNum = 0;
        int sumNum = firstNum + secondNum + thirdNum + fourthNum + fifthNum;
        if (sumNum < 10) {
            sixthNum = sumNum;
            System.out.println("Sixth number is: " + sixthNum);
        }
        else if(sumNum >= 10 && sumNum <= 99) {
            int firstSumNum = sumNum / 10;
            int secondSumNum = sumNum % 10;
            int sum = firstSumNum + secondSumNum;
            System.out.println("Sixth number is: " + sum);
        }
        else {
            int firstSumNum = sumNum / 10;
            int secondSumNum = sumNum % 10;
            int sum = firstSumNum + secondSumNum;
            System.out.println("Sixth number is: " + sum);
        }

        System.out.println("-------------------------------------------");

        int seventhNum;
        if (firstNum % 2 == 0 && thirdNum % 2 == 0 && fifthNum % 2 == 0) {
            seventhNum = 0;
            System.out.println("Seventh number is: " + seventhNum);
        }
        else if(firstNum % 2 == 1 && thirdNum % 2 == 1 && fifthNum % 2 == 1){
            seventhNum = 1;
            System.out.println("Seventh number is: " + seventhNum);
        }
        else if((firstNum % 2 == 0) || (thirdNum % 2 == 0) || (fifthNum % 2 == 0)){
            seventhNum = 2;
            System.out.println("Seventh number is: " + seventhNum);
        }
        else if((firstNum % 2 == 0 && secondNum % 2 == 0) || (thirdNum % 2 == 1 && fourthNum % 2 == 1 && fifthNum % 2 == 1)){
            seventhNum = 3;
            System.out.println("Seventh number is: " + seventhNum);
        }
        else if (firstNum == secondNum && thirdNum == fourthNum && fifthNum == sixthNum) {
            seventhNum = 4;
            System.out.println("Seventh number is: " + seventhNum);
        }
        else if(firstNum < secondNum && thirdNum < fourthNum && fifthNum < sixthNum){
            seventhNum = 5;
            System.out.println("Seventh number is: " + seventhNum);
        }
        else if((firstNum + secondNum + thirdNum + fourthNum + fifthNum + sixthNum) < 10){
            seventhNum = 6;
            System.out.println("Seventh number is: " + seventhNum);
        }
        else if((firstNum + secondNum + thirdNum + fourthNum + fifthNum + sixthNum) > 10){
            seventhNum = 7;
            System.out.println("Seventh number is: " + seventhNum);
        }
        else {
            seventhNum = 9;
            System.out.println("Seventh number is: " + seventhNum);
        }

        System.out.println("-------------------------------------------");

        int eighthNum = 0;
        if (legalAge.equals("Yes") && ((bodyMassIndex >= 30.00 && bodyMassIndex <= 34.99) || (bodyMassIndex >= 35.00 && bodyMassIndex <= 39.99)
                || (bodyMassIndex >= 40)) && (type.equals("5") && frequency.equals("3"))) {
            int eightFirstRandomNum = generator.nextInt(10);
            System.out.println("Your first-eight random generated number is: " + eightFirstRandomNum);
            if (eightFirstRandomNum % 2 == 1) {
                eighthNum = eightFirstRandomNum;
                System.out.println("Eighth number is: " + eighthNum);
            }
            else {
                eighthNum = 0;
                System.out.println("Eighth number is: " + eighthNum);
            }
        }
        else if(legalAge.equals("No") && (bodyMassIndex >= 17.00 && bodyMassIndex <= 18.49) && (type.equals("1") && frequency.equals("1"))){
            int eightSecondRandomNum = generator.nextInt(10);
            System.out.println("Your second-eight random generated number is: " + eightSecondRandomNum);
            if (eightSecondRandomNum % 2 == 0) {
                eighthNum = eightSecondRandomNum;
                System.out.println("Eighth number is: " + eighthNum);
            }
            else {
                eighthNum = 0;
                System.out.println("Eighth number is: " + eighthNum);
            }
        }
        else {
            eighthNum = 0;
            System.out.println("Eighth number is: " + eighthNum);
        }

        System.out.println("-------------------------------------------");

        String symbolFirstNum = "";

        switch (firstNum) {
            case 0:
                symbolFirstNum = "*";
                break;
            case 1:
                symbolFirstNum = "!";
                break;
            case 2:
                symbolFirstNum = "@";
                break;
            case 3:
                symbolFirstNum = "#";
                break;
            case 4:
                symbolFirstNum = "$";
                break;
            case 5:
                symbolFirstNum = "%";
                break;
            case 6:
                symbolFirstNum = "^";
                break;
            case 7:
                symbolFirstNum = "&";
                break;
            case 8:
                symbolFirstNum = "/";
                break;
            case 9:
                symbolFirstNum = "+";
                break;
            default:
                symbolFirstNum = "Unknown";

        }

        String symbolSecondNum = "";
        switch (secondNum) {
            case 0:
                symbolSecondNum = "*";
                break;
            case 1:
                symbolSecondNum = "!";
                break;
            case 2:
                symbolSecondNum = "@";
                break;
            case 3:
                symbolSecondNum = "#";
                break;
            case 4:
                symbolSecondNum = "$";
                break;
            case 5:
                symbolSecondNum = "%";
                break;
            case 6:
                symbolSecondNum = "^";
                break;
            case 7:
                symbolSecondNum = "&";
                break;
            case 8:
                symbolSecondNum = "/";
                break;
            case 9:
                symbolSecondNum = "+";
                break;
            default:
                symbolSecondNum = "Unknown";
        }

        String symbolThirdNum = "";
        switch (thirdNum) {
            case 0:
                symbolThirdNum = "*";
                break;
            case 1:
                symbolThirdNum = "!";
                break;
            case 2:
                symbolThirdNum = "@";
                break;
            case 3:
                symbolThirdNum = "#";
                break;
            case 4:
                symbolThirdNum = "$";
                break;
            case 5:
                symbolThirdNum = "%";
                break;
            case 6:
                symbolThirdNum = "^";
                break;
            case 7:
                symbolThirdNum = "&";
                break;
            case 8:
                symbolThirdNum = "/";
                break;
            case 9:
                symbolThirdNum = "+";
                break;
            default:
                symbolThirdNum = "Unknown";
        }

        String symbolFourthNum = "";
        switch (fourthNum) {
            case 0:
                symbolFourthNum = "*";
                break;
            case 1:
                symbolFourthNum = "!";
                break;
            case 2:
                symbolFourthNum = "@";
                break;
            case 3:
                symbolFourthNum = "#";
                break;
            case 4:
                symbolFourthNum = "$";
                break;
            case 5:
                symbolFourthNum = "%";
                break;
            case 6:
                symbolFourthNum = "^";
                break;
            case 7:
                symbolFourthNum = "&";
                break;
            case 8:
                symbolFourthNum = "/";
                break;
            case 9:
                symbolFourthNum = "+";
                break;
            default:
                symbolFourthNum = "Unknown";
        }

        String symbolFifthNum = "";
        switch (fifthNum) {
            case 0:
                symbolFifthNum = "*";
                break;
            case 1:
                symbolFifthNum = "!";
                break;
            case 2:
                symbolFifthNum = "@";
                break;
            case 3:
                symbolFifthNum = "#";
                break;
            case 4:
                symbolFifthNum = "$";
                break;
            case 5:
                symbolFifthNum = "%";
                break;
            case 6:
                symbolFifthNum = "^";
                break;
            case 7:
                symbolFifthNum = "&";
                break;
            case 8:
                symbolFifthNum = "/";
                break;
            case 9:
                symbolFifthNum = "+";
                break;
            default:
                symbolFifthNum = "Unknown";
        }

        String symbolSixthNum = "";
        switch (sixthNum) {
            case 0:
                symbolSixthNum = "*";
                break;
            case 1:
                symbolSixthNum = "!";
                break;
            case 2:
                symbolSixthNum = "@";
                break;
            case 3:
                symbolSixthNum = "#";
                break;
            case 4:
                symbolSixthNum = "$";
                break;
            case 5:
                symbolSixthNum = "%";
                break;
            case 6:
                symbolSixthNum = "^";
                break;
            case 7:
                symbolSixthNum = "&";
                break;
            case 8:
                symbolSixthNum = "/";
                break;
            case 9:
                symbolSixthNum = "+";
                break;
            default:
                symbolSixthNum = "Unknown";
        }

        String symbolSeventhNum = "";
        switch (seventhNum) {
            case 0:
                symbolSeventhNum = "*";
                break;
            case 1:
                symbolSeventhNum = "!";
                break;
            case 2:
                symbolSeventhNum = "@";
                break;
            case 3:
                symbolSeventhNum = "#";
                break;
            case 4:
                symbolSeventhNum = "$";
                break;
            case 5:
                symbolSeventhNum = "%";
                break;
            case 6:
                symbolSeventhNum = "^";
                break;
            case 7:
                symbolSeventhNum = "&";
                break;
            case 8:
                symbolSeventhNum = "/";
                break;
            case 9:
                symbolSeventhNum = "+";
                break;
            default:
                symbolSeventhNum = "Unknown";
        }

        String symbolEighthNum = "";
        switch (eighthNum) {
            case 0:
                symbolEighthNum = "*";
                break;
            case 1:
                symbolEighthNum = "!";
                break;
            case 2:
                symbolEighthNum = "@";
                break;
            case 3:
                symbolEighthNum = "#";
                break;
            case 4:
                symbolEighthNum = "$";
                break;
            case 5:
                symbolEighthNum = "%";
                break;
            case 6:
                symbolEighthNum = "^";
                break;
            case 7:
                symbolEighthNum = "&";
                break;
            case 8:
                symbolEighthNum = "/";
                break;
            case 9:
                symbolEighthNum = "+";
                break;
            default:
                symbolEighthNum = "Unknown";
        }
        System.out.println("Your barcode is: ");
        System.out.println(symbolFirstNum);
        System.out.println(symbolSecondNum);
        System.out.println(symbolThirdNum);
        System.out.println(symbolFourthNum);
        System.out.println(symbolFifthNum);
        System.out.println(symbolSixthNum);
        System.out.println(symbolSeventhNum);
        System.out.println(symbolEighthNum);

        System.out.println("-------------------------------------------");
    }
}
