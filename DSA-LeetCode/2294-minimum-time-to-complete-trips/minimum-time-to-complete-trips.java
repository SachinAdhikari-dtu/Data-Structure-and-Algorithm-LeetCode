class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long start = 1;
        long min = time[0];
        for(int t:time){
            min=Math.min(min,t);
        }
        long end = (long)min * totalTrips;
        long ans = end;

        while(start<=end){
            long mid =  start+(end-start)/2;

            if(isValid(time,totalTrips,mid)){
                ans = mid;
                end= mid -1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    private boolean isValid(int[] time, int totalTrips, long mid){
        long trip = 0;

        for(int t: time){
            trip += mid/t;

            if(trip>=totalTrips){
                return true;
            }
        }
        return false;
    }
}