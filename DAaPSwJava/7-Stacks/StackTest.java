public class StackTest
{
  public static final int MAX_ITEMS = 15;
  public static void main(String[] args)
  {
    StackArrayBased stack = new StackArrayBased();
    Integer items[] = new Integer[MAX_ITEMS];

    for(int i=0; i<MAX_ITEMS; i++)
    {
      items[i] = Integer.valueOf(i);
      if(!stack.isFull())
      {
        stack.push(items[i]);
      }
    }

    while(!stack.isEmpty())
    {
      System.out.println((Integer)(stack.pop()));
    }

  }
}
