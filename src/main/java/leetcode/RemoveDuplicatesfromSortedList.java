package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedList solution = new RemoveDuplicatesfromSortedList();
        System.out.println(Tool.printLinkNode(solution.deleteDuplicates(Tool.stringToLinkNode("1 1 1 2 3 3"))));
    }

    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * <p/>
     * For example,
     * Given 1->1->2, return 1->2.
     * Given 1->1->2->3->3, return 1->2->3.
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;

        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
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
