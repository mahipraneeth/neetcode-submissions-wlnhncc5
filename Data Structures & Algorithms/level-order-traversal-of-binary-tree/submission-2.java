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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        updateResult(treeNodeQueue, result);
        return result;
    }

    private void updateResult(Queue<TreeNode> treeNodeQueue, List<List<Integer>> result) {
        while(!treeNodeQueue.isEmpty()){
            List<Integer> levels = new ArrayList<>();
            int sizeAsOfNow = treeNodeQueue.size();
            for(int i=0; i<sizeAsOfNow; i++){
                TreeNode element = treeNodeQueue.poll();
                levels.add(element.val);
                if(element.left != null){
                    treeNodeQueue.offer(element.left);
                }
                if(element.right != null){
                    treeNodeQueue.offer(element.right);
                }
            }
            result.add(levels);
        }
    }
}
