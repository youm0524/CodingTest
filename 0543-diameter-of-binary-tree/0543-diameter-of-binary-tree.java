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
    int answer;
    public int dfs(TreeNode root){
        if(root == null)return -1;
        int leftsum = dfs(root.left);
        int rightsum = dfs(root.right);
        answer = Math.max(answer,leftsum+rightsum+2);
        return Math.max(leftsum,rightsum)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return answer;
    }
}