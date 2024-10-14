class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Comparator.reverseOrder());
        //PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long ans=0;

        for(int num: nums){
            pq.add(num);
        }


        while(k-- >0){
            int val= pq.poll();
            //System.out.println(val);
            ans+= val;
            pq.add((val+2)/3);
        }

        return ans;
    }
}
