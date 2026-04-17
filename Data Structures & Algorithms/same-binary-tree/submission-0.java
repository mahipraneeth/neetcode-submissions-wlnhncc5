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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preOrderTraversalComparision(p,q);
    }

    private boolean preOrderTraversalComparision(TreeNode n1, TreeNode n2){
        if(n1 == null && n2==null) {
            return true;
        }
        else if((n1 == null || n2 == null) || (n1.val != n2.val)){
            return false;
        }

        if(!preOrderTraversalComparision(n1.left, n2.left)){
            return false;
        }

        if(!preOrderTraversalComparision(n1.right, n2.right)){
            return false;
        }
        
        return true;
    }
}
