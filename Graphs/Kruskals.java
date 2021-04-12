import java.util.*;
import java.lang.*;

class Edge{
    int start;
    int end;
    int weight;
    public Edge(int start,int end,int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }
}
class SortByWeight implements Comparator<Edge>{


    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight-o2.weight;
    }
}



public class Kruskals {

    public static int TopParent(int v1,int[] parent){
        int parent1=parent[v1];
        int child=v1;
        while(parent1!=child){
            child=parent1;
            parent1=parent[child];
        }
        return parent1;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int v=input.nextInt();
        int e=input.nextInt();
        Edge[] graph=new Edge[e];
        Edge[] output=new Edge[v-1];
        for(int i=0;i<e;i++){
            int a=input.nextInt();
            int b=input.nextInt();
            int w=input.nextInt();
            Edge e1=new Edge(a,b,w);
            graph[i]=e1;
        }
        Arrays.sort(graph, new SortByWeight());
        int count=0;
        int[] parent=new int[v];
        for(int i=0;i<v;i++){
            parent[i]=i;
        }
        int i=0;
        while(count<v-1){
                int v1=graph[i].start;
                int v2=graph[i].end;
                if(TopParent(v1,parent)!=TopParent(v2,parent)){
                    parent[TopParent(v2,parent)]=v1;
//                    System.out.println(count);
                    output[count]=graph[i];
                    count++;
                }
                i=i+1;
            }

        for(i=0;i<v-1;i++){
            System.out.println(Math.min(output[i].start,output[i].end)+" "+ Math.max(output[i].start,output[i].end)+" "+output[i].weight);
        }
    }
}