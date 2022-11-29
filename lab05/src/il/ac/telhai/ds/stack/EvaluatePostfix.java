package il.ac.telhai.ds.stack;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

import static java.lang.System.exit;

public class EvaluatePostfix {

    private static StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(System.in));
    private static Stack<Double> myStack = new DLinkedListStack<Double>();

    public static void main(String[] args) throws IOException {
        tokenizer.slashSlashComments(false);
        tokenizer.ordinaryChar('/');

        //TODO add your code here.
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) //While not the end of file
        {
            if (tokenizer.ttype == StreamTokenizer.TT_WORD)
                if (tokenizer.sval.equals("quit")) break;


            if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) { //Number
                myStack.push(tokenizer.nval);
            } else {
                char c = (char) tokenizer.ttype;
                if (c != '+' && c != '-' && c != '*' && c != '/') {

                    System.err.println(tokenizer);
                    System.err.println(myStack);
                    exit(1);
                }
                if (myStack.isEmpty()) {
                    System.err.println(tokenizer);
                    System.err.println(myStack);
                    exit(1);
                }
                double temp1 = myStack.pop();
                if (myStack.isEmpty()) {
                    System.err.println(tokenizer);
                    System.err.println(myStack);
                    exit(1);
                }
                double temp2 = myStack.pop();

                if (c == '+') {
                    myStack.push(temp1 + temp2);
                }
                if (c == '-') {
                    myStack.push(temp2 - temp1);
                }
                if (c == '*') {
                    myStack.push(temp1 * temp2);
                }
                if (c == '/') {
                    myStack.push(temp1 / temp2);
                }
            }

        }


        if (myStack.isEmpty()) {
            System.err.println(tokenizer);
            System.err.println(myStack);
            System.exit(1);
        }
        double final_res = myStack.pop();
        if (!myStack.isEmpty()) {
            System.err.println(tokenizer);
            System.err.println(myStack);
            System.exit(1);
        }
        System.out.println(final_res);

    }
}
