package leetcode;

import leetcode.base.Interval;

import java.util.ArrayList;

/**
 * Created by Jacob on 2014/5/6.
 */
public class InsertInterval {

    public static void main(String[] args) {
        InsertInterval solution = new InsertInterval();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(8, 9));
        //intervals.add(new Interval(6, 7));
        //intervals.add(new Interval(8, 10));
        //intervals.add(new Interval(12, 16));
        System.out.println(solution.insert(intervals, new Interval(6, 7)));
    }

    /**
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
     * <p/>
     * You may assume that the intervals were initially sorted according to their start times.
     * <p/>
     * Example 1:
     * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
     * <p/>
     * Example 2:
     * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
     * <p/>
     * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {


        ArrayList<Interval> result = new ArrayList<Interval>();

        Interval last = newInterval;
        for (Interval in : intervals) {
            ArrayList<Interval> t = merge(last, in);
            if (t.size() == 1) {
                last = t.get(0);
            } else {
                result.add(t.get(0));
                last = t.get(1);
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


}
