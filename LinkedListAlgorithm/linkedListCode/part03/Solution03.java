import linkedListCode.ListNode;

import static linkedListCode.part01.Solution.createSingleLinkedList;

//链表的花式反转方法

//反转整个单链表 迭代实现
public static ListNode reverseList(ListNode head){
    if(head==null || head.next == null){
        return head;
    }
    ListNode pre, cur, nxt;
    pre = null; cur = head; nxt = head.next;
    while(cur!=null) {
        cur.next = pre;
        pre = cur;
        cur = nxt;
        if(nxt!=null){
            nxt = nxt.next;
        }
    }
    return pre;
}


//反转整个单链表 递归实现
public static ListNode reverseListRecursion(ListNode head){
    if(head == null || head.next == null){
        return head;
    }
    ListNode last = reverseListRecursion(head.next);
    head.next.next = head;
    head.next = null;
    return last;
}


//反转链表前N个节点 递归实现
static ListNode successor = null;

//反转链表前N个节点 迭代实现
public static ListNode reverseN(ListNode head, int n) {

    if (head == null || head.next == null) {
        return head;
    }
    ListNode pre, cur, nxt;
    cur = head;
    pre = null;
    nxt = head.next;
    while (n > 0) {
        cur.next = pre;
        pre = cur;
        cur = nxt;
        nxt = nxt.next;
        n--;
    }
    head.next = cur;
    return pre;
}

public static ListNode reverseNRecursion(ListNode head, int n) {
    if (n == 1) {
        successor = head.next;
        return head;
    }
    ListNode last = reverseNRecursion(head.next, n - 1);
    head.next.next = head;
    head.next = successor;
    return last;
}


public static void main(String[] args) {
    ListNode l1 = createSingleLinkedList(new int[]{1,8,5,3,9,6,76,45,454,4,5,5,5,6});
    ListNode l2 = createSingleLinkedList(new int[]{2,3,4});
    ListNode head = reverseNRecursion(l2, 4);
}
