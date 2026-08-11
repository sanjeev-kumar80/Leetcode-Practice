class Solution {

    public boolean contain(TreeNode root,TreeNode p){
        if(root == null) return false;
        if(root==p) return true;
        return contain(root.left,p) || contain(root.right,p);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

       if(root==null) return root;

        if(p==q) return p;

        if(p==root || q==root) return root;

        boolean left=contain(root.left,p);
        boolean right=contain(root.left,q);

        if(left && right) return  lowestCommonAncestor(root.left,p,q);

        if(!left && !right) return  lowestCommonAncestor(root.right,p,q);

        return root;
        
    }
}