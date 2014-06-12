package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class PartitionList {

    public static void main(String[] args) {
        PartitionList solution = new PartitionList();
        System.out.println(Tool.printLinkNode(solution.partition(Tool.stringToLinkNode("1 4 3 2 5 2"), 3)));
    }

    /**
     * Given a linked list and a value x, partition it such that all nodes less than x
     * come before nodes greater than or equal to x.
     * <p/>
     * You should preserve the original relative order of the nodes in each of the two partitions.
     * <p/>
     * For example,
     * Given 1->4->3->2->5->2 and x = 3,
     * return 1->2->2->4->3->5.
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = head2.next;
        cur2.next = null;
        return head1.next;
    }


}
