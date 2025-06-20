class Solution {
    public int largestRectangleArea(int[] heights) {
    Stack<Integer> s=new Stack<>();
        int maxArea=0;
        int n=heights.length;
        for(int i=0;i<=n;i++) {
            int currentHeight=(i==n) ? 0:heights[i];
            while (!s.isEmpty() && currentHeight < heights[s.peek()]) {
                int height=heights[s.pop()];
                int width=s.isEmpty() ? i:i-s.peek()-1;
                maxArea=Math.max(maxArea,height * width);
            }
            s.push(i);
        }
        return maxArea;  
    }
}