import java.util.Scanner;

public class WalrusCodeApp {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        wordToSymbol();
    }

    public static void wordToSymbol() {
        System.out.print("Enter word: ");
        String word = sc.nextLine();

        boolean matchWord = false;
        String walrusWord = "";
        int sentenceNumber = 1;

        for (int i = 0; i < word.length(); i++) {

            char currentChar = word.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                //Абревиатурата не ми се получава
                /*
                boolean isAbbreviation = false;
                int j = i + 1;
                while (j < word.length()) {
                    if (Character.isLowerCase(word.charAt(j))) {
                        break;
                    } else if (Character.isUpperCase(word.charAt(j))) {
                        isAbbreviation = true;
                        break;
                    }
                    j++;
                }
                if (isAbbreviation) {
                    walrusWord += currentChar;
                    continue;
                }
                 */
                if (i % 2 == 0) {
                    walrusWord += "[" + getSymbol(currentChar) + "]";
                }
                else {
                    walrusWord += "{" + getSymbol(currentChar) + "}";
                }
                walrusWord += "[(" + sentenceNumber + ")]";
                matchWord = true;
            }
            else if (Character.isLowerCase(currentChar)) {
                walrusWord += getSymbol(currentChar);
                matchWord = true;
            }
            else if (currentChar == ' ' && i % 2 == 0) {
                walrusWord += "___";
                matchWord = true;
            }
            else if (currentChar == ' ' && i % 2 == 1) {
                walrusWord += "***";
                matchWord = true;
            }
            else if (currentChar == '.') {
                walrusWord += getSymbol(currentChar);
                sentenceNumber ++;
                matchWord = true;
            }
            else if (currentChar == '?') {
                walrusWord += getSymbol(currentChar);
                sentenceNumber++;
                matchWord = true;
            }
            else {
                walrusWord += currentChar;
            }
        }

        if (matchWord) {
            System.out.println("The word with symbols: " + walrusWord);
        }
        else {
            System.out.println("No matches!");
        }
    }

    public static String getSymbol(char symbol) {
        switch (Character.toLowerCase(symbol)) {
            case 'a':
                return "@(";
            case 'b':
                return "!@";
            case 'c':
                return "(";
            case 'd':
                return "@!";
            case 'e':
                return "(-";
            case 'f':
                return "!-";
            case 'g':
                return "&";
            case 'h':
                return "!%";
            case 'i':
                return "!";
            case 'j':
                return ".!";
            case 'k':
                return "!<";
            case 'l':
                return "!!";
            case 'm':
                return "^^";
            case 'n':
                return "%";
            case 'o':
                return "()";
            case 'p':
                return "!^@";
            case 'q':
                return "!.@";
            case 'r':
                return "@<";
            case 's':
                return ")(";
            case 't':
                return "/_";
            case 'u':
                return "^>";
            case 'v':
                return "<!>";
            case 'w':
                return "><";
            case 'x':
                return "<>";
            case 'y':
                return ".=.";
            case 'z':
                return "#$";
            case '.':
                return "|...|";
            case '?':
                return "$$$";
            default:
                return "";
        }
    }
}