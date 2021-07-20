package com.company;

import java.util.Scanner;


//The Linked List is implemented as a doubly linked list with a previous and next pointers
//All index begin counting at zero

class LinkedList {

    Node head;
    Node tail;
    int sizeOfList = 0;

    static class Node
    {
        Node prev;
        Node next;
        int val;

        Node(Node prev, Node next, int val)
        {
            this.next = next;
            this.prev = prev;
            this.val = val;
        }
    }



    public static void main(String[] args)
    {

        System.out.println("Linked List");
        Scanner sc = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        int loop = 1;

       // insertAtEnd(1,linkedList);
/*
        insertAtEnd(7,linkedList);
        insertAtEnd(7,linkedList);
        insertAtEnd(7,linkedList);
        insertAtEnd(7,linkedList);
        insertAtEnd(7,linkedList);
        insertAtEnd(7,linkedList);
        insertAtEnd(7,linkedList);
*/


        insertAtEnd(1,linkedList);
        insertAtEnd(2,linkedList);
        insertAtEnd(6,linkedList);
        insertAtEnd(3,linkedList);
        insertAtEnd(4,linkedList);
        insertAtEnd(5,linkedList);
        insertAtEnd(6,linkedList);
    /*
        while(loop > 0)
        {
            menu();
            loop = sc.nextInt();

            if(loop == 1)
            {
                System.out.println("Give me an integer value insert");
                int val = sc.nextInt();
                linkedList = insertAtEnd(val, linkedList);
            }


            if(loop == 2)
            {
                System.out.println("Give me an index to insert value");
                int index = sc.nextInt();
                System.out.println("Give me an integer value to insert");
                int val = sc.nextInt();
                linkedList = insertAtIndex(val,index,linkedList);
            }


            if(loop == 3)
            {
                System.out.println("Give me a value to delete");
                int val = sc.nextInt();
                linkedList = deleteValue(val,linkedList);
            }

            if(loop == 4)
            {
                System.out.println("Delete value at index, give us an index");
                int index = sc.nextInt();
                linkedList = deleteValueAtIndex(index,linkedList);
            }

            if(loop == 5)
            {
                printCurrentList(linkedList);
            }
        }*/

        //linkedList.head = removeElements(linkedList.head,7);
        linkedList.head = removeElements(linkedList.head,6);
        //System.out.println(linkedList.sizeOfList);
        Node toPrint = linkedList.head;

        while(toPrint != null)
        {
            System.out.print(toPrint.val + " ");
            toPrint = toPrint.next;
        }


    }


    public static void printCurrentList(LinkedList list)
    {
        Node traverse = list.head;

        while(traverse != null)
        {
            System.out.print(traverse.val + " ");
            traverse = traverse.next;

        }
        System.out.println();
    }

    public static Node removeElements(Node head, int val) {

        while (head != null && head.val == val)
            head = head.next;

        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val)
                curr.next = curr.next.next;

            else
                curr = curr.next;
        }
                return head;
    }

    public static LinkedList deleteValue(int value,LinkedList list)
    {
        int counter = 0;
        Node traverse = list.head;

        //we need to delete the head
        if(traverse.val == value)
        {
            System.out.println("Found at index: " + counter);
            list.head = list.head.next;
            list.sizeOfList--;
            return list;
        }

        else
        {
            while (counter < list.sizeOfList) {
                if (traverse.val == value && counter != list.sizeOfList - 1) {
                    System.out.println("Found at index: " + counter);
                    traverse.prev.next = traverse.next;
                    traverse.next.prev = traverse.prev;

                    //delete the value pointers so they are not pointing to anyone
                    traverse.next = null;
                    traverse.prev = null;


                    list.sizeOfList--;
                    return list;
                }

                //else we need to take care of who the tail will be
                else if (traverse.val == value) {
                    System.out.println("Found at index: " + counter);
                    list.tail = traverse.prev;
                    list.tail.next = null;
                    list.sizeOfList--;

                    traverse.next = null;
                    traverse.prev = null;

                    return list;
                }

                traverse = traverse.next;
                counter++;
            }

            if(counter == list.sizeOfList)
            {
                System.out.println("Index out of bound");
            }
        }

        return list;
    }


    public static LinkedList deleteValueAtIndex(int index, LinkedList list)
    {

        if(index == 0)
        {
            list.head = list.head.next;
            list.head.prev = null; //new addition
            list.sizeOfList--;
            return list;
        }

        else if(index < list.sizeOfList - 1)
        {
            Node traverse = list.head;
            int counter = 0;
            while(counter != index)
            {
                traverse = traverse.next;
                counter++;
            }

            traverse.prev.next = traverse.next;
            traverse.next.prev = traverse.prev;
            list.sizeOfList--;

            //free memory
            traverse.next = null;
            traverse.prev = null;

            return list;
        }

        //deal with deleting the tail
        else if(index == list.sizeOfList - 1)
        {
            list.tail = list.tail.prev;
            list.tail.next = null;
            list.sizeOfList--;
        }

        else if(index >= list.sizeOfList)
        {
            System.out.println("Index out of bound");
        }

        return list;
    }



    public static LinkedList insertAtIndex(int value,int index, LinkedList list)
    {


        if(index > list.sizeOfList)
        {
            System.out.println("Index out of bound");
            return list;
        }

        //place at the end of the list
        else if(index == list.sizeOfList)
        {
            return insertAtEnd(value,list);
        }

        else {

            Node traverse = list.head;
            int counter = 0;
            while(counter != index - 1)
            {
                traverse = traverse.next;
                counter++;
            }

            Node newNode = new Node(traverse,traverse.next,value);
            traverse.next.prev = newNode;
            traverse.next = newNode;
            list.sizeOfList++;

        }
        return list;
    }


    //return the head of the list
    public static LinkedList insertAtEnd(int value, LinkedList list)
    {

        if(list.head == null)
        {
        //we get to initialize our node with value
        Node node = new Node(null,null,value);

        //the head is now equal to the newly created node
        list.head = node;
        list.tail = node;
        list.sizeOfList++;
        }

        else
        {
            //we place the traverse node equal to head
            Node traverse = list.head;

            //we keep traversing until we hit the next null
            while(traverse.next != null)
            {
                traverse = traverse.next;

            }
            Node newNode = new Node(traverse,null,value);
            traverse.next = newNode;
            newNode.prev = traverse;
            list.tail = newNode;
            list.sizeOfList++;
        }
        return list;
    }

    public static void menu()
    {
        System.out.println("0. Exit program");
        System.out.println("1. Insert a node");
        System.out.println("2. Insert a node at specified index");
        System.out.println("3. Delete a node with specified value");
        System.out.println("4. Delete a node at specified index");
        System.out.println("5. Print current list");
    }


}
