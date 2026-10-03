class Solution {
    public int totalFruit(int[] arr) {
        int i=0;
        int j=0;
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();

        while(j<arr.length){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            
            while(map.size()>2){
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i])==0){
                    map.remove(arr[i]);
                }
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
       
}

// class Solution {
//     public int totalFruit(int[] arr) {
//         int max=0;
//         for(int i=0;i<arr.length;i++){
//             Set <Integer> set=new HashSet<>();

//             for(int j=i;j<arr.length;j++){
//                 set.add(arr[j]);

//                 if(set.size()>2){
//                     break;
//                 }
//                 max=Math.max(max,j-i+1);
//             }
//         }
//         return max;
//     }
// }