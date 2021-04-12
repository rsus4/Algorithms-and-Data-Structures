import java.util.*;

import java.lang.*;

public class Prims {

    public static int getMinIndex(boolean[] visited,int[] weight){
        int index=-1;
        for(int i=0;i<weight.length;i++) {
            if (!visited[i] && (index==-1 || (weight[index]>weight[i]) )) {
                index = i;
            }
        }
        return index;

    }


    public static void prims(boolean[] visited,int[] weight,int v,int[] parent,int[][] edges){
        for(int i1=0;i1<v-1;i1++){
            int a=getMinIndex(visited,weight);
            visited[a]=true;
//            System.out.println(a);
            for(int i=0;i<v;i++){
              if(edges[a][i]!=0 && weight[i]>edges[a][i] && i!=a && !visited[i]){
                 weight[i]=edges[a][i];
                 parent[i]=a;
              }


            }
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int v=input.nextInt();
        int e=input.nextInt();
        int[][] edges=new int[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                edges[i][j]=0;
            }
        }
        for(int i=0;i<e;i++){
            int a=input.nextInt();
            int b=input.nextInt();
            int w=input.nextInt();
            edges[a][b]=w;
            edges[b][a]=w;
        }
        boolean[] visited=new boolean[v];
        int[] weight=new int[v];
        for(int i=0;i<v;i++) {
            visited[i] = false;
        }
        for(int i=1;i<v;i++){
            weight[i]=Integer.MAX_VALUE;
        }
        weight[0]=0;
        int[] parent=new int[v];
        parent[0]=-1;

        prims(visited,weight,v,parent,edges);
        for(int i=0;i<v-1;i++){
            System.out.println(Math.min(parent[i+1],i+1)+" "+Math.max(i+1,parent[i+1])+" " + weight[i+1]);
        }


    }

}
