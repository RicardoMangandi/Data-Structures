package com.company;

public class Stack<N> {


    Node top = null; //head
    Node bottom = null; //tail
    int sizeOfList = 0;

    static class Node
    {

        Node prev;
        Node next;
        int val;

        Node(Node prev, Node next, int val)
        {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }


    public static void main (String [] args)
    {

        Stack stack = new Stack();

        push(stack,1);
        push(stack,2);
        push(stack,3);
        push(stack,4);
        push(stack,5);

        pop(stack);
        pop(stack);

        push(stack,90);

        //Expected:
        //90 <- top
        //3
        //2
        //1 <- bottom



        printStack(stack);

        //Top of stack: 90
        peek(stack);

        //Final size: 4
        System.out.println("Final size: " + stack.sizeOfList);
    }


    public static void printStack(Stack stack)
    {
        Node traverse = stack.top;

        while(traverse != null)
        {
            System.out.println(traverse.val);
            traverse = traverse.next;
        }
    }

    //This operation is time complexity O(1)
    //It checks what the head.val is and returns the stack
    public static void peek(Stack stack)
    {
        if(stack.sizeOfList != 0)
        {
            System.out.println("Top of stack: " + stack.top.val);
        }

        else
        {
            System.out.println("Stack is empty");
        }
    }

    //This operation is time complexity O(1)
    //It keeps deleting the head and keeps updating it and returns the stack
    public static void pop(Stack stack)
    {
       // Node traverse = stack.top;
        if(stack.sizeOfList != 0)
        {
            stack.top = stack.top.next;
            stack.top.prev = null;
            stack.sizeOfList--;
        }

        else
        {
            System.out.println("The stack is empty cannot pop items anymore");
        }
    }


    //This operation is time complexity O(1)
    //It keeps adding values to the head and updates it and returns the stack
    public static void push(Stack stack, int val)
    {
        //Check if the top is empty, if yes then the top and bottom is created
        if(stack.top == null)
        {
            Node newNode = new Node(null,null,val);
            stack.top = newNode;
            stack.bottom = newNode;
            stack.sizeOfList++;
        }

        //insert value at the head of the list
        else
        {
            Node traverse = stack.top;
            Node newNode = new Node(null,traverse,val);
            traverse.prev = newNode;
            stack.top = newNode;
            stack.sizeOfList++;
        }
    }
}
