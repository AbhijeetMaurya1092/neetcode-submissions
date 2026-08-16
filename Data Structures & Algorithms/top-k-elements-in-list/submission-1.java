class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Frequency count
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Sort entries according to frequency
        List<Map.Entry<Integer, Integer>> list =
                new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        // Answer
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }

        return ans;
    }
}