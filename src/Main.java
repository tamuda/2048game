import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {

    private static int[][] board = new int[4][4];

    //game constructor
    public Main() {
        //int[][] board = new int[4][4];
        initializeBoard();
        changeBoard();
        changeBoard();
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
            }
            printBoard(board);
            move  = input.nextLine().charAt(0);

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
                System.out.print(board[k][l] + " ");
            }
            System.out.println();
        }
    }

    //change board values
    public  void changeBoard() {
        int x = random();
        int y = random();
        while (checkBoard(board, x, y)== "taken") {
            changeBoard();
        }
        board[x][y] = 2;
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
        int temp = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (checkBoard(board, i, j).equals("taken")) {
                    if (board[i+1][j]==board[i][j]){
                        //add the two numbers
                        board[i][j] = (int)board[i][j] + (int)board[i+1][j];
                     //   System.out.println(sum);
                        //set the second number to 0
                        board[i+1][j] = 0;
                    }
                    }
                else if (checkBoard(board, i, j).equals("empty") && checkBoard(board, i+1, j).equals("taken")){
                    board[i][j] = board[i+1][j];
                    board[i+1][j] = 0;

                }
            }
        }
        //Add a new number
        changeBoard();

    }
    //move down
    public void moveDown() {
        int temp = 0;
        for (int i = 3; i > 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (checkBoard(board, i, j).equals("taken")) {
                    if (board[i-1][j]==board[i][j]){
                        //add the two numbers
                        board[i][j] = (int) ((board[i][j] + board[i-1][j])+0);
                        //set the second number to 0
                        board[i-1][j] = 0;
                    }
                }
                else if (checkBoard(board, i, j).equals("empty") && checkBoard(board, i-1, j).equals("taken")){
                    board[i][j] = board[i-1][j];
                    board[i-1][j] = 0;

                }
            }
        }
        //Add a new number
        changeBoard();
    }
    //move left
    public void moveLeft() {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (checkBoard(board, i, j).equals("taken")) {
                    if (board[i][j+1]==board[i][j]){
                        //add the two numbers
                        board[i][j] = (int) ((board[i][j] + board[i][j+1])+0);
                        //set the second number to 0
                        board[i][j+1] = 0;
                    }
                }
                else if (checkBoard(board, i, j).equals("empty") && checkBoard(board, i, j+1).equals("taken")){
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = 0;

                }
            }
        }
        //Add a new number
        changeBoard();

    }

    //move right
    public void moveRight() {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                if (checkBoard(board, i, j).equals("taken")) {
                    if (board[i][j-1]==board[i][j]){
                        //add the two numbers
                        board[i][j] = (int) ((board[i][j] + board[i][j-1])+0);
                        //set the second number to 0
                        board[i][j-1] = 0;
                    }
                }
                else if (checkBoard(board, i, j).equals("empty") && checkBoard(board, i, j-1).equals("taken")){
                    board[i][j] = board[i][j-1];
                    board[i][j-1] = 0;

                }
            }
        }
        //Add a new number
        changeBoard();

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
        return true;
    }

}