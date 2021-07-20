package com.company;

public class Queue {


    Node front = null;
    Node back = null;
    int sizeOfQ = 0;

    static class Node {

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

    public static void main(String [] args)
    {

        Queue queue = new Queue();


        dequeue(queue);
        /*
        //dequeue(queue);
        enqueue(queue,70);
        printCurrentQueue(queue);
        enqueue(queue,71);
        printCurrentQueue(queue);
        enqueue(queue,72);
        printCurrentQueue(queue);
        enqueue(queue,73);
        printCurrentQueue(queue);
        enqueue(queue,74);
        printCurrentQueue(queue);
        enqueue(queue,75);
        printCurrentQueue(queue);
        enqueue(queue,76);
        printCurrentQueue(queue);
        enqueue(queue,78);
        printCurrentQueue(queue);

        //start removing
        dequeue(queue); //dequeue 70
        printCurrentQueue(queue);
        dequeue(queue); //dequeue 71
        printCurrentQueue(queue);
        dequeue(queue); //dequeue 72
        printCurrentQueue(queue);
        dequeue(queue); //dequeue 73
        */

        peek(queue); //peek is 74
    }


    public static void printCurrentQueue(Queue queue)
    {
        Node traverse = queue.front;

        while(traverse != null)
        {
            System.out.print(traverse.val + " ");
            traverse = traverse.next;
        }
        System.out.println();
    }

    //get the first value without deleting front
    public static void peek(Queue queue)
    {

        if(queue.sizeOfQ == 0)
        {
            System.out.println("Queue is empty");
        }

        else
        {
            System.out.println("Front of queue: " + queue.front.val);
        }
    }

    //add to the back is time complexity of O(1)
    public static void enqueue(Queue queue, int val)
    {
        Node newNode = new Node(null,null,val);

        //list is empty
        if(queue.front == null && queue.back == null)
        {
            queue.front = newNode;
            queue.back = newNode;
        }

        //else place it at the end of the list
        else
        {
            Node temp = queue.back;
            temp.next = newNode;
            newNode.prev = temp.next;
            newNode.next = null;
            queue.back = newNode;
            queue.sizeOfQ++;
        }
    }

    //delete from front has time complexity of O(1)
    public static void dequeue(Queue queue)
    {
        if(queue.front == null && queue.back == null)
        {
            System.out.println("There are no elements in the queue");
        }

        //else delete the head
        else
        {
            if(queue.sizeOfQ != 1)
            {
                queue.front = queue.front.next;
                queue.sizeOfQ--;
                queue.front.prev = null;
            }

            else
            {
                queue.sizeOfQ--;
                queue.front = null;
                queue.back = null;
            }
        }
    }
}
