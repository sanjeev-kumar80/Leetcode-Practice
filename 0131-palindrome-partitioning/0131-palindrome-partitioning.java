class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> ll=new ArrayList<>();
        helper(s,ans,ll);
        return ans;


    }

    private void helper(String str,List<List<String>> ans,List<String> ll){
        if(str.length()==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=0;i<str.length();i++){
            String first=str.substring(0,i+1);

            if(ispalindrome(first)){
                ll.add(first);
                String last=str.substring(i+1);
                helper(last,ans,ll);
                ll.remove(ll.size()-1);
            }
        }
    }

    private static boolean ispalindrome(String str){
        int i=0;
        int j=str.length()-1;

        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}