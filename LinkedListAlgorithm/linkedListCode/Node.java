package linkedListCode;

public class Node<E> {
    public E val;
    public Node<E> next;
    public Node<E> prev;

    public Node(Node<E> prev, E element, Node<E> next) {
        this.val = element;
        this.next = next;
        this.prev = prev;
    }
}