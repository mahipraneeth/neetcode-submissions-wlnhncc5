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
        Stack<List<TreeNode>> nodeStack = new Stack<>();
        nodeStack.push(List.of(root));
        updateResult(nodeStack, result);
        return result;
    }

    private void updateResult(Stack<List<TreeNode>> nodeStack, List<List<Integer>> result) {
        while (!nodeStack.isEmpty()) {
            List<TreeNode> levelNodes = nodeStack.pop();
            List<Integer> levelValues = new ArrayList<>();
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            for (TreeNode levelNode : levelNodes) {
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
                nodeStack.push(nextLevelNodes);
            }
        }
    }
}
