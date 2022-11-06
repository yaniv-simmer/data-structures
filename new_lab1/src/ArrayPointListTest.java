import java.io.*;
import java.awt.Point;

public class ArrayPointListTest {

	public static void main(String args[]) throws IOException {
		PointList polygon = new ArrayPointList();  		// Set of vertices for a polygon
		Point vertex;
		// Initialize reader and tokenizer for the input stream
		// for reading 'tokens' (namely point values) input from the keyboard.
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);
		// Use the tokenizer's nextToken( ) method to step through a stream of tokens.
		// Use the tokenizer's instance variable nval to obtain the number read.
		// Since nval is of type double, cast it to an int when reading points x and y (int)tokens.nval
		// Read in the polygon's vertices.
		// Keep reading as long as word (not number!) has not been entered
		System.out.print("Enter the polygon's vertices (end with abc) : ");
		while ((tokens.nextToken()) != StreamTokenizer.TT_WORD){
			vertex = new Point(); 
			vertex.x = (int)tokens.nval;    
			tokens.nextToken();
			vertex.y = (int)tokens.nval;    
			polygon.append(vertex);    
		}
		// Output the vertices one per line.
		if (polygon.goToBeginning()) { 
			do {       
				vertex = (Point) polygon.getCursor();
				System.out.println("(" + vertex.x + "," + vertex.y + ")");
			} while (polygon.goToNext());
		}
	}

}
