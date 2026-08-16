class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ll=new ArrayList<>();
        bfs(root,ll);
        return ll;

    }

    public void bfs(TreeNode root, List<Integer> ll) {

        Queue<TreeNode> q = new LinkedList<>();

        if (root != null)
            q.add(root);

        while (q.size() > 0) {

            
            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode temp = q.remove();

                if(i==size-1) ll.add(temp.val);

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }
        }
    }

}