package il.ac.telhai.ds.trees;

public class BinarySearchTree<T extends Comparable<T>> {

    BstNode root;
    int size;

    // Binary Search Tree Node
    class BstNode {
        T val;
        BstNode left, right;

        public BstNode(T val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public enum Direction {
        LEFT, RIGHT
    }

    // Returns the val given a path from the root.
    // Used for testing. DO NOT DELETE.
    public T getValInPath(Direction... direction) {
        BstNode node = root;
        for (Direction d : direction) {
            if (d.equals(Direction.LEFT) && node.left != null)
                node = node.left;
            else if (d.equals(Direction.RIGHT) && node.right != null)
                node = node.right;
            else
                return null;
        }
        return node.val;
    }

    /**
     * Constructs an empty BinarySearchTree.
     */
    public BinarySearchTree() {
        // Complete this code.
        super();
        root = null;
        size = 0;
    }

    /**
     * returns the number of elements in the tree
     */
    public int size() {
        // Complete this code.
        return size;
    }

    /**
     * Adds the object value to the tree as a leaf according to the parameter.
     *
     * @param val
     * @return True, if the element was added. Otherwise false.
     */
    public boolean add(T val) {
        // Complete this code.
        if (contains(val)) {
            return false;
        }
        root = addNode(val, root);
        size++;
        return true;
    }

    private BstNode addNode(T val, BstNode nroot) {

        if (nroot == null) {
            nroot = new BstNode(val);
            return nroot;
        }

        if (nroot.val.compareTo(val) > 0) {
            nroot.left = addNode(val, nroot.left);
        } else {
            nroot.right = addNode(val, nroot.right);
        }
        return nroot;

    }


    /**
     * Removes the object in the tree which is equal to the parameter.
     * Nothing is done if not found
     *
     * @param val: the object to be looked for in the tree
     * @return True, if the element was removed. Otherwise false.
     */
    public boolean remove(T val) {
        // Complete this code.
        if (!contains(val))
            return false;
        removeNode(val, root);
        size--;
        return true;
    }

    private void removeNode(T nval, BstNode nroot) {

        if (nroot.val == nval) {
            BstNode following_number = nroot.right;
            while (following_number.left != null) {
                following_number = following_number.left;
            }
            T temp = nroot.val;
            nroot.val = following_number.val;
            following_number.val = temp;
            deleteNode(temp, nroot);
            return;

        }
        if (nroot.right != null) {
            if (nroot.right.val.compareTo(nval) == 0) {
                deleteNode(nval, nroot);
                return;
            }
        }
        if (nroot.left != null) {
            if (nroot.left.val.compareTo(nval) == 0) {
                deleteNode(nval, nroot);
                return;
            }
        }
        if (nroot.val.compareTo(nval) > 0) {
            if (nroot.left != null) {
                removeNode(nval, nroot.left);
            }
            return;
        }
        if (nroot.val.compareTo(nval) < 0) {
            if (nroot.right != null) {
                removeNode(nval, nroot.right);
            }
        }

    }

    private void deleteNode(T nval, BstNode nroot) {

        if (nroot.left != null && nroot.left.val.compareTo(nval) == 0) {
            if (nroot.left.val.compareTo(nval) == 0) {
                if (nroot.left.left == null && nroot.left.right == null) {
                    nroot.left = null;
                }
                if (nroot.left != null && nroot.left.left == null) {
                    nroot.left = nroot.left.right;
                }
                if (nroot.left != null) {
                    if (nroot.left.left != null && nroot.left.right == null) {
                        nroot.left = nroot.left.left;
                    } else {
                        //find the following_number
                        BstNode following_number = nroot.left.right;
                        while (following_number.left != null) {
                            following_number = following_number.left;
                        }
                        T temp = nroot.left.val;
                        nroot.left.val = following_number.val;
                        following_number.val = temp;
                        deleteNode(temp, nroot);
                    }
                }
            }
        } else if (nroot.right != null && nroot.right.val.compareTo(nval) == 0) {
            if (nroot.right.val.compareTo(nval) == 0) {
                if (nroot.right.left == null && nroot.right.right == null) {
                    nroot.right = null;
                } else if (nroot.right.left == null) {
                    nroot.right = nroot.right.right;
                } else if (nroot.right.right == null) {
                    nroot.right = nroot.right.left;
                } else {
                    //find the following_number
                    BstNode following_number = nroot.right.right;
                    while (following_number.left != null) {
                        following_number = following_number.left;
                    }
                    T temp = nroot.right.val;
                    nroot.right.val = following_number.val;
                    following_number.val = temp;
                    deleteNode(temp, nroot);
                }

            }
        }


    }


    /**
     * Looks for an object which is equal to the parameter.
     *
     * @param val: the object to be looked for in the tree
     * @return true if the tree contains this object. Otherwise, return false.
     */
    public boolean contains(T val) {
        // Complete this code.
        return containsRec(val, root);
    }

    private boolean containsRec(T val, BstNode root) {
        if (root == null)
            return false;
        if (root.val.compareTo(val) == 0)
            return true;
        if (root.val.compareTo(val) > 0) {
            return containsRec(val, root.left);
        } else {
            return containsRec(val, root.right);
        }

    }


    /**
     * Looks for the minimal object in the tree, which is greater than or equal to
     * the parameter.
     *
     * @param val: the object to be looked for in the tree
     * @return a reference to the found object.
     */
    public T findGe(T val) {
        if (contains(val)) return val;
        T res;

        if (root.val.compareTo(val) > 0) {
            if (root.left == null) return root.val;
            res = findGeREc(val, root.left);
            if (res.compareTo(val) < 0) return root.val;
        } else {
            if (root.right == null) return null;
            res = findGeREc(val, root.right);
            if (res.compareTo(val) < 0) return null;
        }
        return res;


    }

    private T findGeREc(T val, BstNode nroot) {


        if (nroot.left != null)
            if (findGeREc(val, nroot.left).compareTo(val) > 0)
                return findGeREc(val, nroot.left);
        if (nroot.right != null)
            if (findGeREc(val, nroot.right).compareTo(val) > 0)
                return findGeREc(val, nroot.right);


        return nroot.val;

    }


}
