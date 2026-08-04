class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int min =nums[0];
        int max=nums[0];
        HashSet<Integer> s = new HashSet<>();
        for(int i =0 ;  i < nums.length ; i++){
            s.add(nums[i]);
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }

        while(min < max){
            if(!s.contains(min)){
                l.add(min);
            }
            min++;
        }
        return l;
    }
}