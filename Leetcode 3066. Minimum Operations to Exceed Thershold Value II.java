class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q=new PriorityQueue<>();
        for(int i : nums){
            q.offer((long)i);
        }
        int count=0;
        while(!q.isEmpty() && q.size()>1){
            long val1=q.poll();
            long val2=q.poll();
            if(val1<k || val2<k){
                long cal=(long)Math.min(val1,val2)*(long)2 + (long)Math.max(val1,val2);
                q.offer(cal);
                count++;
            }
            else{
                q.offer(val1);
                q.offer(val2);
                break;
            }
        }
        return count;
    }
}
