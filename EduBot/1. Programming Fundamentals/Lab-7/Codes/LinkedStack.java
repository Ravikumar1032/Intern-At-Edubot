import java.util.EmptyStackException;

public class LinkedStack<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement() {
            return element;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> top = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E top() {
        if (isEmpty()) throw new EmptyStackException();
        return top.getElement();
    }

    public void push(E e) {
        top = new Node<>(e, top);
        size++;
    }

    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E answer = top.getElement();
        top = top.getNext();
        size--;
        return answer;
    }

    public void removeBottomHalf() {
        if (isEmpty()) throw new EmptyStackException();
        int halfSize = size / 2;
        Node<E> current = top;
        for (int i = 0; i < halfSize - 1; i++) {
            current = current.getNext();
        }
        current.setNext(null);
        size = halfSize;
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        System.out.println("Original stack:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        stack.removeBottomHalf();
        System.out.println("\nStack after removing bottom half:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
