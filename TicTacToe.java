import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.*;


public class TicTacToe {
    private static Scanner sc = new Scanner(System.in);

    static List<Integer> playerPositions = new ArrayList<>();
    static List<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                              {'-', '+', '-', '+', '-'},
                              {' ', '|', ' ', '|', ' '},
                              {'-', '+', '-', '+', '-'},
                              {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);

        Random rand = new Random();

        while (true) {
            System.out.println("Enter your position(1-9): ");
            int playerPos = sc.nextInt();
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("Already Taken! Try Again");
                System.out.println("Enter your position(1-9): ");
                playerPos = sc.nextInt();
            }
            placePiece(gameBoard, playerPos, "player");
            printGameBoard(gameBoard);

            String result = checkWinning();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            int cpuPos = rand.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "cpu");
            System.out.println("CPU Played: ");
            printGameBoard(gameBoard);

            checkWinning();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
    }

    private static void placePiece(char[][] gameBoard, int pos, String player) {
        char symbol = ' ';
        if (player.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (player.equals("cpu")) {
            symbol = '0';
            cpuPositions.add(pos);
        }

        switch (pos) {
            case 1: gameBoard[0][0] = symbol; break;
            case 2: gameBoard[0][2] = symbol; break;
            case 3: gameBoard[0][4] = symbol; break;
            case 4: gameBoard[2][0] = symbol; break;
            case 5: gameBoard[2][2] = symbol; break;
            case 6: gameBoard[2][4] = symbol; break;
            case 7: gameBoard[4][0] = symbol; break;
            case 8: gameBoard[4][2] = symbol; break;
            case 9: gameBoard[4][4] = symbol; break;
            default: break;
        }
    }

    private static String checkWinning() {
        List<List<Integer>> winning = new ArrayList<>();
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> diag1 = Arrays.asList(1, 5, 9);
        List<Integer> diag2 = Arrays.asList(3, 5, 7);

        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(botRow);
        winning.add(diag1);
        winning.add(diag2);

        for (List<Integer> positions : winning) {
            if (playerPositions.containsAll(positions)) {
                return "Congratulations! You won the game";
            } else if (cpuPositions.containsAll(positions)) {
                return "Whoops! You Lost!! :(";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "Tie!!";
            }
        }

        return "";
    }

    private static void printGameBoard(char[][] gameBoard) {
        for(char[] row : gameBoard) {
            for (char ele : row) {
                System.out.print(ele);
            }
            System.out.println();
        }
    }
}
