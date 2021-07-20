package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BST {

    TreeNode root = null;

    public class TreeNode
    {

        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(TreeNode left, TreeNode right, int val)
        {
            this.val = val;
            this.left = left;
            this.right = right;

        }


    }

    /*
    public static void main(String [] args)
    {

        BST bst = new BST();


        bst.root =  addNode(bst.root,6);
        bst.root = addNode(bst.root,4);
        bst.root = addNode(bst.root,2);
        bst.root = addNode(bst.root,5);
        bst.root = addNode(bst.root,9);
        bst.root = addNode(bst.root,7);
        bst.root = addNode(bst.root,10);


        TreeNode rootVal = peekRoot(bst.root);

        if(bst.root.left.val == 4)
            System.out.println("yes");
        if(bst.root.left.left.val == 2)
            System.out.println("yes");
        if(bst.root.left.right.val == 5)
            System.out.println("yes");


        if(bst.root.right.val == 9)
            System.out.println("yes");
        if(bst.root.right.left.val == 7)
            System.out.println("yes");
        if(bst.root.right.right.val == 10)
            System.out.println("yes");


        System.out.println("Peek root: " + rootVal.val);
        System.out.println();
        System.out.print("PreOrder: ");
        preOrder(bst.root);
        System.out.println();
        System.out.print("Inorder: ");
        inOrder(bst.root);
        System.out.println();
        System.out.print("PostOrder: ");
        postOrder(bst.root);


        //bst.root = deleteNode(bst.root, 2);
       // bst.root = deleteNode(bst.root,5);

       //bst.root = deleteNode(bst.root,11);
      // bst.root =  deleteNode(bst.root,4);
       //bst.root = deleteNode(bst.root,6);

      // System.out.println();
       //preOrder(bst.root);

       System.out.println();

       /*
       if(findNode(bst.root,7))
       {
           System.out.println("Val was found");
       }

       System.out.println();

       if(findNode(bst.root,9))
       {
           System.out.println("Val was found");

       }

        if(findNode(bst.root,2))
        {
            System.out.println("Val was found");

        }

        ArrayList<Integer> fin = collectOdd(bst.root);


        System.out.println(fin.size());

        for(int i = 0; i < fin.size(); i++)
        {
            System.out.print(fin.get(i) + " ");

        }
    }
    */
    static ArrayList<Integer> ans = new ArrayList<>();

    public static ArrayList<Integer> collectOdd(TreeNode root)
    {




        if(root == null)
            return ans;


        if(root.val % 2 != 0)
        {
            ans.add(root.val);

        }


        collectOdd(root.left);


        collectOdd(root.right);



        return ans;

    }


    public static boolean findNode(TreeNode root, int val)
    {

        while(root != null)
        {

            if(root.val == val)
                return true;

            else if(val < root.val)
            {
                root = root.left;

            }

            else
            {

                root = root.right;
            }


        }

        return false;


    }

    public static TreeNode preOrder(TreeNode root)
    {
        if(root == null)
            return null;

        System.out.print(" " + root.val);
        root.left = preOrder(root.left);
        root.right = preOrder(root.right);

        return root;
    }

    public static void inOrder(TreeNode root)
    {
        if(root == null)
            return;


        inOrder(root.left);
        System.out.print(" " + root.val);
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root)
    {
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" " + root.val);

    }

    public static TreeNode peekRoot(TreeNode root)
    {

        return root;

    }

    public TreeNode addNode(TreeNode root, int val)
    {
        TreeNode traversal = root;

        //root is empty so place root in position
        if(traversal == null)
        {
            traversal = new TreeNode(null, null, val);
            return traversal;
        }


        //go left
        if(val < traversal.val )
        {


            if(traversal.left == null)
            {
                traversal.left = new TreeNode(null, null, val);
            }

            else
            {
                addNode(traversal.left,val);
            }


        }
        //go right
        else
        {


            if(traversal.right == null)
            {
                traversal.right = new TreeNode(null, null, val);
            }

            else
            {
                addNode(traversal.right,val);
            }

        }

        return root;
    }


    public static int minValue(TreeNode root)
    {
        int minV = root.val;
        while(root.left != null)
        {

            minV = root.left.val;
            root = root.left;
        }


        return minV;
    }


    public static TreeNode deleteNode(TreeNode root, int val)
    {

        if(root == null)
            return null;

        //base case that ends recursion
        if(root.val == val)
        {
            //if the to be deleted node has no children
            if(root.left == null && root.right == null)
            {
              return null;
            }

            //just replace the root.val with the value we want to replace
            //there is no node to delete the actual root memory
            root.val = minValue(root.right);

            //we need to delete the node we are replacing head with
            root.right = deleteNode(root.right,root.val);

        }

        else if(val < root.val)
        {
            root.left = deleteNode(root.left,val);
        }

        else
        {
            root.right = deleteNode(root.right,val);
        }

        return root;
    }



}
