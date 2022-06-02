package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//751 IP 到 CIDR
//2022-06-02 09:20:20
class IpToCidr {

    public static void main(String[] args) {
        Solution solution = new IpToCidr().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution.ipToCIDR("117.145.102.62", 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();

        //https://leetcode.cn/problems/ip-to-cidr/solution/ke-neng-shi-mu-qian-wei-yi-yi-ge-yi-dong-de-ti-jie/
        public List<String> ipToCIDR(String ip, int n) {
            long start = ipToLong(getBinaryString(ip));
            int mask = 0;
            while (n > 0) {
                mask = getMask(start, n);
                ans.add(longToIp(start) + "/" + mask);
                int temp = 1 << (32 - mask);
                n -= temp;
                start += temp;
            }
            return ans;
        }
        //细节：t*2<=n
        private int getMask(long start, int n) {
            int th = 0;
            long t = 1;
            while ((t & start) == 0 && th < 33 && t * 2 <= n) {
                th++;
                t = t << 1;
            }
            return 32 - th;
        }


        //二进制ip转换为long
        private long ipToLong(String ip) {
            Long res = Long.parseUnsignedLong(ip, 2);
            return res;
        }

        //255.0.0.7 -> 11111111 00000000 00000000 00000111
        private String getBinaryString(String ip) {
            String sp[] = ip.split("\\.");
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < sp.length; i++) {
                Integer temp = Integer.parseInt(sp[i]);
                String strBinary = Integer.toBinaryString(temp);
                for (int j = 0; j < 8 - strBinary.length(); j++) {
                    str.append("0");
                }
                str.append(strBinary);
            }
            return str.toString();
        }

        //11111111 00000000 00000000 00000111 -> 255.0.0.7
        private String binToString(String bin) {
            int len = bin.length();
            for (int i = 0; i < 32 - len; i++) {
                bin = "0" + bin;
            }
            int v1 = Integer.parseInt(bin.substring(0, 8), 2);
            int v2 = Integer.parseInt(bin.substring(8, 16), 2);
            int v3 = Integer.parseInt(bin.substring(16, 24), 2);
            int v4 = Integer.parseInt(bin.substring(24, 32), 2);
            return v1 + "." + v2 + "." + v3 + "." + v4;
        }

        private String longToIp(long l) {
            return binToString(Long.toBinaryString(l));
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}