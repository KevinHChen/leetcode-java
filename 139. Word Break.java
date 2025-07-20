/**
 * Solution 1: shall be correct but timeout
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s, 0, wordDict);
    }

    private boolean backtrack(String s, int fromIndex, List<String> wordDict) {
        if (fromIndex>=s.length()) 
            return true;

        for (int i=0;i<wordDict.size();++i) {
            if (s.indexOf(wordDict.get(i), fromIndex)==fromIndex) {
                boolean res = backtrack(s, fromIndex+wordDict.get(i).length(), wordDict);
                if (res) {
                    return res;
                }
            }
        }
        return false;
    }
}
