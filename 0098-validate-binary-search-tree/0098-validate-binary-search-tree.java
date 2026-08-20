class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        helper(root,ll);

        for(int i=1;i<ll.size();i++){
            if(ll.get(i-1)>=ll.get(i)) return false;
        }
        return true;
    }
    public void helper(TreeNode root,List<Integer> ll){
        if(root==null) return ;
        helper(root.left,ll);
        ll.add(root.val);
        helper(root.right,ll);
    }
}