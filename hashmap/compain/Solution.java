import java.util.Map;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
	String participant[] = {"a", "AA", "AA"};
	String completion[] = {"a","AA"};
 	
	Solution solutions = new Solution();
	System.out.println(solutions.solution(participant,completion));
	}
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String key : participant){
	    if (map.containsKey(key)){
		map.put(key,map.get(key)+1);
	    }else{
		map.put(key,1);
	    }
	}
	
	
	for(String key : completion){
	    map.put( key,map.get(key)-1);
	}

	for(String key : participant){
	    if (map.get(key) > 0 )
		answer = key;
	}
	
	return answer;
    }
}
