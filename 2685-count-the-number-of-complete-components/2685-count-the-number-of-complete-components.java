class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        if(edges.length == 0) return n;

        int cnt = 0;
        int[] colourArray = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        int[] cntArray1 = new int[n];
        int[] cntArray2 = new int[n];

        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        colourTheComponents(graph, colourArray);

        for(int ele : colourArray){
            cntArray1[ele]++;
        }

        for(int i = 0 ; i < n ; i++){
            if(graph[i].size() == cntArray1[colourArray[i]] - 1){
                cntArray2[colourArray[i]]++;
                if(cntArray2[colourArray[i]] >= cntArray1[colourArray[i]])
                    cnt++;
            }
        }

        return cnt;
    }

    private void colourTheComponents(List<Integer>[] graph, int[] colourArray){
        int colour = 1, n = graph.length;

        for(int i = 0 ; i < n ; i++){
            if(colourArray[i] == 0){
                bfs(i, graph, colourArray, colour);
                colour++;
            }
        }
    }

    private void bfs(int st, List<Integer>[] graph, int[] colourArray, int colour){
        Queue<Integer> q = new LinkedList<>();
        q.offer(st);

        while(!q.isEmpty()){
            int node = q.poll();
            colourArray[node] = colour;

            for(int adjNode : graph[node]){
                if(colourArray[adjNode] == 0){
                    q.offer(adjNode);
                }
            }
        }
    }
}