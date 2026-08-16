class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ll=new ArrayList<>();

        helper(root,ll);
        return ll;
    }
    public void helper(TreeNode root,List<Integer> ll){
        if(root==null) return ;
        helper(root.left,ll);
        ll.add(root.val);
        helper(root.right,ll);
    }
}