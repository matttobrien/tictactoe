/**
 * Java Assignment 3
 * block maintains the state of each cell in the board
 * @author mattobrien
 * @ID 104944866
 * @date 30/11/2018
 * @version 1
 */

public class block implements global{
    private String state;

    /**
     * sets the default state of block to E
     */
    public block(){
        state = "E";
    }

    /**
     * getter for state
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * setter for state
     * either X or O
     * @param s
     * @return
     */
    public boolean setState(String s) {
        if(isValidState(s)){
            if(s.equals("X")){
                this.state = "X";
            }
            else{
                this.state = "O";
            }
            return true;
        }
        return false;
    }

    /**
     * checks if the State is Valid
     * the state can only be either X or O
     * @param s
     * @return
     */
    protected static boolean isValidState(String s){
       return (s.equals("X")) || (s.equals("O"));
    }

    /**
     * override toString
     * @return
     */
    public String toString(){
        return state;
    }


}
