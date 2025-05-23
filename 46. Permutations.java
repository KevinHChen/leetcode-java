/**
 * Solution 3: similar to solution 2, but avoid 'path' clone, >90%
 **/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        results = new ArrayList();
        boolean[] used = new boolean[nums.length];
        backtrack(used, nums, new ArrayList<Integer>());
        return results;
    }

    private List<List<Integer>> results;

    private void backtrack(boolean[] used, int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            results.add(new ArrayList<Integer>(path));
        }

        for (int i = 0; i < nums.length; ++i) {
            if (used[i] == true)
                continue;

            path.add(nums[i]);
            boolean[] used2 = used.clone();
            used2[i] = true;
            backtrack(used2, nums, path);
            path.remove(path.size()-1);
        }
    }
}

/**
 * Solution 2: Still a DFS, but add a used array to avoid .contains() check, >90%
 **/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        results = new ArrayList();
        boolean[] used = new boolean[nums.length];
        backtrack(used, nums, new ArrayList<Integer>());
        return results;
    }

    private List<List<Integer>> results;

    private void backtrack(boolean[] used, int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            results.add(new ArrayList<Integer>(path));
        }

        for (int i = 0; i < nums.length; ++i) {
            if (used[i] == true)
                continue;

            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(nums[i]);
            boolean[] used2 = used.clone();
            used2[i] = true;
            backtrack(used2, nums, newPath);
        }
    }
}

/**
 * Solution 1: A really slow DFS solution (2%)
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
