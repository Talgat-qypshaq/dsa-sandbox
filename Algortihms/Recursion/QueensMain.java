public class QueensMain
{
  public static void main(String [] args) throws Exception
  {
    Queens q = new Queens();
    q.clearBoard();
    q.placeQueens(0);
    q.displayBoard();
  }
}
