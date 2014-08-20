package leetcode;

/**
 * Created by jacob on 14-8-17.
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode list = Tool.stringToLinkNode("1 2 3 4 5");
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(list);
        System.out.println(Tool.printLinkNode(list));
    }

    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     * <p/>
     * You must do this in-place without altering the nodes' values.
     * <p/>
     * For example,
     * Given {1,2,3,4}, reorder it to {1,4,2,3}.
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        //find mid
        if (head == null || head.next == null) {
            return;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode midPre = head;
        while (p1.next != null && (p2.next != null && p2.next.next != null)) {
            p1 = p1.next;
            midPre = p1;
            p2 = p2.next.next;

        }
        //reverse mid -> end
        p1 = p1.next;
        ListNode cur = p1.next;

        midPre.next = null;
        p1.next = null;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = p1;
            p1 = cur;
            cur = t;
        }
        //now p1 is the head, do merge
        ListNode p = head;
        while (p != null && p1 != null) {
            ListNode A = p.next;
            ListNode B = p1.next;
            p.next = p1;
            p1.next = A;
            p = A;
            p1 = B;
        }


    }
}
