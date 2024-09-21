package linkedListCode;

public class singleLinkedListBase {

    //单链表结点
    static class ListNode{
        Integer val;
        ListNode next;
        ListNode(int x){this.val = x;};
    }

//    输入一个数组，将其转换成一个单链表
static ListNode createLinkedList(int[] arr){
        if(arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i = 1; i < arr.length; i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{1,2,3,4,5,});

//        遍历单链表
//        ListNode p = head;
//        while(head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        //在单链表头部插入一个新节点 0
//        ListNode p = new ListNode(0);
//        p.next = head;
//        head = p;
//        while(p != null){
//            System.out.println(p.val);
//            p = p.next;
//        }

        //在单链表尾部插入新元素
//        ListNode q = head;
//        while(q.next != null){
//            q = q.next;
//        }
//        q.next = new ListNode(6);
//        while(head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        //在单链表中间插入新元素
//        ListNode p = head;
//        for (int i = 0 ; i < 2; i++) {
//            p = p.next;
//        }
//        ListNode q = new ListNode(66);;
//        q.next = p.next;
//        p.next = q;

        //在单链表中删除一个节点
//        ListNode p = head;
//        for(int i = 0; i < 2; i++) {
//            p = p.next;
//        }
//        ListNode q = p.next;
//        p.next = q.next;
//        while(head!=null){
//            System.out.println(head.val);
//            head=head.next;
//        }

        //在单链表尾部删除元素
//        ListNode p = head;
//        while(head.next.next!=null){
//            head=head.next;
//        }
//        head.next = null;
//        while(p!=null){
//            System.out.println(p.val);
//            p=p.next;
//        }

        //在单链表头部删除元素
//        head=head.next;
//        while(head!=null){
//            System.out.println(head.val);
//            head=head.next;
//        }

    }




}
