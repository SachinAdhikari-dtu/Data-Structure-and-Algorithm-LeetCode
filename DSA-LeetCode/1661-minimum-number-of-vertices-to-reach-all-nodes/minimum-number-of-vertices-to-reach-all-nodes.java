class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int arr[]=new int[n];
        
        for(int i =0 ; i < edges.size() ; i++){
            int u =edges.get(i).get(0); 
            int v =edges.get(i).get(1); 
            arr[v]++;
        }

        List<Integer> l = new ArrayList<>();
        for(int i= 0  ; i < arr.length ; i++){
            if(arr[i]==0){
                l.add(i);
            }
        }
        return l;

        
    }
}