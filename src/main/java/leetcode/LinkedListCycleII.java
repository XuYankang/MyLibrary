package leetcode;

/**
 * Created by jacob on 14-8-20.
 */
public class LinkedListCycleII {


    public static void main(String[] args) {
        //-1,-7,7,-4,19,6,-9,-5,-2,-5
        LinkedListCycleII linkedListCycleII = new LinkedListCycleII();
        ListNode head = Tool.stringToLinkNode("-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5");
        ListNode tail = null;
        ListNode joint = null;
        int i = 0;
        ListNode p1 = head;
        while (p1 != null) {
            i++;
            if (i == 24) {
                joint = p1;
            }
            tail = p1;
            p1 = p1.next;
        }
        tail.next = joint;


        ListNode listNode = linkedListCycleII.detectCycle(head);
        System.out.println(listNode);
    }

    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     * <p/>
     * Follow up:
     * Can you solve it without using extra space?
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //find if exist cycle
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && (p2 != null && p2.next != null)) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                break;
            }
        }

        boolean existCycle = (p1 == p2);
        if (!existCycle) {
            return null;
        }
        p1 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
