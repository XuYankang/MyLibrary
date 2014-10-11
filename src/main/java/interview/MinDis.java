package interview;

import java.util.ArrayList;

/**
 * Created by jacob on 14-10-10.
 */
public class MinDis {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(0,0));
        points.add(new Point(0,1));
        points.add(new Point(1,0));
        int dis = new MinDis().minDis(points);
        System.out.println(dis);
    }

    int minDis(ArrayList<Point> points) {
        if (points.size() < 3) {
            return -1;
        }

        int xStart = points.get(0).x, xEnd = points.get(0).x, yStart = points.get(0).y, yEnd = points.get(0).y;
        for (Point point : points) {
            if (point.x < xStart) {
                xStart = point.x;
            }
            if (point.x > xEnd) {
                xEnd = point.x;
            }
            if (point.y < yStart) {
                yStart = point.y;
            }
            if (point.y > yEnd) {
                yEnd = point.y;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) {
                int dis = 0;
                Point now = new Point(i, j);
                for (int k = 0; k < points.size(); k++) {
                    dis += dis(now, points.get(k));
                }
                min = Math.min(dis, min);

            }
        }
        return min;

    }

    int dis(Point A, Point B) {
        return Math.abs(A.x - B.x) + Math.abs(A.y - B.y);
    }

}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}