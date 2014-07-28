package leetcode;

/**
 * Created by Administrator on 2014/7/28.
 */
public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
//        one.next = two;
//        two.next = three;
//        three.next = two;
        LinkedListCycle solution = new LinkedListCycle();
        System.out.println(solution.hasCycle(one));
    }

    /**
     * Given a linked list, determine if it has a cycle in it.
     * <p/>
     * Follow up:
     * Can you solve it without using extra space?
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode second = head;
        while (head != null && second != null) {
            head = head.next;
            second = second.next;
            if (second != null) {
                second = second.next;
            }
            if (head == second) {
                return true;
            }
        }
        return false;

    }
}
