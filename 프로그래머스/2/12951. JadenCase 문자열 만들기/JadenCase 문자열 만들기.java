import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        s = " " + s + " ";
        
        char[] inputs = s.toCharArray();
        
        for(int i = 1; i < inputs.length; i++){
            
            if(inputs[i] == ' ') sb.append(' ');
            else if(inputs[i-1] == ' ' && inputs[i] != ' '){
                if(inputs[i] >= '0' && inputs[i] <= '9' || Character.isUpperCase(inputs[i]))    {
                    sb.append(inputs[i]);
                    continue;
                }
                sb.append(Character.toUpperCase(inputs[i]));
            }else if(inputs[i-1] != ' ' && inputs[i] != ' ' && Character.isUpperCase(inputs[i])) {
                sb.append(inputs[i] = Character.toLowerCase(inputs[i]));
            }else{
                sb.append(inputs[i]);
            }
        }
        
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}