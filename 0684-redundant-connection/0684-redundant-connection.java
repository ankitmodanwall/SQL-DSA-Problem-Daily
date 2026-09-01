class DSU{
    static int par[];
    static int rank[];
    public DSU(int n){
        par=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<=n;i++){
            par[i]=i;
        }
    }
    public static int find(int x){
        if(par[x]!=x){
            par[x]=find(par[x]);
        }
        return par[x];
    }
    public static boolean union(int x,int y){
        int root1=find(x);
        int root2=find(y);
        if(root1==root2){
            return false;
        }
        if(root1>root2){
            par[root2]=root1;
        }
        else if(root2>root1){
            par[root1]=root2;
        }
        else{
            par[root1]=root2;
        }
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int v=0;
        for(int i=0;i<n;i++){
            v=Math.max(v,Math.max(edges[i][0],edges[i][1]));
        }
        DSU dsu=new DSU(v);
        for(int i=0;i<edges.length;i++){
            if(!dsu.union(edges[i][0],edges[i][1])){
                return edges[i];
            }
        }
        return new int[]{};
        
    }
}