package i.jmv.solution;

import i.jmv.solution.util.ListNode;
import org.junit.Test;


/**
 * 83. 删除排序链表中的重复元素
 */
public class Solution83 {

    @Test
    public void testDeleteDuplicates() {
        ListNode listNode = deleteDuplicates(ListNode.createListNode(new int[]{1, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 6, 7}));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}