public class Driver {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();
        LinkedStack linkedStack = new LinkedStack();

        int[] numbers = {1, 7, 3, 4, 9, 2};

        // Pushing numbers onto the stacks
        for (int num : numbers) {
            arrayStack.push(num);
            linkedStack.push(num);
        }

        System.out.println("Popping off elements from ArrayStack:");
        while (!arrayStack.isEmpty()) {
            System.out.println(arrayStack.pop());
        }

        System.out.println("\nPopping off elements from LinkedStack:");
        while (!linkedStack.isEmpty()) {
            System.out.println(linkedStack.pop());
        }
    }
}

class ArrayStack {
    private int[] array;
    private int top;

    public ArrayStack() {
        array = new int[10]; // Assuming initial capacity of 10
        top = -1;
    }

    public void push(int item) {
        if (top == array.length - 1) {
            // Resize array if full
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[++top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class LinkedStack {
    private Node top;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void push(int item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
