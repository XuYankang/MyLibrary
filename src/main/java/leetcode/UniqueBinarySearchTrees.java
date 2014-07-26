package leetcode;

/**
 * Created by Jacob on 2014/5/6.
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        UniqueBinarySearchTrees solution = new UniqueBinarySearchTrees();
        System.out.println(solution.numTrees(0));
    }

    /**
     * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
     * <p/>
     * For example,
     * Given n = 3, there are a total of 5 unique BST's.
     * <p/>
     * 1         3     3      2      1
     * \       /     /      / \      \
     * 3     2     1      1   3      2
     * /     /       \                 \
     * 2     1         2                 3
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {

        if (n == 0) return 0;
        int[] record = new int[n + 1];
        record[0] = 1;
        record[1] = 1;


        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                int left = j - 1;
                int right = i - j;
                count += (record[left] * record[right]);
            }
            record[i] = count;
        }
        return record[n];


    }


}
