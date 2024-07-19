import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.NoSuchElementException;

class BFSIterator implements Iterator<Integer>
{
  private Graph g;
  private int numVertices;
  private int count;

  private int[] mark;
  private int iter;

  public BFSIterator(Graph g)
  {
    this.g=g;
    numVertices=g.getNumVertices();
    mark=new int[numVertices];
    Arrays.fill(mark,0,numVertices,-1);
    count=0;
    iter=-1;
    startSerarch();
  }

  public boolean hasNext()
  {
    return (iter>=0)&&(iter<numVertices);
  }

  public Integer next() throws NoSuchElementException
  {
    if(hasNext())
    {
      return mark[iter++];
    }
    else
    {
      throw new NoSuchElementException();
    }
  }

  public void remove()
  {
    throw new UnsupportedOperationException();
  }

  protected void startSerarch()
  {
    for(int v=0; v<numVertices; v++)
    {
      if(mark[v]==-1)
      {
        search(v);
      }
    }
    iter=0;
  }

  protected void search(Integer vertex)
  {
    LinkedList<Integer> q=new LinkedList<Integer>();
    TreeMap<Integer,Integer> m;
    Set<Integer> connectedVertices;
    Integer v;
    q.add(vertex);
    while(!q.isEmpty())
    {
      v=q.remove();
      if(mark[v]==-1)
      {
        mark[v]=count++;
        m=g.getAdjList(v);
        connectedVertices=m.keySet();
        for(Integer w:connectedVertices)
        {
          if(mark[w]==-1)
          {
            q.add(w);
          }
        }
      }
    }
  }
}
