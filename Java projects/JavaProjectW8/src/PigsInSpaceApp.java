import java.util.Random;
import java.util.Scanner;

public class PigsInSpaceApp {
    final static String FIRST_ROBOT_HAND = "A";
    final static String SECOND_ROBOT_HAND = "B";
    final static String THIRD_ROBOT_HAND = "C";
    public static void main(String[] args) {
        int OXYGEN = 168;
        int FUEL = 90;
        Scanner sc = new Scanner(System.in);
        Random generator = new Random();

        System.out.print("How many holes do you want to fill? Answer: ");
        int holesNum = sc.nextInt();
        sc.nextLine();
        System.out.println("----------------------------------------------------------------------------");

        for(int i = 1; i <= holesNum; i++){
            int coordinateX = generator.nextInt(50);
            int coordinateY = generator.nextInt(50);
            System.out.println("Hole " + i + " is with coordinates X - " + coordinateX + " and Y - " + coordinateY);
            System.out.println("----------------------------------------------------------------------------");
            while(true){
                System.out.print("Enter command to activate the operative aggregate: ");
                String turnOn = sc.nextLine();

                if (turnOn.equals("turnon")) {
                    System.out.println("The system us turned on.");

                    while (true){
                        System.out.print("Enter command to activate robot hand: ");
                        String load = sc.nextLine();

                        if (load.equals("load")) {
                            System.out.print("Enter which one you want (A, B or C): ");
                            String enterHandToLoad = sc.nextLine();
                            if (enterHandToLoad.equals(FIRST_ROBOT_HAND) || enterHandToLoad.equals(SECOND_ROBOT_HAND) || enterHandToLoad.equals(THIRD_ROBOT_HAND)) {
                                System.out.println("Your robot hand " + enterHandToLoad + " is activated.");
                                FUEL --;
                                System.out.println("You have " + FUEL + " fuel left.");

                                System.out.print("Do you want to add second robot hand? Type yes or no: ");
                                String answer = sc.nextLine();
                                if (answer.equals("yes")) {
                                    System.out.print("Type unload: ");
                                    String unloadHand = sc.nextLine();

                                    if (unloadHand.equals("unload")) {
                                        System.out.println("Your robot hand " + enterHandToLoad + " is deactivated.");
                                        continue;
                                    }
                                }
                                else {
                                    while(true){
                                        System.out.print("Type moveX: ");
                                        String moveX = sc.nextLine();
                                        if (moveX.equals("moveX")) {
                                            System.out.print("Type position (left, right, up, down): ");
                                            String positionX = sc.nextLine();
                                            if (positionX.equals("left") || positionX.equals("right") || positionX.equals("up") || positionX.equals("down")) {
                                                System.out.print("Type position number: ");
                                                int positionNumX = sc.nextInt();
                                                int oxygenConsumedX = positionNumX - 1;
                                                System.out.println("Your consumed oxygen is: " + oxygenConsumedX);
                                                OXYGEN -= oxygenConsumedX;
                                                System.out.println("You have " + OXYGEN + " oxygen left.");

                                                sc.nextLine();

                                                while (true){
                                                    System.out.print("Type moveY: ");
                                                    String moveY = sc.nextLine();
                                                    if (moveY.equals("moveY")) {
                                                        System.out.print("Type position (left, right, up, down): ");
                                                        String positionY = sc.nextLine();
                                                        if (positionY.equals("left") || positionY.equals("right") || positionY.equals("up") || positionY.equals("down")) {
                                                            System.out.print("Type position number: ");
                                                            int positionNumY = sc.nextInt();
                                                            int oxygenConsumedY = positionNumY - 1;
                                                            System.out.println("Your consumed oxygen is: " + oxygenConsumedY);
                                                            OXYGEN -= oxygenConsumedY;
                                                            System.out.println("You have " + OXYGEN + " oxygen left.");

                                                            sc.nextLine();

                                                            while (true) {
                                                                System.out.print("Type identify: ");
                                                                String identify = sc.nextLine();
                                                                if (identify.equals("identify")) {
                                                                    int randomNum = generator.nextInt(5);
                                                                    System.out.println("Your random generated number is: " + randomNum);
                                                                    System.out.println("The hole has been identified!");


                                                                    System.out.print("Type cut: ");
                                                                    String cut = sc.nextLine();
                                                                    if (cut.equals("cut")) {
                                                                        int randomNumCut = generator.nextInt(20);
                                                                        while (true){
                                                                            System.out.println("(For fast answering) The number is: " + randomNumCut);
                                                                            System.out.print("I have generated random number from 1 - 20, you must guess it, so I can cut the hole. Your answer: ");
                                                                            int answerCut = sc.nextInt();
                                                                            if (randomNumCut == answerCut) {
                                                                                System.out.println("Command cut is successful!");

                                                                                sc.nextLine();

                                                                                System.out.print("Type fill: ");
                                                                                String fill = sc.nextLine();
                                                                                if (fill.equals("fill")) {
                                                                                    int randomNumFill = generator.nextInt(20);
                                                                                    while (true) {
                                                                                        int resultNum = randomNumFill + randomNumCut;
                                                                                        System.out.println("(For fast answering) The number is: " + resultNum);
                                                                                        System.out.print("I have generated random number from 1 - 20 and I sum it with " + randomNumCut + ", you must guess it, so I can cut the hole. Your answer: ");
                                                                                        int answerFill = sc.nextInt();
                                                                                        if (resultNum == answerFill) {
                                                                                            System.out.println("Command fill is successful!");

                                                                                            sc.nextLine();

                                                                                            System.out.print("Type finish: ");
                                                                                            String finish = sc.nextLine();
                                                                                            if (finish.equals("finish")) {
                                                                                                System.out.println("The hole with coordinates " + positionNumX + " and " + positionNumY + " is completed!");

                                                                                                System.out.print("Type status: ");
                                                                                                String status = sc.nextLine();
                                                                                                if (status.equals("status")) {
                                                                                                    System.out.println("----------------------------------------------------------------------------");
                                                                                                    System.out.println("Fuel left: " + FUEL);
                                                                                                    System.out.println("Oxygen left: " + OXYGEN);
                                                                                                    System.out.println("Holes completed: " + i);
                                                                                                    System.out.println("----------------------------------------------------------------------------");

                                                                                                    if (holesNum == i) {
                                                                                                        System.out.println("The mission is completed!");
                                                                                                    }
                                                                                                    else if (FUEL == 0) {
                                                                                                        System.out.println("No fuel in the tank, please fill up!");
                                                                                                        break;
                                                                                                    }
                                                                                                    else if (OXYGEN <= 24) {
                                                                                                        System.out.println("We have reached a critical oxygen minimum!");
                                                                                                        break;
                                                                                                    }
                                                                                                    else {
                                                                                                        System.out.println("The mission neither failed neither completed.");
                                                                                                    }
                                                                                                }
                                                                                                else {
                                                                                                    System.out.println("Incorrect command!");
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                            else {
                                                                                                System.out.println("Incorrect command!");
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        else{
                                                                                            FUEL --;
                                                                                            System.out.println("You have " + FUEL + " fuel left.");
                                                                                            System.out.println("Wrong, try again!");
                                                                                            continue;
                                                                                        }
                                                                                        break;
                                                                                    }
                                                                                }
                                                                            }
                                                                            else {
                                                                                OXYGEN --;
                                                                                System.out.println("You have " + OXYGEN + " oxygen left.");
                                                                                System.out.println("Wrong, try again!");
                                                                                continue;
                                                                            }

                                                                            break;
                                                                        }
                                                                    }
                                                                    else {
                                                                        System.out.println("Error - incorrect sequence!");
                                                                        break;
                                                                    }
                                                                }
                                                                else {
                                                                    System.out.println("Incorrect word.");
                                                                    continue;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                        else {
                                                            System.out.println("Incorrect position.");
                                                            continue;
                                                        }
                                                    }
                                                    else {
                                                        System.out.println("Incorrect move.");
                                                        continue;
                                                    }
                                                    break;
                                                }
                                            }
                                            else {
                                                System.out.println("Incorrect position.");
                                                continue;
                                            }
                                        }
                                        else {
                                            System.out.println("Incorrect move.");
                                            continue;
                                        }
                                        break;
                                    }
                                }
                            }
                            else {
                                System.out.println("You don't have such a hand. Enter valid one.");
                                continue;
                            }
                        }
                        else {
                            System.out.println("Enter valid command.");
                            continue;
                        }
                        break;
                    }
                }
                else{
                    System.out.println("You must turn it on before you want to do something.");
                    continue;
                }
                break;
            }
        }





    }
}

