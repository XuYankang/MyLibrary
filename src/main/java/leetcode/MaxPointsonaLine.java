package leetcode;

import java.util.HashMap;

/**
 * Created by Jacob on 2014/5/6.
 */
public class MaxPointsonaLine {

    public static void main(String[] args) {
        MaxPointsonaLine solution = new MaxPointsonaLine();
        System.out.println(3);
    }

    public int maxPoints(Point[] points) {


        if (points.length < 2) {
            return points.length;
        } else {
            //itself
            int result = 1;

            for (int i = 0; i < points.length; i++) {
                HashMap<Double, Integer> count = new HashMap<Double, Integer>();
                int extra = 1;
                int max = 0;

                for (int j = 0; j < points.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        extra++;
                    } else {
                        double inclination = getInclination(points[i], points[j]);
                        if (count.get(inclination) == null) {
                            count.put(inclination, 1);
                        } else {
                            count.put(inclination, count.get(inclination) + 1);
                        }
                    }
                }
                for (Double d : count.keySet()) {
                    if (max < count.get(d)) {
                        max = count.get(d);
                    }
                }
                if (result < extra + max) {
                    result = max + extra;
                }
            }


            return result;
        }
    }

    private double getInclination(Point a, Point b) {
        double result = 0;

        if (b.x - a.x == 0) {
            return Double.MAX_VALUE;
        } else {
            return (double) (b.y - a.y) / (double) (b.x - a.x);
        }
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
