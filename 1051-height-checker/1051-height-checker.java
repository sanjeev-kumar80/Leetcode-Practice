class Solution {
    public int heightChecker(int[] arr) {
        int n=arr.length;
        int [] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=arr[i];
        }
        Arrays.sort(arr);
        int count=0;
        for(int i=0;i<n;i++){
            if(ans[i]!=arr[i]) count++;
        }
        return count ;

    }
}