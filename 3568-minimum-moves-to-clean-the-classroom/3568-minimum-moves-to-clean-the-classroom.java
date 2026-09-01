import java.util.*;

class Solution {
    public int minMoves(String[] a, int E) {
        int m=a.length,n=a[0].length(),sr=0,sc=0,k=0;
        int[][] id=new int[m][n];
        for(int[] x:id) Arrays.fill(x,-1);

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                if(a[i].charAt(j)=='S'){sr=i;sc=j;}
                if(a[i].charAt(j)=='L') id[i][j]=k++;
            }

        int all=(1<<k)-1;
        boolean[][][][] v=new boolean[m][n][E+1][1<<k];
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sr,sc,E,0,0});
        v[sr][sc][E][0]=true;

        int[] dr={-1,1,0,0},dc={0,0,-1,1};

        while(!q.isEmpty()){
            int[] x=q.poll();
            if(x[3]==all) return x[4];

            for(int d=0;d<4;d++){
                int r=x[0]+dr[d],c=x[1]+dc[d],e=x[2]-1,mask=x[3];

                if(r<0||r>=m||c<0||c>=n||a[r].charAt(c)=='X'||e<0) continue;

                if(a[r].charAt(c)=='R') e=E;
                if(id[r][c]!=-1) mask|=1<<id[r][c];

                if(!v[r][c][e][mask]){
                    v[r][c][e][mask]=true;
                    q.add(new int[]{r,c,e,mask,x[4]+1});
                }
            }
        }
        return -1;
    }
}