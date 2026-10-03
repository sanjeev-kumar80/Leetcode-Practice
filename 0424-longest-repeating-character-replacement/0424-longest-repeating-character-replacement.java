class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int max=0;
        int i=0;int j=0;
        int maxcount=0;
        while(j<s.length()){
            char ch=s.charAt(j);

            map.put(ch,map.getOrDefault(ch,0)+1);

            maxcount=Math.max(maxcount,map.get(ch));

            while((j-i+1)-maxcount>k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);

                if(map.get(s.charAt(i))==0){
                    map.remove(s.charAt(i));

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
//     public int characterReplacement(String s, int k) {
//         // HashMap<Character,Integer> map=new HashMap<>();
//         int max=0;

//         for(int i=0;i<s.length();i++){
//             HashMap<Character,Integer> map=new HashMap<>();
//             int mac=0;

//             for(int j=i;j<s.length();j++){

//                 char ch=s.charAt(j);

//                 map.put(ch,map.getOrDefault(ch,0)+1);

//                 mac=Math.max(mac,map.get(ch));

//                 if((j-i+1)-mac >k){
//                     break;
//                 }
//                 max=Math.max(max,j-i+1);
//             }
//         }
//         return max;
//     }
// }