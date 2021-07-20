package com.company;


public class BSTpractice {



    static BST.TreeNode root = null;

    static BST.TreeNode rootOther = null;


    public static void main(String[] args)
    {
        //to access a method that is non-static
        //since the method called addNode is non-static we need to initialize it and create an object to access it
        BST bst = new BST();


        root = bst.addNode(root,6);
        root = bst.addNode(root,4);
        root = bst.addNode(root,8);
        root = bst.addNode(root,2);
        root = bst.addNode(root,5);
        root = bst.addNode(root,7);
        root = bst.addNode(root,9);


        rootOther = bst.addNode(rootOther,6);
        rootOther = bst.addNode(rootOther,4);
        rootOther = bst.addNode(rootOther,8);
        rootOther = bst.addNode(rootOther,2);
        rootOther = bst.addNode(rootOther,5);
        rootOther = bst.addNode(rootOther,7);
        rootOther = bst.addNode(rootOther,9);





        //the method inOrder is static therefore we do NOT need to initialize an object to access it
        //we just need to call the class where it lives

        
        BST.inOrder(root);



        System.out.println();
        //String [] ans = otherForm(root);

        //for (String i : ans)
            //System.out.print(" " + i);

        System.out.println(check(root,rootOther));

    }


    public static boolean check(BST.TreeNode root1, BST.TreeNode root2)
    {

        if(root1 == null && root2 == null)
            return true;


        else if(root1 == null && root2 != null)
            return false;
        else if(root1 != null && root2 == null)
                return false;

        check(root1.left,root2.left);
        check(root2.right,root2.right);

        if(root1.val == root2.val)
            return true;
        else
            return false;

    }





    public static String [] otherForm(BST.TreeNode head)
    {
        String [] y ;


        y = new String[]{"hello", "world"};

        return y;




    }




}
