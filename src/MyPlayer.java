import java.awt.*;
import java.util.Arrays;

// this class runs when the "MyPlayer" button is pressed
// this is where students will write their own code

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public Board[] losingBoards = new Board[10];
    public Board[] winningBoards = new Board[20];

    public MyPlayer() {
        columns = new int[10];

        losingBoards[0] = new Board(1, 0, 0, 0, 0);

//        oneMove(3,3,1);
        print3x3boards();


        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;


        row = 1;
        column = 1;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        //add code to fill in the columns array
        // so that it represents the gameBoard in number form
        // print your columns array to show it's working
        System.out.println("MY PLAYER CLICKED");
        for (int m = 0; m < columns.length; m++) {
            int count = 0;
            for (int k = 0; k < gameBoard.length; k++) {
                if (gameBoard[k][m].isAlive == true) {
                    count++;
                }
            }
            columns[m] = count;

        }
        System.out.println(Arrays.toString(columns));

        Point myMove;
        myMove = new Point(row, column);

        if (columns[0] == 3 && columns[1] == 3 && columns[2] == 0) {
            myMove = new Point(2, 1);
        }
        return myMove;
    }

    public void print3x3boards() {
        //using 1 or more for loop, print all possible 3x3 or smaller board states.
        // figure out how to cancel out the impossible boards
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                for (int k = 0; k <= 3; k++) {
                    if (i >= j && j >= k) {
                        System.out.print(i + " " + j + " " + k);
                        oneMove(i, j, k);


                    }

                }

            }
            System.out.println(i);
        }


    }

    public void oneMove(int i, int j, int k) {


        //addBoard(i,j,k,row,col) to either
        // the "Winners" array or the "losers" array

        int h = 0;
        int p = 0;

        boolean isWinner = false;

        System.out.println("Possible moves from:" + i + "," + j + "," + k);


        for (int x = 1; x <= 3; x++) {    // this for loop represents the right column
            if (k > 0 && i >= j && j >= (k - x) && (k - x) >= 0) { // the move when taking the top right piece
                Board newBoard = new Board(i, j, (k - x), k - x, 2);
                System.out.println(i + " " + j + " " + (k - x));
                for (Board losingBoard : losingBoards) {
                    if (Arrays.equals(newBoard.cols, losingBoard.cols)) {
                        System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2]);
                        h = k - x;
                        p = 2;

                        isWinner = true;
                        break;
                    }
                }
            }
                        for (int y = j - 1; y >= 0; y--) {

                            if (y >= k) {
                                Board newBoard = new Board(i, y, k, y, 1);
                                System.out.println(i + " " + y + " " + k);
                                for (Board losingBoard : losingBoards) {
                                    if (Arrays.equals(newBoard.cols, losingBoard.cols)) {
                                        System.out.println("Board Loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2]);
                                        h = y;
                                        p = 1;

                                        isWinner = true;
                                        break;
                                    }
                                }

                            } else {
                                Board newBoard = new Board(i, y, y, y, 1);
                                System.out.println(i + " " + y + " " + y);
                                for (Board losingBoard : losingBoards) {
                                    if (Arrays.equals(newBoard.cols, losingBoard.cols)) {
                                        System.out.println("Board Loser : " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2]);
                                        h = y;
                                        p = 1;
                                        isWinner = true;
                                        break;
                                    }
                                }
                            }

                        }



                    for (int z = 2; z >= 0; z--) {
                        if (z >= j && j >= k) {
                            Board newBoard = new Board(z, j, k, z, 0);
                            System.out.println(z + " " + j + " " + k);
                            for (Board losingBoard : losingBoards) {
                                if (Arrays.equals(newBoard.cols, losingBoard.cols)) {
                                    System.out.println("new board found loser: " + newBoard.cols[0] + newBoard.cols[1] + newBoard.cols[2]);
                                    h = z;
                                    p = 0;
                                    isWinner = true;
                                    break;
                                }
                            }
                        } else {
                            Board newBoard = new Board(z, z, z, z, 0);
                            System.out.println(z + " " + z + " " + z);
                            for (Board losingBoard : losingBoards) {
                                if (Arrays.equals(newBoard.cols, losingBoard.cols)) {
                                    h = z;
                                    p = 0;
                                    isWinner = true;
                                    break;
                                }

                            }

                        }

                    }
            if (isWinner) {
                winningBoards.add(new Board(i,j,k,h,p));
            }
            else {
                losingBoards.add(new Board(i,j,k,h,p));
            }
            System.out.println();
            System.out.println(losingBoards);
            System.out.println(winningBoards);


                    // based on iswinner, add ijk to winning or losing board array


                }


        }


    }



