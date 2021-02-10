package i.jmv.solution;

import i.jmv.solution.util.ListNode;
import org.junit.Test;


/**
 * 21. 合并两个有序链表
 */
public class Solution21 {

    @Test
    public void testMergeTwoLists() {
        ListNode listNode = mergeTwoLists(ListNode.createListNode(new int[]{3}), ListNode.createListNode(new int[]{0, 1, 4, 5, 7, 7, 7}));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode l1i = l1;
//        ListNode l2i = l2;
//
//        ListNode tmpI = new ListNode();
//        ListNode head = tmpI;
//
//        while (l1i != null || l2i != null) {
//            if (tmpI.next == null) {
//                tmpI.next = new ListNode();
//                tmpI = tmpI.next;
//            }
//            if (l1i != null && l2i != null) {
//                if (l1i.val <= l2i.val) {
//                    tmpI.val = l1i.val;
//                    l1i = l1i.next;
//                } else {
//                    tmpI.val = l2i.val;
//                    l2i = l2i.next;
//                }
//            } else {
//                if (l1i != null) {
//                    tmpI.val = l1i.val;
//                    l1i = l1i.next;
//                }
//
//                if (l2i != null) {
//                    tmpI.val = l2i.val;
//                    l2i = l2i.next;
//                }
//            }
//        }
//
//        return head.next;
//    }

}