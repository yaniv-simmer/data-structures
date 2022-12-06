package il.ac.telhai.ds.trees;

public interface BinaryTreeI<T> {

	/**
	 * @return the left subtree
	 */
	public BinaryTreeI<T> getLeft();

	/**
	 * @return the right subtree
	 */
	public BinaryTreeI<T> getRight();

	/**
	 * @return the value in the root
	 */
	public T getValue();

	/**
	 * @param value
	 *            set the value in the root
	 */
	public void setValue(T value);

	/**
	 * @param left
	 *            set the left subtree
	 */
	public void setLeft(BinaryTreeI<T> left);

	/**
	 * @param right
	 *            set the right subtree
	 */
	public void setRight(BinaryTreeI<T> right);

	/**
	 * @return if it is a leaf or not.
	 */
	public boolean isLeaf();

	/**
	 * @return the height of the tree, i.e. the length of a longest path starting
	 *         from the root.
	 */
	public int height();

	/**
	 * @return the number of nodes in the tree
	 */
	public int size();

	/**
	 * clears all the tree except its root.
	 */
	public void clear();

	/**
	 * @return the concatenation of the string representations of the data values in
	 *         the tree traversed in preorder fashion, where adding a " " before and
	 *         a " " after each value in the tree.
	 */
	public String preOrder();

	/**
	 * @return the concatenation of the string representations of the data values in
	 *         the tree traversed in preorder fashion, where adding a
	 *         "separationBeforeVal" before each value and a
	 *         "separationAfterVal" after each value in the tree.
	 */
	public String preOrder(String separationBeforeVal, String separationAfterVal);

	/**
	 * @return the concatenation of the string representations of the data values in
	 *         the tree traversed in inorder fashion, where adding a " " before and
	 *         a " " after each value in the tree.
	 */
	public String inOrder();

	/**
	 * @return the concatenation of the string representations of the data values in
	 *         the tree traversed in inorder fashion, where adding a
	 *         "separationBeforeVal" before each value and a
	 *         "separationAfterVal" after each value in the tree.
	 */
	public String inOrder(String separationBeforeVal, String separationAfterVal);

	/**
	 * @return the concatenation of the string representations of the data values in
	 *         the tree traversed in postorder fashion, where adding a " " before
	 *         and a " " after each value in the tree.
	 */
	public String postOrder();

	/**
	 * @return the concatenation of the string representations of the data values in
	 *         the tree traversed in postorder fashion, where adding a
	 *         "separationBeforeVal" before each value and a
	 *         "separationAfterVal" after each value in the tree.
	 */
	public String postOrder(String separationBeforeVal, String separationAfterVal);

}
