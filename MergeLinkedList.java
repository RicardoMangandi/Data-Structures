package com.company;

public class MergeLinkedList {


    //This is a driver tester to test out leetcode question
    //that merges two lists that are sorted

    public static void main(String[] args) {

        //List l1 is created
        ListNode head = new ListNode(1, null);
        ListNode other = new ListNode(2, null);
        head.next = other;
        other.next = new ListNode(4, null);
        ListNode l1 = head;


        //List l2 is created
        ListNode otherHead = new ListNode(0, null);
        ListNode otherTemp = new ListNode(3, null);
        otherHead.next = otherTemp;
        otherTemp.next = new ListNode(4, null);
        ListNode l2 = otherHead;



        ListNode finalList = mergeTwoLists(l1, l2);


        while (finalList != null) {
            System.out.print(finalList.val + " ");
            finalList = finalList.next;

        }


    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode head = new ListNode(0);
        ListNode traversal = head;

       while(l1 != null && l2 != null)
       {

           if(l1.val <= l2.val)
           {
            traversal.next = l1;
            l1 = l1.next;

           }

           else
           {
               traversal.next = l2;
               l2 = l2.next;

           }
        traversal = traversal.next;
       }


       if(l1 != null)
       {
           traversal.next = l1;
       }
       else
       {
           traversal.next = l2;
       }


       return head.next;
    }
}