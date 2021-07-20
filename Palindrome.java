package com.company;

import java.util.Stack;

public class Palindrome {

    Node head;

    static class Node {

        Node next;
        int val;

        Node(Node next, int val) {
            this.next = next;
            this.val = val;

        }


    }


    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();

        palindrome.head = insertNode(palindrome.head,1);
        palindrome.head = insertNode(palindrome.head,2);
        palindrome.head = insertNode(palindrome.head,2);
        palindrome.head = insertNode(palindrome.head,1);
        //palindrome.head = insertNode(palindrome.head,'n');


        Node printer = palindrome.head;
        while(printer != null)
        {
            System.out.print(" " + printer.val);
            printer = printer.next;

        }

        System.out.println();

        if(isPalindromeFaster(palindrome.head))
        {

            System.out.println("Is palindrome");
        }

        else
        {
            System.out.println("Is not palindrome");

        }


    }

    //accepted solution
    public static boolean isPalindromeFaster(Node head)
    {

        Stack <Node> stack = new Stack<>();

        Node temp = head;
        while(temp != null)
        {
            stack.add(temp);
            temp = temp.next;

        }

        Node otherTemp = head;
        while(otherTemp != null)
        {
            int val = stack.pop().val;

            if(val != otherTemp.val)
                return false;

            otherTemp = otherTemp.next;
        }

        return true;

    }






    //create a new list which is O(n) space complexity
    //create a new list is O(n) for insertion
    //Reversing the list is O(n)

    //solution is too slow and will not be accepted
    public static boolean isPalindrome(Node head)
    {

        Node temp = head;
        Node otherHead = null;


        while(temp != null)
        {

            otherHead = insertNode(otherHead,temp.val);
            temp = temp.next;
        }



       //reverse the list and compare
        Node prev = null;
        Node curr = head;
        Node next = head;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

         Node pointer1 = prev;
         Node pointer2 = otherHead;

         while(pointer1 != null && pointer2 != null)
         {

             if(pointer1.val != pointer2.val)
             {
                 return false;
             }

             pointer1 = pointer1.next;
             pointer2 = pointer2.next;

         }

        return true;

    }



    public static Node insertNode(Node head, int val)
    {

        if(head == null)
        {
            head = new Node(null,val);
            return head;
        }

       Node temp = head;

        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = new Node(null,val);


        return head;
    }


}

