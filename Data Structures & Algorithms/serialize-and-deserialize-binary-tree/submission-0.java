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

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode nullNode = new TreeNode();
        queue.offer(getOrNull(root, nullNode));
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != nullNode) {
                sb.append(node.val);
                queue.offer(getOrNull(node.left, nullNode));
                queue.offer(getOrNull(node.right, nullNode));
            }else{
                sb.append("#");
            }
            if(!queue.isEmpty()){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private TreeNode getOrNull(TreeNode actualNode, TreeNode nullNode){
        return (actualNode == null) ? nullNode : actualNode;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String wholeData) {
        if(wholeData.equals("#")) {
            return null;
        }
        String[] data = wholeData.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(data[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int nextIndex = 1;
        while(!queue.isEmpty() && nextIndex < data.length) {

            TreeNode curr = queue.poll();

            //construct left
            if(!data[nextIndex].equals("#")){
                curr.left = new TreeNode(Integer.parseInt(data[nextIndex]));
                queue.offer(curr.left);
            }
            nextIndex++;

            // construct right 
            if(nextIndex < data.length && !data[nextIndex].equals("#")){
                curr.right = new TreeNode(Integer.parseInt(data[nextIndex]));
                queue.offer(curr.right);
            }
            nextIndex++;
        }
        
        return root;
    }

    
}
