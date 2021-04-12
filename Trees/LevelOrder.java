import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
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


    public static int findSumAtkthLevel(Node root,int k){
        Queue<Node> queue=new LinkedList<Node>();
        int count=0;
        queue.add(root);
        queue.add(null);
        int sum=0;
        while(!queue.isEmpty()){
            Node a=queue.remove();
            if(queue.isEmpty()){
                break;
            }
            else if(a==null){
                count++;
                queue.add(null);
            }
            else{
                if(a.left!=null){
                    queue.add(a.left);
                }
                if(a.right!=null){
                    queue.add(a.right);
                }
                if(count==k){
                    sum+=a.data;
                }
            }
        }
        return sum;
    }

    public static void rightView(Node root){
        Queue<Node> queue1=new LinkedList<Node>();
        queue1.add(root);

    }

    public static void levelOrder(Node root){
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        queue.add(null); // whenever finish level add null to the queue
        while(!queue.isEmpty()){
            Node a=queue.remove();
            if(queue.isEmpty()){
                break;
            }
            else if(a==null) {
                System.out.println();// whenever we encounter a null value, it means that the tree is moving to the next level
                queue.add(null);
            }
            else{
                if(a.left!=null){
                    queue.add(a.left);
                }
                if(a.right!=null){
                    queue.add(a.right);
                }
                System.out.print(a.data+" ");
            }

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

//        levelOrder(root);
        int a=findSumAtkthLevel(root,2);
        System.out.println(a);
    }
}
