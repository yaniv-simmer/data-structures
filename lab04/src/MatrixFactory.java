import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MatrixFactory<T> {

	/**
	 * @param size
	 * @param defaultVal
	 * @return an instance of Matrix<T> by applying the constructor with on
	 *         parameter (T defaultVal)
	 */
	public Matrix<T> getMatrix(T defaultVal) {
		return getMatrix(-1, defaultVal);
	}

	/**
	 * @param size
	 * @param defaultVal
	 * @return an instance of Matrix<T> by applying the constructor with two
	 *         parameters (ins size, T defaultVal)
	 */
	@SuppressWarnings("unchecked")
	public Matrix<T> getMatrix(int size, T defaultVal) {
		Class<?> c;
		Matrix<T> matrix = null;
		try {
			c = Class.forName("SparseMatrix");
			try {
				Constructor<?>[] constructors = c.getConstructors();
				for (Constructor<?> cons : constructors) {
					if ((size == -1) && (cons.getParameterCount() == 1))
						matrix = (Matrix<T>) cons.newInstance(defaultVal);
					if ((size > 0) && (cons.getParameterCount() == 2))
						matrix = (Matrix<T>) cons.newInstance(size, defaultVal);
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return matrix;
	}

}