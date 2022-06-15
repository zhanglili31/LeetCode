package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//1236 网络爬虫
//2022-06-15 19:41:12
class WebCrawler {

    public static void main(String[] args) {
//        Solution solution = new WebCrawler().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is the HtmlParser's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface HtmlParser {
     * public List<String> getUrls(String url) {}
     * }
     */
/*
   class Solution {
        public List<String> crawl(String startUrl, HtmlParser htmlParser) {
            Set<String> set = new HashSet<>();
            recursion(startUrl, getHostName(startUrl), htmlParser, set);
            List<String> list = new ArrayList<>();
            set.forEach((str) -> {
                list.add(str);
            });
            return list;
        }

        public void recursion(String startUrl, String init, HtmlParser htmlParser, Set<String> set) {
            if (set.contains(startUrl)) {
                return;
            }
            set.add(startUrl);
            List<String> list = htmlParser.getUrls(startUrl);
            for (int i = 0; i < list.size(); i++) {
                String url = list.get(i);
                if (init.equals(getHostName(url))) {
                    recursion(url, init, htmlParser, set);
                }
            }
        }

        private String getHostName(String url) {
            url = url.substring(7);
            if (url.contains("/")) {
                int index = url.indexOf("/");
                return url.substring(0,index);
            }else{
                return url;
            }
        }
    }
    */
//leetcode submit region end(Prohibit modification and deletion)

}