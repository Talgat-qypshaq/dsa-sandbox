import java.util.LinkedList;
public class TreeIterator<T> implements java.util.Iterator<T>
{
  private BinaryTreeBasis<T> binTree;
  private TreeNode<T> currentNode;
  private LinkedList <TreeNode<T>> queue;

  public TreeIterator(BinaryTreeBasis<T> bTree)
  {
    binTree = bTree;
    currentNode = null;
    queue = new LinkedList <TreeNode<T>>();
  }

  public boolean hasNext()
  {
    return !queue.isEmpty();
  }

  public T next() throws java.util.NoSuchElementException
  {
    currentNode = queue.remove();
    return currentNode.item;
  }

  public void remove() throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  }

  public void setPreOrder()
  {
    queue.clear();
    preorder(binTree.root);
  }

  public void setInorder()
  {
    queue.clear();
    inorder(binTree.root);
  }

  public void setPostorder()
  {
    queue.clear();
    postorder(binTree.root);
  }

  private void preorder(TreeNode<T> treeNode)
  {
    if(treeNode != null)
    {
      queue.add(treeNode);
      preorder(treeNode.leftChild);
      preorder(treeNode.rightChild);
    }
  }

  private void inorder(TreeNode<T> treeNode)
  {
    if(treeNode != null)
    {
      inorder(treeNode.leftChild);
      queue.add(treeNode);
      inorder(treeNode.rightChild);
    }
  }

  private void postorder(TreeNode<T> treeNode)
  {
    if(treeNode != null)
    {
      inorder(treeNode.leftChild);
      inorder(treeNode.rightChild);
      queue.add(treeNode);
    }
  }
}
