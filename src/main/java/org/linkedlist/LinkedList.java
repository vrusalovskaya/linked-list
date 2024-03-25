package org.linkedlist;

public class LinkedList {

    Node head;

    public void insertInTheBeginning(String data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void insertAtTheEnd(String data) {
        Node new_node = new Node(data);

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new_node;
    }

    public void insertAfterNode(Node node, String data) {
        Node new_node = new Node(data);
        new_node.next = node.next;
        node.next = new_node;
    }

    public boolean insertAtPosition(Integer position, String data) {
        if (position == 1) {
            insertInTheBeginning(data);
        }

        Node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            return false;
        } else insertAfterNode(temp, data);
        return true;
    }

}
