import java.awt.*;
import java.util.Arrays;

// this class runs when the "MyPlayer" button is pressed
// this is where students will write their own code

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public MyPlayer() {
        columns = new int[10];




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
        myMove = new Point(row,column);

        if(columns[0]==3 && columns[1] ==3 && columns[2] == 0){
           myMove=new Point(2,1);
       }
        return myMove;
    }
    public void print3x3boards(){
        //using 1 or more for loop, print all possible 3x3 or smaller board states.
        // figure out how to cancel out the impossible boards
        for(int i = 1; i <= 3; i++){
            for(int j = 0; j<= 3; j++){
                for( int k= 0;k<=3; k++){
                    if(i>=j && j>=k) {
                        System.out.print(i + " " + j + " " + k);
                        oneMove(i, j, k);


                    }

                }

            }
            System.out.println(i);
        }


    }
    public void oneMove(int i, int j, int k){


        System.out.println("Possible moves from:"+ i + "," + j + "," + k );


        for(int z = k-1; z>=0; z--){
            System.out.println("New Board (Right Column):" + i + ", " + j + ", " + z);

        }
            //attempt at making a board to
        Chip[][]= new Chip[gameBoard.length][gameBoard[0].length];

        }

    }


