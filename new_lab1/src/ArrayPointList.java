import java.awt.*;

public class ArrayPointList implements PointList {

    Point[] pointsArray;
    int size;
    int cursur;

    public ArrayPointList(int size) {
        pointsArray = new Point[size];
        this.size = 0;
        cursur = 0;
    }

    public ArrayPointList() {
        pointsArray = new Point[MAX_SIZE];
        size = 0;
        cursur = 0;
    }

    @Override
    public void append(Point newPoint) {
        if (!isFull()) {
            pointsArray[size] = newPoint;
            cursur = size;
            size++;
        }
    }

    @Override
    public void clear() {
        size = 0;
        cursur = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == pointsArray.length;
    }

    @Override
    public boolean goToBeginning() {
        if (!this.isEmpty()) {
            cursur = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean goToEnd() {
        if (!this.isEmpty()){
            cursur = size-1;
        return true;
    }
        return false;
}

    @Override
    public boolean goToNext() {
        if (!this.isEmpty() && cursur != size-1) {
            cursur++;
            return true;
        }
        return false;
    }


    @Override
    public boolean goToPrior() {
        if (!this.isEmpty()) {
            cursur--;
            return true;
        }
        return false;
    }

    @Override
    public Point getCursor() {
        if (isEmpty()) {
            return null;
        }


        return new Point(pointsArray[cursur].x , pointsArray[cursur].y);

    }
}
