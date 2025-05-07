/**
 * A really slow DFS solution (2%)
 **/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(nums, results, new ArrayList<Integer>());
        return results;
    }

    private void dfs(int[] nums, List<List<Integer>> results, List<Integer> path) {
        if (path.size()==nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i=0;i<nums.length;++i) {
            if (path.contains(nums[i])) continue;

            path.add(nums[i]);
            dfs(nums, results, path);
            path.remove(path.size()-1);
        }
    }

}
