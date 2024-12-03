import java.util.Scanner;

// LinkedNode.java
class LinkedNode {
    int value;
    LinkedNode next;

    LinkedNode(int value) {
        this.value = value;
        this.next = null;
    }
}

// Set.java
class Set {
    private LinkedNode head;

    Set() {
        head = null;
    }

    // Method to add an element to the set
    public void add(int x) {
        if (!exists(x)) {
            LinkedNode newNode = new LinkedNode(x);
            newNode.next = head;
            head = newNode;
        }
    }

    // Method to delete an element from the set
    public void delete(int x) {
        if (head == null) return;
        
        if (head.value == x) {
            head = head.next;
            return;
        }
        
        LinkedNode current = head;
        while (current.next != null) {
            if (current.next.value == x) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Method to check if an element exists in the set
    public boolean exists(int x) {
        LinkedNode current = head;
        while (current != null) {
            if (current.value == x) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to represent the set as a space-separated string
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedNode current = head;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}

// Assignment4_Test.java
class Assignment4_Test {
    public static void main(String[] args) {
	System.out.println("Programming Fundamentals");
	System.out.println("NAME: RAVIKUMAR NAIK");
	System.out.println("PROGRAMMING ASSIGNMENT 4 - SET\n");
        Scanner scanner = new Scanner(System.in);
        Set set = new Set();

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] command = input.split(" ");
            if (command.length != 2) {
                System.out.println("Invalid command. Please enter in the format: add/del/exists <number>");
                continue;
            }
            int num;
            try {
                num = Integer.parseInt(command[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer.");
                continue;
            }
            switch (command[0]) {
                case "add":
                    set.add(num);
                    break;
                case "del":
                    set.delete(num);
                    break;
                case "exists":
                    System.out.println(set.exists(num));
                    break;
                default:
                    System.out.println("Invalid command. Please enter either add, del, or exists.");
            }
            System.out.println(set.toString());
        }
    }
}
