package leetcode;

import java.util.ArrayList;

/**
 * Created by Jacob on 2014/5/6.
 */
public class MergekSortedLists {

    public static void main(String[] args) {
        MergekSortedLists solution = new MergekSortedLists();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = three;
        two.next = four;
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        list.add(one);
        list.add(two);
        System.out.println(solution.mergeKLists(list));
    }

    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }

        ListNode head = new ListNode(0);
        ListNode result = head;
        while (true) {
            int nullCount = 0;
            ListNode min = null;
            int minValue = Integer.MAX_VALUE;
            int minI = 0;

            for (int i = 0; i < lists.size(); i++) {
                ListNode cur = lists.get(i);
                if (cur == null) {
                    nullCount++;
                } else {
                    if ( minValue > cur.val) {
                        minValue = cur.val;
                        min = cur;
                        minI = i;
                    }
                }
            }
            if (nullCount == lists.size()) {
                break;
            }
            head.next = min;
            head = head.next;
            lists.set(minI, min.next);

        }


        return result.next;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
