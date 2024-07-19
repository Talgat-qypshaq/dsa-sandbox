public interface QueueInterface
{
  public boolean isEmpty();
  public void enqueue(Object newItem) throws QueueException;
  public Object dequeue() throws QueueException;
  public void dequeueAll();
  public Object peek() throws QueueException;
}
