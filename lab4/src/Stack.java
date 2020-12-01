public class Stack {
    private int size = 0;
    private Node head = null;

    public void push(String value) {
        head = new Node(value, head);
        size++;
    }

    public String pop() {
        String value;
        if (head != null) {
            value = head.value;
            head = head.next;
            return value;
        } else {
            return "";
        }
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    static class Node {

        Node next;
        String value;

        Node (String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        Node temp = head;
        while (temp != null) {
            str.append(temp.value);
            temp = temp.next;
        }
        return str.toString();
    }
}
