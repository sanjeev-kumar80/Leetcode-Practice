
class Solution {

    int sum=0;
    public int sumNumbers(TreeNode root) {
        helper(root,"");
        return sum;
        
    }
    public void helper(TreeNode root,String str){


        if(root==null)  return ;

        str=str+root.val;

        if(root.left==null && root.right==null) {
            sum+=Integer.parseInt(str);
        }

        helper(root.left,str);
        helper(root.right,str);
    }
}