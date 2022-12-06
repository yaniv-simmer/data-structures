package il.ac.telhai.ds.trees;

import java.io.IOException;
import java.io.StreamTokenizer;

public class ExpressionTree extends FullBinaryTree<String> {

    public ExpressionTree(String key, BinaryTreeI<String> left, BinaryTreeI<String> right) {
        super(key, left, right);
    }

    public ExpressionTree(String key) {
        super(key);
    }

    /*
     * Read the stream tokenizer until EOF and construct
     *  the expression tree corresponding to it.
     * The input contains a prefix expression.
     */
    public static ExpressionTree createTree(StreamTokenizer tokenizer) throws IOException {

        if (tokenizer.nextToken() == StreamTokenizer.TT_EOF) {
            return null;
        }

        if (tokenizer.ttype == StreamTokenizer.TT_WORD)
            if (tokenizer.sval.equals("q")) return null;

        String temp;
        if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
            temp = Integer.toString((int) tokenizer.nval);
        } else {
            char c = (char) tokenizer.ttype;

            temp = Character.toString(c);
        }
        ExpressionTree res = new ExpressionTree(temp);

        if (tokenizer.ttype != StreamTokenizer.TT_NUMBER) { //operator
            res = new ExpressionTree(temp, createTree(tokenizer), createTree(tokenizer));
            //createTree(tokenizer);
        } else { //number
            return res;
        }
        return res;
    }

    /*
     * Returns the infix expression corresponding to the current tree (*)
     */
    public String infix() {
        return inOrder("(", ")");
    }

    @Override
    public String inOrder(String separationBeforeVal, String separationAfterVal) {
        StringBuilder res = new StringBuilder();
        if (isLeaf())
            return getValue();
        if (getLeft() != null)
            res.append(getLeft().inOrder(separationBeforeVal, separationAfterVal)).append(" ");
        res.append(getValue());
        if (getRight() != null)
            res.append(" ").append(getRight().inOrder(separationBeforeVal, separationAfterVal));
        return separationBeforeVal + res + separationAfterVal;
    }


    /*
     * Returns the prefix expression corresponding to the current tree (*)
     */
    public String prefix() {
        return preOrder();
    }

    /*
     * Evaluates the expression corresponding to the current tree
     * and returns its value
     */
    public double evaluate() {

        if (isLeaf())
            return Double.parseDouble(getValue());
        else {
            if (getValue().equals("+"))
                return getLeft().evaluate() + getRight().evaluate();
            if (getValue().equals("-"))
                return getLeft().evaluate() - getRight().evaluate();
            if (getValue().equals("*"))
                return getLeft().evaluate() * getRight().evaluate();

            return getLeft().evaluate() / getRight().evaluate();
        }
    }

    @Override
    public ExpressionTree getRight() {
        return (ExpressionTree) super.getRight();
    }

    @Override
    public ExpressionTree getLeft() {
        return (ExpressionTree) super.getLeft();
    }
}

