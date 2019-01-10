/**
 * Java Assignment 3
 * board maintains the state of the game
 * and checks for a winner
 * @author mattobrien
 * @ID 104944866
 * @date 30/11/2018
 * @version 1
 */

public class board implements global {
    block[][] gBoard;
    private String state = "E";

    /**
     * creates a new board and fills the array with blocks
     */
    public board() {
        gBoard = new block[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gBoard[i][j] = new block();
            }
        }
    }

    /**
     * displays the contents of the board to the screen
     * after there is a winner
     */
    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(gBoard[i][j].getState().equals("E")){
                    System.out.print(" ");
                }else {
                    System.out.print(gBoard[i][j]);
                }
                if (j != 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    /**
     * displays the board for player selection
     * a number is placed in the block with state E
     * for player selection
     */
    public void displaySelectionBoard() {
        int x = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(gBoard[i][j].getState().equals("E")){
                    System.out.print(x);
                }
                else{
                    System.out.print(gBoard[i][j]);
                }
                if (j != 2) {
                    System.out.print("|");
                }
                x++;
            }
            System.out.println();
        }
    }


    /**
     * getter for the state of the board
     * @return
     */
    public String getState() { return state; }

    /**
     * check the state of every block in the board
     * if no blocks have state E then there is a draw!
     * @return true/false
     */
    public boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gBoard[i][j].getState().equals("E")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * checks the blocks in corresponding order for a win
     * @return true/false
     */
    public boolean checkForWin() {
        //horizontal win check
        //c tells the check which row to consider
        if(checkHorizontal(0, 1, 0) && checkHorizontal(1, 2, 0)) {
            return true;
        } else if (checkHorizontal(0, 1, 1) && checkHorizontal(1, 2, 1)) {
            return true;
        } else if (checkHorizontal(0, 1, 2) && checkHorizontal(1, 2, 2)) {
            return true;
        }

        //vertical win check
        //c tells the check which column to consider
        else if(checkVertical(0, 1, 0) && checkVertical(1, 2, 0)) {
            return true;
        } else if(checkVertical(0, 1, 1) && checkVertical(1, 2, 1)) {
            return true;
        } else if(checkVertical(0, 1, 2) && checkVertical(1, 2, 2)) {
            return true;
        }

        //diagonal win check
        //c and d tell the check which row/column to consider
        else if(checkDiagonal(0, 1, 1, 0) && checkDiagonal(1, 2, 1, 0)) {
            return true;
        } else if(checkDiagonal(0, 2, 2, 1) && checkDiagonal(0, 2, 3, 1)) {
            return true;
        } else{
            return false;
        }
    }

    public boolean checkHorizontal(int a, int b, int c) {
        if (gBoard[c][a].getState().equals(gBoard[c][b].getState()) && !(gBoard[c][a].getState().equals("E"))) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * checks for Vertical win
     * @param a
     * @param b
     * @param c
     * @return true/false
     */
    private boolean checkVertical(int a, int b, int c) {
        if (gBoard[a][c].getState().equals(gBoard[b][c].getState()) && !(gBoard[a][c].getState().equals("E"))) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * checks for diagonal win
     * @param a
     * @param b
     * @param c
     * @param d
     * @return true/false
     */
    private boolean checkDiagonal(int a, int b, int c, int d) {
        if (c == 1) {
            if (gBoard[a][a].getState().equals(gBoard[b][b].getState()) && !(gBoard[a][a].getState().equals("E"))) {
                return true;
            }
            else {
                return false;
            }
        } else if(c == 2){
            if (gBoard[a][b].getState().equals(gBoard[d][d].getState()) && !(gBoard[d][d].getState().equals("E"))) {
                return true;
            }
            else {
                return false;
            }
        } else {
            if (gBoard[d][d].getState().equals(gBoard[b][a].getState()) && !(gBoard[b][a].getState().equals("E"))) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    /**
     * takes the players move and changes
     * the state of the selected block
     * @param i
     * @param j
     * @return true/false
     */
    public boolean makeMove(int i, String j) {
        int row = 0, col = 0;
        if (i < 1 || i > 9) {
            return false;
        }
        if (i == 1) {
            row = 0;
            col = 0;
        }
        if (i == 2) {
            row = 0;
            col = 1;
        }
        if (i == 3) {
            row = 0;
            col = 2;
        }
        if (i == 4) {
            row = 1;
            col = 0;
        }
        if (i == 5) {
            row = 1;
            col = 1;
        }
        if (i == 6) {
            row = 1;
            col = 2;
        }
        if (i == 7) {
            row = 2;
            col = 0;
        }
        if (i == 8) {
            row = 2;
            col = 1;
        }
        if (i == 9) {
            row = 2;
            col = 2;
        }
        if (gBoard[row][col].getState().equals("E")) {
            gBoard[row][col].setState(j);
            if(checkForWin()){
                if(j.equals("X")){
                    state = "X";
                }
                else{
                    state = "O";
                }
            }else if(checkDraw()){
                state = "D";
            }
            return true;
        }
        return false;
    }
}


