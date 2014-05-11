package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        System.out.println(Tool.printLinkNode(solution.mergeTwoLists(Tool.stringToLinkNode("2"), Tool.stringToLinkNode("1"))));
    }

    /*
    Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode root = new ListNode(0);
        ListNode cur = root;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
        }
        if (l2 != null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return root.next;
    }


    private void swap(int[] a, int pre, int i) {
        int temp = a[pre];
        a[pre] = a[i];
        a[i] = temp;
    }
}
