/**
 * Java Assignment 3
 * contains the start menu to interact with the user
 * @author mattobrien
 * @ID 104944866
 * @date 30/11/2018
 * @version 1
 */

import java.util.Random;
import java.util.Scanner;
public class game implements global{
    private player playerX;
    private player playerO;
    private board gameBoard;
    private String coin;
    private boolean menu = true;

    /**
     * sets the default value for the coin
     */
    public game(){
        coin = "unknown";
    }

    /**
     * start function which interacts with the user
     */
    public void start(){
        System.out.println("-----------------------");
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("T | I | C");
        System.out.println("T | A | C");
        System.out.println("T | O | E");
        System.out.println("-----------------------");
        gameBoard = new board();
        int i = 0, j;
        while (menu) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Which game mode would you like to play?");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs AI");
            System.out.println("3. GUI");
            System.out.println("4. I would like to quit!");
            int mode = sc.nextInt();
            switch (mode) {
                case 1: {
                    System.out.println("You have selected Player vs Player!");
                    Scanner sca = new Scanner(System.in);
                    while (true) {
                        System.out.println("Please enter your name player X:");
                        String name1 = sca.nextLine();
                        playerX = new HumanPlayer(gameBoard, name1, "X");
                        if (!playerX.getPlayerName().equals("unknown")) {
                            break;
                        } else
                            System.out.println("Invalid playerX!");
                        }
                        while (true) {
                            System.out.println("Please enter your name player O:");
                            String name2 = sca.nextLine();
                            playerO = new HumanPlayer(gameBoard, name2, "O");
                            if (!playerO.getPlayerName().equals("unknown")) {
                                break;
                            } else
                                System.out.println("Invalid playerX!");
                        }
                        menu = false;
                        break;
                    }case 2: {
                        System.out.println("You have selected player vs AI!");
                        Scanner scan = new Scanner(System.in);
                        while (true) {
                            System.out.println("Please enter your name player X:");
                            String name1 = scan.nextLine();
                            playerX = new HumanPlayer(gameBoard, name1, "X");
                            if (!playerX.getPlayerName().equals("unknown")) {
                                break;
                            } else
                                System.out.println("Invalid playerX!");
                        }
                        System.out.println(playerX.getPlayerName() + ", you will be facing off against Jarvis!");
                        playerO = new AIPlayer(gameBoard, "Jarvis", "O");
                        menu = false;
                        break;
                    }case 3: {
                        GUI.createWindow();
                        break;
                    }case 4: {
                        System.out.println("Thank you!\nGoodbye!");
                        System.exit(0);
                        break;
                    }default:
                        System.out.println("Please enter a valid selection!");
                        break;
                }
            }
            System.out.println("Now i will do the coin toss to determine who goes first!");
            setCoin();
            if (getCoin().equals("X")) {
                System.out.println(playerX.getPlayerName() + " will go first!");
            } else {
                System.out.println(playerO.getPlayerName() + " will go first!");
            }
            while (i == 0) {
                if (getCoin().equals("X")) {
                    System.out.println("Make your move playerX!");
                    playerX.play(gameBoard);
                    coin = "O";
                } else {
                    System.out.println("Make your move playerO!");
                    playerO.play(gameBoard);
                    coin = "X";
                }
                if (!gameBoard.getState().equals("E")) {
                    i = 1;
                }
            }
            gameBoard.displayBoard();
            if (gameBoard.getState().equals("D")) {
                System.out.println("Draw!");
            } else if (gameBoard.getState().equals("X")) {
                System.out.printf("The winner is %s!\n", playerX.getPlayerName());
            } else if (gameBoard.getState().equals("O")) {
                System.out.printf("The winner is %s!\n", playerO.getPlayerName());
            }
    }

    /**
     * randomly sets a value of coin(50/50 chance of even/odd)
     */
    private void setCoin(){
        Random number = new Random();
        int rand = number.nextInt(100);
        if(rand % 2 == 0){
            coin = "X";
        }
        else
            coin = "O";
    }

    /**
     * returns the value of coin
     * @return
     */
    public String getCoin() {
        return coin;
    }
}
