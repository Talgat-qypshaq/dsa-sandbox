public class Queens
{
  public static final int BOARD_SIZE = 8;

  public static final int EMPTY = 0;

  public final static int QUEEN = 1;

  private int board [][];

  public Queens()
  {
    board = new int [BOARD_SIZE][BOARD_SIZE];
  }

  public void clearBoard()
  {
    for(int row = 0; row < BOARD_SIZE; ++row)
    {
      for(int column = 0; column < BOARD_SIZE; ++column)
      {
        board[row][column] = EMPTY;
      }
    }
  }

  public void displayBoard()
  {
    for(int row = 0; row < BOARD_SIZE; ++row)
    {
      for(int column = 0; column < BOARD_SIZE; ++column)
      {
        if(board[row][column] == EMPTY) System.out.print("  ");
        if(board[row][column] == QUEEN) System.out.print("Q ");
        if(board[row][column] < EMPTY) System.out.print("• ");
        /*  debug variant
        if(board[row][column] == EMPTY) System.out.print(" "+EMPTY+" ");
        if(board[row][column] == QUEEN) System.out.print(" Q ");
        if(board[row][column] < EMPTY) System.out.print(board[row][column]+" ");
        */
      }
      System.out.println("");
    }
    System.out.println("");
  }

  public boolean placeQueens(int column)
  {
    //displayBoard();
    if(column >= BOARD_SIZE)
    {
      return true;
    }
    else
    {
      boolean queenPlaced = false;
      int row = 0;
      while(!queenPlaced && (row < BOARD_SIZE))
      {
        if(isUnderAttack(row, column))
        {
          ++row;
        }
        else
        {
          //System.out.println("PLACE QUEEN "+board[row][column]+"; row = "+row+"; column = "+column+".");
          setQueen(row, column);
          queenPlaced = placeQueens(column+1);
          if(!queenPlaced)
          {
            removeQueen(row, column);
            ++row;
          }
        }
      }
      return queenPlaced;
    }
  }

  public void setQueen(int row, int column)
  {
    //System.out.println("SET QUEEN "+board[row][column]+"; row = "+row+"; column = "+column+".");
    board[row][column] = QUEEN;
    //set all elements in the row, the column and diagonal as UNDER_ATTACK (value less than EMPTY)
    for(int i = row, j = column, k = 0, l = row; k < BOARD_SIZE; ++i, ++j, ++k, l--)
    {
      //row
      if(k != row && board[k][column] != QUEEN) board[k][column] = board[k][column] - 1;
      //column
      if(k != column && board[row][k] != QUEEN) board[row][k] = board[row][k] - 1;
      //diagonal from left to right
      if(i < BOARD_SIZE && j < BOARD_SIZE && board[i][j] != QUEEN)
      {
        board[i][j] = board[i][j] - 1;
      }
      //diagonal from right to left
      if(j < BOARD_SIZE && l >= 0 && board[l][j] != QUEEN)
      {
        board[l][j] = board[l][j] - 1;
      }
    }
  }

  private void removeQueen(int row, int column)
  {
    //System.out.println("REMOVED "+board[row][column]+"; row = "+row+"; column = "+column+".");
    board[row][column] = EMPTY;
    //increment UNDER_ATTACK (value less than EMPTY) values of the row, the column and diagonal
    for(int i = row, j = column, k = 0, l = row; k < BOARD_SIZE; ++i, ++j, ++k, l--)
    {
      //row
      if(k != row && board[k][column] < EMPTY) board[k][column] = board[k][column] + 1;
      //column
      if(k != column && board[row][k] < EMPTY) board[row][k] = board[row][k] + 1;
      //diagonal from left to right
      if(i < BOARD_SIZE && j < BOARD_SIZE && board[i][j] < EMPTY)
      {
        board[i][j] = board[i][j] + 1;
      }
      //diagonal from right to left
      if(j < BOARD_SIZE && l >= 0 && board[l][j] < EMPTY)
      {
        board[l][j] = board[l][j] + 1;
      }
    }
  }

  private boolean isUnderAttack(int row, int column)
  {
    if(board[row][column] != EMPTY)
    {
      //System.out.println("UNDER ATTACK value = "+board[row][column]+"; row = "+row+"; column = "+column+".");
      return true;
    }
    else
    {
      //System.out.println("NOT UNDER ATTACK value = "+board[row][column]+"; row = "+row+"; column = "+column+".");
      return false;
    }
  }

  private int index(int number)
  {
    return number-1;
  }
}
