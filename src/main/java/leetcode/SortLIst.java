package leetcode;

/**
 * Created by jacob on 14-8-16.
 */
public class SortLIst {


    public static void main(String[] args) {
        ListNode list = Tool.stringToLinkNode("4 2 5 13 2 99");

        SortLIst sortList = new SortLIst();

//        ListNode first = Tool.stringToLinkNode("5 6");
//        ListNode second = Tool.stringToLinkNode("1 2");
//        ListNode result1 = sortList.merge(first, second);
//        System.out.println(Tool.printLinkNode(result1));

        ListNode result = sortList.sortList(list);
        System.out.println(Tool.printLinkNode(result));
    }

    private ListNode merge(ListNode first, ListNode second) {

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (first != null && second != null) {
            if (first.val < second.val) {
                cur.next = first;
                first = first.next;
                cur = cur.next;
            } else {
                cur.next = second;
                second = second.next;
                cur = cur.next;
            }
        }
        while (first != null) {
            cur.next = first;
            first = first.next;
            cur = cur.next;
        }
        while (second != null) {
            cur.next = second;
            second = second.next;
            cur = cur.next;
        }

        return head.next;
    }


    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode cur = head;

        ListNode mid = head;

        if (cur.next == null) {
            return cur;
        }


        while (mid.next != null && cur.next.next != null) {
            cur = cur.next.next;
            mid = mid.next;
            if (cur.next == null) {
                break;
            }
        }

        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);


    }


}
