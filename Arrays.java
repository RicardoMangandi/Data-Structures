package com.company;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
//The class 'T' stands for type class
class Arrays <T> implements Iterable<T>{



    //We are initializing the array for the user
    //and stating that it start with size 0 and initial capacity 0
    T [] arr;
    int capacity = 0;
    int currentLength = 0;


    //implement a constructor for the Array
    public Arrays(int capacity)
    {
        if(capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity:" + capacity);

        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }




    public static void main(String [] args)
    {

        System.out.println("Arrays!");

        int yes = 1;

        Scanner sc = new Scanner(System.in);

        Arrays mArrays = new Arrays(2);



        while(yes > 0)
        {


            mArrays.menuPrint();

            System.out.println("Select an option 1 - 6");
            yes = sc.nextInt();

            if(yes == 0)
            {
                break;
            }

            if(yes == 1)
            {
                //function to add a value at the end of the list
                System.out.println("Please enter an integer: ");
                int val = sc.nextInt();
                mArrays.setValueAtEnd(val);
            }

            if(yes == 2)
            {

                //function to add a value at the specified index of the list
                System.out.println("Please enter an index integer");
                int index = sc.nextInt();
                System.out.println("Please enter an integer: ");
                int value = sc.nextInt();
                mArrays.setValueAtIndex(index,value);

            }

            if(yes == 3)
            {
               //function to get a value at a specified index
                System.out.println("Please enter an index integer");
                int index = sc.nextInt();
                int valueReturned = mArrays.getValueAtIndex(index);
                System.out.println("Value at index " + index + "is " +valueReturned);
            }

            if(yes == 4)
            {
                //function to clear the entire list
                mArrays.clearList();

            }

            if(yes == 5)
            {

                System.out.println("The current length is: " + mArrays.getLength());
            }

            if(yes == 6)
            {
                //check if list is empty
                System.out.println("The list is empty: " + mArrays.isListEmpty());
            }


            if(yes == 7)
            {

                //function to remove a value at the last index
                mArrays.removeAtLastIndex();

            }


            else if (yes < 0 || yes > 7) {

                System.out.println("Invalid input");
            }



        }


    }

    private void removeAtLastIndex()
    {

            arr[currentLength - 1] = null;
            currentLength--;

    }



    private boolean isListEmpty()
    {
        return currentLength == 0;


    }

    private void clearList()
    {
        for(int i = 0; i < currentLength; i++)
        {
            arr[i] = null;

        }
        currentLength = 0;

    }

    private int getValueAtIndex(int index) {

        return (int) arr[index];

    }


    private void menuPrint()
    {
        System.out.println("0. To exit");
        System.out.println("1. Set value to end of list");
        System.out.println("2. Set value to list with specified index");
        System.out.println("3. Get value at specified index");
        System.out.println("4. Clear the list");
        System.out.println("5. Get the length of the list");
        System.out.println("6. Check if the list is empty");
        System.out.println("7. Remove a value at the specified index");
        System.out.println("8. Remove a value at the last index");

    }

    private void setValueAtIndex(T index, T value)
    {

        if((int)index >= capacity)
        {
            throw new IndexOutOfBoundsException();
        }

        else
        {
            arr[(int)index] = value;

        }


    }

    private void setValueAtEnd(T value)
    {

        if(currentLength >= capacity)
        {
            capacity = capacity * 2;
            T[] newArr = (T[]) new Object[capacity];

            for(int i = 0; i < currentLength; i++)
            {
                newArr[i] = arr[i];
            }

            newArr[currentLength] = value;

            currentLength++;

            arr = newArr;
        }

        else {

            arr[currentLength] = value;
            currentLength++;
        }


    }

    private int getLength()
    {
        int counter = 0;
        for(int i = 0; i < capacity; i++)
        {
            if(arr[i] != null)
                counter++;

        }
        return counter;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }


    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
