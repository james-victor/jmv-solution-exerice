package i.jmv.solution;

import i.jmv.solution.util.ListNode;
import org.junit.Test;


/**
 * 2. Add Two Numbers
 */
public class Solution2 {

    @Test
    public void testAddTwoNumbers() {
        ListNode l1 = ListNode.createListNode(new int[]{1, 2, 3});
        ListNode l2 = ListNode.createListNode(new int[]{9, 7, 6, 9});
        printListNode(l1);
        printListNode(l2);
        printListNode(addTwoNumbers(l1, l2));
        // Assert.assertNull(addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode p1 = l1, p2 = l2;
        ListNode nh = new ListNode(0);
        ListNode np = nh;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int a = 0;
            int b = 0;
            if (p1 != null) {
                a = p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                b = p2.val;
                p2 = p2.next;
            }
            int sum = carry + a + b;
            carry = sum / 10;
            np = np.next = new ListNode(sum % 10);
        }
        if (carry > 0) {
            np.next = new ListNode(carry);
        }
        return nh.next;
    }

    public void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
        System.out.println();
    }
}