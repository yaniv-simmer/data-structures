package il.ac.telhai.ds.trees;

public class BinaryTree<T> implements BinaryTreeI<T> {

    private BinaryTreeI<T> left;
    private BinaryTreeI<T> right;
    private T key;


    public BinaryTree() {
        this.left = null;
        this.right = null;
        this.key = null;
    }

    public BinaryTree(T key, BinaryTreeI<T> left, BinaryTreeI<T> right) {
        this.left = left;
        this.right = right;
        this.key = key;
    }

    public BinaryTree(T key) {
        this.left = null;
        this.right = null;
        this.key = key;
    }


    /**
     * @return the left subtree
     */
    @Override

    public BinaryTreeI<T> getLeft() {
        return left;
    }

    /**
     * @return the right subtree
     */
    @Override
    public BinaryTreeI<T> getRight() {
        return right;
    }

    /**
     * @return the value in the root
     */
    @Override
    public T getValue() {
        return key;
    }

    /**
     * @param value set the value in the root
     */
    @Override
    public void setValue(T value) {
        key = value;
    }

    /**
     * @param left set the left subtree
     */
    @Override
    public void setLeft(BinaryTreeI<T> left) {
        this.left = left;
    }

    /**
     * @param right set the right subtree
     */
    @Override
    public void setRight(BinaryTreeI<T> right) {
        this.right = right;
    }

    /**
     * @return if it is a leaf or not.
     */
    @Override
    public boolean isLeaf() {
        return (right == null && left == null);
    }

    /**
     * @return the height of the tree, i.e. the length of a longest path starting
     * from the root.
     */
    @Override
    public int height() {
        if (isLeaf())
            return 0;
        if (left == null)
            return right.height() + 1;
        if (right == null)
            return left.height() + 1;


        return Math.max(left.height(), right.height()) + 1;

    }

    /**
     * @return the number of nodes in the tree
     */
    @Override
    public int size() {
        if (isLeaf())
            return 1;
        if (left == null)
            return right.size() + 1;
        if (right == null)
            return left.size() + 1;
        return left.size() + right.size() + 1;
    }

    /**
     * clears all the tree except its root.
     */
    @Override
    public void clear() {
        left = null;
        right = null;
    }

    /**
     * @return the concatenation of the string representations of the data values in
     * the tree traversed in preorder fashion, where adding a " " before and
     * a " " after each value in the tree.
     */
    @Override
    public String preOrder() {
        return preOrder(" ", " ");
    }

    /**
     * @param separationBeforeVal
     * @param separationAfterVal
     * @return the concatenation of the string representations of the data values in
     * the tree traversed in preorder fashion, where adding a
     * "separationBeforeVal" before each value and a
     * "separationAfterVal" after each value in the tree.
     */
    @Override
    public String preOrder(String separationBeforeVal, String separationAfterVal) {
        StringBuilder res = new StringBuilder();
        res.append(separationBeforeVal).append(key.toString()).append(separationAfterVal);

        if (isLeaf())
            return separationBeforeVal + key.toString() + separationAfterVal;


        if (left != null)
            res.append(left.preOrder(separationBeforeVal, separationAfterVal));

        if (right != null)
            res.append(right.preOrder(separationBeforeVal, separationAfterVal));
        return res.toString();

    }


    /**
     * @return the concatenation of the string representations of the data values in
     * the tree traversed in inorder fashion, where adding a " " before and
     * a " " after each value in the tree.
     */
    @Override
    public String inOrder() {
        return inOrder(" ", " ");
    }

    /**
     * @param separationBeforeVal
     * @param separationAfterVal
     * @return the concatenation of the string representations of the data values in
     * the tree traversed in inorder fashion, where adding a
     * "separationBeforeVal" before each value and a
     * "separationAfterVal" after each value in the tree.
     */
    @Override
    public String inOrder(String separationBeforeVal, String separationAfterVal) {
        StringBuilder res = new StringBuilder();

        if (isLeaf())
            return separationBeforeVal + key.toString() + separationAfterVal;
        if (left != null)
            res.append(left.inOrder(separationBeforeVal, separationAfterVal));

        res.append(separationBeforeVal).append(key.toString()).append(separationAfterVal);

        if (right != null)
            res.append(right.inOrder(separationBeforeVal, separationAfterVal));

        return res.toString();
    }

    /**
     * @return the concatenation of the string representations of the data values in
     * the tree traversed in postorder fashion, where adding a " " before
     * and a " " after each value in the tree.
     */
    @Override
    public String postOrder() {
        return postOrder(" ", " ");
    }

    /**
     * @param separationBeforeVal
     * @param separationAfterVal
     * @return the concatenation of the string representations of the data values in
     * the tree traversed in postorder fashion, where adding a
     * "separationBeforeVal" before each value and a
     * "separationAfterVal" after each value in the tree.
     */
    @Override
    public String postOrder(String separationBeforeVal, String separationAfterVal) {
        StringBuilder res = new StringBuilder();
        if (isLeaf())
            return separationBeforeVal + key.toString() + separationAfterVal;
        if (left != null)
            res.append(left.postOrder(separationBeforeVal, separationAfterVal));
        if (right != null)
            res.append(right.postOrder(separationBeforeVal, separationAfterVal));
        res.append(separationBeforeVal).append(key.toString()).append(separationAfterVal);

        return res.toString();
    }
}
