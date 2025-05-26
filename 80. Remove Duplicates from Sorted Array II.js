class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length<=2) return nums.length;

        int toInsert=2;
        for (int i=2;i<=nums.length-1;++i) {
            if (nums[i]!=nums[toInsert-2]) {
                nums[toInsert++] = nums[i];
            }
            // System.out.println(Arrays.toString(nums));
        }

        return toInsert;
    }
}
