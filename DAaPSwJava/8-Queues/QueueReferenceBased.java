public class QueueReferenceBased implements QueueInterface
{
  private Node lastNode;

  public QueueReferenceBased()
  {
    lastNode = null;
  }

  public boolean isEmpty()
  {
    return lastNode == null;
  }

  public void dequeueAll()
  {
    lastNode = null;
  }

  public void enqueue(Object newItem)
  {
    Node newNode = new Node(newItem);
    if(isEmpty())
    {
      newNode.next = newNode;
    }
    else
    {
      newNode.next = lastNode.next;
      lastNode.next = newNode;
    }
    lastNode = newNode;
  }

  public Object dequeue() throws QueueException
  {
    if(!isEmpty())
    {
      Node firstNode = lastNode.next;
      if(firstNode == lastNode)
      {
        lastNode = null;
      }
      else
      {
        lastNode.next = firstNode.next;
      }
      return firstNode.item;
    }
    else
    {
      throw new QueueException("QueueException on dequeue: queue empty");
    }
  }

  public Object peek() throws QueueException
  {
    if(!isEmpty())
    {
      Node firstNode = lastNode.next;
      return firstNode.item;
    }
    else
    {
      throw new QueueException("QueueException on peek: queue empty");
    }
  }

}
