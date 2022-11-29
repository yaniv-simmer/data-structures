public class DLinkedList<T> implements List<T> {


    private final DNode head;
    private final DNode tail;
    private DNode cursor;


    public DLinkedList() {
        head = new DNode(null);
        tail = new DNode(null);
        cursor = head;

        head.setNext(tail);
        tail.setNext(head);


    }

    @Override
    public void insert(T newElement) {
        if (newElement == null) {
            throw new RuntimeException();
        }
        DNode newDNode = new DNode(newElement);


        newDNode.setNext(cursor.getNext());
        cursor.getNext().setPrev(newDNode);
        cursor.setNext(newDNode);
        newDNode.setPrev(cursor);
        cursor = newDNode;
    }

    /**
     * Precondition: NONE
     * Postcondition: Removes the element marked by the cursor from the list. If the
     * resulting list is not empty, then moves the cursor to the element that
     * followed the deleted element. If the deleted element was at the end of the
     * list, then moves the cursor to the beginning of the list. Returns the deleted
     * element, or null if the list was empty.
     */
    @Override
    public T remove() {
        if (isEmpty() || cursor == head) {
            return null;
        }
        T element = cursor.getElement();

        cursor.getNext().setPrev(cursor.getPrev());
        cursor.getPrev().setNext(cursor.getNext());
        if (cursor.getNext() == tail) {
            cursor = head;
            return element;
        }


        cursor = cursor.getNext();
        return element;
    }

    /**
     * Precondition: NONE
     * Postcondition: Removes element from the list. Moves the cursor to the element
     * that followed the deleted element. If the deleted element was at the end of
     * the list, then moves the cursor to the beginning of the list. Returns the
     * deleted element, or null if it did not exist in the list.
     * If this element appears several times, removes the first occurrence of it.
     */
    @Override
    public T remove(T element) {

        if (isEmpty()) return null;
        DNode temp = head;
        T e = temp.element;
        while (temp != tail.getPrev() && e != element) {
            temp = temp.getNext();
            e = temp.getElement();
        }
        if (e == element) {
            cursor = temp;
            return remove();
        }
        return null;
    }


    @Override
    public void clear() {
        cursor = head;
        head.setNext(tail);
        tail.setNext(head);
    }

    /**
     * Precondition: List is not empty and newElement is not null.
     * Postcondition: Replaces the element marked by the cursor with newElement. The
     * cursor remains at newElement
     */
    @Override
    public void replace(T newElement) {
        if (isEmpty() || newElement == null) {
            throw new RuntimeException();
        }
        DNode temp = cursor.getPrev();
        remove();
        cursor = temp;
        insert(newElement);
    }

    @Override
    public boolean isEmpty() {
        return head.getNext().equals(tail);
    }

    @Override
    public boolean goToBeginning() {
        if (!isEmpty()) {
            cursor = head.getNext();
            return true;
        }
        return false;


    }

    @Override
    public boolean goToEnd() {
        if (!isEmpty()) {
            cursor = tail.getPrev();
            return true;
        }
        return false;


    }

    @Override
    public T getNext() {
        if (cursor.getNext() == tail || cursor == tail) return null;
        cursor = cursor.getNext();
        return cursor.getElement();
    }

    /**
     * // Precondition: NONE.
     * // Postcondition: If the cursor is not at the beginning of a list, then moves
     * // the cursor to the preceding element and returns it. Otherwise, returns null.
     */
    @Override
    public T getPrev() {

        if (cursor.getPrev() == head || cursor == head) return null;
        cursor = cursor.getPrev();
        return cursor.getElement();
    }

    @Override
    public T getCursor() {
        if (isEmpty()) return null;
        return cursor.getElement();
    }

    @Override
    public boolean hasNext() {
        return (cursor.getNext().getElement() != null);
    }

    @Override
    public boolean hasPrev() {
        if (!isEmpty()) return (cursor.getPrev().getElement() != null);
        return false;
    }


    private class DNode {
        private final T element;
        private DNode next;
        private DNode prev;

        public DNode(T element) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public void setNext(DNode next) {
            this.next = next;
        }

        public DNode getNext() {
            return next;
        }

        public void setPrev(DNode prev) {
            this.prev = prev;
        }

        public DNode getPrev() {
            return prev;
        }
    }
}