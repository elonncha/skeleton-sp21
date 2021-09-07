package deque;

public class LinkedListDeque<T> {

    public class Node {
        public Node prev;
        public Node next;
        public T item;

        public Node(Node p, T i, Node n){
            prev = p;
            i = item;
            n = next;
        }
    }

    private int size;
    public Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node(null,null,null);
        sentinel.next = sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel.next = sentinel.prev = new Node(sentinel, item, sentinel);
        size = 1;
    }

    public int size() {return this.size;}

    public boolean isEmpty() { return this.size == 0; }

    public void addFirst(T item){
        sentinel.next = sentinel.next.prev = new Node(sentinel, item, sentinel.next);
        size += 1;
    }

    public void addLast(T item){
        sentinel.prev = sentinel.prev.next = new Node(sentinel.prev, item, sentinel);
        size += 1;
    }

    public void printDeque(){
        Node currentNode = sentinel;
        for (int i=0;i<= this.size-1; i++) {
            currentNode = currentNode.next;
            System.out.println(currentNode.item);
        }
    }

}
