import java.awt.*;
import java.sql.SQLOutput;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public int chipcount

    public MyPlayer() {
        columns = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
        // FILL COLUMNS ARRAY WITH 0'S
        for (int i = 0; i < columns.length; i++) {
            columns[i] = 0;

        }
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
        // so that it represents  the Game Board in number form
        //print your column array to show its working
        //In the MyPlayer move method, take the gameBoard 2D array and translate it into the columns 1D array.
        // Columns[] should represent how many tiles are alive in each column from left to right.
        System.out.println("MY PLAYER CLICKED");


        for (int y = 0; y< columns.length; y++) {
            int chipcount = 0;// this is to count how many chips are in the column
            for (int i = 0; i < gameBoard.length; i++) {
                if (gameBoard[y][i].isAlive==true) {  // assuming null could means empty cells
                    chipcount ++;


                }

            }
            columns[y]= chipcount; // this is to update the
        }



        Point myMove = new Point(row, column);
        return myMove;
    }
}
