class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0)=='0') return 0;
        int[] ways = new int[s.length()+1];
        ways[0]=1;
        ways[1]=1;

        for (int i=1;i<s.length();++i) {
            int n1=Integer.parseInt(s.substring(i,i+1));
            int n2 = Integer.parseInt(s.substring(i-1, i+1));

            if (n1>0 && n1<=9) ways[i+1]=ways[i];
            if (n2>=10 && n2<=26) ways[i+1]+=ways[i-1];
        }

        return ways[ways.length-1];
    }
}
