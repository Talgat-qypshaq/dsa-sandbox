import java.util.Stack;

public class TestStack
{
  public static void main(String[] args)
  {
    Stack<Integer> aStack = new Stack<Integer>();
    for(int i = 0; i < 5; i++)
    {
      aStack.push(i);
    }

    int a = aStack.search(3);
    System.out.println("search result: "+a);  

    while(!aStack.empty())
    {
      System.out.print(aStack.pop()+" ");
    }

    System.out.println();

    int b = aStack.search(3);
    System.out.print("search result: "+b);
    System.out.println();
  }
}
