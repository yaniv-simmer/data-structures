public class SparseMatrix<T> implements Matrix<T> {

    private final DLinkedList<SparseMatrixEntry> ll;
    private final T defaultValue;
    private final int size;
    private boolean isTransposed;


    public SparseMatrix(T defaultValue) {
        this.defaultValue = defaultValue;
        ll = new DLinkedList<>();
        size = MAX_SIZE;
        isTransposed = false;
    }


    public SparseMatrix(int size, T defaultValue) {
        this.defaultValue = defaultValue;
        ll = new DLinkedList<>();
        this.size = size;
        isTransposed = false;
    }

    /**
     * @param row - number of row
     * @param col - number of column.
     * @return the value in (row,col) entry.
     * @throws IllegalArgumentException if row<1 or col<1 or row>size or col>size.
     */
    @Override
    public T get(int row, int col) {
        if (row > size || col > size || row < 1 || col < 1)
            throw new IllegalArgumentException();
        if (ll.isEmpty()) {
            return defaultValue;
        }
        ll.goToBeginning();
        do {
            if (ll.getCursor().row == row && ll.getCursor().col == col && !isTransposed) {
                return ll.getCursor().value;
            }
            if (ll.getCursor().row == col && ll.getCursor().col == row && isTransposed) {
                return ll.getCursor().value;
            }
        } while (ll.getNext() != null);
        return defaultValue;
    }

    /**
     * @param row     - number of row
     * @param col     - number of column.
     * @param element - element to update
     *                Update the value in (row,col) entry.
     * @throws IllegalArgumentException if row<1 or col<1 or row>size or col>size.
     */
    @Override
    public void set(int row, int col, T element) {
        if (row > size || col > size || row < 1 || col < 1)
            throw new IllegalArgumentException();

        SparseMatrixEntry sm = new SparseMatrixEntry(row, col, element);

        if (ll.isEmpty()) {
            ll.insert(sm);
            return ;
        }
        ll.goToBeginning();
        do {
            if (ll.getCursor().row == row && ll.getCursor().col == col && !isTransposed) {
                ll.replace(sm);
                return ;
            }
            if (ll.getCursor().row == col && ll.getCursor().col == row && isTransposed) {
                ll.replace(sm);
                return ;
            }
        } while (ll.getNext() != null);
        ll.insert(sm);

    }

    /**
     * Transpose the matrix.
     * Bonus of 5 points will be given for implementation in O(1).
     */
    @Override
    public void transpose() {

        isTransposed = !isTransposed;

    }


    private class SparseMatrixEntry {
        private T value;
        private int row;
        private int col;

        public SparseMatrixEntry(int row, int col, T val) {
            this.row = row;
            this.col = col;
            value = val;
        }


        public int getRow() {
            return row;
        }


        public void setRow(int row) {
            this.row = row;
        }


        public int getCol() {
            return col;
        }


        public void setCol(int col) {
            this.col = col;
        }


        public T getValue() {
            return value;
        }


        public void setValue(T newVal) {
            this.value = newVal;
        }


    }

}
