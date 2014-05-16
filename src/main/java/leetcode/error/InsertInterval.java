package leetcode.error;

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
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }
        if (newInterval.start > intervals.get(intervals.size() - 1).end) {
            intervals.add(newInterval);
            return intervals;
        }
        Interval last = intervals.get(0);
        boolean merged = false;
        for (int i = 0; i < intervals.size(); i++) {
            Interval in = intervals.get(i);
            if (newInterval.start >= in.start && newInterval.end <= in.end) {
                result.add(in);
                newInterval = in;
            } else if (newInterval.start > in.end) {
                result.add(in);
            } else if (newInterval.end < in.start) {

                if (merged) {
                    result.add(newInterval);
                    merged = false;
                }
                result.add(in);
            } else {
                newInterval = merge(newInterval, in);
                merged = true;
            }
        }
        if (merged) {
            result.add(newInterval);
        }
        return result;

    }


    public Interval merge(Interval x, Interval y) {
        Interval small, big;
        if (x.start < y.start) {
            small = x;
            big = y;
        } else {
            small = y;
            big = x;
        }
        if (big.end < small.end) {
            return small;
        } else {
            Interval interval = new Interval(small.start, big.end);
            return interval;
        }

    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
