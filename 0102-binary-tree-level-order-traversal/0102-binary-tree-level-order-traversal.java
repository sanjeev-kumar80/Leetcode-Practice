class Solution {
    public void bfs(TreeNode root, List<List<Integer>> ans) {

        Queue<TreeNode> q = new LinkedList<>();

        if (root != null)
            q.add(root);

        while (q.size() > 0) {

            List<Integer> ll = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode temp = q.remove();

                ll.add(temp.val);

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }

            ans.add(ll);
        }
    }


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
        bfs(root,ans);
        // if(root==null) return ans;

        // for(int i=1;i<=height(root)+1;i++){
        //     List<Integer> ll = new ArrayList<>();
        //     helper(root,ll,i);
        //     ans.add(ll);

        // }
        return ans;
    }
}





