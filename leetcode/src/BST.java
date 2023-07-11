public class BST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public static void main(String[] args) {
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(3);
        TreeNode left = new TreeNode(2, left2, right2);
        TreeNode right = new TreeNode(6);
        TreeNode root = new TreeNode(4, left, right);
        System.out.println(getMinimumDifference(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // 노드를 발견한게 있는지 없는지 체크
    static boolean init;
    static int min;
    // 직전에 발견한 노드값을 알고 있어야 두 노드의 차 알 수 있음
    static int prev;
    public static int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        init = false;
        inorder(root);
        return min;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        // recursion
        // left
        inorder(root.left);
        // self 처리
        if (!init) {
            // 발견한 노드가 없다면
            init = true;
        } else {
            // 발견한 노드가 있다면
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        // right
        inorder(root.right);
    }
}

