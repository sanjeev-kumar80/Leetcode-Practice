class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
         if(root==null) return ll;
        helper(root,ll);
        return ll;
    }

    public void helper(TreeNode root,List<Integer>ll){
        if(root==null) return ;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
        int max=-2147483648;
        for(int i=0;i<size;i++){
            TreeNode temp=q.poll();
            max=Math.max(max,temp.val);

            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
        }
        ll.add(max);
        }
    }
}