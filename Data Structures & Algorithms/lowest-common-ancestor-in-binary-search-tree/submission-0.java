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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if((root.val >= p.val && root.val <= q.val) || (root.val >= q.val && root.val <= p.val)){
        return root;
      }

      if(p.val > root.val ){
        root = root.right;
      }else{
        root = root.left;
      }
      return lowestCommonAncestor(root, p, q);
    }
}
