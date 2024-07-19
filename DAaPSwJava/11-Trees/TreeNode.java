class TreeNode <T>
{
  T item;
  TreeNode<T> leftChild;
  TreeNode<T> rightChild;

  public TreeNode(T newItem)
  {
    item = newItem;
    leftChild = null;
    rightChild = null;
  }

  public TreeNode(T newItem, TreeNode<T> left, TreeNode<T> right)
  {
    item = newItem;
    leftChild = left;
    rightChild = right;
  }
}
