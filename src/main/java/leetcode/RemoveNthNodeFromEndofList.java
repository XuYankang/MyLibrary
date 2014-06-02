package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList solution = new RemoveNthNodeFromEndofList();
        System.out.println(Tool.printLinkNode(solution.removeNthFromEnd(Tool.stringToLinkNode("1 2 3 4"),2)));
    }

    /**
     * Given a linked list, remove the nth node from the end of list and return its head.
     * <p/>
     * For example,
     * <p/>
     * Given linked list: 1->2->3->4->5, and n = 2.
     * <p/>
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     * Given n will always be valid.
     * Try to do this in one pass.
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }
        ListNode first = head;

        while (head != null && n > 0) {
            head = head.next;
            n--;
        }
        if (n != 0) {
            return first;
        }

        ListNode cur = new ListNode(0);
        cur.next = first;
        while (head != null) {
            head = head.next;
            cur = cur.next;
        }
        //remove cur
        if (cur.next == first) {
            return cur.next.next;
        } else {
            cur.next = cur.next.next;
            return first;
        }

    }
}
