import java.util.*;
public class PermutationSwaps {


    public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj,int v,boolean[] visited,ArrayList<Integer> arr){
        visited[v]=true;
        arr.add(v);
        for(int i=0;i<adj.get(v).size();i++){
            if(!visited[adj.get(v).get(i)]){
                dfs(adj,adj.get(v).get(i),visited,arr);
            }
        }
    }

    public static boolean compareTwoArrays(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<arr1.length;i++){
            if(map.containsKey(arr1[i])){
                map.put(arr1[i],map.get(arr1[i])+1);
            }
            else{
                map.put(arr1[i],1);
            }
        }
        for(int i=0;i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
                if(map.get(arr2[i])==0){
                    return false;
                }
                else{
                    map.put(arr2[i],map.get(arr2[i])-1);
                }
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int t=input.nextInt();
        for(int i2=0;i2<t;i2++){
            int n=input.nextInt();
            int m=input.nextInt();
            int[] p=new int[n];
            int[] q=new int[n];
            for(int i=0;i<n;i++){
                p[i]=input.nextInt()-1;
            }
            for(int i=0;i<n;i++){
                q[i]=input.nextInt()-1;
            }

            ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i=0;i<m;i++){
                int a=input.nextInt()-1;
                int b=input.nextInt()-1;
                addEdge(adj,a,b);
            }
            boolean[] visited=new boolean[n];
            for(int i=0;i<n;i++){
                visited[i]=false;
            }
            ArrayList<ArrayList<Integer>> comp=new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    ArrayList<Integer> arr=new ArrayList<>();
                    dfs(adj,i,visited,arr);
                    comp.add(arr);
                }
            }

//            for(int i=0;i<comp.size();i++){
//                for(int j=0;j<comp.get(i).size();j++){
//                    System.out.print(comp.get(i).get(j)+" ");
//                }
//                System.out.println();
//            }

            boolean flag=true;

            for(int i=0;i<comp.size();i++){
                int[] arr1=new int[comp.get(i).size()];
                int[] arr2=new int[comp.get(i).size()];
                for(int j=0;j<comp.get(i).size();j++){
                    arr1[j]=p[comp.get(i).get(j)];
                    arr2[j]=q[comp.get(i).get(j)];
                }
//                Arrays.sort(arr1);
//                Arrays.sort(arr2);
                if(!compareTwoArrays(arr1,arr2)){
//                    System.out.println("ith "+ i);
//                    for(int j=0;j<2;j++){
//                        System.out.print(arr1[j]+" ");
//                    }
//                    System.out.println();
//                    for(int j=0;j<2;j++){
//                        System.out.print(arr2[j]+" ");
//                    }
//                    System.out.println();
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }



        }
    }
}
