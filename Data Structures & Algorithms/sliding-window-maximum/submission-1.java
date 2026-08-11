
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int left = 0;
        int right = 0;
        int index = 0;

        while (right < n) {

            // Remove smaller elements from the back
            while (!deque.isEmpty() && 
                   nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(right);

            // Remove elements outside the window
            if (deque.peekFirst() < left) {
                deque.pollFirst();
            }

            // Window size is k
            if (right - left + 1 == k) {
                result[index++] = nums[deque.peekFirst()];
                left++;
            }

            right++;
        }

        return result;
    }
}