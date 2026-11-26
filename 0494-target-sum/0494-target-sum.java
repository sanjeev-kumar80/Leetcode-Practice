class Solution {
    static HashMap<String,Integer> map;
    public int findTargetSumWays(int[] arr, int target) {
        map=new HashMap<>();
       
        return helper(0,target,arr);
    }

    private static int helper(int idx,int target,int [] arr){
        if(idx==arr.length){
            if(target==0){
                return 1;
            }
        }
        if(idx>=arr.length){
            return 0;
        }
        String key=idx+","+target;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int take=helper(idx+1,target-arr[idx],arr);
        int no=helper(idx+1,target+arr[idx],arr);
        map.put(key,take+no);
        return map.get(key);
    }
}