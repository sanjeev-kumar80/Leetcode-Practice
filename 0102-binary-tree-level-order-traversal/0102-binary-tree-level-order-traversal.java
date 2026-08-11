class Solution {

    public int height(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return 0;

        return 1+Math.max(height(root.left),height(root.right));
    }

    public void helper(TreeNode root,List<Integer> ll,int i){
        if(root==null) return;

        if(i==1) {
            ll.add(root.val);
            return;
        }
        helper(root.left,ll,i-1);
        helper(root.right,ll,i-1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans=new ArrayList();
        if(root==null) return ans;

        for(int i=1;i<=height(root)+1;i++){
            List<Integer> ll = new ArrayList<>();
            helper(root,ll,i);
            ans.add(ll);

        }
        return ans;
    }
}





