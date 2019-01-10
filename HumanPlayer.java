/**
 * Java Assignment 3
 * Humanplayer class for player vs player mode
 * @author mattobrien
 * @ID 104944866
 * @date 30/11/2018
 * @version 1
 */

import java.util.Scanner;
public class HumanPlayer extends player {

    /**
     * constructor for humanPlayer
     * @param gb
     * @param name
     * @param sym
     */
    HumanPlayer(board gb, String name, String sym){
        super(gb, name, sym);
    }

    /**
     * allows the user to make a move
     * @param TempGameBoard
     */
    @Override
    void play(board TempGameBoard) {
        Scanner sc = new Scanner(System.in);
        gameBoard = TempGameBoard;
        boolean loop = false;
        while(!loop){
            TempGameBoard.displaySelectionBoard();
            int i = sc.nextInt();
            loop = TempGameBoard.makeMove(i, playerSymbol);
            if(!loop){
                System.out.println("Invalid move!");
            }
        }
    }
}
