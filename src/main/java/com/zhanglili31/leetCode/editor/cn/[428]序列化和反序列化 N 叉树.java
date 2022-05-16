package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateArray;
import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.*;

//428 序列化和反序列化 N 叉树
//2022-05-16 11:42:39
class SerializeAndDeserializeNAryTree {

    public static void main(String[] args) {
//        Solution solution = new SerializeAndDeserializeNAryTree().new Solution();
        TreeNode root = CreateTree.deserialize("[1,2,3,4,5,6,7,8,9]");
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        String testStr = "hello";
        String strArray[] = {"wrt", "wrf"};
        char[] charArray = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        int temp[] = CreateArray.getArray(20, 100);
        System.out.println(Arrays.toString(temp));
//        Codec codes = new Codec();
//
//        System.out.println(codes.deserialize("1 [3 [5  6 ] 2  4 ]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            String ans = recursion(root);
            System.out.println(ans);
            return ans;

        }

        public String recursion(Node root) {
            String ans = "";
            if (root == null)
                return ans;
            ans = String.valueOf(root.val) + " ";
            StringBuilder sub = new StringBuilder();
            sub.append(" ");
            for (int i = 0; i < root.children.size(); i++) {
                sub.append(recursion(root.children.get(i)));
                sub.append(" ");
            }
            if (sub.length() > 2) {
                sub.replace(0, 1, "[");
                sub.replace(sub.length() - 1, sub.length(), "]");
                ans = ans + sub.toString();
            }
            return ans;
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data == null || data.length() == 0)
                return null;
            Stack<Node> stack = new Stack<>();
            char ch = ' ';
            StringBuilder strB = new StringBuilder();
            for (int i = 0; i < data.length(); i++) {
                ch = data.charAt(i);
                if ('0' <= ch && ch <= '9') {
                    strB.append(ch);
                } else if (ch == '[') {
                    if (strB.length() > 0) {
                        stack.push(new Node(Integer.valueOf(strB.toString()), new LinkedList<Node>()));
                    }
                    strB = new StringBuilder();
                    stack.push(null);
                } else if (ch == ' ' && strB.length() > 0) {
                    stack.push(new Node(Integer.valueOf(strB.toString()), new LinkedList<Node>()));
                    strB = new StringBuilder();
                } else if (ch == ']') {
                    if (strB.length() > 0) {
                        stack.push(new Node(Integer.valueOf(strB.toString()), new LinkedList<Node>()));
                    }

                    strB = new StringBuilder();
                    LinkedList<Node> list = new LinkedList<>();
                    while (stack.peek() != null) {
                        list.offerFirst(stack.pop());
                    }
                    stack.pop();//null
                    Node tempRoot = stack.peek();
                    tempRoot.children = list;
                }
            }

            return stack.pop();

        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}