package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;
import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;

import java.util.Arrays;

//426 将二叉搜索树转化为排序的双向链表
//2022-05-14 22:17:12
class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    public static void main(String[] args) {
        Solution solution = new ConvertBinarySearchTreeToSortedDoublyLinkedList().new Solution();
        TreeNode root = CreateTree.deserialize("[4,2,5,1,3]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        System.out.println(solution.treeToDoublyList(root));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        int MIN = 0;
        int MAX = 1;

        public Node treeToDoublyList(Node root) {
            if(root==null)return null;
            Node[] ans = recursion(root);
            ans[MIN].left = ans[MAX];
            ans[MAX].right = ans[MIN];
            return ans[MIN];

        }

        public Node[] recursion(Node root) {
            Node[] res = new Node[2];
            if (root != null && root.left == null && root.right == null) {
                res[MIN] = root;
                res[MAX] = root;
                return res;
            }
            Node[] left = root.left != null ? recursion(root.left) : null;
            Node[] right = root.right != null ? recursion(root.right) : null;
            res[MIN] = root;
            res[MAX] = root;
            if (left != null) {
                res[MIN] = left[MIN];
                root.left = left[MAX];
                left[MAX].right = root;
            }
            if (right != null) {
                res[MAX] = right[MAX];
                root.right = right[MIN];
                right[MIN].left = root;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}