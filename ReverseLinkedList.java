package com.company;

public class ReverseLinkedList {

    Node head = null;


    static class Node
    {
        Node next;
        int val;

        Node(Node next, int val)
        {

            this.next = next;
            this.val = val;
        }


    }

    public static void main(String[] args)
    {


        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        insertNode(reverseLinkedList,4);
        insertNode(reverseLinkedList,5);
        insertNode(reverseLinkedList,1);
        insertNode(reverseLinkedList,9);

        Node temp = reverseLinkedList.head;

        while(temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
        System.out.println("List in reverse:");
        reverseList(reverseLinkedList);



        Node otherTemp = reverseLinkedList.head;
        while(otherTemp != null)
        {
            System.out.print(otherTemp.val + " ");
            otherTemp = otherTemp.next;
        }

    }

    public static void insertNode(ReverseLinkedList reverseLinkedList, int val)
    {

        if(reverseLinkedList.head == null)
        {
            reverseLinkedList.head = new Node(null,val);
        }

        else
        {
            Node traverse = reverseLinkedList.head;
            while(traverse.next != null)
            {
                traverse = traverse.next;
            }
            traverse.next = new Node(null,val);
        }

    }


    public static void reverseList(ReverseLinkedList reverseLinkedList)
    {


        Node current = reverseLinkedList.head;
        Node next = null;
        Node prev = null;

        while(current != null)
        {
            next = current.next;
            current.next = prev;

            //keep moving along the list and reverse pointers
            prev = current;
            current = next;
        }

        reverseLinkedList.head = prev;
        // 1 -> 2 -> 3
        //initially:
        //current = head
        //next = head
        //prev = null

        //prev = null
        //current = 1
        //current.next = prev which is null
        //next = 2

        //prev = 1
        //current = 2
        //current.next = 1
        //next = 3

        //prev = 2
        //current = 3
        //current.next = 2
        //next = null

        //prev = 3
        //current = null
        //current.next = 2
        //next = null



    }
}



