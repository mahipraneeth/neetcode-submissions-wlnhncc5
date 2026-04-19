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
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidNode(TreeNode node, Integer min, Integer max){
        if(node == null){
            return true;
        }
        if(!(node.val < max && node.val > min)){
            return false;
        }

        return isValidNode(node.left, min, node.val) && isValidNode(node.right, node.val, max);
    }
}
