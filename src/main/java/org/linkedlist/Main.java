package org.linkedlist;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertAtTheEnd("test1");
        list.insertInTheBeginning("First Node");
        list.insertAtTheEnd("Last Node");
        list.insertAtPosition(3, "Hello");
        list.insertInTheBeginning("The Very First Node");
        list.insertInTheBeginning("Hello");
        list.insertAtPosition(25, "test");

        printList(list);

        String searchedValue = "Hello";
        printSearchResult(list, searchedValue);

        printLength(list);

        confirmRemoval(list.removeValue("Hello"));
        printList(list);

        confirmRemoval(list.removeByPosition(7));
        printList(list);

        list.clear();
        printList(list);

    }

    public static void printList(LinkedList list) {
        var p = list.getHead();

        if (p == null) {
            System.out.println("The list is empty");
            return;
        }

        System.out.println("Linked list: ");
        while (p != null) {
            System.out.print("[" + p.getData() + "] ");
            p = p.getNext();
        }
        System.out.println();
    }

    public static void printSearchResult(LinkedList list, String value) {
        if (list.search(value)) {
            System.out.println("Value " + value + " was found in the list");
        } else {
            System.out.println("Value " + value + " was not found in the list");
        }
    }

    public static void printLength(LinkedList list) {
        if (list.length() > 0) {
            System.out.println("This list contains " + list.length() + " nodes");
        } else {
            System.out.println("This list is empty");
        }
    }

    public static void confirmRemoval(Boolean result) {
        if (result) {
            System.out.println("Node was successfully removed");
        } else {
            System.out.println("Node was not removed");
        }
    }
}

