// >20%
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(triangle.get(0).get(0));
        for (int row = 1; row < triangle.size(); ++row) {
            List<Integer> currRow = triangle.get(row);
            List<Integer> newResult = new ArrayList<Integer>();
            newResult.add(currRow.get(0) + result.get(0));
            for (int col = 1; col < currRow.size() - 1; ++col) {
                newResult.add(Math.min(result.get(col - 1), result.get(col)) + currRow.get(col));
            }
            newResult.add(result.get(result.size() - 1) + currRow.get(currRow.size() - 1));
            result = newResult;
        }
        return Collections.min(result);
    }
}
