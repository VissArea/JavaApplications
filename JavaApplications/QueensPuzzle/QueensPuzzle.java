/***********************
 *
 *   QueensPuzzle - models a row x col chessboard with queens on it
 *
 *   Author:   Joshua Visser
 *   Date:     11-20-2019
 *
 ***********************/

 public class QueensPuzzle
 {
    private boolean[][] board;
    public static final String SOLID = "\u2588\u2588";
    public static final String BLANK = "  ";
    public static final String QUEEN = "Qu";

    // write a constructor which takes int row and int col and creates the row x col board
    public QueensPuzzle( int row, int col ){
        board = new boolean[ row ][ col ];
        for( row = 0; row < board.length; row++ )
        {
          	for( col = 0; col < board[ row ].length; col++ )
            {
          		board[ row ][ col ] = false;
          	}
        }
      }


    // write a getter for board
    public boolean[][] getBoard()
    {
      return board;
    }


    public void placeQueen(int row, int col){
        // if row and col are valid for this board, place a queen there
        if( board[ row ][ col ] == false )
        {
            board[ row ][ col ] = true;
        }
    }


    public void clearBoard( )
    {
        // remove all queens from the board
        for( int row = 0; row < board.length; row++ )
        {
          for( int col = 0; col < board[ row ].length; col++ )
          {
            board[ row ][ col ] = false;
          }
        }
    }

/*****************************************************************************
For allQueensSafe to be true, you need to check each ~~row~~ and ~~collum~~
along with the diagnol spaces. So;
~~checkRow~~ would check the vertical spaces~~~~~~~~~~~~~~~~ Completed
~~checkCol~~ would check the horizontal spaces~~~~~~~~~~~~~~ Completed
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
The diagnol spaces will need multiple helper methods~~~~~~~~
~~upAndLeft~~ checks going diagonaly up to the left~~~~~~~~~ Completed
~~upAndRight~~ checks going diagonaly up to the right~~~~~~~ Completed
~~downAndLeft~~ checks going diagonaly down to the left~~~~~ Completed
~~downAndRight~~ checks going diagonaly down to the right~~~ Completed
~~eachDirection~~ uses the above helpers to form 1 method~~~ Completed
******************************************************************************/

    public boolean checkRow( )
    {
        boolean queenIsSafe = true;

           for( int row = 0; row < board.length; row++ )
           {
             int queens = 0;
             for( int col = 0; col < board[ row ].length; col++ )
             {
               if( board[ row ][ col ] == true )
               {
                 queens++;
               }
             }
              if( queens > 1 )
              {
                queenIsSafe = false;
              }
           }
        return queenIsSafe;
    }

/******************************************************************************
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ******************************************************************************/

    public boolean checkCol( )
    {
        boolean queenIsSafe = true;

        for( int col = 0; col < board[ 0 ].length; col++ )
        {
            int queens = 0;
            for( int row = 0; row < board.length; row++ )
            {
              if( board[ row ][ col ] == true )
              {
          			queens++;
          		}
          	}
          	if( queens > 1 )
            {
              queenIsSafe = false;
            }
        }
      return queenIsSafe;
    }

/*****************************************************************************
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ******************************************************************************/

    public boolean upAndLeft( int row, int col )
    {
        boolean queenIsSafe = true;
        row -= 1;
        col -= 1;
        while( row >= 0 && col >= 0 )
        {
          if( board[ row ][ col ] == true )
          {
            queenIsSafe = false;
          }
          row -= 1;
          col -= 1;
        }
     return queenIsSafe;
    }

/*****************************************************************************
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *****************************************************************************/


    public boolean upAndRight( int row, int col )
    {
        boolean queenIsSafe = true;
        row -= 1;
        col += 1;
        while( row >= 0 && col < board[ row ].length )
        {
          if( board[ row ][ col ] == true )
          {
            queenIsSafe = false;
          }
          row -= 1;
          col += 1;
        }
      return queenIsSafe;
    }

/******************************************************************************
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
******************************************************************************/

    public boolean downAndLeft( int row, int col )
    {
        boolean queenIsSafe = true;
        row += 1;
        col -= 1;
        while( row < board.length && col >= 0 )
        {
          if( board[ row ][ col ] == true )
          {
            queenIsSafe = false;
          }
          row += 1;
          col -= 1;
        }
      return queenIsSafe;
    }

/******************************************************************************
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ******************************************************************************/

    public boolean downAndRight( int row, int col )
    {
        boolean queenIsSafe = true;
        row += 1;
        col += 1;
        while( row < board.length && col < board[ row ].length )
        {
          if( board[ row ][ col ] == true )
          {
              queenIsSafe = false;
          }
          row += 1;
          col += 1;
        }
      return queenIsSafe;
    }

/******************************************************************************
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ******************************************************************************/
    public boolean eachDirection( int row, int col )
    {
        boolean queenIsSafe = false;
        if( upAndLeft( row, col ) && downAndLeft( row, col ) && upAndRight( row, col )
        && downAndRight( row, col ) && checkRow( ) && checkCol( ) )
        {
          queenIsSafe = true;
        }
      return queenIsSafe;
    }

/******************************************************************************
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ******************************************************************************/

    public boolean allQueensSafe( )
    {
        // answers if all queens on the board are safe (i.e., not threatening each other)
        boolean queenIsSafe = true;
        for( int row = 0; row < board.length; row++ )
        {
          for( int col = 0; col < board[ row ].length; col++ )
          {
            if( board[ row ][ col ] )
            {
              if( !eachDirection( row, col ) )
              {
                queenIsSafe = false;
              }
            }
          }
        }
      return queenIsSafe;
    }

/******************************************************************************
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ******************************************************************************/

    public String toString( )
    {
      String chessBoardMap = "";
      for( int row = 0; row < board.length; row++ )
      {
          for( int col = 0; col < board[ row ].length; col++ )
          {
            if( board[ row ][ col ] )
            {
              chessBoardMap += QUEEN;
            }
            else if( !( board[ row ][ col ] ) )
            {
              int color = row + col;

              if( color % 2 == 0 )
              {
              chessBoardMap += SOLID;
              }
              else if( color % 2 == 1 )
              {
              chessBoardMap += BLANK;
              }
            }
          }
        chessBoardMap += "\n";
      }
    return chessBoardMap;
    }
 }

 /*****************************************************************************
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  *****************************************************************************/
