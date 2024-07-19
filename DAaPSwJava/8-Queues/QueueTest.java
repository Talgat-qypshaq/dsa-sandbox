public class QueueTest
{
  public static void main(String [] args)
  {
    QueueReferenceBased aQueue = new QueueReferenceBased();
    for(int i = 0; i < 9; i++)
    {
      aQueue.enqueue(i);
    }
    for(int i = 0; i < 9; i++)
    {
      System.out.println(aQueue.peek());
    }
    for(int i = 0; i < 9; i++)
    {
      System.out.println(aQueue.dequeue());
    }
  }
}
