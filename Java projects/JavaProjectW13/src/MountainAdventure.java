import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MountainAdventure {
    private static final int GRID_SIZE = 10;
    private static final int MAX_PLATFORM_VALUE = 999;

    private static int[][] grid;
    private static int[] playerPositions;
    private static int moveCount;

    public static void main(String[] args) {
        initializeGrid();
        initializePlayers();

        Scanner scanner = new Scanner(System.in);
        while (moveCount < 15) {
            printGrid();
            System.out.println("Enter a command (SBD, VGO, LFS, Q):");
            String command = scanner.nextLine().toUpperCase();

            if (command.equals("SBD")) {
                movePlayerSBD();
            } else if (command.equals("VGO")) {
                movePlayerVGO();
            } else if (command.equals("LFS")) {
                movePlayerLFS();
            } else if (command.equals("Q")) {
                break;
            }

            moveCount++;

            if (checkWinCondition()) {
                System.out.println("Congratulations! You reached the summit!");
                break;
            } else if (checkLoseCondition()) {
                System.out.println("Game over! You fell off the mountain!");
                break;
            }
        }

        System.out.println("Adventure ends! Thanks for playing.");
    }

    private static void initializeGrid() {
        grid = new int[GRID_SIZE][GRID_SIZE];
        Random random = new Random();

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = random.nextInt(MAX_PLATFORM_VALUE + 1);
            }
        }
    }

    private static void initializePlayers() {
        playerPositions = new int[3];
        Arrays.fill(playerPositions, 0);
        moveCount = 0;
    }

    private static void printGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Player Positions:");
        System.out.println("SBD: " + playerPositions[0]);
        System.out.println("VGO: " + playerPositions[1]);
        System.out.println("LFS: " + playerPositions[2]);
        System.out.println("Moves: " + moveCount);
    }

    private static void movePlayerSBD() {
        int currentPlayer = 0;
        int currentPos = playerPositions[currentPlayer];

        if (currentPos % 2 == 0 && currentPos + 1 < GRID_SIZE) {
            playerPositions[currentPlayer] = currentPos + 1;
        } else {
            System.out.println("Invalid move! Cannot move SBD.");
        }
    }

    private static void movePlayerVGO() {
        int currentPlayer = 1;
        int currentPos = playerPositions[currentPlayer];

        int sum = 0;
        int count = 0;

        if (currentPos - 1 >= 0) {
            sum += grid[currentPos - 1][currentPos];
            count++;
        }

        if (currentPos + 1 < GRID_SIZE) {
            sum += grid[currentPos + 1][currentPos];
            count++;
        }

        if (currentPos - 1 >= 0 && currentPos - 1 < GRID_SIZE) {
            sum += grid[currentPos][currentPos - 1];
            count++;
        }

        if (currentPos + 1 >= 0 && currentPos + 1 < GRID_SIZE) {
            sum += grid[currentPos][currentPos + 1];
            count++;
        }

        int average = sum / count;
        grid[currentPos][currentPos] = average;

        if (currentPos + 2 < GRID_SIZE) {
            playerPositions[currentPlayer] = currentPos + 2;
        } else {
            System.out.println("Invalid move! Cannot move VGO.");
        }
    }

    private static void movePlayerLFS() {
        int currentPlayer = 2;
        int currentPos = playerPositions[currentPlayer];

        System.out.println("Enter a direction (R/C):");
        Scanner scanner = new Scanner(System.in);
        String direction = scanner.nextLine().toUpperCase();

        if (direction.equals("R")) {
            int[] row = grid[currentPos];
            Arrays.sort(row);
        } else if (direction.equals("C")) {
            int[] column = new int[GRID_SIZE];
            for (int i = 0; i < GRID_SIZE; i++) {
                column[i] = grid[i][currentPos];
            }
            Arrays.sort(column);
            for (int i = 0; i < GRID_SIZE; i++) {
                grid[i][currentPos] = column[i];
            }
        } else {
            System.out.println("Invalid direction! Cannot move LFS.");
        }

        if (currentPos + 3 < GRID_SIZE) {
            playerPositions[currentPlayer] = currentPos + 3;
        } else {
            System.out.println("Invalid move! Cannot move LFS.");
        }
    }

    private static boolean checkWinCondition() {
        int currentPlayer = 0;
        int currentPos = playerPositions[currentPlayer];
        return currentPos == GRID_SIZE - 1;
    }

    private static boolean checkLoseCondition() {
        for (int pos : playerPositions) {
            if (pos >= GRID_SIZE) {
                return true;
            }
        }
        return false;
    }
}
