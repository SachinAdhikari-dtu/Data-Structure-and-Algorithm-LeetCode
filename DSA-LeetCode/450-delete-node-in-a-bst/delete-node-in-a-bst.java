class Solution {
    public int min(TreeNode root) {
       if(root == null) return Integer.MIN_VALUE;
       int val = root.val;
       val = Math.max(val, min(root.left));
       val = Math.max(val, min(root.right));
       return val;
    }

    public TreeNode helper(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val == key) {
            // 1. Leaf node
            if(root.left == null && root.right == null) {
                return null;
            }
            // 2. Only right child
            else if(root.left == null && root.right != null) {
                return root.right;
            }
            // 3. Only left child
            else if(root.left != null && root.right == null) {
                return root.left;
            }
            // 4. Two children
            else {
                int val = min(root.left); // Find the minimum in the left subtree
                root.val = val;           // Replace current value with the minimum
                root.left = helper(root.left, val); // ✅ Delete the duplicate minimum node from the left subtree
                return root;
            }
        } else {
            // ✅ Fixed Search Logic
            if(root.val > key) {
                root.left = helper(root.left, key); // Go left and update connection
            } else {
                root.right = helper(root.right, key); // Go right and update connection
            }
            return root;
        }
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        return helper(root, key); // ✅ Return the new root directly
    }
}