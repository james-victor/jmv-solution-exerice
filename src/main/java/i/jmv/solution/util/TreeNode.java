package i.jmv.solution.util;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

//   public TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }


    /**
     * 创建链表数据
     *
     * @param arr 数组
     */
    public static TreeNode createTreeNode(int[] arr) {
        return new TreeNode();
    }

    public static void printTreeNode(TreeNode treeNode) {
        for (int i = 0; i < maxDepth(treeNode); i++) {
            printTreeNode(treeNode, i, 0);
            System.out.println();
        }
    }


    public static void printTreeNode(TreeNode treeNode, int depth, int currDepth) {
        if (treeNode == null) {
            if (currDepth == depth) {
                System.out.print("nu\t");
            }
        } else {
            if (currDepth == depth) {
                System.out.print(treeNode.val + "\t");
            }
            currDepth++;
            printTreeNode(treeNode.left, depth, currDepth);
            printTreeNode(treeNode.right, depth, currDepth);
        }
    }


    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}