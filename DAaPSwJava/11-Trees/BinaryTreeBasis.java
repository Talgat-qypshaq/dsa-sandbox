public abstract class BinaryTreeBasis<T>
{
  protected TreeNode<T> root;

  public BinaryTreeBasis()
  {
    root = null;
  }

  public BinaryTreeBasis(T rootItem)
  {
    root = new TreeNode<T>(rootItem, null, null);
  }

  public boolean isEmpty()
  {
    return root == null;
  }

  public void makeEmpty()
  {
    root = null;
  }

  public T getRootItem() throws TreeException
  {
    if(root == null)
    {
      throw new TreeException("TreeException: Empty Tree");
    }
    else
      return root.item;
  }

  public abstract void setRootItem(T newItem);
}
