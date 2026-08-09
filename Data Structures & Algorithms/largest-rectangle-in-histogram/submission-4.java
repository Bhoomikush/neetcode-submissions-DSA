class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            int start = i;

            while (!stack.isEmpty() &&
                   stack.peek()[1] > heights[i]) {

                int[] pair = stack.pop();

                int index = pair[0];
                int height = pair[1];

                int width = i - index;

                maxArea = Math.max(maxArea, height * width);

                start = index;
            }

            stack.push(new int[]{start, heights[i]});
        }

        // Process remaining bars
        while (!stack.isEmpty()) {

            int[] pair = stack.pop();

            int index = pair[0];
            int height = pair[1];

            int width = heights.length - index;

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}