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
    for(int column = 0; column < BOARD_SIZE; ++column)
    {
      for(int row = 0; row < BOARD_SIZE; ++row)
      {
        System.out.print(board[row][column]);
      }
      System.out.print(" ");
    }
  }

  public boolean placeQueens(int column)
  {
    if(column > BOARD_SIZE)
    {
      return true;
    }
    else
    {
      boolean queenPlaced = false;
      int row = 1;
      while(!queenPlaced && (row <= BOARD_SIZE))
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
    for(int j = 1; j <= BOARD_SIZE; j++)
    {
      if(j != column && board[row][j] != QUEEN) board[row][j] = UNDER_ATTACK;
      if(j != row && board[j][column] != QUEEN) board[j][column] = UNDER_ATTACK;
    }
    //set all elements in the diagonal UNDER_ATTACK
    int upRow = row;
    int upColumn = column;
    int downRow = row;
    int downColumn = column;
    while(upRow > 0 && downRow <= BOARD_SIZE && upColumn > 0 && downColumn <= BOARD_SIZE)
    {
      upRow--;
      downRow++;
      upColumn--;
      downColumn--;
      if(board[upRow][upColumn] != QUEEN) board[upRow][upColumn] = UNDER_ATTACK;
      if(board[downRow][downColumn] != QUEEN) board[downRow][downColumn] = UNDER_ATTACK;
    }
  }

  private void removeQueen(int row, int column)
  {
    board[row][column] = EMPTY;
  }

  private boolean isUnderAttack(int row, int column)
  {
    return false;
  }

  private int index(int number)
  {
    return number-1;
  }
}
