class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // s1 ki frequency + s2 ki first window ki frequency
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // first window check
        if (Arrays.equals(freq1, freq2)) {
            return true;
        }

        // sliding window
        for (int right = s1.length(); right < s2.length(); right++) {

            // new character add
            freq2[s2.charAt(right) - 'a']++;

            // old left character remove
            int left = right - s1.length();
            freq2[s2.charAt(left) - 'a']--;

            // current window check
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}