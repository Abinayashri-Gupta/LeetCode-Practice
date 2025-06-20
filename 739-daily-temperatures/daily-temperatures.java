class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s=new Stack<>();
        int[] answer=new int[temperatures.length];
        for(int i=0;i<answer.length;i++)
        {
            while(!s.isEmpty() && temperatures[i]>temperatures[s.peek()])
            {
                int index=s.pop();
                answer[index]=i-index;
            }
            s.push(i);
        }
        return answer;
    }
}