/**
 * Java Assignment 3
 * GUI for TicTacToe
 * @author mattobrien
 * @date 30/11/2018
 * @version 1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class GUI extends game {
    private static String coin;
    private static JButton buttons[] = new JButton[9];
    private static boolean AI = false;

    /**
     * creates the JFrame, JPanel and JButtons
     * for the GUI
     */
    public static void createWindow(){
        String playerX;
        String playerO;
        JFrame frame  = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(300,200,300,300);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new ActionListener() {
                @Override
                //if the button is clicked this method will be called
                public void actionPerformed(ActionEvent e) {
                    JButton bc = (JButton)e.getSource();
                    if(!bc.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Invalid move!");
                    }
                    else if(AI){
                        bc.setText("X");
                        if (!checkForWin()) {
                            makeAImove();
                            if (checkForWin()) {
                                coin = "X";
                            }
                            else {
                                coin = "O";
                            }
                        }
                    }
                    else {
                        if (coin.equals("X")) {
                            bc.setText("X");
                            coin = "O";
                        } else {
                            bc.setText("O");
                            coin = "X";
                        }
                    }
                    if(checkDraw()){
                        JOptionPane.showMessageDialog(null, "Its a Draw!");
                        resetButtons();
                    }
                    if(checkForWin()){
                        if(coin.equals("O")){
                            JOptionPane.showMessageDialog(null, "The winner is: X");
                            resetButtons();
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"The winner is: O");
                            resetButtons();
                        }
                    }
                }
            });
            panel.add(buttons[i]);
        }
        //custom icon
        ImageIcon icon = new ImageIcon("src/ttt.png");
        String[] options = {"Quit", "Player vs AI", "Player vs Player"};
        int option = JOptionPane.showOptionDialog(null,"Please select a Gamemode!",
                "Welcome to Tic-Tac-Toe!",JOptionPane.YES_NO_CANCEL_OPTION,0,icon,options,options[0]);
        //sets the value pf coin before the game starts
        setCoin();
        if(option == JOptionPane.CANCEL_OPTION){
            playerX = JOptionPane.showInputDialog(null, "What's your name playerX?");
            playerO = JOptionPane.showInputDialog(null, "What's your name playerO?");
            if(coin.equals("X")){
                JOptionPane.showMessageDialog(null, playerX + " has won the coin toss!\nMake your move!");
            }
            else{
                JOptionPane.showMessageDialog(null, playerO + " has won the coin toss!\nMake your move!");
            }
        }
        else if(option == JOptionPane.NO_OPTION){
            playerX = JOptionPane.showInputDialog(null, "What's your name playerX?");
            playerO = "Jarvis";
            if(coin.equals("X")) {
                JOptionPane.showMessageDialog(null, playerX + " has won the coin toss!!\nMake your move!");
            }
            else{
                JOptionPane.showMessageDialog(null, playerO + " has won the coin toss!!\nMake your move!");
                makeAImove();
            }
            AI = true;
        }
        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * makes the move for the AI player
     * ensures the button is blank
     * and the number is between 0 - 8
     */
    private static void makeAImove() {
        int x = 0;
        int[] intArray = new int[9];
        Random rand = new Random();
        for(int i = 0; i < 9; i++){
            if(buttons[i].getText().equals("")){
                intArray[(x++)] = i;
            }
        }
        int move = intArray[rand.nextInt(x)];
        buttons[move].setText("O");
    }

    /**
     * setter for coin
     * 50/50 chance of X or O
     */
    private static void setCoin(){
        Random number = new Random();
        int rand = number.nextInt(100);
        if(rand % 2 == 0){
            coin = "X";
        }
        else
            coin = "O";
    }

    /**
     * resets the buttons after a game is finished
     */
    private static void resetButtons() {
        for(int i = 0; i < 9; i++) {
            buttons[i].setText("");
        }
    }

    /**
     * calls the check function to check for any kind of win
     * @return
     */
    private static boolean checkForWin() {
        //horizontal win check
        if (check(0,1) && check(1,2))
            return true;
        else if (check(3,4) && check(4,5))
            return true;
        else if (check(6,7) && check(7,8))
            return true;

            //vertical win check
        else if (check(0,3) && check(3,6))
            return true;
        else if (check(1,4) && check(4,7))
            return true;
        else if (check(2,5) && check(5,8))
            return true;

            //diagonal win check
        else if (check(0,4) && check(4,8))
            return true;
        else if (check(2,4) && check(4,6))
            return true;
        else
            return false;
    }

    public static boolean check(int a, int b) {
        return buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("");
    }

    public static boolean checkDraw(){
        for(int i = 0; i < 9; i++){
            if(buttons[i].getText().equals("")){
                return false;
            }
        }
        return true;
    }
}
