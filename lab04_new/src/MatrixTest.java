import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class MatrixTest {

    private MatrixFactory<Integer> matrixFactory = new MatrixFactory<Integer>();
    private Matrix<Integer> matrix3;
    private Integer defaultVal;
    private Integer newInstance2;
    private Integer newInstance3;

    private int i = 0;

    public Integer getParameterInstance() {
        return i++;
    }


    @Before
    public void setUp() throws Exception {
        i = 0;
        defaultVal = getParameterInstance();
        newInstance2 = getParameterInstance();
        newInstance3 = getParameterInstance();

        matrix3 = matrixFactory.getMatrix(3, defaultVal);

        if ((defaultVal.equals(newInstance2)) || (defaultVal.equals(newInstance3))
                || (newInstance3.equals(newInstance2))) {
            fail("new instances should be different");
        }
    }

    @Test
    public void testSparseMatrixSize() {
        assertEquals(defaultVal, matrix3.get(1, 2));
        assertEquals(defaultVal, matrix3.get(1, 3));
        assertEquals(defaultVal, matrix3.get(3, 2));
        try {
            matrix3.get(1, 4);
            fail("Should not work");
        } catch (Exception e) {
        }
        try {
            matrix3.get(0, 1);
            fail("Should not work");
        } catch (Exception e) {
        }

        assertEquals(defaultVal, matrix3.get(1, 2));
        assertEquals(defaultVal, matrix3.get(1, 3));
        assertEquals(defaultVal, matrix3.get(3, 2));
        try {
            matrix3.get(1, 4);
            fail("Should not work");
        } catch (Exception e) {
        }
        try {
            matrix3.get(0, 1);
            fail("Should not work");
        } catch (Exception e) {
        }

        Matrix<Integer> matrixDefSize = matrixFactory.getMatrix(defaultVal);
        assertEquals(defaultVal, matrixDefSize.get(1, 2));
        assertEquals(defaultVal, matrixDefSize.get(1, 3));
        assertEquals(defaultVal, matrixDefSize.get(100, 100));
        try {
            matrix3.get(101, 1);
            fail("Should not work");
        } catch (Exception e) {
        }
        try {
            matrix3.get(0, 1);
            fail("Should not work");
        } catch (Exception e) {
        }

    }

    @Test
    public void testGetSet() {
        matrix3.set(1, 1, newInstance2);
        assertEquals(newInstance2, matrix3.get(1, 1));
        assertNotEquals(defaultVal, matrix3.get(1, 1));
        assertEquals(defaultVal, matrix3.get(2, 2));
        matrix3.set(2, 2, newInstance3);
        assertEquals(newInstance2, matrix3.get(1, 1));
        assertNotEquals(defaultVal, matrix3.get(1, 1));
        assertEquals(newInstance3, matrix3.get(2, 2));
        assertNotEquals(defaultVal, matrix3.get(2, 2));
        assertEquals(defaultVal, matrix3.get(3, 3));
        assertEquals(defaultVal, matrix3.get(1, 3));

        matrix3.set(1, 3, defaultVal);
        assertEquals(defaultVal, matrix3.get(1, 3));
        matrix3.set(1, 1, defaultVal);
        assertEquals(defaultVal, matrix3.get(1, 1));

        try {
            matrix3.set(4, 1, newInstance3);
            fail("Should not work");
        } catch (Exception e) {
        }
        try {
            matrix3.set(1, 4, newInstance3);
            fail("Should not work");
        } catch (Exception e) {
        }

    }

    @Test
    public void testTranspose() {
        matrix3.set(1, 1, newInstance2);
        matrix3.set(2, 3, newInstance3);
        matrix3.transpose();

        chackTrans(matrix3);
    }

    private void chackTrans(Matrix<Integer> transM) {
        assertEquals(newInstance2, transM.get(1, 1));
        assertEquals(defaultVal, transM.get(2, 2));
        assertEquals(defaultVal, transM.get(2, 3));
        assertEquals(defaultVal, transM.get(1, 2));
        assertEquals(newInstance3, transM.get(3, 2));
    }

}