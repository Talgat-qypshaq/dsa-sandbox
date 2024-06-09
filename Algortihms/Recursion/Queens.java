public class Queens
{
  public static final int BOARD_SIZE = 8;

  public static final int EMPTY = 0;

  public final static int QUEEN = 1;

  public final static int UNDER_ATTACK = -1;

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
        if(board[row][column] == UNDER_ATTACK) System.out.print("• ");
      }
      System.out.println("");
    }
    System.out.println("");
  }

  public boolean placeQueens(int column) throws Exception
  {
    displayBoard();
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
    board[row][column] = QUEEN;
    //set all elements in the row and the column UNDER_ATTACK
    for(int i = row, j = column, k = 0, l = row; k < BOARD_SIZE; ++i, ++j, ++k, l--)
    {
      //row
      if(k != row && board[k][column] != QUEEN) board[k][column] = UNDER_ATTACK;
      //column
      if(k != column && board[row][k] != QUEEN) board[row][k] = UNDER_ATTACK;
      //diagonal from left to right
      if(i < BOARD_SIZE && j < BOARD_SIZE && board[i][j] != QUEEN)
      {
        board[i][j] = UNDER_ATTACK;
      }
      //diagonal from right to left
      if(i < BOARD_SIZE && l >= 0 && board[l][j] != QUEEN)
      {
        board[l][j] = UNDER_ATTACK;
      }
    }
  }

  private void removeQueen(int row, int column)
  {
    board[row][column] = EMPTY;
  }

  private boolean isUnderAttack(int row, int column) throws Exception
  {
    if(board[row][column] != EMPTY) return true;
    else return false;
  }

  private int index(int number)
  {
    return number-1;
  }
}
