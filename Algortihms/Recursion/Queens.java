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

  }

  public void displayBoard()
  {

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

  }

  private void removeQueen(int row, int column)
  {

  }

  private boolean isUnderAttack(int row, int column)
  {
    return false;
  }

  private int index(int number)
  {
    return -1;
  }
}
