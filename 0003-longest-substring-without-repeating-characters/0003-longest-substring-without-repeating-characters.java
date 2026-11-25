class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map=new HashMap<>();
        int i=0,j=0;
        int max=0;

        while(j<s.length()){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.get(ch)>1){
                char c=s.charAt(i);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    map.remove(c);
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
//     public int lengthOfLongestSubstring(String s) {
//         int max=0;

//         for(int i=0;i<s.length();i++){
//             Set <Character> set=new HashSet<>();
//             for(int j=i;j<s.length();j++){
//                 char ch=s.charAt(j);
//                 if(set.contains(ch)){
//                     break;
//                 }
//                 set.add(ch);
//                 max=Math.max(max,j-i+1);
//             }
//         }
//         return max;
//     }
// }