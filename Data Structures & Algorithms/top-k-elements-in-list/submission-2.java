class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];
        boolean[] selected = new boolean[nums.length];

        for (int x = 0; x < k; x++) {

            int maxFreq = 0;
            int maxIndex = -1;

            for (int i = 0; i < nums.length; i++) {

                if (selected[i])
                    continue;

                int count = 0;

                for (int j = 0; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        count++;
                    }
                }

                if (count > maxFreq) {
                    maxFreq = count;
                    maxIndex = i;
                }
            }

            ans[x] = nums[maxIndex];

            
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == nums[maxIndex]) {
                    selected[i] = true;
                }
            }
        }

        return ans;
    }
}