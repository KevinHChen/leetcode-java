class Solution {
    public int jump(int[] nums) {
        int farthest = 0;
        int endsHere=0;
        int jump=0;

        // No need to process the last index since we never jump from there
        for (int i=0;i<nums.length-1;++i) {
            farthest = Math.max(farthest, i+nums[i]);

            if (i==endsHere) {
                endsHere = farthest;
                jump++;
            }
        }

        return jump;
    }
}
