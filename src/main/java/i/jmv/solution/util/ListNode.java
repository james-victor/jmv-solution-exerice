package i.jmv.solution.util;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
    /*
     *
     * 公共方法
     */

    /**
     * 创建链表数据
     *
     * @param arr 数组
     */
    public static ListNode createListNode(int[] arr) {
        ListNode tmpI = new ListNode();
        ListNode head = tmpI;
        for (int value : arr) {
            tmpI.next = new ListNode(value);
            tmpI = tmpI.next;
        }
        return head.next;
    }


}
