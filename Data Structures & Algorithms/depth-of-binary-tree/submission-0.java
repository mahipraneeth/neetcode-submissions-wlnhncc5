/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        return preFixTraversal(root, 0, 0);
    }

    private int preFixTraversal(TreeNode root, int count, int maxSeen) {
        if(root == null) {
            return Math.max(count, maxSeen);
        }

        int leftMaxSeen = preFixTraversal(root.left, count+1, maxSeen);

        int totalMaxSeen = preFixTraversal(root.right, count+1, leftMaxSeen);

        return totalMaxSeen;
    }
}
