class Solution {
    class Pair{
        int count;
        char ch;
        Pair(int count, char ch){
            this.count= count;
            this.ch= ch;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        String s="";
        PriorityQueue<Pair> pq= new PriorityQueue<>((p1, p2) -> p2.count- p1.count);

        if(a >0)pq.add(new Pair(a, 'a'));
        if(b >0)pq.add(new Pair(b, 'b'));
        if(c >0)pq.add(new Pair(c, 'c'));

        while(!pq.isEmpty()){
            Pair maxPair= pq.poll();

            if(s.length() >=2 && s.charAt(s.length()-1)==maxPair.ch && s.charAt(s.length()-2)==maxPair.ch){
                if(pq.isEmpty()) break;
                
                Pair nextPair= pq.poll();

                s+= nextPair.ch;
                nextPair.count--;

                if(nextPair.count >0){
                    pq.add(nextPair);
                }
                pq.add(maxPair);
            }else{
                s+= maxPair.ch;
                maxPair.count--;
                if(maxPair.count >0){
                    pq.add(maxPair);
                }
            }
        }

        return s;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        
        int totalLength = a + b + c;
        int continuousA = 0, continuousB = 0, continuousC = 0;
        
        for(int i = 0; i < totalLength; i++) {
            if ((a >= b && a >= c && continuousA != 2) || (continuousB == 2 && a > 0) || (continuousC == 2 && a > 0))  {
                sb.append("a");
                a--;
                continuousA++;
                continuousB = 0;
                continuousC = 0;  
            } else if ((b >= a && b >= c && continuousB != 2) || (continuousA == 2 && b > 0) || (continuousC == 2 && b > 0)) {
                sb.append("b");
                b--;
                continuousB++;
                continuousA = 0;
                continuousC = 0;
            } else if ((c >= a && c >= b && continuousC != 2) || (continuousB == 2 && c > 0) || (continuousA == 2 && c > 0)) {
                sb.append("c");
                c--;
                continuousC++;
                continuousA = 0;
                continuousB = 0;  
            }
        }
        return sb.toString();
    }
}
