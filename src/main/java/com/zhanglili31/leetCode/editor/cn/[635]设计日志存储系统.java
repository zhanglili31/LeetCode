package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//635 设计日志存储系统
//2022-05-31 19:34:48
class DesignLogStorageSystem {

    public static void main(String[] args) {
//        Solution solution = new DesignLogStorageSystem().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
//        LogSystem l = new LogSystem();
//        l.put(1, "2017:01:01:23:59:59");
//        l.put(2, "2017:01:01:21:59:59");
//        l.put(3, "2017:01:01:33:59:59");
        System.out.println();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
class LogSystem {
        /*
         * 1 如何存储日志？
         * 后续会通过时间查询时间范围内的日志，刚好时间是字符串，可以按照字符串大小排序
         * 2 查询使用的是起始字符串时间，如何快速找到对应的区间内的日志？
         * 使用二分查找，寻找min和max
         * 3 精确位的处理：精确到那里，那里后面的就变为0
         * */
        class Node {
            int id;
            String timestamp;

            public Node(int id, String timestamp) {
                this.id = id;
                this.timestamp = timestamp;
            }
        }

        LinkedList<Node> list = null;
        Map<String, Integer> map = new HashMap<>();

        public LogSystem() {
            list = new LinkedList<Node>();
            map.put("Year", 5);
            map.put("Month", 4);
            map.put("Day", 3);
            map.put("Hour", 2);
            map.put("Minute", 1);
            map.put("Second", 0);
        }

        //插入排序
        public void put(int id, String timestamp) {
            int i = list.size() - 1;
            while (i >= 0) {
                if (list.get(i).timestamp.compareTo(timestamp) <= 0) {
                    list.add(i + 1, new Node(id, timestamp));
                    return;
                }
                if (i == 0) {
                    list.add(0, new Node(id, timestamp));
                    return;
                }
                i--;
            }
            list.add(new Node(id, timestamp));

        }
        //二分查找寻找区间示例，前提是保证在区间中
        public List<Integer> retrieve(String start, String end, String granularity) {
            int min = 0;
            int max = 0;
            List<Integer> ans = new ArrayList<>();
            int left = 0;
            int right = list.size() - 1;
            int mid = 0;
            start = getString(granularity, start);
            end = getString(granularity, end);
            String midString = null;
            if (list.size() == 0) {
                return ans;
            }
            if (start.compareTo(getString(granularity, list.get(list.size() - 1).timestamp)) > 0) {
                return ans;
            }
            if (end.compareTo(getString(granularity, list.get(0).timestamp)) < 0) {
                return ans;
            }
            while (left < right) {
                mid = left + (right - left) / 2;
                midString = getString(granularity, list.get(mid).timestamp);
                if (midString.compareTo(start) < 0) {//目标：a<t<=b:寻找B  当a<t:肯定不是a，mid+1
                    left = mid + 1;
                } else {
                    right = mid;
                }
                if (left == right) {
                    min = left;
                }
            }
            left = 0;
            right = list.size() - 1;
            while (left < right) {
                mid = left + (right - left + 1) / 2;
                midString = getString(granularity, list.get(mid).timestamp);
                if (midString.compareTo(end) > 0) {//目标：a<=t<b: 寻找a,当t<b  肯定不是b，right=mid-1；这里会因为取天地的原因导致死循环
                    right = mid - 1;
                } else {
                    left = mid;
                }
                if (left == right) {
                    max = left;
                }
            }

            for (int i = min; i <= max; i++) {
                ans.add(list.get(i).id);
            }
            return ans;

        }

        private String getString(String granularity, String timestamp) {
            int n = map.get(granularity);
            StringBuilder str = new StringBuilder(timestamp);
            int th = str.length() - 1;
            for (int i = 0; i < n; i++) {
                str.setCharAt(th--, '0');
                str.setCharAt(th--, '0');
                th--;
            }
            return str.toString();
        }

    }

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */
//leetcode submit region end(Prohibit modification and deletion)

}