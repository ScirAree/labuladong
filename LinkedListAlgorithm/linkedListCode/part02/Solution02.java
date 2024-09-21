import linkedListCode.ListNode;
import java.util.HashMap;
import java.util.Stack;
import java.util.PriorityQueue;

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


//删除排序链表中的重复元素II
public static ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(-1);
    ListNode p = dummy,q = head;
    while(q!=null){
        if(q.next!=null&&q.next.val == q.next.next.val){
            q = q.next;
        }
        q = q.next;
        if(q==null){
            p.next = q;
        }
        else{
            p.next = q;
            p = p.next;
            q = q.next;
        }
    }
    return dummy.next;
}


//递归删除排序链表中的重复元素
public static ListNode deleteDuplicate(ListNode head){
    if(head == null || head.next == null){
        return head;
    }
    if(head.val !=head.next.val){
        head.next = deleteDuplicate(head.next);
        return head;
    }
    while(head.next!=null&&head.val == head.next.val){
        head = head.next;
    }
    return deleteDuplicate(head.next);
}


//从未排序的链表中移除重复元素
public static ListNode deleteDuplicatesUnsorted(ListNode head){
    HashMap<Integer,Integer> count = new HashMap<>();
    ListNode p = head;
    while(p!=null){
        count.put(p.val,count.getOrDefault(p.val,0)+1);
        p = p.next;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    p = dummy;
    while(p!=null){
        ListNode unique = p.next;
        while(unique!=null&&count.get(unique.val)>1){
            unique = unique.next;
        }
        p.next = unique;
        p = p.next;
    }
    return dummy.next;
}


//丑数
public static int nyhUglyNumber(int n){
    int p2 = 1, p3 = 1, p5 = 1;
    int product2 = 1, product3 = 1, product5 = 1;
    int[] ugly = new int[n+1];
    int p = 1;
    while(p<=n){
        int min = Math.min(Math.min(product2,product3),product5);
        ugly[p] = min;
        p++;
        if(min == product2){
            product2 = 2 * ugly[p2];
            p2++;
        }
        if(min == product3){
            product3 = 3 * ugly[p3];
            p3++;
        }
        if(min == product5){
            product5 = 5 * ugly[p5];
            p5++;
        }
    }
    return ugly[n];
}


//有序矩阵中第k小的元素
public static int kthSmallest(int[][] matrix, int k){
    // 存储二元组 (matrix[i][j], i, j)
    // i, j 记录当前元素的索引位置，用于生成下一个节点
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        // 按照元素大小升序排序
        return a[0] - b[0];
    });
    // 初始化优先级队列，把每一行的第一个元素装进去
    for (int i = 0; i < matrix.length; i++) {
        pq.offer(new int[]{matrix[i][0], i, 0});
    }
    int res = -1;
    // 执行合并多个有序链表的逻辑，找到第 k 小的元素
    while (!pq.isEmpty() && k > 0) {
        int[] cur = pq.poll();
        res = cur[0];
        k--;
        // 链表中的下一个节点加入优先级队列
        int i = cur[1], j = cur[2];
        if (j + 1 < matrix[i].length) {
            pq.add(new int[]{matrix[i][j + 1], i, j + 1});
        }
    }
    return res;
}


//俩数相加
public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
    ListNode p1 = l1, p2 = l2;
    ListNode dummy = new ListNode(-1);
    ListNode p = dummy;
    int carry = 0;
    while(p1!=null||p2!=null||carry > 0){
        int val = carry;
        if(p1!=null){
            val += p1.val;
            p1 = p1.next;
        }
        if(p2!=null){
            val += p2.val;
            p2 = p2.next;
        }
            carry = val / 10;
            val = val % 10;
            p.next = new ListNode(val);
            p = p.next;
    }
    return dummy;
}


//俩数相加II
public static ListNode addTwoNumbersII(ListNode l1, ListNode l2){

    Stack<Integer> stk1 = new Stack<>();
    while(l1!=null){
        stk1.push(l1.val);
        l1 = l1.next;
    }
    Stack<Integer> stk2 = new Stack<>();
    while(l2!=null){
        stk2.push(l2.val);
        l2 = l2.next;
    }

    ListNode dummy = new ListNode(-1);

    int carry = 0;
    while(!stk1.isEmpty() || !stk2.isEmpty()||carry > 0){
        int val = carry;
        if(!stk1.isEmpty()){
            val += stk1.pop();
        }
        if(!stk2.isEmpty()){
            val += stk2.pop();
        }
         carry = val / 10;
         val = val % 10;
         ListNode newNode = new ListNode(val);
         newNode.next = dummy.next;
         dummy.next = newNode;

    }
    return dummy.next;
}


public static void main(String[] args) {


    ListNode l1 = createSingleLinkedList(new int[]{1,8,5,3,9,6,76,45,454,4,5,5,5,6});
    ListNode l2 = createSingleLinkedList(new int[]{2,3,4});


//int m = kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8);
//System.out.println(m);


//ListNode head = deleteDuplicatesUnsorted(l1);
//while(head!=null){
//    System.out.println(head.val);
//    head = head.next;
//}


//ListNode head =deleteDuplicates(l1);
//while(head!=null){
//    System.out.println(head.val);
//    head = head.next;
//}




}
