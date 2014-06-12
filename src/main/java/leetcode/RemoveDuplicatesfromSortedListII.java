package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedListII solution = new RemoveDuplicatesfromSortedListII();
        System.out.println(Tool.printLinkNode(solution.deleteDuplicates(Tool.stringToLinkNode("1 1 1 2 3 3"))));
    }

    /**
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     * <p/>
     * For example,
     * Given 1->2->3->3->4->4->5, return 1->2->5.
     * Given 1->1->1->2->3, return 2->3.
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = new ListNode(0);
        ListNode result = pre;
        while (cur != null) {

            boolean dup = false;
            //循环的作用是，跳过多个相同的元素，例如1->1->2 变为 1->2，并记录是否是dup
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
                dup = true;
            }

            if (dup) {
                //如果是dup，pre.next = cur.next不能省略，因为有可能cur.next是null，如果漏掉的话，pre.next是cur，
                //会输出尾部的重复元素。
                //cur指针下移
                pre.next = cur.next;
                cur = cur.next;
            } else {
                //此时，应该记录结果路径
                pre.next = cur;
                cur = cur.next;
                pre = pre.next;
            }
        }
        return result.next;

    }


}
