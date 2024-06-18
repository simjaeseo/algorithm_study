import java.util.*;

class Solution {
    public String solution(String s) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        
        StringTokenizer st = new StringTokenizer(s);
        
        while(st.hasMoreTokens()){
            int number = Integer.parseInt(st.nextToken());
            
            maxPQ.add(number);
            minPQ.add(number);
        }
        
        String answer = minPQ.poll() + " " + maxPQ.poll();
        return answer;
    }
}