class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        int half = (m + n + 1) / 2;

        while (left <= right) {

            int i = left + (right - left) / 2;
            int j = half - i;

            int leftA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int rightA = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int leftB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int rightB = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Correct partition
            if (leftA <= rightB && leftB <= rightA) {

                // Odd total length
                if ((m + n) % 2 == 1) {
                    return Math.max(leftA, leftB);
                }

                // Even total length
                return (Math.max(leftA, leftB)
                        + Math.min(rightA, rightB)) / 2.0;
            }

            // Too many elements taken from nums1
            if (leftA > rightB) {
                right = i - 1;
            }

            // Too few elements taken from nums1
            else {
                left = i + 1;
            }
        }

        return 0.0;
    }
}