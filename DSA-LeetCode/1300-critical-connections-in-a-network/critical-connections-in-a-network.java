class Solution {

    public static void dfs(List<List<Integer>> l , int curr , List<List<Integer>> ans , int s[] , int e[] , int p[] , int t[]  ){
        s[curr]=e[curr]=t[0];
        t[0]++;

        for(int x : l.get(curr)){
            if(p[curr]==x)continue;
            if(s[x]==-1){
                p[x]=curr;
                dfs(l,x,ans,s,e,p,t);
                e[curr]=Math.min(e[x],e[curr]);
                if(s[curr] < e[x]){
                    ans.add(Arrays.asList(x,curr));
                }
            }else{
               e[curr]=Math.min(e[x],e[curr]); 
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> list) {

        List<List<Integer>> l = new ArrayList<>();
        for(int i=0 ; i < n ; i++){
            l.add(new ArrayList<>());
        }
        for(int i=0 ; i < list.size() ; i++){
            int u =list.get(i).get(0);
            int v =list.get(i).get(1);
            l.get(u).add(v);
            l.get(v).add(u);
        }

        List<List<Integer>> ans = new ArrayList<>();
        int s[]=new int[n];
        int e[]=new int[n];
        int p[]=new int[n];
        int t[]=new int[1];
        t[0]=0;
        Arrays.fill(s,-1);
        Arrays.fill(p,-1);

        for(int i =0 ; i < n ; i++){
            if(s[i]==-1){
                dfs(l,i,ans,s,e,p,t);

            }
        }
        return ans;
        
    }
}