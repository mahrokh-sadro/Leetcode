// You are given a positive integer num. You may swap any two digits of num that have the same parity (i.e. both odd digits or both even digits).

// Return the largest possible value of num after any number of swaps.


class Solution {
    public int largestInteger(int num) {
        if (num < 10) return num;

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();

        int temp = num;

        // Extract digits
        while (temp > 0) {
            int d = temp % 10;
            digits.add(d);
            if (d % 2 == 1) {
                odd.add(d);
            } else {
                even.add(d);
            }
            temp /= 10;
        }

        // Reverse digits to make them MSB -> LSB
        Collections.reverse(digits);

        // Sort both lists descending
        odd.sort((e1, e2) -> e2 - e1);
        even.sort((e1, e2) -> e2 - e1);

        int i = 0; // index for odd
        int j = 0; // index for even
        int number = 0;

        // Build the final number
        for (int d : digits) {
            number *= 10;
            if (d % 2 == 1) {
                number += odd.get(i++);
            } else {
                number += even.get(j++);
            }
        }

        return number;
    }
}
