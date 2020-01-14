package com.ihs;
import java.util.Stack;


class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;



    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}



public class Main {

    static boolean isValidBST(TreeNode root) {
        if(root != null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null || root.val < pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        root.right = new TreeNode(6);
        root.left = new TreeNode(3);

        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        System.out.println(isValidBST(root));

    }

}

