import java.util.*;

public class Codec {

    public void helper(StringBuilder arr, TreeNode root){
        if(root == null){
            arr.append("#,");
            return;
        }
        arr.append(root.val).append(",");
        helper(arr, root.left);
        helper(arr, root.right);
    }

    public String serialize(TreeNode root) {
        StringBuilder arr = new StringBuilder();
        helper(arr, root);
        return arr.toString();
    }

    public TreeNode deserialize(String str) {
        int index[] = new int[]{0};
        String arr[] = str.split(",");
        return helper(arr, index);
    }

    public TreeNode helper(String str[], int index[]) {
        if (index[0] >= str.length) return null;
        if (str[index[0]].equals("#")) { // Use .equals for strings
            index[0]++;
            return null;
        }

        // ✅ Fixed: Integer.parseInt
        TreeNode curr = new TreeNode(Integer.parseInt(str[index[0]]));
        index[0]++;
        curr.left = helper(str, index);
        curr.right = helper(str, index);
        return curr;
    }
}