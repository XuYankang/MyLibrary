package interview.amazon;

import java.util.ArrayList;

/**
 * Created by jacob on 14-10-9.
 */
public class P1 {
    public static void main(String[] args) {
        System.out.println(getClosestCommonAncestor(16, 10));
    }

    static int getClosestCommonAncestor(int node1, int node2) {
        ArrayList<Long> starts = new ArrayList<Long>();
        starts.add(0L);
        long t = 1;
        long pre = 0;
        for (; t < Integer.MAX_VALUE; t *= 3) {
            starts.add(pre + t);
            pre = pre + t;
        }
        //%2==0 front %2==1 back
        int x = 2;
        getParent(starts, x);

        long node1Parent = node1, node2Parent = node2;
        while (node1Parent != node2Parent) {
            if (node1Parent < node2Parent) {
                node2Parent = getParent(starts, node2Parent);
            }else{
                node1Parent = getParent(starts, node1Parent);
            }
        }
        if (node1 == node1Parent) {
            return (int) getParent(starts, node1);
        } else {
            return (int) node1Parent;
        }

    }

    private static long getParent(ArrayList<Long> starts, long x) {
        if (x == 0) {
            return 0;
        }

        int level = 0;
        for (int i = 0; i < starts.size(); i++) {
            if (x >= starts.get(i)) {
                level = i;
            }
        }
        long fromStart = (x - starts.get(level)) / 3;
        long parentStart = starts.get(level - 1);
        long parentSize = starts.get(level) - starts.get(level - 1);
        long parent = 0;
        if (level % 2 == 1) {
            //reverse
            parent = parentStart + (parentSize - 1 - fromStart);
        } else {
            parent = parentStart + (parentSize - 1 - fromStart);
        }

        return parent;
    }
}
