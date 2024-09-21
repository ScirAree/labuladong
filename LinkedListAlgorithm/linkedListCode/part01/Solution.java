package linkedListCode.part01;

import linkedListCode.ListNode;
import java.util.PriorityQueue;

public class Solution {
    //输入一个数组创建一个单链表不带虚拟头结点
    public static ListNode createSingleLinkedList(int[] arr) {
        if (arr == null) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode q = head;
        for (int i = 1; i < arr.length; i++) {
            q.next = new ListNode(arr[i]);
            q = q.next;
        }
        return head;
    }

    //合并俩个有序链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    //单链表的分解
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }

            //断开原链表结点否则成环
            // 总的来说，如果我们需要把原链表的节点接到新链表上，
            // 而不是 new 新节点来组成新链表的话，那么断开节点和原链表之间的链接可能是必要的。
            // 那其实我们可以养成一个好习惯，但凡遇到这种情况，就把原链表的节点断开，这样就不会出错了。
            ListNode temp = p.next;
            p.next = null;
            p = temp;

        }
        p1.next = dummy2.next;
        return dummy1.next;
    }

    //合并k个有序链表
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

    //单链表的倒数第k个结点
    public static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        //p1先走k步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        //p1,p2同时走n-k步
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    //删除链表的倒数第k个结点
    public static ListNode removeFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode x = findFromEnd(head, k + 1);
        x.next = x.next.next;
        return dummy.next;
    }

    //单链表的中点
    public static ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    //判断链表是否包含环
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                flag = true;
                break;
            }
            ;
        }
        return flag;
    }

    //寻找环的起点
    public static ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }

        // 重新指向头结点
        slow = head;

        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //俩个链表是否相交
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    public static void main(String[] args) {


        ListNode l1 = createSingleLinkedList(new int[]{1, 4, 5});
        ListNode l2 = createSingleLinkedList(new int[]{2, 3, 4});

        //链表的交点
//    l1.next.next = l2;
//    ListNode point = getIntersectionNode(l1,l2);
//    System.out.println(point.val);


        //单链表的中点
//    ListNode i = middleNode(l1);
//    System.out.println(i.val);

        //单链表的倒数第k个节点
//    ListNode head = findFromEnd(l1,2);
//    System.out.println(head.val);

        //合并k个有序链表
//    ListNode head = mergeKLists(new ListNode[]{l1,l2});
//    while(head!=null){
//        System.out.println(head.val);
//        head = head.next;
//    }

        //    合并俩个有序链表
//    ListNode head = mergeTwoLists(l1,l2);
//    while(head!=null){
//        System.out.println(head.val);
//        head= head.next;
//    }

//    单链表的分解
//    ListNode l2 =partition(l1,3);
//    while(l2!=null){
//        System.out.println(l2.val);
//        l2 = l2.next;
//    }

    }
}


