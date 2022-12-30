package il.ac.telhai.ds.trees;


import static java.lang.Math.abs;
import static java.lang.Math.max;

public class AVLTree<T extends Comparable<T>> {

    private AVLTree<T> left;
    private AVLTree<T> right;
    private AVLTree<T> dady;      //this is the father
    private final T data;
    private int height;

    public AVLTree(T value) {
        left = null;
        dady = null;
        right = null;
        data = value;
        height = 0;
    }


    //add the value to the tree, and return the updated root of the tree.
    public AVLTree<T> add(T value) {

        //first add the node
        if (data.compareTo(value) > 0) {
            if (left == null) {
                left = new AVLTree<>(value);
                left.dady = this;
            } else left = left.add(value);
        } else {
            if (right == null) {
                right = new AVLTree<>(value);
                right.dady = this;
            } else right = right.add(value);
        }
        postOrderHeightUpdate();

        //now check if the tree is balanced after the add
        String isBalance = checkTypeOfUnbalance();
        switch (isBalance) {
            case "LL" -> {
                LeftLeft();
                return this.dady;
            }
            case "RR" -> {
                RightRight();
                return this.dady;
            }
            case "RL" -> {
                right.LeftLeft();
                RightRight();
                return this.dady;
            }
            case "LR" -> {
                left.RightRight();
                LeftLeft();
                return this.dady;
            }
            default -> {         //tree is balanced
                return this;
            }
        }
    }


    private boolean isLeaf() {
        return (right == null && left == null);
    }


    //update the whole damn tree
    private void postOrderHeightUpdate() {
        if (isLeaf())
            height = 0;
        if (left != null)
            left.postOrderHeightUpdate();
        if (right != null)
            right.postOrderHeightUpdate();
        updateHeight();
    }


    private void RightRight() {
        if (dady != null) {
            if (data.compareTo(dady.getValue()) < 0) {
                dady.left = getRight();
            } else dady.right = getRight();
        } else {
            this.dady = getRight();
            getRight().dady = null;
        }

        AVLTree<T> temp = getRight();
        this.right = getRight().getLeft();
        temp.left = this;
        temp.dady = dady;
        this.dady = temp;
    }

    private void LeftLeft() {
        if (dady != null) {
            if (data.compareTo(dady.getValue()) < 0) {
                dady.left = getLeft();
            } else dady.right = getLeft();
        } else {
            dady = getLeft();
            getLeft().dady = null;
        }

        AVLTree<T> temp = getLeft();
        this.left = getLeft().getRight();
        temp.right = this;
        temp.dady = dady;
        this.dady = temp;
    }

    private String checkTypeOfUnbalance() {

        int leftHeight = (left == null) ? -1 : left.height;
        int rightHeight = (right == null) ? -1 : right.height;
        int diff = leftHeight - rightHeight;

        if (abs(diff) <= 1)
            return ""; //the tree is balanced !

        if (diff > 0) {     //left subtree is bigger then the right one
            int LL_height = (left.left == null) ? -1 : left.left.height;
            int LR_height = (left.right == null) ? -1 : left.right.height;
            if (LL_height > LR_height)
                return "LL";
            else {
                return "LR";
            }
        } else {
            int RR_height = right.right == null ? -1 : right.right.height;
            int RL_height = right.left == null ? -1 : right.left.height;
            if (RR_height > RL_height)
                return "RR";
            else
                return "RL";
        }
    }

    private void updateHeight() {
        if (left != null && right != null)
            height = max(left.height, right.height) + 1;
        if (left != null && right == null)
            height = left.height + 1;
        if (left == null && right != null)
            height = right.height + 1;
    }

    //return the value in this node
    public T getValue() {
        return data;
    }

    //return the left subTree of this node
    public AVLTree<T> getLeft() {
        return left;
    }

    //return the right subTree of this node
    public AVLTree<T> getRight() {
        return right;
    }

}
