/**
 * Java Assignment 3
 * GUI for TicTacToe
 * @author mattobrien
 * @ID 104944866
 * @date 30/11/2018
 * @version 1
 */

import java.util.Random;
public class AIPlayer extends player {

    /**
     * constructor for AIPlayer
     * @param gameBoard
     * @param n
     * @param s
     */
   public AIPlayer(board gameBoard, String n, String s){
       super(gameBoard, n, s);
   }

    /**
     * Moves the move for the AI player
     * @param gameBoard
     */
   public void play(board gameBoard){
       int i;
       i = randomMove(gameBoard);
       System.out.println("Random move incoming!");
       gameBoard.makeMove(i, "O");
   }

    /**
     * generates random number for the player
     * ensures the number is a block that is empty
     * and that the number is between 1-9
     * @param gameBoard
     * @return
     */
    private int randomMove(board gameBoard) {
        int x = 0;
        int[] intArray = new int[9];
        Random rand = new Random();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(gameBoard.gBoard[i][j].getState().equals("E")){
                    intArray[(x++)] = (3 * i + 1 + j);
                }
            }
        }
        return intArray[rand.nextInt(x)];
    }


}
