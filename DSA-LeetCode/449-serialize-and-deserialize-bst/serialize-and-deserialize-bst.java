/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return sb.toString();

    }

    private void helper(TreeNode root , StringBuilder sb){
        if(root==null){
            
            sb.append('#');
            sb.append(',');
            return;
        }
        sb.append(root.val);
        sb.append(',');
        helper(root.left,sb);
        helper(root.right,sb);
    }

    private TreeNode helper(String str[] , int index[]){
        if(index[0] >= str.length)return null;
        String currStr=str[index[0]];
        index[0]++;
        if(currStr.isEmpty()){
            currStr=str[index[0]];
            index[0]++;
        }
        if(currStr.charAt(0)=='#')return null;
        int val=help(currStr);
        TreeNode curr=new TreeNode(val);
        curr.left=helper(str,index);
        curr.right=helper(str,index);
        return curr;
        
    }

    public int help(String str){
        int n=0;
        for(int i= 0 ; i < str.length();i++){
            n*=10;
            n+=str.charAt(i)-'0';
        }
        return n;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String str[]=data.split(",");
      return  helper(str,new int[]{0});
    }


}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;