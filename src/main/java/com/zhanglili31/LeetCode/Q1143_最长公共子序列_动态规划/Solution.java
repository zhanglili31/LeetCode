package com.zhanglili31.LeetCode.Q1143_最长公共子序列_动态规划;
//短的字符串默认只有一个字符，然后不断的增加字符，计算最长公共子序列。max dp[n].
//1, 找出新增字符在长字符串中的序号index，
//2  在aIndex中，对于所有的aIndex[i]<index,并且dp最大的。
//3  不确定2是否能存在让dp[i]!=0||1,的index,因此还要对其他的index执行1，2操作。
class Solution {
    public static void main(String[] args) {
        new Solution().longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd");
    }
    public int longestCommonSubsequence(String text1, String text2) {
        String lonStr = null;
        String shortStr = null;
        if (text1.length() > text2.length()) {
            lonStr = text1;
            shortStr = text2;
        } else {
            lonStr = text2;
            shortStr = text1;
        }
        char ch;
        int index = 0;
        int[] dp = new int[shortStr.length()];
        int[] aIndex = new int[shortStr.length()];
        int curMaxDp = 0;
        int resMaxDp = 0;
        for (int i = 0; i < shortStr.length(); i++) {
            ch = shortStr.charAt(i);
            index = lonStr.indexOf(ch);
            curMaxDp=0;
            if(index == -1){
                aIndex[i] = Integer.MAX_VALUE;
            }
            while (index != -1) {
                for (int j = 0; j <i; j++) {
                    if (aIndex[j] < index && dp[j] >= curMaxDp) {
                        curMaxDp = dp[j];
                    }
                }
                if (dp[i] <= curMaxDp ) {
                    dp[i] = curMaxDp+1;//这里的加一操作比较重要。
                    aIndex[i] = index;
                }
                index = lonStr.indexOf(ch, index + 1);
            }

            if (resMaxDp < dp[i]) resMaxDp = dp[i];

        }
        return resMaxDp;
    }
}