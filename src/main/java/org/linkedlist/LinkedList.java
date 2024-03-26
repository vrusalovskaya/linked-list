package org.linkedlist;

import java.util.Objects;

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

    public void insertAtPosition(Integer position, String data) {
        if (position == 1) {
            insertInTheBeginning(data);
            return;
        }

        Node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }

        if (temp != null) {
            insertAfterNode(temp, data);
        }
    }

    public boolean removeValue(String data) {
        Node temp = head;
        Node prev = null;

        while (temp != null && !Objects.equals(temp.data, data)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null && Objects.equals(temp.data, data)) {
            prev.next = temp.next;
            return true;
        } else return false;
    }

    public boolean removeByPosition(Integer position) {
        Node temp = head;

        if (temp != null && position == 1) {
            head = head.next;
            return true;
        }

        for (int i = 1; i < position; i++) {
            if (temp == null) {
                break;
            } else {
                temp = temp.next;
            }
        }

        if (temp != null) {
            temp.next = temp.next.next;
            return true;
        } else return false;
    }

    public boolean search(String data) {
        Node temp = head;
        while (temp != null && !Objects.equals(temp.data, data)) {
            temp = temp.next;
        }

        return temp != null && Objects.equals(temp.data, data);
    }

    public Integer listLength(Node head) {
        if (head == null) {
            return 0;
        }

        Integer count = 1;
        Node temp = head;

        while (temp.next != null){
            count ++;
            temp = temp.next;
        }
        return count;
    }

    public void clearList (){
        this.head = null;
    }
}
