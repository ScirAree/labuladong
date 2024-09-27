import linkedListCode.ListNode;

import static linkedListCode.part01.Solution.createSingleLinkedList;


//判断回文单链表
public static boolean isPalindrome(ListNode head) {
    ListNode slow, fast;
    slow = fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    if (fast != null) {
        slow = slow.next;
    }
    ListNode left = head;
    ListNode right = reverse(slow);
    while (right != null) {
        if (left.val != right.val) {
            return false;
        }
        left = left.next;
        right = right.next;
    }
    return true;
}

public static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next; // 保存下一个节点
        curr.next = prev; // 反转指针
        prev = curr; // 移动prev
        curr = nextTemp; // 移动到下一个节点
    }
    return prev; // 返回新的头节点
}

public static void main(String[] args) {
    ListNode l1 = createSingleLinkedList(new int[]{1, 8, 5, 3, 9, 6, 76, 45, 454, 4, 5, 5, 5, 6});
    ListNode l2 = createSingleLinkedList(new int[]{2, 3, 4});
}

