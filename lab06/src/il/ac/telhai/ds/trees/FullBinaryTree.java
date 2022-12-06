package il.ac.telhai.ds.trees;

public class FullBinaryTree<T> extends BinaryTree<T> {


    public FullBinaryTree(T key, BinaryTreeI<T> left, BinaryTreeI<T> right) {
        super(key, left, right);

        if (left == null && right == null)
            return;
        if (left == null || right == null)
            throw new RuntimeException();

    }

    public FullBinaryTree(T key) {

        super(key);
    }

    /**
     * @param left set the left subtree
     */
    @Override
    public void setLeft(BinaryTreeI<T> left) {
        if (left == null && this.getRight() == null)
            return;
        if ((this.getRight() == null && left != null) || !(left instanceof FullBinaryTree<T>))
            throw new RuntimeException();
        super.setLeft(left);
    }

    @Override
    public void setRight(BinaryTreeI<T> right) {

        if (right == null && this.getLeft() == null)
            return;


        if ((this.getLeft() == null && right != null) || !(right instanceof FullBinaryTree<T>))
            throw new RuntimeException();
        super.setRight(right);
    }

}