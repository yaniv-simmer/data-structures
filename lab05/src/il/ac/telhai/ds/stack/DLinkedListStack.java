package il.ac.telhai.ds.stack;

public class DLinkedListStack<T> implements Stack<T> {

    private DLinkedList<T> ll;

    public DLinkedListStack() {
        ll = new DLinkedList<>();
    }

    @Override
    public void push(T t) {
        ll.goToEnd();
        ll.insert(t);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        ll.goToEnd();
        T temp = ll.getCursor();
        ll.remove();
        return temp;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            return null;
        }
        ll.goToEnd();
        return ll.getCursor();

    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder res = new StringBuilder();
        res.append("[");
        ll.goToEnd();
        do{
            res.append(ll.getCursor());
            if(ll.hasPrev()) res.append(", ");
        }while (ll.getPrev()!=null);
        res.append("]");
        return res.toString();
    }
}
