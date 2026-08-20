
class Solution {
    public void helper(TreeNode root,String str,List<String> ll){
        if(root==null) return;
        if(root.left==null && root.right==null){
            str+=root.val;
            ll.add(str);
            return;
        }
        helper(root.left,str+root.val+"->",ll);
        helper(root.right,str+root.val+"->",ll);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ll=new ArrayList<>();
        helper(root,"",ll);
        return ll;
        
    }
}