class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans=new ArrayList<>();
        HashMap<Character,Integer> result=new HashMap<>();
        HashMap<Character,Integer> map=new HashMap<>();
        if (p.length() > s.length()) {
            return ans;
        }

        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            if(!result.containsKey(ch)){
                result.put(ch,0);
            }
            result.put(ch,result.get(ch)+1);
        }

        for(int i=0;i<p.length();i++){
            char ch=s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,0);
            }
            map.put(ch,map.get(ch)+1);

        }
        if(result.equals(map)){
            ans.add(0);
        }

        for(int i=p.length();i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

            char removech=s.charAt(i-p.length());

            map.put(removech,map.get(removech)-1);
            if(map.get(removech)==0){
                map.remove(removech);
            }

            if(result.equals(map)){
                ans.add(i-p.length()+1);
            }
        }
        return ans;
    }
}










// class Solution {
//     public List<Integer> findAnagrams(String s, String p) {
//         List<Integer> ans=new ArrayList<>();
//         HashMap<Character,Integer> map=new HashMap<>();
//         for(int i=0;i<p.length();i++){
//             char ch=p.charAt(i);
//             if(!map.containsKey(ch)){
//                 map.put(ch,0);
//             }
//             map.put(ch,map.get(ch)+1);
//         }

//         for(int i=0;i<=s.length()-p.length();i++){
//             HashMap<Character,Integer> container=new HashMap<>();

//             for(int j=i;j<i+p.length();j++){
//                 char ch=s.charAt(j);
//                 container.put(ch,container.getOrDefault(ch,0)+1);
//             }

//             if(map.equals(container)){
//                 ans.add(i);
//             }
//         }
//         return ans;
//     }
// }