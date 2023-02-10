import java.util.Scanner;

public class Main {
    private static int[][] board = new int[4][4];
    int validMove = 0;
    //game constructor
    public Main() {
        initializeBoard();
        addNumber();
        addNumber();
        printBoard(board);
    }

    public static void main(String[] args) {
        Main game = new Main();
        Scanner input = new Scanner(System.in);
        char move  = input.nextLine().charAt(0);
        while (!game.checkFull(board)){
            switch (move) {
                case 'w':
                    game.moveUp();
                    break;
                case 's':
                    game.moveDown();
                    break;
                case 'a':
                    game.moveLeft();
                    break;
                case 'd':
                    game.moveRight();
                    break;
                case 'q':
                    System.out.println("are you sure you want to quit? type yes or no");
                    String quitResponse = input.nextLine();
                    if (quitResponse.equalsIgnoreCase("yes")) {
                        game.quitGame();
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");
                    }
                    else if (quitResponse.equalsIgnoreCase("no")) {
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");
                        break;
                    }
                case 'r':
                    System.out.println("are you sure you want to restart? type yes or no");
                    String restartResponse = input.nextLine();
                    if (restartResponse.equalsIgnoreCase("yes")) {
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");
                        game.restartGame();
                    }
                    else if (restartResponse.equalsIgnoreCase("no")) {
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");
                        break;
                    }
            }
            printBoard(board);
            move = input.nextLine().charAt(0);
            //input.close();
        }
    }

    //initialize 4X4 array
    public void initializeBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = 0;
            }
        }
    }

    //generate random number
    public int random() {
        int random = (int) (Math.random() * 4);
        return random;
    }

    //print board
    public static void printBoard(int[][] board) {
        for (int k = 0; k < 4; k++) {
            for (int l = 0; l < 4; l++) {
                System.out.printf("%-5s",board[k][l]);
            }
            System.out.println();
        }
    }

    //change board values
    public void addNumber() {
        int x = random();
        int y = random();
        while (checkBoard(board, x, y)== "taken") {
            x = random();
            y = random();
        }
        double probability = Math.random();
        if (probability <= .8) {
            board[x][y] = 2;
        }
        else {
            board[x][y] = 4;
        }
    }

    //check if space is taken
    public String checkBoard(int[][] board, int x, int y) {
        if (board[x][y] == 0) {
            return "empty";
        } else {
            return "taken";
        }
    }

    //move up
    public void moveUp() {
        int order = 0;
        //having a separate nested for loop so the ordering is correct
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (checkBoard(board, i, j).equals("empty") && checkBoard(board, i+1, j).equals("taken")){
                    board[i][j] = board[i+1][j];
                    board[i+1][j] = 0;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (checkBoard(board, i, j).equals("taken") && order < 2) {
                    if (board[i+1][j]==board[i][j]){
                        //add the two numbers
                        board[i][j] = (int)board[i][j] + (int)board[i+1][j];
                        //set the second number to 0
                        board[i+1][j] = 0;
                        order++;
                    }
                }
            }
        }
        //Add a new number
        addNumber();
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("That was a valid move");
        System.out.println("\n");
        validMove++;
    }

    //move down
    public void moveDown() {
        int order = 0;
        //having a separate nested for loop so the ordering is correct
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (checkBoard(board, i, j).equals("empty") && checkBoard(board, i-1, j).equals("taken")){
                    board[i][j] = board[i-1][j];
                    board[i-1][j] = 0;
                }
            }
        }
        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (checkBoard(board, i, j).equals("taken") && order < 2) {
                    if (board[i-1][j]==board[i][j]){
                        //add the two numbers
                        board[i][j] = (int) ((board[i][j] + board[i-1][j])+0);
                        //set the second number to 0
                        board[i-1][j] = 0;
                        order++;
                    }
                }
            }
        }
        //Add a new number
        addNumber();
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("That was a valid move");
        System.out.println("\n");
        validMove++;
    }

    //have a for statement with a while loop inside it checking only one row/column at first

    //move left
    public void moveLeft() {
        int order = 0;
        //having a separate nested for loop so the ordering is correct
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                while (checkBoard(board, i, j).equals("empty") && checkBoard(board, i, j+1).equals("taken")){
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = 0;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (checkBoard(board, i, j).equals("taken") && order < 2) {
                    if (board[i][j+1]==board[i][j]){
                        //add the two numbers
                        board[i][j] = (int) ((board[i][j] + board[i][j+1])+0);
                        //set the second number to 0
                        board[i][j+1] = 0;
                        order++;
                    }
                }
            }
        }
        //Add a new number
        addNumber();
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("That was a valid move");
        System.out.println("\n");
        validMove++;
    }

    //move right
    public void moveRight() {
        int order = 0;
        //having a separate nested for loop so the ordering is correct
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 3; j++) {
                if (checkBoard(board, i, j).equals("empty") && checkBoard(board, i, j-1).equals("taken")){
                    board[i][j] = board[i][j-1];
                    board[i][j-1] = 0;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                if (checkBoard(board, i, j).equals("taken") && order < 2) {
                    if (board[i][j-1]==board[i][j]){
                        //add the two numbers
                        board[i][j] = (int) ((board[i][j] + board[i][j-1])+0);
                        //set the second number to 0
                        board[i][j-1] = 0;
                        order++;
                    }
                }
            }
        }
        //Add a new number
        addNumber();
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("That was a valid move");
        System.out.println("\n");
        validMove++;
    }

    //Check if board is full
    public boolean checkFull(int[][] board){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == 0){
                    return false;
                }
            }
        }
        System.out.println("You lost!");
        System.out.println("You had:"+ validMove +" valid moves");
        return true;

    }

    //restart the game
    public void restartGame() {
        initializeBoard();
        addNumber();
        addNumber();
    }

    //quit the game
    public void quitGame() {
        System.exit(0);
    }

}