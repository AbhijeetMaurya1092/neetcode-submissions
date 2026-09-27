class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find maximum pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int answer = right;

        // Binary Search
        while (left <= right) {

            int k = left + (right - left) / 2;

            long hours = 0;

            // Calculate total hours needed with speed k
            for (int pile : piles) {
                hours += (pile + k - 1L) / k;
            }

            if (hours <= h) {
                // k works, but try a smaller speed
                answer = k;
                right = k - 1;
            } else {
                // k is too slow
                left = k + 1;
            }
        }

        return answer;
    }
}