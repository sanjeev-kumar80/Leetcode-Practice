class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        
        // left ma ha to
        if(root==null) return null;

        if(key< root.val){
           root.left= deleteNode(root.left,key);
        }
        else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }
        else{
            if(root.left==null){
                return root.right;
            }

            if(root.right==null){
                return root.left;
            }
             // Case 3: two children
            TreeNode successor = minelement(root.right);

            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    public TreeNode minelement(TreeNode root){

        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}