package org.linkedlist;

import java.util.Objects;

public class LinkedList {
    private class Node implements INode {
        String data;
        Node next;

        Node (String data){
            this.data = data;
            next = null;
        }

        @Override
        public INode getNext() {
            return next;
        }

        @Override
        public String getData() {
            return data;
        }
    }
    private Node head;

    public INode getHead () {
        return head;
    }

    public void insertInTheBeginning(String data) {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    public void insertAtTheEnd(String data) {
        Node new_node = new Node(data);

        Node temp = head;
        if (insertInTheBeggingIfEmpty(temp, data)) {
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new_node;
    }

    public void insertAtPosition(Integer position, String data) {
        if (position == 1) {
            insertInTheBeginning(data);
            return;
        }

        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp != null) {
            insertAfterNode(temp, data);
        } else {
            insertInTheBeggingIfEmpty(temp, data);
        }
    }

    public boolean removeValue(String data) {
        Node temp = head;
        Node prev = null;

        if (Objects.equals(head.data, data)) {
            head = head.next;
            return true;
        }

        while (temp != null && !Objects.equals(temp.data, data)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp != null && Objects.equals(temp.data, data)) {
            prev.next = temp.next;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeByPosition(Integer position) {
        Node temp = head;

        if (temp != null && position == 1) {
            head = head.next;
            return true;
        }

        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.next = temp.next.next;
            return true;
        } else {
            return false;
        }
    }

    public boolean search(String data) {
        Node temp = head;
        while (temp != null && !Objects.equals(temp.data, data)) {
            temp = temp.next;
        }

        return temp != null;
    }

    public Integer length() {
        if (this.head == null) {
            return 0;
        }

        Integer count = 1;
        Node temp = this.head;

        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void clear() {
        this.head = null;
    }

    private boolean insertInTheBeggingIfEmpty(Node temp, String data) {
        if (temp == null) {
            insertInTheBeginning(data);
            return true;
        } else {
            return false;
        }
    }

    private void insertAfterNode(Node node, String data) {
        Node new_node = new Node(data);

        if (insertInTheBeggingIfEmpty(node, data)) {
            return;
        }

        new_node.next = node.next;
        node.next = new_node;
    }

}

