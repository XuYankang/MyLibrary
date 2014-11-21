package jp.co.worksap.global;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Orienteering {

    private static int[] directionX = {0, 1, 0, -1};
    private static int[] directionY = {-1, 0, 1, 0};
    private static int w = 0;
    private static int h = 0;
    private static ArrayList<Point> checkPoints = null;
    private static char[][] map = null;
    private static Set<Status> visited = null;
    private static Queue<Status> queue = null;

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine();
            w = Integer.parseInt(line.split(" ")[0]);
            h = Integer.parseInt(line.split(" ")[1]);
            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Point start = new Point();
        Point goal = new Point();
        checkPoints = new ArrayList<Point>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'S') {
                    start.i = i;
                    start.j = j;
                }
                if (map[i][j] == 'G') {
                    goal.i = i;
                    goal.j = j;
                }
                if (map[i][j] == '@') {
                    checkPoints.add(new Point(i, j));
                }
            }
        }

        visited = new TreeSet<Status>();

        int initVisitedStatus = (1 << checkPoints.size()) - 1;
        Status initStatus = new Status(start.i, start.j, initVisitedStatus, 0, null);
        Status goalStatus = new Status(goal.i, goal.j, 0, 0, null);

        visited.add(initStatus);

        queue = new LinkedList<Status>();
        queue.add(initStatus);

        Status resultStatus = null;

        while (!queue.isEmpty()) {
            Status status = queue.poll();
            if (status.equals(goalStatus) && queue.isEmpty()) {
                resultStatus = status;
                System.out.println();
                break;
            }
//            int visitedStatus = status.visited;
//            if (map[status.i][status.j] == '@') {
//                Point p = new Point(status.i, status.j);
//                int checkPointIndex = checkPoints.indexOf(p);
//                if ((status.visited & (1 << checkPointIndex)) == (1 << checkPointIndex)) {
//                    visitedStatus = status.visited ^ (1 << checkPointIndex);
//                }
//            }
//            status.visited = visitedStatus;


            visited.add(status);
            ArrayList<Status> availableDirection = findAvailableDirection(status, visited);
            queue.addAll(availableDirection);
        }
        if (resultStatus != null) {
            System.out.println(resultStatus.level);
        } else {
            System.out.println(-1);
        }


    }

    private static ArrayList<Status> findAvailableDirection(Status point, Set<Status> visited) {
        ArrayList<Status> result = new ArrayList<Status>();
        for (int t = 0; t < 4; t++) {
            Point newPoint = new Point(point.i + directionX[t], point.j + directionY[t]);
            if (!boarderCheck(newPoint)) {
                continue;
            }

            if (map[newPoint.i][newPoint.j] == '.' || map[newPoint.i][newPoint.j] == '@' || map[newPoint.i][newPoint.j] == 'S' || map[newPoint.i][newPoint.j] == 'G') {
                if (map[newPoint.i][newPoint.j] == '@') {
                    int checkPointIndex = checkPoints.indexOf(newPoint);
                    int visitedStatus = 0;
                    if ((point.visited & (1 << checkPointIndex)) == 1) {
                        visitedStatus = point.visited ^ (1 << checkPointIndex);
                    }
                    Status status = new Status(newPoint.i, newPoint.j, visitedStatus, point.level + 1, point);
                    if (!visited.contains(status)) {
                        result.add(status);
                    }
                } else {
                    Status status = new Status(newPoint.i, newPoint.j, point.visited, point.level + 1, point);
                    if (!visited.contains(status)) {
                        result.add(status);
                    }
                }
            }
        }
        return result;
    }

    private static boolean boarderCheck(Point point) {
        return point.i >= 0 && point.j >= 0 && point.i < w && point.i < h;
    }
}

class Point {
    int i;
    int j;

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return p.i == i && p.j == j;
    }

    Point() {
    }

    Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "Point{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}

class Status implements Comparable<Status> {
    int i;
    int j;
    int visited;
    int level;
    Status parent;

    Status(int i, int j, int visited, int level, Status parent) {
        this.i = i;
        this.j = j;
        this.visited = visited;
        this.level = level;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        Status status = (Status) obj;
        return i == status.i && j == status.j && visited == status.visited;
    }


    @Override
    public int compareTo(Status o) {
        return i > o.i ? 1 : (i < o.i ? -1 : (j > o.j ? 1 : (j < o.j ? -1 : (visited > o.visited ? 1 : (visited < o.visited ? -1 : 0)))));
    }

    @Override
    public String toString() {
        return "Status{" +
                "i=" + i +
                ", j=" + j +
                ", visited=" + visited +
                ", level=" + level +
                ", parent=" + parent +
                '}';
    }
}