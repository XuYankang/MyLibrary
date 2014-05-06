package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2014/5/4.
 */
public class Solution0505 {

    public static void main(String[] args) {
        Solution0505 solution = new Solution0505();
//        int[] x = {1, 2, 2};
//        TreeNode five = new TreeNode(5);
//        TreeNode seven = new TreeNode(2);
//        TreeNode two = new TreeNode(7);
//        TreeNode eleven = new TreeNode(11);
//        TreeNode four = new TreeNode(4);
//
//        seven.left = null;
//        seven.right = null;
//        two.left = null;
//        two.right = null;
//        eleven.left = seven;
//        eleven.right = two;
//        four.left = eleven;
//        four.right = null;
//        five.left = four;
//        five.right = null;
//        System.out.println(solution.hasPathSum(five, 22));
        ListNode one = new ListNode(1);
        // ListNode two = new ListNode(2);
        //ListNode three = new ListNode(3);
        //ListNode four = new ListNode(4);
        //one.next = two;
        //two.next = three;
        //three.next=four;
        TreeNode node = solution.sortedListToBST(one);
        System.out.println(solution.generate(5));

    }


    public ArrayList<ArrayList<Integer>> subsets(int[] S) {

        if (S == null) {
            return null;
        }

        Arrays.sort(S);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < S.length; i++) {
            for (ArrayList<Integer> t : temp) {
                ArrayList<Integer> newT = new ArrayList<Integer>(t);
                newT.add(S[i]);
                result.add(newT);
            }

            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(S[i]);
            result.add(single);

            temp = new ArrayList<ArrayList<Integer>>(result);

        }
        result.add(new ArrayList<Integer>());

        return result;


    }

    /**
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
     * adding up all the values along the path equals the given sum.
     * <p/>
     * For example:
     * Given the below binary tree and sum = 22,
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean result1 = false;
        boolean result2 = false;
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null) {
            result1 = hasPathSum(root.left, sum - root.val);
        }
        if (root.right != null) {
            result2 = hasPathSum(root.right, sum - root.val);
        }
        return result1 || result2;
    }

    /**
     * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = findMid(head, null);
        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBSTNode(head, mid);
        node.right = sortedListToBSTNode(mid.next, null);
        return node;
    }

    public TreeNode sortedListToBSTNode(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        if (head.next == tail) {
            return new TreeNode(head.val);
        }

        ListNode mid = findMid(head, tail);
        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBSTNode(head, mid);
        node.right = sortedListToBSTNode(mid.next, tail);

        return node;
    }


    private ListNode findMid(ListNode head, ListNode tail) {


        ListNode stepOne = head;
        //stepOne.next = head.next;
        ListNode stepTwo = head;
        // stepTwo.next = head.next;
        while (stepTwo.next != tail) {
            stepTwo = stepTwo.next;
            if (stepTwo.next != tail) {
                stepTwo = stepTwo.next;
            } else {
                break;
            }
            stepOne = stepOne.next;
        }
        return stepOne;
    }

    /**
     * Given numRows, generate the first numRows of Pascal's triangle.
     * <p/>
     * For example, given numRows = 5,
     * Return
     * <p/>
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     *
     * @param numRows
     * @return
     */
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows < 1) {
            return result;
        }
        if (numRows >= 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            result.add(list);
        }
        if (numRows >= 2) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(1);
            result.add(list);
        }
        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            for (int j = 1; j <= i - 1; j++) {
                list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }

}


