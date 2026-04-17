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
        updateResult(List.of(root), result);
        return result;
    }

    private void updateResult(List<TreeNode> availableNodes, List<List<Integer>> result) {
        while (!availableNodes.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            for (TreeNode levelNode : availableNodes) {
                levelValues.add(levelNode.val);
                if (levelNode.left != null) {
                    nextLevelNodes.add(levelNode.left);
                }
                if (levelNode.right != null) {
                    nextLevelNodes.add(levelNode.right);
                }
            }
            result.add(levelValues);
            if (!nextLevelNodes.isEmpty()) {
                availableNodes = nextLevelNodes;
            }else {
                availableNodes = new ArrayList<>();
            }
        }
    }
}
