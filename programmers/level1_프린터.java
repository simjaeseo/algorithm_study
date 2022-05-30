package algo;

import java.util.*;
public class level1_프린터 {

	    public int solution(int[] priorities, int location) {
	        int answer = 0;
	        int max = 0;
	        Queue<Integer> q = new LinkedList<>();
	        List<Integer> prioritiesQ = new LinkedList<>();
	        
	        for(int num : priorities){
	            prioritiesQ.add(num);
	            q.add(num);
	        }
	        
	        Collections.sort(prioritiesQ, Collections.reverseOrder());
//	                     System.out.println();
	        
//	          for(int i = 0; i<prioritiesQ.size(); i++){
//	                     System.out.println(prioritiesQ.get(i));

//	          }
//	                     System.out.println();
	        
	        
	        while(true){
	            int priority = q.peek();
	            int priorityPeek = prioritiesQ.get(0);
	            
	            if(location == 0 ){
	                // 우선순위가 제일 클때
	                if(priority == priorityPeek ){
	                    // System.out.println(1);
	                    answer++;
	                    return answer;
	                }else{
	                    // System.out.println(2);
	                    
	                    q.add(q.poll());
	                    location = q.size()-1;
	                }
	            }else{
	                // 맨 앞에 있는게 내꺼랑 상관 없을떄
	                // 우선순위가 제일 클때
	                if(priority == priorityPeek ){
	                    // System.out.println(priority + " " + priorityPeek);
	                    q.poll();
	                    prioritiesQ.remove(0);
	                    location--;
	                    answer++;
	                    // System.out.println(3);
	                    
	                }else{
	                    // System.out.println(4);
	                    
	                    q.add(q.poll());
	                    location--;
	                }
	            }
	            
	            
	            
	        }
	        
	        
	}
}
