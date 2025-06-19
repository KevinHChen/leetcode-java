class Solution {
    public int uniquePaths(int m, int n) {
        int[] cnt = new int[n];
        for (int i=0;i<n;++i) {
            cnt[i]=1;
        }

        for (int i=1;i<m;++i) {
            for (int col=1;col<n;++col) {
                cnt[col]=cnt[col-1]+cnt[col];
            }
        }

        return cnt[n-1];
    }
}
