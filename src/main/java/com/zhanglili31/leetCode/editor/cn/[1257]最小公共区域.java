package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1257 最小公共区域
//2022-06-17 15:38:03
class SmallestCommonRegion {

    public static void main(String[] args) {
        Solution solution = new SmallestCommonRegion().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
//        int temp[] = CreateArray.getArray(20, 100);
        int temp[] = {5, 3, 2, 2};
        System.out.println(Arrays.toString(temp));
        System.out.println(solution);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //首先构建n叉树，其次寻找最近公共父节点即可，同类题参考：236
    class Solution {
        class Node {
            int hashcode = 0;
            String str = null;
            List<Node> children = new ArrayList<Node>();

            public Node(int hashcode, String str) {
                this.hashcode = hashcode;
                this.str = str;
            }
        }

        List<Node> list = new ArrayList<>();
        String ans = "";
        public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
            //build tree
            for (int i = 0; i < regions.size(); i++) {
                String pa = regions.get(i).get(0);
                Node father = null;
                for (int k = 0; k < list.size(); k++) {
                    father = findParent(list.get(k), pa);
                    if (father != null) {
                        break;
                    }
                }
                if (father == null) {
                    father = new Node(pa.hashCode(), pa);
                    list.add(father);
                }
                for (int j = 1; j < regions.get(i).size(); j++) {
                    String child = regions.get(i).get(j);
                    father.children.add(new Node(child.hashCode(), child));
                }
            }
            //在每一刻构建的树中查找是否存在最近公共父节点
            for (int i = 0; i < list.size(); i++) {
//                Node tar = findTarget(list.get(i), "iZ");
                findTwoRegions(list.get(i), region1.hashCode(), region2.hashCode());

            }
            return ans;
        }

        private Node findTarget(Node root, String str) {
            if (root == null) {
                return null;
            }
            Node ans = null;
            if (root.str.equals(str)) {
                return root;

            }
            for (int i = 0; i < root.children.size(); i++) {
                ans = findTarget(root.children.get(i), str);
                if (ans != null) {
                    return ans;
                }
            }
            return ans;
        }

        private int findTwoRegions(Node root, int region1HashCode, int region2HashCode) {
            if (root == null) {
                return 0;
            }

            int count = 0;
            for (int i = 0; i < root.children.size(); i++) {
                count += findTwoRegions(root.children.get(i), region1HashCode, region2HashCode);
                if (count == 2) {
                    ans = root.str;
                    return 0;
                }
            }
            if (root.hashcode == region1HashCode || root.hashcode == region2HashCode) {
                count++;
            }
            if (count == 2) {
                ans = root.str;
                return 0;
            }
            return count;

        }

        private Node findParent(Node node, String tar) {
            if (node == null) {
                return null;
            }
            if (node.hashcode == tar.hashCode() && node.str.equals(tar)) {
                return node;
            } else {
                for (int i = 0; i < node.children.size(); i++) {
                    Node ans = findParent(node.children.get(i), tar);
                    if (ans != null) {
                        return ans;
                    }
                }
                return null;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}