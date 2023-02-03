public class Main {

    //game constructor
    public Main(){
        char[][] board = new char[4][4];
        initializeBoard();
        changeBoard(board, random(), random());
        changeBoard(board, random(), random());
        printBoard(board);
    }


    public static void main(String[] args) {
        Main game = new Main();
        }

    //initialize 4X4 array
    public void initializeBoard() {
        char[][] board = new char[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = '*';

            }
        }
    }
    //generate random number
    public int random() {
        int random = (int) (Math.random() * 4);
        return random;
    }
    //print board
    public void printBoard(char[][] board){
        for(int k = 0; k < 4; k++){
            for(int l = 0; l < 4; l++){
                System.out.print(board[k][l]+" ");
            }
            System.out.println();
        }
    }
    //change board values
    public void changeBoard(char[][] board, int x, int y){
        board[x][y] = '2';
    }

}