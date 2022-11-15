public class DiagonalMatrix implements Matrix {

    private final int MAX_SIZE = 100;
    private double[] arr;
    private final int size;
    private int isTransposed;

    // Initializes a size*size  diagonal matrix using an array of length 2*size-1.
    DiagonalMatrix(int size) {
        if (size <= 0 || size > MAX_SIZE) {
            throw new RuntimeException();
        }
        this.size = size;
        isTransposed = 1;
        arr = new double[2 * size - 1];
    }

    DiagonalMatrix() {
        size = MAX_SIZE;
        arr = new double[MAX_SIZE];
        isTransposed = 1;
    }

    @Override
    public double get(int i, int j) {
        if (i <= 0 || j <= 0 || i > size || j > size) {
            throw new RuntimeException();
        }
        int coordinate = (i - j) * isTransposed;


        if (coordinate <= 0) {
            return arr[-(coordinate)];
        } else {
            return arr[(coordinate + ((2 * size - 1) / 2))];
        }
    }

    @Override
    public void set(int i, int j, double x) {
        if (i <= 0 || j <= 0 || i > size || j > size) {
            throw new RuntimeException();
        }
        int coordinate = (i - j) * isTransposed;

        if (coordinate <= 0) {
            arr[-(coordinate)] = x;
        } else {
            arr[(coordinate + ((2 * size - 1) / 2))] = x;
        }
    }

    @Override
    public void transpose() {
        isTransposed *= -1;
    }

    @Override
    public Matrix getTranspose() {
        DiagonalMatrix mat = new DiagonalMatrix(size);
        mat.arr = arr;
        mat.isTransposed = isTransposed;
        mat.transpose();
        return mat;



    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                str = str.concat(String.valueOf(this.get(i, j)));
                if (j != size)
                    str = str.concat("\t");
            }
            str = str.concat("\n");

        }
        return str;
    }
}
