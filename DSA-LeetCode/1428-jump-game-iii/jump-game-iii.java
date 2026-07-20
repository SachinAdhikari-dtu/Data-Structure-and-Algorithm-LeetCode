class Solution {
    public boolean canReach(int[] arr, int src) {

        if(arr.length==1){if (arr[0]==0)return true; }
         if(arr.length==1)return false;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0 ; i < arr.length ; i++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            int u = i;
            int v1 = i + arr[i];
            int v2 = i - arr[i];
            if(u==v1 || u==v2  )continue;
            if (v1 >= 0  && v1 < arr.length ) {
                list.get(u).add(v1);
            }
            if (v2 >= 0  && v2 < arr.length) {
                list.get(u).add(v2);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        boolean visited[] = new boolean[arr.length];

        q.offer(src);
        visited[src] = true;
        while (!q.isEmpty()) {
            int index = q.poll();
            if (arr[index] == 0)
                return true;
            for (Integer x : list.get(index)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.offer(x);
                }
            }
        }

        return false;

    }
}