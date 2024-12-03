public class Ex1_Driver {
    public static void main(String[] args) {
        ArrayQ arrayQ = new ArrayQ();
        LinkedQueue linkedQueue = new LinkedQueue();

        // Enqueue elements
        int[] elements = {1, 7, 3, 4, 9, 2};
        for (int element : elements) {
            arrayQ.enqueue(element);
            linkedQueue.enqueue(element);
        }

        // Dequeue and display elements from ArrayQ
        System.out.println("Dequeueing elements from ArrayQ:");
        while (!arrayQ.isEmpty()) {
            System.out.println(arrayQ.dequeue());
        }

        // Dequeue and display elements from LinkedQueue
        System.out.println("\nDequeueing elements from LinkedQueue:");
        while (!linkedQueue.isEmpty()) {
            System.out.println(linkedQueue.dequeue());
        }
    }
}

class ArrayQ {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayQ() {
        capacity = 10; // Default capacity
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }
}

class LinkedQueue {
    private Node front;
    private Node rear;

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return item;
    }
}
