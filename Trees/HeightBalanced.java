public class HeightBalanced {


    static class Node{
        Node left;
        Node right;
        int data;
        public Node(Node left,Node right, int data){
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
        boolean flagBalanced;

        public Pair(int height,boolean flagBalanced){
            this.height=height;
            this.flagBalanced=flagBalanced;
        }
    }

    public static Pair isBalanced(Node root){
        if(root==null){
            return new Pair(0,true);
        }
        Pair p1=isBalanced(root.left);
        if(!p1.flagBalanced){
            return new Pair(0,false);
        }
        Pair p2=isBalanced(root.right);
        if(!p2.flagBalanced){
            return new Pair(0,false);
        }
        int lh=p1.height;
        int rh= p2.height;
        if(Math.abs(lh-rh)>1){
            return new Pair(0,false);
        }
        else{
            return new Pair(Math.max(lh,rh)+1,true);
        }

    }

    public static void main(String[] args){
        Node root=new Node(1);
        root.right=new Node(2);
        root.right.right=new Node(3);
        root.left=new Node(4);
        Pair a=isBalanced(root);
        System.out.println(a.flagBalanced);

    }
}
