class Solution {
    static int[] dp;
    public int numDecodings(String s) {
        int n=s.length();
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        // return solve(0,s);
        return tabulation(s);

    }

    private static int tabulation(String s){
        int n=s.length();
        int [] dp=new int [n+1];
        dp[n] =1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0') dp[i]= 0;
            else{
                int one=dp[i+1];
                int two=0;
                if(i+1<s.length()){
                    int num=Integer.parseInt(s.substring(i,i+2));

                    if(num>=10 && num<=26){
                        two=dp[i+2];
                    }
                }
                dp[i]=one+two;
            }
        }
        return dp[0];
    }

    private static int solve(int i,String str){
        if(i==str.length()) return 1;

        if(str.charAt(i)=='0') return 0;
        if(dp[i]!=-1) return dp[i];

        int one=solve(i+1,str);
        int two=0;
        if(i+1<str.length()){
            int num=Integer.parseInt(str.substring(i,i+2));

            if(num>=10 && num<=26){
                 two=solve(i+2,str);
            }
        }
        return dp[i]=one+two;
    }
}