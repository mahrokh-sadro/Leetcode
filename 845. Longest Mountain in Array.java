// You may recall that an array arr is a mountain array if and only if:

//     arr.length >= 3
//     There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
//         arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//         arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

// Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.


class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        int longest = 0;
        int i = 1;

        while (i < n - 1) {
            // Check if arr[i] is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Move left down the mountain
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // Move right down the mountain
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Update longest mountain length
                longest = Math.max(longest, right - left + 1);

                // Jump to the end of this mountain
                i = right;
            } else {
                i++;
            }
        }

        return longest;
    }
}
