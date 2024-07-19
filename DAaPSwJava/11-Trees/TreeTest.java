public class TreeTest
{
  public static void main(String[] args)
  {
    BinaryTree<Integer> tree3 = new BinaryTree<Integer>(70);

    BinaryTree<Integer> tree1 = new BinaryTree<Integer>();
    tree1.setRootItem(40);
    tree1.attachLeft(30);
    tree1.attachRight(50);

    BinaryTree<Integer> tree2 = new BinaryTree<Integer>();
    tree2.setRootItem(20);
    tree2.attachLeft(10);
    tree2.attachRightSubtree(tree1);

    BinaryTree<Integer> binTree = new BinaryTree<Integer>(60, tree2, tree3);

    TreeIterator<Integer> btIterator = new TreeIterator<Integer>(binTree);
    btIterator.setInorder();
    while(btIterator.hasNext())
    {
      System.out.println(btIterator.next());
    }
    System.out.println();
    BinaryTree<Integer> leftTree = binTree.detachLeftSubtree();
    TreeIterator<Integer> leftIterator = new TreeIterator<Integer>(leftTree);
    leftIterator.setInorder();

    while(leftIterator.hasNext())
    {
      System.out.println(leftIterator.next());
    }
    System.out.println();
    btIterator.setInorder();
    while(btIterator.hasNext())
    {
      System.out.println(btIterator.next());
    }
    System.out.println();
  }
}
