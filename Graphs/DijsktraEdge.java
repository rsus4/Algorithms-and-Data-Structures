import java.util.*;
public class DijsktraEdge {

    public static int getMinVertex(long[] distance,boolean[] visited){
        int index=-1;
        long maxDistance=Long.MAX_VALUE;
        for(int i=0;i<distance.length;i++){
            if((index==-1 || distance[index]>distance[i]) && !visited[i]){
                index=i;
            }
        }
        return index;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int v=input.nextInt();
        int e= input.nextInt();
        long[][] edge=new long[e][e];
        for(int i=0;i<e;i++){
            for(int j=0;j<e;j++){
                edge[i][j]=0;
            }
        }
        for(int i=0;i<e;i++){
            int ei=input.nextInt();
            int ej=input.nextInt();
            long wi=input.nextLong();
            edge[ei][ej]=wi;
            edge[ej][ei]=wi;
        }
        long[] distance=new long[v];
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++){
            distance[i]=Integer.MAX_VALUE;
            visited[i]=false;
        }
        distance[0]=0;
        for(int i1=0;i1<v-1;i1++){
            int ind=getMinVertex(distance,visited);
            visited[ind]=true;
//            System.out.println(ind);
            for(int i=0;i<v;i++){
                if(i!=ind && !visited[i] && edge[ind][i]!=0){
                    if(distance[ind]+edge[ind][i]<distance[i]){
                        distance[i]=distance[ind]+edge[ind][i];
                    }
                }
            }

        }

        for(int i=0;i<v;i++){
            System.out.println(i+" "+ distance[i]);
        }


    }

}
