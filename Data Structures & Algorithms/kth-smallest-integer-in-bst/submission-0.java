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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode result = new TreeNode(-1);
        preOrderTraversal(root, new TreeNode(k), result);
        return result.val;
    }

    private void preOrderTraversal(TreeNode root, TreeNode k, TreeNode result) {
        if (root == null) {
            return;
        }
        preOrderTraversal(root.left, k, result);
        k.val = k.val-1;
        if(k.val == 0) {
            if(result.val == -1){
                result.val = root.val;
            }
            return;
        }
        preOrderTraversal(root.right, k, result);
    }
}
