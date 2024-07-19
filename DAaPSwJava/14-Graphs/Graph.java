import java.util.Vector;
import java.util.TreeMap;
class Graph
{
  private int numVertices;
  private int numEdges;

  private Vector<TreeMap<Integer, Integer>> adjList;

  public Graph (int n)
  {
    numVertices = n;
    numEdges = 0;

    adjList = new Vector<TreeMap<Integer, Integer>>();
    for(int i=0; i<numVertices; i++)
    {
      adjList.add(new TreeMap<Integer, Integer>());
    }
  }

  public int getNumVertices()
  {
    return numVertices;
  }

  public int getNumEdges()
  {
    return numEdges;
  }

  public int getEdgeWeight(Integer v, Integer w)
  {
    return adjList.get(v).get(w);
  }

  public void addEdge(Integer v, Integer w, int wgt)
  {
    adjList.get(v).put(w, wgt);
    adjList.get(w).put(v, wgt);
    numEdges++;
  }

  public void addEdge(Edge e)
  {
    Integer v = e.getV();
    Integer w = e.getW();
    int weight = e.getWeight();
    addEdge(v,w,weight);
  }

  public void removeEdge(Edge e)
  {
    Integer v = e.getV();
    Integer w = e.getW();

    adjList.get(v).remove(w);
    adjList.get(w).remove(v);

    numEdges--;
  }

  public Edge findEdge(Integer v, Integer w)
  {
    int wgt = adjList.get(v).get(w);
    return new Edge(v,w,wgt);
  }

  TreeMap<Integer, Integer> getAdjList(Integer v)
  {
    return adjList.get(v);
  }
}
