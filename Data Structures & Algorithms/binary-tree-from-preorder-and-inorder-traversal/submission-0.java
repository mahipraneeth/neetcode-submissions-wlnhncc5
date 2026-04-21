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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inOrderIndexMap.put(inorder[i], i);
        }
        return buildTreeRecursive(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, inOrderIndexMap);
    }

    private TreeNode buildTreeRecursive(int[] preorder, int[] inorder, int preOrderStart,
        int preOrderEnd, int inOrderStart, int inOrderEnd, Map<Integer, Integer> inOrderIndexMap) {
            if(preOrderStart>preOrderEnd || inOrderStart>inOrderEnd){
                return null;
            }

            TreeNode root = new TreeNode(preorder[preOrderStart]);
            int inOrderIndex = inOrderIndexMap.get(root.val);

            // left side construction
            int newInOrderEnd = inOrderIndex-1;
            int newPreOrderStart =  preOrderStart+1;
            int newPreOrderEnd = preOrderStart + (inOrderIndex - inOrderStart);

            TreeNode leftNode = buildTreeRecursive(preorder, inorder, newPreOrderStart, newPreOrderEnd, inOrderStart, newPreOrderEnd, inOrderIndexMap);

            // right side Construction

            int newInOrderStart = inOrderIndex+1;
            newPreOrderStart = preOrderStart + (inOrderIndex - inOrderStart) + 1;

            TreeNode rightNode = buildTreeRecursive(preorder, inorder, newPreOrderStart, preOrderEnd, newInOrderStart, inOrderEnd, inOrderIndexMap);


            //set both left and right

            root.left = leftNode;
            root.right = rightNode;

            return root;

    }
}
