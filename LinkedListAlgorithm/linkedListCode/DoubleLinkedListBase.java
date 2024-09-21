package linkedListCode;

public class DoubleLinkedListBase {

    //双链表结点
    static class DoubleListNode {
        int val;
        DoubleListNode prev, next;

        DoubleListNode(Integer x) {
            this.val = x;
        }

        ;
    }

    //输入一个数组，将其转换成一个双链表
    static DoubleListNode createDoubleLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        DoubleListNode head = new DoubleListNode(arr[0]);
        DoubleListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoubleListNode newNode = new DoubleListNode(arr[i]);
            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {

        DoubleListNode head = createDoubleLinkedList(new int[]{1,2,3,4,5,});
        DoubleListNode tail = null;

        //从头节点遍历双链表
//        while(head!=null){
//            System.out.println(head.val);
//            head=head.next;
//        }

        //从尾节点遍历双链表
//        while(head.next != null){
//            head = head.next;
//        }
//        tail = head;
//        while(tail != null){
//            System.out.println(tail.val);
//            tail = tail.prev;
//        }

        //在双链表头部插入新元素
//        DoubleListNode newNode = new DoubleListNode(0);
//        newNode.next = head;
//        head.prev = newNode;
//        head = newNode;
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }

        //在双链表尾部插入新元素
//        DoubleListNode newNode = new DoubleListNode(9);
//        DoubleListNode p = null;
//        p = head;
//        while(p.next!=null){
//            p = p.next;
//        }
//        tail = p;
//        tail.next = newNode;
//        newNode.prev = tail;
//        tail = newNode;
//        while(head!=null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        //在双链表中间插入新元素
//        DoubleListNode p = head;
//        for (int i = 0; i < 2; i++) {
//            p = p.next;
//        }
//        DoubleListNode newNode = new DoubleListNode(88);
//        newNode.next = p.next;
//        newNode.prev = p;
//        p.next = newNode;
//        p.next.prev = newNode;
//        while (head!=null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        //在双链表中删除一个节点
//        DoubleListNode p = head;
//        for (int i = 0; i < 2; i++) {
//            p = p.next;
//        }
//        p.next.prev = p.prev;
//        p.prev.next = p.next;
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }

        //在双链表头部删除元素
//        DoubleListNode newHead = head.next;
//        head.next.prev = null;
//        head.next = null;
//        head = newHead;
//        while(head!=null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        //在双链表尾部删除元素
//        DoubleListNode p = head;
//        while(p.next != null){
//            p = p.next;
//        }
//        tail = p;
//        DoubleListNode newTail = tail.prev;
//        newTail.next = null;
//        tail.prev = null;
//        while(head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }







    }
}
