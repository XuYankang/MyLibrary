package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class SwapNodesinPairs {

    public static void main(String[] args) {
        SwapNodesinPairs solution = new SwapNodesinPairs();


        System.out.println(Tool.printLinkNode(solution.swapPairs(Tool.stringToLinkNode("1"))));
    }

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * <p/>
     * For example,
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     * <p/>
     * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = cur;
        head = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                return head;
            } else {
                pre.next = next;
                cur.next = next.next;
                next.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }

        return head;


    }

    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
