class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        helper(root,ll);
        return ll;
    }
    public void helper(TreeNode root,List<Integer> ll){
        if(root==null) return ;
        ll.add(root.val);
        helper(root.left,ll);
        helper(root.right,ll); 
    }
}