class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll=new ArrayList<>();
        helper(ll,n,0,0,"");
        return ll;
    }

    public void helper(List<String> ll,int n,int open,int close,String str){
        if(open>n || close>n ) return ;

        if(open<close) return;

        if(open==n && close==n) {
            ll.add(str);
        }
        helper(ll,n,open+1,close,str+"(");
        helper(ll,n,open,close+1,str+")");
    }
}