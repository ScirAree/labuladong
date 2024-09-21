package linkedListCode;

public class MyLinkedList <E> {

    public void createMyLinedList(E[] arr){
        if (arr == null) return;
       for(E item:arr){
           addLast(item);
       }
    }

    //双链表结点
    private  class Node<E> {
        E val;
        Node<E> prev;
        Node<E> next;
        Node(E val){
            this.val = val;
        }
    }

    //虚拟头尾结点
    private Node<E> head;
    private Node<E> tail;
    private int size;

    //带有虚拟头尾结点的MyLinkedList构造函数
    public MyLinkedList(){
         this.size = 0;
         this.head = new Node<>(null);
         this.tail = new Node<>(null);
         head.next = tail;
         tail.prev = head;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        Integer[] arr = {1,2,3,4,5,};
        myLinkedList.createMyLinedList(arr);
        myLinkedList.add(2,22);
        while(myLinkedList.head!=null){
            System.out.println(myLinkedList.head.val);
            myLinkedList.head = myLinkedList.head.next;
        }

    }

    //增
    public void addLast(E e){
        Node<E> x = new Node<>(e);
        Node<E> temp = tail.prev;
        temp.next = x;
        x.next = tail;
        tail.prev = x;
        size++;
    }

    public void addFirst(E e){
        Node<E> x = new Node<>(e);
        Node<E> temp = head.next;
        temp.prev = x;
        x.next = temp;
        head.next = x;
        x.prev = head;
        size++;
    }

    public void add(int index, E element){
        Node<E> e = new Node<>(element);
        Node<E> p = head;
        for (int i = 0; i < index-1; i++){
            p= p.next;
        }
        Node<E> q = p.next;
        p.next = e;
        e.prev = p;
        q.prev = e;
        e.next = q;
        size++;
    }

    //删
    public E removeFirst(){
        Node<E> x = head.next;
        Node<E> temp = x.next;
        head.next = temp;
        temp.prev = head;

        x.prev = null;
        x.next = null;
        size--;
        return  x.val;
    }

    public E removeLast(){
        Node<E> x = tail.prev;
        Node<E> temp = x.prev;
        tail.prev = temp;
        temp.next = tail;

        x.prev = null;
        x.next = null;
        size--;
        return  x.val;
    }

    public E remove(int index){
        Node<E> p = head;
        for(int i = 0; i < index ; i++){
            p = p.next;
        }
        Node<E> x = p.next;
        Node<E> y = p.prev;
        y.next = x;
        x.prev = y;
        p.next = null;
        p.prev = null;
        size--;
        return p.val;
    }

    //改
    public E set(int index, E val){
        Node<E> p = head;
        for(int i = 0; i < index ; i++){
            p = p.next;
        }
        E oldVal = p.val;
        p.val = val;
        return  oldVal;
    }






























}
