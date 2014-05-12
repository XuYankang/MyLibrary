package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Jacob on 14-5-10.
 */
public class Tool {

    public static void main(String[] args) {
        System.out.println(Tool.printLinkNode(stringToLinkNode("1,2,3,5")));
    }

    public static void printTree(TreeNode t) {
        if (t == null) {
            System.out.println("Empty Tree");
        }
    }

    public static ListNode stringToLinkNode(String s) {
        if (s.length() == 0) {
            return null;
        }
        String[] ss = s.split(",");
        ListNode root = new ListNode(0);
        ListNode cur = root;
        for (String temp : ss) {
            ListNode ln = new ListNode(Integer.valueOf(temp));
            cur.next = ln;
            cur = cur.next;
        }
        return root.next;
    }

    public static String printLinkNode(ListNode node) {
        if (node == null) {
            return "";
        }
        String result = "";
        while (node != null) {
            result += node.val + "->";
            node = node.next;
        }
        return result.substring(0, result.length() - 2);
    }

    /**
     * OJ's Binary Tree Serialization:
     * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
     * <p/>
     * Here's an example:
     * 1
     * / \
     * 2   3
     * /
     * 4
     * \
     * 5
     * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
     *
     * @param sorce
     */
    public static TreeNode stringToTree(String sorce) {
        String[] node = sorce.split(",");
        if (node.length == 0) {
            return null;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.valueOf(node[0]));
        queue.add(root);
        int index = 1;
        while (index < node.length) {
            TreeNode cur = queue.poll();
            if (!node[index].equals("#")) {
                TreeNode t = new TreeNode(Integer.valueOf(node[index]));
                cur.left = t;
                queue.add(t);
            } else {
                cur.left = null;
            }
            index++;
            if (index < node.length) {
                if (!node[index].equals("#")) {
                    TreeNode t = new TreeNode(Integer.valueOf(node[index]));
                    cur.right = t;
                    queue.add(t);
                } else {
                    cur.right = null;
                }
            }
            index++;
        }
        return root;

    }


}
