package il.ac.telhai.ds.trees;


import static java.lang.Math.abs;
import static java.lang.Math.max;

public class AVLTree<T extends Comparable<T>> {

    private AVLTree<T> left;
    private AVLTree<T> right;
    private AVLTree<T> parent;
    private final T data;
    private int height;

    public AVLTree(T value) {
        left = null;
        parent = null;
        right = null;
        data = value;
        height = 0;
    }


    //add the value to the tree, and return the updated root of the tree.
    public AVLTree<T> add(T value) {

        if (data.compareTo(value) > 0) {
            if (left == null) {
                left = new AVLTree<>(value);
                left.parent = this; //////////////////
            } else left = left.add(value);
        } else {
            if (right == null) {
                right = new AVLTree<>(value);
                right.parent = this; ///////////////////
            } else right = right.add(value);
        }

        if (right != null)
            this.right.parent = this;
        if (left != null)
            this.left.parent = this;

        postOrderUpdate();
        if (!isBalance()) {
            String x = checkTypeOfUnBalance(value);
            switch (x) {
                case "LL":
                    LeftLeft();

                    return this.parent;
                case "RR":
                    RightRight();
                    return this.parent;
                case "RL":
                    right.LeftLeft();
                    RightRight();
                    parent.parent = null;
                    return this.parent;
                case "LR":
                    left.RightRight();
                    LeftLeft();
                    parent.parent = null;
                    return this.parent;
            }
        }
        return this;
    }


    private boolean isLeaf() {
        return (right == null && left == null);
    }

    private void postOrderUpdate() {
        if (isLeaf()) {
            height = 0;
            return;
        }
        if (left != null)
            left.postOrderUpdate();
        if (right != null)
            right.postOrderUpdate();
        updateHeight();
        return;
    }


    private void RightRight() {
        if (parent != null) {
            if (this.data.compareTo(parent.getValue()) < 0) {
                parent.left = getRight();
            } else parent.right = getRight();

        } else {
            this.parent = getRight();
            getRight().parent = null;
        }

        AVLTree<T> temp = getRight();
        this.right = getRight().getLeft();
        temp.left = this;
        temp.parent = this.parent;
        this.parent = temp;

    }

    private void LeftLeft() {
        if (parent != null) {
            if (this.data.compareTo(parent.getValue()) < 0) {
                parent.left = getLeft();
            } else parent.right = getLeft();

        } else {
            this.parent = getLeft();
            getLeft().parent = null;
        }

        AVLTree<T> temp = getLeft();
        this.left = getLeft().getRight();
        temp.right = this;
        temp.parent = this.parent;
        this.parent = temp;

    }

    private String checkTypeOfUnBalance(T value) {


        int lefthight = left == null ? -1 : left.height;
        int righthight = right == null ? -1 : right.height;


        int diff = lefthight - righthight;

        if (diff > 0) { //left os bigger then right
            int LLhight = left.left == null ? -1 : left.left.height;
            int LRhight = left.right == null ? -1 : left.right.height;
            if (LLhight > LRhight)
                return "LL";
            else {
                return "LR";
            }
        } else {
            int RRH = right.right == null ? -1 : right.right.height;
            int RLH = right.left == null ? -1 : right.left.height;
            if (RRH > RLH)
                return "RR";
            else
                return "RL";
        }

//        try {
//            if (getRight().getRight().getValue()==value)
//                return "RR";
//        } catch (NullPointerException e) {
//        }
//        try {
//            if (getRight().getLeft().getValue()==value)
//                return "RL";
//        } catch (NullPointerException e) {
//        }
//        try {
//            if (getLeft().getRight().getValue()==value)
//                return "LR";
//        } catch (NullPointerException e) {
//        }
//
//        return "LL";
    }

    private void updateHeight() {
        if (left != null && right != null)
            height = max(left.height, right.height) + 1;
        if (left != null && right == null)
            height = left.height + 1;
        if (left == null && right != null)
            height = right.height + 1;
    }

    private boolean isBalance() {
        if (left != null && right != null)
            return abs(left.height - right.height) <= 1;
        if (left == right)
            return true;

        return left == null ? right.height < 1 : left.height < 1;
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
