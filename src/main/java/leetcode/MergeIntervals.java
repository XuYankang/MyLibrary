package leetcode;

import com.sun.corba.se.impl.naming.cosnaming.InternalBindingValue;
import leetcode.base.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Jacob on 2014/5/6.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        //intervals.add(new Interval(2, 6));
        //intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        System.out.println(solution.merge(intervals));
    }

    /**
     * Given a collection of intervals, merge all overlapping intervals.
     * <p/>
     * For example,
     * Given [1,3],[2,6],[8,10],[15,18],
     * return [1,6],[8,10],[15,18].
     *
     * @param intervals
     * @return
     */
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        ArrayList<Interval> result = new ArrayList<Interval>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start > o2.start) {
                    return 1;
                } else if (o1.start < o2.start) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            ArrayList<Interval> temp = merge(intervals.get(i), last);
            if (temp.size() == 1) {
                last = temp.get(0);
            } else {
                result.add(temp.get(0));
                last = temp.get(1);
            }
        }
        result.add(last);

        return result;
    }

    public ArrayList<Interval> merge(Interval x, Interval y) {
        Interval small, big;
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (x.start < y.start) {
            small = x;
            big = y;
        } else {
            small = y;
            big = x;
        }

        if (big.start > small.end) {
            //can't merge
            result.add(small);
            result.add(big);
        } else if (big.end < small.end) {
            //big is in small
            result.add(small);
        } else {
            Interval interval = new Interval(small.start, big.end);
            result.add(interval);
        }
        return result;

    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
