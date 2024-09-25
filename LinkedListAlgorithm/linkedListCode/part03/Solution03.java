import linkedListCode.ListNode;

import static linkedListCode.part01.Solution.createSingleLinkedList;

//链表的花式反转方法

//反转整个单链表 迭代实现
public static ListNode reverseList(ListNode head){
    if(head==null || head.next == null){
        return head;
    }
    ListNode pre, cur, nxt;
    pre = null;
    cur = head;

    nxt = head.next;
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
    pre = null;
    cur = head;

    nxt = head.next;
    while (n > 0) {
        cur.next = pre;
        pre = cur;
        cur = nxt;
        if (nxt != null) {
            nxt = nxt.next;
        }
        n--;
    }
    head.next = cur;
    return pre;
}


//反转链表前N个节点 递归实现
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


//反转链表的一部分
//public static ListNode reverseBetween(ListNode head, int m, int n) {
//}


//反转链表结点
public static ListNode reverseList2(ListNode head) {
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


//k个一组反转链表
public static ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) return null;
    ListNode a, b;
    a = b = head;
    for (int i = 0; i < k; i++) {
        if (b == null) return head;
        b = b.next;
    }
    ListNode newHead = reverseN(a, k);
    a.next = reverseKGroup(b, k);
    return newHead;
}




public static void main(String[] args) {
    ListNode l1 = createSingleLinkedList(new int[]{1,8,5,3,9,6,76,45,454,4,5,5,5,6});
    ListNode l2 = createSingleLinkedList(new int[]{2,3,4});

}
