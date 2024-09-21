import linkedListCode.ListNode;

import java.util.List;

import static linkedListCode.part01.Solution.*;

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

public static void main(String[] args) {
    ListNode l1 = createSingleLinkedList(new int[]{1,8,5,3,9,6,76,45,454,4,5,5,5,6});
    ListNode l2 = createSingleLinkedList(new int[]{2,3,4});
}
