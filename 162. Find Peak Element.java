class Solution {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // one elem left
            if (mid == left && mid == right)
                return mid;
            // two elems left
            if (mid == left)
                return nums[left] > nums[right] ? left : right;
            
            // at least there are three elems
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] >= nums[mid - 1])
                left = mid;
            else
                right = mid;
        }

        return left;
    }
}
