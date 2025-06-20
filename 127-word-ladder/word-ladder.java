class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord))return 0;
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        int lvl=1;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                String w=q.poll();
                char[] arr=w.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char orig=arr[j];
                    for(char c='a';c<='z';c++){
                        arr[j]=c;
                        String next=new String(arr);
                        if(set.contains(next)){
                            if(next.equals(endWord))return lvl+1;
                            q.offer(next);
                            set.remove(next);
                        }
                    }
                    arr[j]=orig;
                }
            }
            lvl++;
        }
        return 0;
    }
}