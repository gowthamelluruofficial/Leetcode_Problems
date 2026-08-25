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
    public void helper(TreeNode root, List<String> ans, List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        if(root.left==null && root.right==null){
            List<Integer> a = new ArrayList<>(res);
            int n = a.size();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<n; i++){
                if(i!=0) sb.append("->");
                sb.append(a.get(i)+""); 
            }
            ans.add(sb.toString());
            res.remove(res.size()-1);
            return;
        }
        helper(root.left,ans,res);
        helper(root.right,ans,res);
        res.remove(res.size()-1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(root,ans,res);
        return ans;
    }
}