class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n= times.length;

        //order the friends in order of their arrival
        Integer order[]= new Integer[n];
        for(int i=0; i<n; i++) order[i]=i;
        Arrays.sort(order, (a,b) -> Integer.compare(times[a][0], times[b][0]));

        //Initially all seats are empty
        PriorityQueue<Integer> emptySeats= new PriorityQueue<>();
        for(int i=0; i<n; i++) emptySeats.offer(i);

        //Queue to remove the seats which would be empty
        PriorityQueue<int[]> takenSeats= new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for( int i: order){
            int arrival= times[i][0], leave= times[i][1];

            while(!takenSeats.isEmpty() && takenSeats.peek()[0] <= arrival){
                emptySeats.offer(takenSeats.poll()[1]);
            }

            int seat= emptySeats.poll();

            if(targetFriend == i) return seat;

            takenSeats.offer(new int[]{leave, seat});
        }

        return -1;
    }
}
