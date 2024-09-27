package linkedListCode;

public class huiwenshu {
    // 从左向右移动的指针
    ListNode left;
    // 从右向左移动的指针
    ListNode right;

    // 记录链表是否为回文
    boolean res = true;

    boolean isPalindrome(ListNode head) {
        left = head;
        traverse(head);
        return res;
    }

    void traverse(ListNode right) {
        if (right == null) {
            return;
        }
        traverse(right.next);

        if (left.val != right.val) {
            res = false;
        }
        left = left.next;
    }
}
