package leetcode;

/**
 * Created by jacob on 14-8-17.
 */
public class InsertionSortList {

    public static void main(String[] args) {
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode result = insertionSortList.insertionSortList(Tool.stringToLinkNode("4 2 1 3"));
        System.out.println(Tool.printLinkNode(result));
    }

    /**
     * Sort a linked list using insertion sort.
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        ListNode cur = head;
        ListNode p = head;
        while (cur != null) {

            p = head;

            ListNode pPre = new ListNode(0);
            pPre.next = p;
            if (head.val > cur.val) {
                head = cur;
            }

            while (p != cur) {

                if (cur.val < p.val) {
                    ListNode curPre = p;
                    while (curPre.next != cur) {
                        curPre = curPre.next;
                    }
                    pPre.next = cur;

                    curPre.next = cur.next;
                    cur.next = p;
                    cur = curPre;
                } else {
                    p = p.next;
                    pPre = pPre.next;
                }
            }
            cur = cur.next;

        }
        return head;

    }
}
