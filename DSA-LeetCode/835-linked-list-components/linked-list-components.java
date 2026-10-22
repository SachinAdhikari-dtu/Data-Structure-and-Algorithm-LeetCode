
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            s.add(nums[i]);
        }
        int ans=0;
        
        while(head!=null){
            boolean istrue=false;
            while(head!=null && s.contains(head.val)){
                head=head.next;
                istrue=true;
            }
            if(istrue)ans++;
            if(head!=null)head=head.next;
        }
        return ans;
    }
}