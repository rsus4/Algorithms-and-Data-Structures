import java.lang.*;
import java.util.*;
public class BinaryTree {

  static class Node{
        Node left;
        Node right;
        int data;
        public Node(Node left,Node right,int data){
            this.left=left;
            this.right=right;
            this.data=data;
        }
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class Pair{
      int height;
      int dia;

      public Pair(int height,int dia){
          this.height=height;
          this.dia=dia;
      }

    }






    //                                 T R A V E R S A L S

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);

    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }






    //                                 D I A M E T E R

    public static int diameter(Node root){
      if(root==null){
          return 0;
      }
      int lHeight=height(root.left);
      int rHeight=height(root.right);
      int ldiameter= diameter(root.left);
      int rdiameter=diameter(root.right);

      return Math.max(lHeight+rHeight+1,Math.max(ldiameter,rdiameter));
    }


    public static Pair diamEfficient(Node root){
      if(root==null){
          Pair p1=new Pair(0,0);
          return p1;
      }
      Pair q1=diamEfficient(root.left);
      Pair q2=diamEfficient(root.right);
      int height1=1+Math.max(q1.height,q2.height);
      int option1=q1.height+q2.height+ 1;
      int option2=q1.dia;
      int option3=q2.dia;
      int diameter1=Math.max(option1,Math.max(option2,option3));
      Pair a3=new Pair(height1,diameter1);
      return a3;
    }






//                                  H E I G H T

    public static int height(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }





    //                             C O U N T / S U M

    public static int countNodes(Node root){
      if(root==null){
          return 0;
      }
      return countNodes(root.left)+countNodes(root.right)+1;
    }
    public static int sumOfNodes(Node root){
      if(root==null){
          return 0;
      }
      return sumOfNodes(root.left)+sumOfNodes(root.right)+root.data;
    }
    public static void sumReplacement(Node root){
      if(root.left==null || root.right==null){
          return;
      }
      sumReplacement(root.left);
      sumReplacement(root.right);
      if(root.left==null && root.right!=null){
          root.data=root.data + root.right.data;
      }
      if(root.right==null && root.left!=null){
          root.data=root.data+root.left.data;
      }
      if(root.right!=null && root.right!=null){
          root.data=root.data+root.left.data+root.right.data;
        }


    }

    public static void main(String[] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
//                    1
//                  /   \
//                2       3
//              /   \   /   \
//            4      5 6     7


//        preorder(root);
//        inorder(root);
//        postorder(root);

//        int a=countNodes(root);
//        int a=sumOfNodes(root);
//        int a=height(root);
//        Diamater of a tree is the length of the longest path between two nodes.
//        System.out.println(a);

//        preorder(root);
//        sumReplacement(root);
//        preorder(root);

        int a=diameter(root);
        Pair b=diamEfficient(root);
        System.out.println(a);
        System.out.println(b.dia);

    }

}
