/**
 * Solution 2: Better duplicate handling. Fast
 */
class Solution {
    public boolean search(int[] nums, int target) {
        return backtrack(nums, 0, nums.length - 1, target) != -1;
    }

    private int backtrack(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;

        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;

        // handle duplicate
        while (left < right && nums[left] == nums[mid] && nums[mid]==nums[right]) {
            left++;
            right--;
        }

        if (nums[left] <= nums[mid]) { // left half is ordered
            if (nums[left] <= target && target < nums[mid]) {
                return backtrack(nums, left, mid - 1, target);
            } else {
                return backtrack(nums, mid + 1, right, target);
            }
        } else { // right half is ordered
            if (nums[mid] < target && target <= nums[right]) {
                return backtrack(nums, mid + 1, right, target);
            } else {
                return backtrack(nums, left, mid - 1, target);
            }
        }
    }
}

/**
 * Solution 1: too much patching. Fast
 */
class Solution {
    public boolean search(int[] nums, int target) {
        return backtrack(nums, 0, nums.length - 1, target) != -1;
    }

    private int backtrack(int[] nums, int left, int right, int target) {
        while (left < right - 1 && nums[left] == nums[right] && nums[left] != target) {
            left++;
            right--;
        }
        if (left > right)
            return -1;

        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;

        if (nums[left] <= nums[mid]) { // left half is ordered
            if (nums[left] <= target && target < nums[mid]) {
                return backtrack(nums, left, mid - 1, target);
            } else {
                return backtrack(nums, mid + 1, right, target);
            }
        } else { // right half is ordered
            if (nums[mid] < target && target <= nums[right]) {
                return backtrack(nums, mid + 1, right, target);
            } else {
                return backtrack(nums, left, mid - 1, target);
            }
        }
    }
}
