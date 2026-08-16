class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ll=new ArrayList<>();

        helper(root,ll);

        return ll;
    }

    public void helper(TreeNode root,List<Integer> ll){
        if(root==null) return ;

        helper(root.left,ll);
        helper(root.right,ll);
        ll.add(root.val);
    }
}