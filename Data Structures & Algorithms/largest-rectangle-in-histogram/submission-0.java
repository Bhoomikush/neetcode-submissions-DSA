class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max=0;
        for(int i=0;i<heights.length;i++){
            int start = i;

            while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                int[] bar = stack.pop();
                int index = bar[0];
                int height = bar[1];
                max = Math.max(max , height*(i-index));
                start = index;
            }
            stack.push(new int[]{start,heights[i]});
        }
        while(!stack.isEmpty()){
            int[] bar = stack.pop();
            int index = bar[0];
            int height = bar[1];
            max = Math.max(max , height*(heights.length-index));

        }
        return max;
    }
}
