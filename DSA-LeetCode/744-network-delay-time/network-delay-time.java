class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<HashMap<Integer,Integer>> list=new ArrayList<>();
            n++;
        for(int i =0 ; i < n ; i++){
            list.add(new HashMap<>());
        }
        for(int i =0 ; i < times.length ;i++){
             int u = times[i][0];
            int v= times[i][1];
            int weight=times[i][2];
            list.get(u).put(v,weight);
        }

        int ans[]=dijstraAlgorihtm(list,n,k);
        int a=Integer.MAX_VALUE;
        int min=0;
        for(int i=1 ; i < n ; i++){
            if(ans[i]==a)return -1;
            min=Math.max(min,ans[i]);
        }
        return min;
    }





    public static class pair implements Comparable<pair> {
        int node;
        int cumulativeDistance;

        pair(int node, int cumulativeDistance) {
            this.node = node;
            this.cumulativeDistance = cumulativeDistance;
        }

        @Override
        public int compareTo(pair other) {
            return this.cumulativeDistance - other.cumulativeDistance;
        }
    }

    public static int[] dijstraAlgorihtm(ArrayList<HashMap<Integer,Integer>> list, int n, int src) {

        int distance[] = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean visited[] = new boolean[n];
        PriorityQueue<pair> q = new PriorityQueue<>();

        distance[src] = 0;
        q.offer(new pair(src, 0));

        while (!q.isEmpty()) {
            pair top = q.poll();
            int node = top.node;
            int cumulativeDistance = top.cumulativeDistance;

            if (visited[node]) continue;
            visited[node] = true;

            for (Integer x : list.get(node).keySet()) {
                if (!visited[x]) {
                    int val = list.get(node).get(x);
                    if (cumulativeDistance + val < distance[x]) {
                        distance[x] = cumulativeDistance + val;
                        q.offer(new pair(x, distance[x]));
                    }
                }
            }
        }

        return distance;
    }

}
