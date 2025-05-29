class Solution {
    public int longestConsecutive(int[] nums) {
        // this looks stupid but effective
        // I did try "Set<Integer> container = Arrays.stream(nums).boxed().collect(Collectors.toSet());", but unfortunately very slow
        Set<Integer> container = new HashSet<>();
        for (int elem : nums) container.add(elem);

        int maxLen = 0;
        for (int elem : container) {
            if (container.contains(elem-1)) continue;

            int cnt = 0;
            while (container.contains(elem)) {
                cnt++;
                elem++;
            }
            maxLen = Math.max(maxLen, cnt);
        }
        
        return maxLen;
    }
}
