class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int [] arr,int left,int right){
        if(left>right){
            return null;
        }

        int mid=left+(right-left)/2;

        TreeNode root=new TreeNode(arr[mid]);

        root.left=helper(arr,left,mid-1);

        root.right=helper(arr,mid+1,right);

        return root;
    }
}