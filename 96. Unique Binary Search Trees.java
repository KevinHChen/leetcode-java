class Solution {
    public int numTrees(int n) {
        int[] results=new int[n+1];
        results[0]=1;
        results[1]=1;

        for(int i=2;i<=n;++i) {
            int accu=0;
            for (int j=0;j<i;++j) {
                accu += results[j]*results[i-j-1];
            }
            results[i]=accu;
        }

        return results[n];
    }
}
