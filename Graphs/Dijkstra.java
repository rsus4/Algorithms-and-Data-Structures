import java.util.*;
public class Dijkstra {

    static class Pair{
        int end;
        long weight;
        public Pair(int end,long weight){
            this.end=end;
            this.weight=weight;
        }
    }

    static class VertDist{
        int vertex;
        long distance;
        public VertDist(int vertex,long distance){
            this.vertex=vertex;
            this.distance=distance;
        }
    }

    static class DistanceComparator implements Comparator<VertDist>{

        @Override
        public int compare(VertDist o1, VertDist o2) {
            if(o1.distance>o2.distance){
                return 1;
            }
            else if(o1.distance<o2.distance){
                return -1;
            }
            else{
                return 0;
            }
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int v=input.nextInt();
        int e=input.nextInt();
        ArrayList<ArrayList<Pair>> adj=new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<e;i++){
                int ei=input.nextInt();
                int ej=input.nextInt();
                long wi=input.nextInt();
                adj.get(ei).add(new Pair(ej,wi));
                adj.get(ej).add(new Pair(ei,wi));
        }

        boolean[] visited=new boolean[v];
        long[] distance=new long[v];
        for(int i=0;i<v;i++){
            distance[i]=Integer.MAX_VALUE;
            visited[i]=false;
        }
        distance[0]=0;
        PriorityQueue<VertDist> heap=new PriorityQueue<VertDist>(v,new DistanceComparator());
        heap.add(new VertDist(0,0));
        for(int i=1;i<v;i++){
            heap.add(new VertDist(i,Integer.MAX_VALUE));
        }
        for(int i1=0;i1<v-1;i1++){
             VertDist a=heap.poll();
            distance[a.vertex]=a.distance;
            int ind=a.vertex;
//            System.out.print("ind = " + ind+" ");
//            System.out.println("distance = "+ distance[a.vertex]+" ");
            for(int i=0;i<adj.get(ind).size();i++){
//                System.out.print("tick tick "+i+" " );
                if(!visited[adj.get(ind).get(i).end] && adj.get(ind).get(i).weight+ a.distance<distance[adj.get(ind).get(i).end]){
//                    System.out.print("HIII");
                    distance[adj.get(ind).get(i).end]=adj.get(ind).get(i).weight+ a.distance;
                    heap.remove(adj.get(ind).get(i));
                    VertDist a1=new VertDist(adj.get(ind).get(i).end,distance[adj.get(ind).get(i).end]);
                    heap.add(a1);
                }
            }
//            System.out.println("i1 = " + i1);
            visited[ind]=true;
        }

        for(int i=0;i<v;i++){
            System.out.println(i+" "+ distance[i]+" ");
        }

    }
}

