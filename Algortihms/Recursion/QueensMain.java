public class QueensMain
{
  public static void main(String [] args)
  {
    Queens q = new Queens();
    q.clearBoard();
    q.placeQueens(0);
    q.displayBoard();
  }
}
