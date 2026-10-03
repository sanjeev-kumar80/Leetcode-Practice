class Solution {
    public int maxVowels(String s, int k) {
        int max=0;
        int count=0;

        for(int i=0;i<k;i++ ){
            char ch=s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                count ++;
            }
        }
        max=Math.max(max,count);

        for(int i=k;i<s.length();i++){
            char ch=s.charAt(i);
            char removeele=s.charAt(i-k);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    count ++;
            }
             if(removeele=='a' || removeele=='e' || removeele=='i' || removeele=='o' || removeele=='u'){
                    count --;
             }

             max=Math.max(max,count);
        }
        return max;
    }
}



// class Solution {
//     public int maxVowels(String s, int k) {
//         int max=0;
//         for(int i=0;i<=s.length()-k;i++){
//             int count=0;
//             for(int j=i;j<i+k;j++){
//                 char ch=s.charAt(j);

//                 if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
//                     count ++;
//                 }
//             }
//             max=Math.max(max,count);
//         }
//         return max;
//     }
// }