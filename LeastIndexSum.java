package com.company;

public class LeastIndexSum {


    public static void main(String [] args)
    {

        String [] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String [] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};


        String [] finalAnswer = findRestaurant(list1,list2);

        for(int i = 0; i < finalAnswer.length; i++)
        {

            System.out.print(finalAnswer[i] + " ");

        }
    }

    public static String [] findRestaurant(String[] list1, String []list2)
    {
        int [] tempArray;
        String [] ans;





        if(list1.length < list2.length)
        {
            tempArray = new int[list1.length];
            ans = new String[list1.length];

            //list1 is shorter
            for(int i = 0; i < list2.length; i++)
            {
                for(int j = 0; j < list1.length; j++)
                {

                    if(list1[j].equals(list2[i]) && tempArray[j] != 1)
                    {
                        tempArray[j] = 1;
                    }

                }

            }

        }

        else
        {
            tempArray = new int[list2.length];
            int counter = 0;


            //list2 is shorter
            for(int i = 0; i < list1.length; i++)
            {
                for(int j = 0; j < list2.length; j++)
                {
                    if(list1[j].equals(list2[i]) && tempArray[j] != 1)
                    {
                        tempArray[j] = 1;
                        counter++;
                    }


                }
            }
            ans = new String[counter];

            for(int i = 0 ; i < tempArray.length; i++)
            {
                int k = 0;

                if(tempArray[i] == 1)
                {
                    ans[k] = list2[i];
                    k++;
                }

            }



        }


        return ans;



    }


}
