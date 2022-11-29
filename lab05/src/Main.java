import il.ac.telhai.ds.stack.DLinkedListStack;

public class Main {
    public static void main(String[] args) {
        DLinkedListStack<Integer> j= new DLinkedListStack<Integer>();
        j.push(8);
        j.push(34);

        System.out.println(j);
        System.out.println(j.pop());
        System.out.println(j.pop());
    }
}