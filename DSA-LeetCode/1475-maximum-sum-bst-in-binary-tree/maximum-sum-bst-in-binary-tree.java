class Solution {
    // A global variable to track the maximum sum found anywhere
    int maxSum = 0;

    class info {
        boolean isbst;
        int sum;
        int max;
        int min;

        info(boolean isbst, int sum, int max, int min) {
            this.isbst = isbst;
            this.sum = sum;
            this.max = max;
            this.min = min;
        }
    }

    public info help(TreeNode root) {
        if(root == null) {
            // Empty tree is a valid BST. 
            // max = -infinity, min = +infinity so it doesn't break parent's checks
            return new info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        info l = help(root.left);
        info r = help(root.right);

        // 1. If BOTH children are valid BSTs
        if(l.isbst && r.isbst) {
            // Check if current node maintains the BST property
            if(l.max < root.val && root.val < r.min) {
                int currSum = l.sum + r.sum + root.val;
                maxSum = Math.max(maxSum, currSum);

                // Max is either root, or right's max. Min is either root, or left's min.
                int currMax = Math.max(root.val, r.max);
                int currMin = Math.min(root.val, l.min);

                return new info(true, currSum, currMax, currMin);
            } else {
                // ❌ Current node VIOLATES BST property
                // It is NOT a BST, but we must pass up the correct max/min and the best sum.
                int bestSum = Math.max(l.sum, r.sum);
                int currMax = Math.max(root.val, Math.max(l.max, r.max));
                int currMin = Math.min(root.val, Math.min(l.min, r.min));
                
                return new info(false, bestSum, currMax, currMin);
            }
        } 
        
        // 2. If at least one child is NOT a valid BST
        // The whole subtree is NOT a BST. 
        // We pass up the best sum found so far, and the correct max/min bounds.
        int bestSum = Math.max(l.sum, r.sum);
        int currMax = Math.max(root.val, Math.max(l.max, r.max));
        int currMin = Math.min(root.val, Math.min(l.min, r.min));
        
        return new info(false, bestSum, currMax, currMin);
    }

    public int maxSumBST(TreeNode root) {
        help(root);
        return maxSum;
    }
}