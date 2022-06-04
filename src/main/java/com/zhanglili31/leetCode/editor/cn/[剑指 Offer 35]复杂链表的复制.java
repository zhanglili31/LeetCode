package com.zhanglili31.leetCode.editor.cn;

import com.zhanglili31.leetCode.editor.cn.utils.CreateTree;
import com.zhanglili31.leetCode.editor.cn.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//剑指 Offer 35 复杂链表的复制
//2022-06-04 08:07:24
class FuZaLianBiaoDeFuZhiLcof {

    public static void main(String[] args) {
        Solution solution = new FuZaLianBiaoDeFuZhiLcof().new Solution();
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

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Integer> map = new HashMap<Node, Integer>();
            Map<Integer, Node> map2 = new HashMap<Integer,Node>();
            Node temp = head;
            Node ans = new Node(0);
            Node cur=ans;
            int index = 0;
            while (temp != null) {
                cur.next = new Node(temp.val);
                map2.put(index,cur.next);
                map.put(temp, index++);
                temp = temp.next;
                cur=cur.next;
            }
            temp=head;
            cur=ans.next;
            while (temp != null) {
                if (temp.random != null) {
                    index = map.get(temp.random);
                    cur.random = map2.get(index);
                }
                temp=temp.next;;
                cur=cur.next;
            }
            return ans.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}