import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<TreeNode> sortedNodes = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        // Step 1: Inorder traversal to get sorted values
        inorder(root);
        
        // Step 2: Recursively build balanced BST from sorted list
        return buildBalancedBST(0, sortedNodes.size() - 1);
    }
    
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        sortedNodes.add(node);
        inorder(node.right);
    }
    
    private TreeNode buildBalancedBST(int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode root = sortedNodes.get(mid);
        
        // Recursively build subtrees
        root.left = buildBalancedBST(start, mid - 1);
        root.right = buildBalancedBST(mid + 1, end);
        
        return root;
    }
}