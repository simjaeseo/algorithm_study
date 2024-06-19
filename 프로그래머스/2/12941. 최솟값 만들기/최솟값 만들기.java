import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        
        Integer[] BCopy = new Integer[B.length];
        
        for( int i =0 ; i<B.length; i++){
            BCopy[i] = B[i];
        }
        
        
        Arrays.sort(BCopy, Collections.reverseOrder());        
        int answer = 0;
        
        
        for( int i =0 ; i<A.length; i++){
            answer += A[i] * BCopy[i];
        }

        return answer;
    }
}