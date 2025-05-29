/**
 * Solution 1: >5%
 **/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(results, 0, path, candidates, target);
        return results;
    }

    private void backtrack(List<List<Integer>> results, int start, List<Integer> path, int[] candidates,
            int remain) {
        
        if (remain < 0)
            return;
        if (remain == 0) {
            results.add(new ArrayList<Integer>(path));
            return;
        }
        System.out.println(path);
        for (int i = start; i < candidates.length; ++i) {
            path.add(candidates[i]);
            backtrack(results, i, path, candidates, remain - candidates[i]); // the second param is `i` not `start`, i made the mistake a few times before
            path.remove(path.size() - 1);
        }

    }
}
