package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(Tool.stringToLinkNode("9 8"), Tool.stringToLinkNode("1"));
        System.out.println(Tool.printLinkNode(result));
    }

    /**
     * You are given two linked lists representing two non-negative numbers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * <p/>
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overflow = 0;
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while (l1 != null || l2 != null || overflow != 0) {

            int sum = overflow;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum >= 10) {
                sum %= 10;
                overflow = 1;
            } else {
                overflow = 0;
            }
            ListNode node = new ListNode(sum);

            cur.next = node;
            cur = node;
        }


        return head.next;
    }

    private ListNode reverseList(ListNode l1) {

        if (l1 == null || l1.next == null) {
            return l1;
        }
        ListNode pre = l1;

        ListNode cur = pre.next;
        ListNode temp = null;
        pre.next = null;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        cur.next = pre;

        return cur;

    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
