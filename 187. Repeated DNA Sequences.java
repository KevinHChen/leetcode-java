/**
 * Sliding window solution, > 70%
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> repeated = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (int i=0;i<s.length()-9;++i) {
            String c = s.substring(i,i+10);
            if (repeated.contains(c)) {
                result.add(c);
            }
            repeated.add(c);
        }

        return new ArrayList(result);
    }
}
