class Solution {
    public int height(TreeNode root){
        if(root==null ) return 0;

        return 1+Math.max(height(root.left),height(root.right));
    }

    public void helper1(TreeNode root,List<Integer> ll,int i){
        if (root == null)
            return;
        if (i== 1) {
            ll.add(root.val);
            return;
        }
        helper1(root.left,ll, i - 1);
        helper1(root.right,ll, i - 1);
    }

    public void helper2(TreeNode root,List<Integer> ll,int i){
        if (root == null)
            return;

        if (i == 1) {
            ll.add(root.val);
            return;
        }
        helper2(root.right,ll, i - 1);
        helper2(root.left,ll, i - 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();

        for(int i=1;i<=height(root);i++){
            List<Integer> ll=new ArrayList<>();
            // it follow the 1 base indexing
            // if the level is the even number that time preoder work 
            // if the level is the odd number level that time postorder work
            if(i%2==1) helper1(root,ll,i);
            else helper2(root,ll,i);
            ans.add(ll);
        }
        return ans;
    }
}