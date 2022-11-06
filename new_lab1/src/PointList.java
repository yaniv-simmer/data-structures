import java.awt.Point;

public interface PointList {

	int MAX_SIZE = 100;
	
	void append (Point newPoint); // Adds newPoint to the end of the list, 
	                              // Moves cursor to newPoint
	void clear();                 // Removes all points in the list

	boolean isEmpty();
	boolean isFull();
	
	boolean goToBeginning();      // If list is not empty moves the cursor to the first element of the list
	                              // and returns true. Otherwise, returns false.
	boolean goToEnd();            // If list is not empty moves the cursor to the last element of the list
                                  // and returns true. Otherwise, returns false.
	
	boolean goToNext();           // If the cursor is not in the last element of the list, 
	                              // moves it to the next element and returns true. Otherwise, returns false.
	boolean goToPrior();          // If the cursor is not in the first element of the list, 
                                  // moves it to the previous element and returns true. Otherwise, returns false.
	
	Point getCursor();            // Returns a copy of the point marked by the cursor, and null if the list is empty
	
	String toString();            // Outputs the Points in the list. If the list is empty, outputs "Empty list".
	                              // Intended for debugging purposes only.
}