import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class PointListCommandLine {

    public static void main(String[] args) throws IOException {
        PointList polygon = new ArrayPointList();  		// Set of vertices for a polygon

        InputStreamReader reader = new InputStreamReader(System.in);
        StreamTokenizer tokens = new StreamTokenizer(reader);

        while (true){
            tokens.nextToken();
            if (tokens.sval.equals("quit"))
                break;

            switch (tokens.sval) {
                case "add" -> {
                    tokens.nextToken();
                    int x = (int) tokens.nval;
                    tokens.nextToken();
                    int y = (int) tokens.nval;
                    Point p = new Point(x, y);
                    polygon.append(p);
                }
                case "curr" -> System.out.println("(" + polygon.getCursor().x
                        + ", " + polygon.getCursor().y + ")");
                case "next" -> System.out.println(polygon.goToNext());
                case "prev" -> System.out.println(polygon.goToPrior());
                case "start" -> System.out.println(polygon.goToBeginning());
                case "end" -> System.out.println(polygon.goToEnd());
                case "empty" -> System.out.println(polygon.isEmpty());
                case "full" -> System.out.println(polygon.isEmpty());
                case "clear" -> polygon.clear();
            }


        }

    }

}