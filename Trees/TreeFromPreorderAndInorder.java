import java.util.*;
public class TreeFromPreorderAndInorder {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }


    public static int search(int[] inorder,int current,int start,int end){
        int index=-1;
        for(int i=start;i<end;i++){
            if(inorder[i]==current){
                index=i;
                break;
            }
        }
        return index;
    }

    public static Node buildTree(int[] preorder,int[] inorder,int start,int end){
        int index=0;
        if(start>end){
            return null;
        }
        int current=preorder[index];
        index++;
        Node a=new Node(current);
        if(start==end){
            return a;
        }
        int pos=search(inorder,current,start,end);
        a.left=buildTree(preorder,inorder,start,pos);
        a.right=buildTree(preorder,inorder,pos+1,end);
        return a;
    }
    public static void main(String[] args){
        int[] preorder={1,2,4,3,5};
        int[] inorder={4,2,1,5,3};
        Node root=buildTree(preorder,inorder,0, preorder.length);
        inorder(root);
    }
}
