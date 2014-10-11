package test;

/**
 * Created by jacob on 14-9-23.
 */
public class ReverseLink {
    class Node {
        int x;
        Node next;
    }

    public static void main(String[] args) {
        new ReverseLink().reverse();
    }

    private void reverse() {
        Node node1 = new Node();
        node1.x = 1;
        Node node2 = new Node();
        node2.x = 2;
        Node node3 = new Node();
        node3.x = 3;
        node1.next = node2;
        node2.next = node3;
        doReverse(node1);
    }

    private Node doReverse(Node node1) {
        Node cur = node1;
        Node pre = null;
        while (cur.next != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return cur;
    }
}
