package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1152 用户网站访问行为分析
//2022-06-12 12:11:06
class AnalyzeUserWebsiteVisitPattern {

    public static void main(String[] args) {
        Solution solution = new AnalyzeUserWebsiteVisitPattern().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"ua","ua","ua","ub","ub","ub"};
        String website[] = {"a","b","a","a","b","c"};
        int temp[] = {1, 2, 3, 4, 5, 6};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};

        System.out.println(Arrays.toString(temp));
        System.out.println(solution.mostVisitedPattern(strArray, temp, website));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Node {
            int timestamp;
            String website;

            public Node(int timestamp, String website) {
                this.timestamp = timestamp;
                this.website = website;
            }
        }

        public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
            Map<String, List<Node>> map = new HashMap<>();
            int n = username.length;
            for (int i = 0; i < n; i++) {
                List<Node> temp = map.getOrDefault(username[i], new ArrayList<>());
                temp.add(new Node(timestamp[i], website[i]));
                map.put(username[i], temp);
            }
            map.forEach((k, v) -> {
                v.sort(new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        return o1.timestamp - o2.timestamp;
                    }
                });
            });
            Map<String, Set<String>> pattern = new HashMap<>();
            map.forEach((k, v) -> {
                Set<String> set = new HashSet<>();
                for (int i = 0; i < v.size(); i++) {
                    String s1 = v.get(i).website;
                    for (int j = i + 2; j < v.size(); j++) {
                        String s3 = v.get(j).website;
                        for (int t = i + 1; t < j; t++) {
                            String s2 = v.get(t).website;
                            set.add(s1 + "," + s2 + "," + s3);
                        }
                    }
                }
                pattern.put(k, set);
            });
            Map<Integer, List<String>> ans = new HashMap<>();
            Set<String> sign = new HashSet<>();
            int maxScore[] = {Integer.MIN_VALUE};
            pattern.forEach((k, v) -> {
                Iterator<String> iterator = v.iterator();
                while (iterator.hasNext()) {
                    String p = iterator.next();
                    if (sign.contains(p))
                        continue;
                    sign.add(p);
                    final int score[] = {1};
                    pattern.forEach((k2, v2) -> {
                        if (!k2.equals(k)) {
                            if (v2.contains(p)) {
                                score[0]++;
                            }
                        }

                    });
                    List<String> strList = ans.getOrDefault(score[0], new ArrayList<>());
                    strList.add(p);
                    ans.put(score[0], strList);
                    maxScore[0] = Math.max(score[0], maxScore[0]);
                }
            });
            System.out.println(ans);
            List<String> res = ans.get(maxScore[0]);
            res.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            String temp[] = res.get(0).split(",");
            List<String> lastAns = new ArrayList<>();
            for (int i = 0; i < temp.length; i++) {
                lastAns.add(temp[i]);
            }
            return lastAns;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}