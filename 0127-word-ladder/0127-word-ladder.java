class Solution {
    class Pair{
        String word;
        int val;
        Pair(String word,int val){
            this.word=word;
            this.val=val;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> map=new HashSet<>();

        for(int i=0;i<wordList.size();i++){
            map.add(wordList.get(i));
        }
        if(map.contains(beginWord)){
            map.add(beginWord);
        }
        if(!map.contains(endWord)) return 0;
        Queue<Pair> q=new LinkedList<>();

        q.add(new Pair(beginWord,1));
        map.remove(beginWord);

        while(q.size()>0){
            Pair curr=q.poll();
            String word=curr.word;
            int val=curr.val;
            if (word.equals(endWord)) return val;

            StringBuilder sb=new StringBuilder(word);

            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);

                for(int j=0;j<26;j++){
                    char change=(char)(j+'a');
                    if(ch==change) continue;
                    sb.setCharAt(i,change);
                    String next = sb.toString();
                    if(map.contains(next)){
                        // String next = sb.toString();
                        q.add(new Pair(next, val + 1));
                        map.remove(next);
                    }

                }
                sb.setCharAt(i,ch);
            }
        }
        return 0;
    }
}