import java.util.Scanner;

public class MasterChief {
    final static String MEAT = "Meat";
    final static String VEGETARIAN = "Vegetarian";
    final static String DESSERT = "Dessert";
    final static String SMALL = "Small";
    final static String MEDIUM_SIZE = "Medium";
    final static String LARGE = "Large";
    final static String RARE = "Rare";
    final static String MEDIUM = "Medium";
    final static String WELL_DONE = "Well done";
    final static String VEGETARIAN_TYPE = "Vegetarian";
    final static String VEGAN_TYPE = "Vegan";
    final static String PESCATERIAN_TYPE= "Pescaterian";
    final static String DESSERT_TYPE = "Cake";
    final static String DESSERT_TYPE2 = "Ice cream";
    final static String STRAWBERRY = "Strawberry";
    final static String BANANA = "Banana";
    final static String VANILLA = "Vanilla";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello, I'm your master chief today and I must ask you some questions!");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("First question: ");
        String firstQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int firstAnswer = sc.nextInt();
        sc.nextLine();
        System.out.print("Second question: ");
        String secondQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int secondAnswer = sc.nextInt();
        sc.nextLine();
        System.out.print("Third question: ");
        String thirdQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int thirdAnswer = sc.nextInt();
        sc.nextLine();
        System.out.print("Fourth question: ");
        String fourthQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int fourthAnswer = sc.nextInt();
        sc.nextLine();
        System.out.print("Fifth question: ");
        String fifthQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int fifthAnswer = sc.nextInt();
        sc.nextLine();
        System.out.print("Sixth question: ");
        String sixthQuestion = sc.nextLine();
        System.out.print("Answer: ");
        String sixthAnswer = sc.nextLine();
        System.out.print("Seventh question: ");
        String seventhQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int seventhAnswer = sc.nextInt();
        sc.nextLine();
        System.out.print("Eighth question: ");
        String eighthQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int eighthAnswer = sc.nextInt();
        sc.nextLine();
        System.out.print("Ninth question: ");
        String ninthQuestion = sc.nextLine();
        System.out.print("Answer: ");
        String ninthAnswer = sc.nextLine();
        System.out.print("Tenth question: ");
        String tenthQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int tenthAnswer = sc.nextInt();
        sc.nextLine();
        System.out.print("Eleventh question: ");
        String eleventhQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int eleventhAnswer = sc.nextInt();
        sc.nextLine();
        System.out.print("Twelveth question: ");
        String twelvethQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int twelvethAnswer = sc.nextInt();
        sc.nextLine();
        System.out.print("Thirteenth question: ");
        String thirteenthQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int thirteenthAnswer = sc.nextInt();
        sc.nextLine();
        System.out.print("Fourteenth question: ");
        String fourteenthQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int fourteenthAnswer = sc.nextInt();
        sc.nextLine();
        System.out.print("Fifteenth question: ");
        String fifteenthQuestion = sc.nextLine();
        System.out.print("Answer: ");
        int fifteenthAnswer = sc.nextInt();
        sc.nextLine();

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Do you want to answer additional questions?");
        System.out.print("Type Y for (Yes) or N for (No): ");
        String type = sc.nextLine();
        if (type.contains("Y")){
            System.out.print("First additional question: ");
            String firstAddQuestion = sc.nextLine();
            System.out.print("Answer: ");
            String firstAddQuestionAnswer = sc.nextLine();
            System.out.print("Second additional question: ");
            String secondAddQuestion = sc.nextLine();
            System.out.print("Answer: ");
            String secondAddQuestionAnswer = sc.nextLine();
            System.out.print("Third additional question: ");
            String thirdAddQuestion = sc.nextLine();
            System.out.print("Answer: ");
            String thirdAddQuestionAnswer = sc.nextLine();
            System.out.print("Fourth additional question: ");
            String fourthAddQuestion = sc.nextLine();
            System.out.print("Answer: ");
            String fourthAddQuestionAnswer = sc.nextLine();
            System.out.print("Fifth additional question: ");
            String fifthAddQuestion = sc.nextLine();
            System.out.print("Answer: ");
            String fifthAddQuestionAnswer = sc.nextLine();
            System.out.println("All answers are questioned or answered.");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("What will you eat?");
            System.out.println("Our menu for today:");
            System.out.println("(1) " + MEAT);
            System.out.println("(2) " + VEGETARIAN);
            System.out.println("(3) " + DESSERT);
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();
            if (choice.equals("Meat")){
                System.out.println("What size do you prefer?");
                System.out.println("(1) " + SMALL);
                System.out.println("(2) " + MEDIUM_SIZE);
                System.out.println("(3) " + LARGE);
                System.out.print("Enter your choice: ");
                String size = sc.nextLine();
                if (size.equals("Small") || size.equals("Medium") || size.equals("Large")) {
                    System.out.println("What kind of baking do you want?");
                    System.out.println("(1) " + RARE);
                    System.out.println("(2) " + MEDIUM);
                    System.out.println("(3) " + WELL_DONE);
                    System.out.print("Enter your choice: ");
                    String chooseBaking = sc.nextLine();
                    if (secondAddQuestionAnswer.contains("N") && fourthAddQuestionAnswer.contains("Y") && (tenthAnswer >= 36 && eleventhAnswer <= 48)
                            && fifthAddQuestionAnswer.contains("Y") && size.contains("S")){
                        System.out.println("Your order has been taken, please wait!");
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("Your order has been successfully placed, thank you for dining with us!");
                    }
                    else if (thirdAddQuestionAnswer.contains("Y") || (seventhAnswer == 5 && eighthAnswer == 5) || size.equals(MEDIUM_SIZE) || sixthAnswer.contains("Иван")) {
                        System.out.println("Your order has been taken, please wait!");
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("Your order has been successfully placed, thank you for dining with us!");
                    }
                    else if ((fifteenthAnswer == 22 || (ninthAnswer.equals("Петър") || ninthAnswer.equals("Радо")))
                            && ((thirdAnswer * fourthAnswer == 45) || (firstAnswer == 3 || secondAnswer == 2))) {
                        System.out.println("Your order has been taken, please wait!");
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("Your order has been successfully placed, thank you for dining with us!");
                    }
                    else {
                        System.out.println("The restaurant cannot fulfill your order, we are starting a self-destruct procedure. Thank you for eating with us!");
                    }
                }
            }
            if (choice.contains("V")) {
                System.out.println("What type do you prefer?");
                System.out.println("(1) " + VEGETARIAN_TYPE);
                System.out.println("(2) " + VEGAN_TYPE);
                System.out.println("(3) " + PESCATERIAN_TYPE);
                System.out.print("Enter your choice: ");
                String chooseVegetarian = sc.nextLine();
                if (thirdAddQuestionAnswer.contains("N") || fourthAddQuestionAnswer.contains("N") || fifthAddQuestionAnswer.contains("N")) {
                    System.out.println("Your order has been taken, please wait!");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Your order has been successfully placed, thank you for dining with us!");
                }
                else if (firstAddQuestionAnswer.contains("Y") && sixthAnswer.equals("Манол") && (seventhAnswer >= 3 || seventhAnswer < 11) && eighthAnswer != 7) {
                    System.out.println("Your order has been taken, please wait!");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Your order has been successfully placed, thank you for dining with us!");
                }
                else if ((fourthAddQuestionAnswer.contains("Y") || type.contains("Y")) && (thirdAnswer * fourthAnswer * fifthAnswer < 13 || (twelvethAnswer + thirteenthAnswer < 158000))) {
                    System.out.println("Your order has been taken, please wait!");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Your order has been successfully placed, thank you for dining with us!");
                }
                else {
                    System.out.println("The restaurant cannot fulfill your order, we are starting a self-destruct procedure. Thank you for eating with us!");
                }
            }
            if (choice.contains("D")) {
                System.out.println("What kind of dessert do you prefer?");
                System.out.println("(1) " + DESSERT_TYPE);
                System.out.println("(2) " + DESSERT_TYPE2);
                System.out.print("Enter your choice: ");
                String chooseDessert = sc.nextLine();
                if (chooseDessert.equals(DESSERT_TYPE) || chooseDessert.equals(DESSERT_TYPE2)) {
                    System.out.println("Are you addicted to sugar?");
                    System.out.print("Type Y for (Yes) or N for (No): ");
                    String addicted = sc.nextLine();
                    if (chooseDessert.equals(DESSERT_TYPE2)) {
                        System.out.println("What kind of ice cream do you want?");
                        System.out.println("(1) " + STRAWBERRY);
                        System.out.println("(2) " + BANANA);
                        System.out.println("(3) " + VANILLA);
                        System.out.print("Enter your choice: ");
                        String chooseIceCream = sc.nextLine();
                        if (addicted.contains("N") || chooseIceCream.equals(STRAWBERRY)) {
                            System.out.println("Your order has been taken, please wait!");
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("Your order has been successfully placed, thank you for dining with us!");
                        }
                    }
                    else if ((firstAddQuestionAnswer.contains("Y") && fifteenthAnswer == 19 && fifthAddQuestionAnswer.contains("N")
                            && (twelvethAnswer >= 15000 || twelvethAnswer <= 50000)) || sixthAnswer.equals("Румен")) {
                        System.out.println("Your order has been taken, please wait!");
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println("Your order has been successfully placed, thank you for dining with us!");
                    }
                }
                else {
                    System.out.println("The restaurant cannot fulfill your order, we are starting a self-destruct procedure. Thank you for eating with us!");
                }
            }
        }
        else if (type.contains("N")) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("All answers are questioned or answered.");
        }
    }
}
