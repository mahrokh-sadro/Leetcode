// A swap is defined as taking two distinct positions in an array and swapping the values in them.

// A circular array is defined as an array where we consider the first element and the last element to be adjacent.

// Given a binary circular array nums, return the minimum number of swaps required to group all 1's present in the array together at any location.


class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;

        // Count total number of 1's
        for (int num : nums) totalOnes += num;

        // Edge cases
        if (totalOnes <= 1 || totalOnes == n) return 0;

        // Count initial number of 1's in the first window
        int currentOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            currentOnes += nums[i];
        }

        int maxOnesInWindow = currentOnes;

        // Slide the window across the circular array
        for (int i = 1; i < n; i++) {
            // Remove the element leaving the window and add the new one
            currentOnes -= nums[(i - 1) % n];
            currentOnes += nums[(i + totalOnes - 1) % n];
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }

        // Minimum swaps = total ones - max ones in any valid window
        return totalOnes - maxOnesInWindow;
    }
}
