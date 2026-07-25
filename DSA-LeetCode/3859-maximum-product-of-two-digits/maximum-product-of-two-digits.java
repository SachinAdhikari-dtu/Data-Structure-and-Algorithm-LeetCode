class Solution {
    public int maxProduct(int n) {

     
     ArrayList<Integer> l = new ArrayList<>();

     while(n > 0){
        l.add(n%10);
        n/=10;
     }

     Collections.sort(l);

     return l.get(l.size()-1)*l.get(l.size()-2);


    }
}