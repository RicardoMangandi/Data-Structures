package com.company;



public class CycleLinkedList {


    ListNode head = null;

    static class ListNode
    {
        int val;
        ListNode next;
        ListNode (int x)
        {
            val = x;
            next = null;
        }
    }

    public static void main (String [] args)
    {

        CycleLinkedList cycleLinkedList = new CycleLinkedList();

        insertion(cycleLinkedList,-1,3);
        insertion(cycleLinkedList,-1,2);
        insertion(cycleLinkedList,-1,0);
        insertion(cycleLinkedList,1,4);

        ListNode traversal = cycleLinkedList.head;
        ListNode temp = cycleLinkedList.head.next;

        //
        int i = 0;

        while(i < 5)
        {

                if(traversal.val == 4 && traversal.next == temp)
                {
                    System.out.println("true");
                }

                System.out.print(traversal.val + " ");


            traversal = traversal.next;
            i++;
        }

        System.out.println();
        if(hasCycle(cycleLinkedList))
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }


    public static void insertion(CycleLinkedList cycleList, int pos, int val)
    {

        if(cycleList.head == null && pos == 0)
        {
            ListNode newNode = new ListNode(val);
            cycleList.head = newNode;
            //cycleList.next = null; //according to the class
            newNode.next = cycleList.head;
        }

        else if(cycleList.head == null && pos == -1)
        {
            ListNode newNode = new ListNode(val);
            cycleList.head = newNode;
        }
        //else if the list has an element and will have no cycle
        //place at the end of the list
        else if(cycleList.head != null && pos == -1)
        {

            ListNode traversal = cycleList.head;
            while(traversal.next != null)
            {
                traversal = traversal.next;
            }
            ListNode newNode = new ListNode(val);
            traversal.next = newNode;


        }

        //else the list has an element and will have a cycle
        else
        {

            ListNode traversal = cycleList.head;
            ListNode temp = null;
            int counter = 0;
            while(traversal.next != null)
            {
                if(counter == pos)
                {
                    temp = traversal;
                    System.out.println("true");
                }
                counter++;
                traversal = traversal.next;

            }
            ListNode newNode = new ListNode(val);
            traversal.next = newNode;
            newNode.next = temp;


        }

    }



    public static boolean hasCycle(CycleLinkedList cycleLinkedList)
    {

        ListNode slow = cycleLinkedList.head;
        ListNode fast = cycleLinkedList.head;

        while(slow != null || fast != null)
        {
            if(slow == fast)
                return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;

    }






}
