package scenariobased;
import java.util.Scanner;
import java.util.Arrays;

public class SnakeLadderProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO SNAKE LADDER GAME.\n");

        // UC1 & start: ask user for game mode
        int gameMode = startGame();
        
        if (gameMode == 0) {
            singlePlayerGame();
        } else if (gameMode == 1) {
            doublePlayerGame();
        } else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }

    // UC2: roll dice to get number between 1 to 6
    static int dice() {
        return (int)(Math.random()*6)+1;
    }

    // UC3: check for option - No Play, Ladder, or Snake (returns 1=Ladder, 2=Snake)
    static int snakeOrLadder() {
        int option = (int)(Math.random()*2)+1; // only 1 or 2 for two-player game
        return option;
    }

    // start game: select single or two player mode
    static int startGame() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 0 for single player game and 1 for 2 player game : ");
        return sc.nextInt();
    }

    // UC4, UC5, UC6: single player game implementation
    static void singlePlayerGame() {
        int count = 0;
        StringBuilder diceCount = new StringBuilder("");
        
        System.out.println("\n=========== SINGLE PLAYER GAME ===========\n");
        
        // UC4: repeat till player reaches 100
        while(count < 100) {
            int diceNo = dice();
            diceCount.append(" ");

            int playerGets = (int)(Math.random()*3)+1; // 1=Ladder, 2=Snake, 3=No Play
            System.out.println("You got dice number: " + diceNo);

            // UC3: option 1 = Ladder
            if (playerGets == 1) {
                // UC5: ensure player gets exact 100
                if(count + diceNo > 100) {
                    System.out.println("You got: Ladder");
                    System.out.println("Try again, your position is " + count + " (cannot exceed 100)");
                    System.out.println("\n-------------------------------------------------------------------------\n");

                } else if(count + diceNo == 100) {
                    count += diceNo;
                    System.out.println("You got: Ladder");
                    System.out.println("🎉 Congratulations! You reached position 100, you WIN the game!");
                    System.out.println("\n-------------------------------------------------------------------------\n");
                } else {
                    count += diceNo;
                    System.out.println("You got: Ladder");
                    System.out.println("Your position is: " + count);
                    System.out.println("\n-------------------------------------------------------------------------\n");
                }

            // UC3: option 2 = Snake
            } else if(playerGets == 2) {
                // UC4: if position goes below 0, restart from 0
                if(count - diceNo < 0) {
                    count = 0;
                    System.out.println("You got: Snake");
                    System.out.println("Your position is: " + count + " (cannot go below 0, restarting)");
                    System.out.println("\n-------------------------------------------------------------------------\n");

                } else {
                    count -= diceNo;
                    System.out.println("You got: Snake");
                    System.out.println("Your position is: " + count);
                    System.out.println("\n-------------------------------------------------------------------------\n");
                }

            // UC3: option 3 = No Play
            } else {
                System.out.println("You got: No Play Option (position remains same)");
                System.out.println("Your position is: " + count);
                System.out.println("\n-------------------------------------------------------------------------\n");
            }

            diceCount.append(count);

        }
        
        // UC6: report number of times dice was played and position after every roll
        int [] diceArray = Arrays.stream(diceCount.toString().trim().split(" ")).mapToInt(Integer :: parseInt).toArray();
        System.out.println("\n========== GAME REPORT ==========");
        System.out.println("Number of times dice rolled: " + diceArray.length);
        int rollCount = 1;
        System.out.println("\nS.No.\tPosition");
        for (int x : diceArray) {
            System.out.println(rollCount + "\t" + x);
            rollCount++;
        }
        System.out.println("=================================\n");
    }

    // UC7: two player game implementation
    static void doublePlayerGame() {
        int p1Count = 0, p2Count = 0;
        StringBuilder p1diceCount = new StringBuilder("");
        StringBuilder p2diceCount = new StringBuilder("");
        boolean player1Turn = true;

        System.out.println("\n=========== TWO PLAYER GAME ===========\n");

        // continue till one player reaches 100
        while(p1Count < 100 && p2Count < 100) {
            
            if (player1Turn) {
                System.out.println("--- PLAYER 1's Turn ---");
                int diceNo = dice();
                p1diceCount.append(" ");

                int playerGets = snakeOrLadder(); // only Ladder(1) or Snake(2)
                System.out.println("Player 1 got dice number: " + diceNo);

                if (playerGets == 1) {
                    // Ladder: move forward by dice number
                    if(p1Count + diceNo > 100) {
                        System.out.println("Player 1 got: Ladder (cannot exceed 100)");
                        System.out.println("Player 1 position: " + p1Count);
                        p1diceCount.append(p1Count);
                        player1Turn = false; // switch turn
                    } else if(p1Count + diceNo == 100) {
                        p1Count += diceNo;
                        System.out.println("Player 1 got: Ladder");
                        System.out.println("🎉 PLAYER 1 WINS! Reached position 100!");
                        p1diceCount.append(p1Count);
                    } else {
                        p1Count += diceNo;
                        System.out.println("Player 1 got: Ladder");
                        System.out.println("Player 1 position: " + p1Count);
                        System.out.println("Player 1 gets another turn!");
                        p1diceCount.append(p1Count);
                        // player1Turn remains true - continue loop without switching
                    }

                } else {
                    // Snake: move backward by dice number
                    if(p1Count - diceNo < 0) {
                        p1Count = 0;
                        System.out.println("Player 1 got: Snake");
                        System.out.println("Player 1 position: " + p1Count + " (restarting from 0)");
                    } else {
                        p1Count -= diceNo;
                        System.out.println("Player 1 got: Snake");
                        System.out.println("Player 1 position: " + p1Count);
                    }
                    p1diceCount.append(p1Count);
                    player1Turn = false; // switch to player 2
                }

            } else {
                System.out.println("--- PLAYER 2's Turn ---");
                int diceNo = dice();
                p2diceCount.append(" ");

                int playerGets = snakeOrLadder(); // only Ladder(1) or Snake(2)
                System.out.println("Player 2 got dice number: " + diceNo);

                if (playerGets == 1) {
                    // Ladder: move forward by dice number
                    if(p2Count + diceNo > 100) {
                        System.out.println("Player 2 got: Ladder (cannot exceed 100)");
                        System.out.println("Player 2 position: " + p2Count);
                        p2diceCount.append(p2Count);
                        player1Turn = true; // switch turn
                    } else if(p2Count + diceNo == 100) {
                        p2Count += diceNo;
                        System.out.println("Player 2 got: Ladder");
                        System.out.println("🎉 PLAYER 2 WINS! Reached position 100!");
                        p2diceCount.append(p2Count);
                    } else {
                        p2Count += diceNo;
                        System.out.println("Player 2 got: Ladder");
                        System.out.println("Player 2 position: " + p2Count);
                        System.out.println("Player 2 gets another turn!");
                        p2diceCount.append(p2Count);
                        // player1Turn remains false - continue loop without switching
                    }

                } else {
                    // Snake: move backward by dice number
                    if(p2Count - diceNo < 0) {
                        p2Count = 0;
                        System.out.println("Player 2 got: Snake");
                        System.out.println("Player 2 position: " + p2Count + " (restarting from 0)");
                    } else {
                        p2Count -= diceNo;
                        System.out.println("Player 2 got: Snake");
                        System.out.println("Player 2 position: " + p2Count);
                    }
                    p2diceCount.append(p2Count);
                    player1Turn = true; // switch to player 1
                }
            }

            System.out.println("\n-------------------------------------------------------------------------\n");
        }

        // UC7: report which player won
        System.out.println("\n========== GAME REPORT ==========");
        if (p1Count == 100) {
            System.out.println("🏆 PLAYER 1 WON THE GAME! 🏆");
        } else {
            System.out.println("🏆 PLAYER 2 WON THE GAME! 🏆");
        }

        // display player 1 progress
        int [] p1Array = Arrays.stream(p1diceCount.toString().trim().split(" ")).mapToInt(Integer :: parseInt).toArray();
        System.out.println("\nPlayer 1 - Dice rolled: " + p1Array.length + " times");
        System.out.println("Turn\tPosition");
        for (int i = 0; i < p1Array.length; i++) {
            System.out.println((i+1) + "\t" + p1Array[i]);
        }

        // display player 2 progress
        int [] p2Array = Arrays.stream(p2diceCount.toString().trim().split(" ")).mapToInt(Integer :: parseInt).toArray();
        System.out.println("\nPlayer 2 - Dice rolled: " + p2Array.length + " times");
        System.out.println("Turn\tPosition");
        for (int i = 0; i < p2Array.length; i++) {
            System.out.println((i+1) + "\t" + p2Array[i]);
        }
        System.out.println("=================================\n");
    }
}
