import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> brackets = new Stack<>();
        
        char[] inputs = s.toCharArray();
        
        for(char c : inputs){
            if(c == '('){
                brackets.add(c);
            }else{
                
                if(brackets.isEmpty()){
                    return false;
                }else{
                    brackets.pop();
                }
                
            }
        }
        
        if(brackets.isEmpty()) return true;
        
        return false;

    }
}