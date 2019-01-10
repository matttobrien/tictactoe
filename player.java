/**
 * Java Assignment 3
 * abstract class to create new players
 * and ensure they implement abstract methods
 * @author mattobrien
 * @ID 104944866
 * @date 30/11/2018
 * @version 1
 */

public abstract class player {
    public board gameBoard;
    private String playerName;
    public String playerSymbol;

    /**
     * conatructor for each player
     * @param b
     * @param n
     * @param s
     */
    public player(board b, String n, String s){
        setPlayerName(n);
        setPlayerSymbol(s);
        setGameBoard(b);
    }

    /**
     * setter for playerName
     * @param n
     */
    private void setPlayerName(String n) {
        if(n.length() != 0){
            this.playerName = n;
        }
    }

    /**
     * getter for playerName
     * @return
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * setter for the playerSymbol
     * @param s
     */
    private void setPlayerSymbol(String s) {
        if(s.equals("X") || s.equals("O")) {
            this.playerSymbol = s;
        }
    }

    /**
     * sets the players gameBoard
     * @param b
     */
    private void setGameBoard(board b) {
        this.gameBoard = b;
    }

    /**
     * abstract method which must be implemented in player classes
     * @param gameBoard
     */
    abstract void play(board gameBoard);
}
