import java.util.Stack;
class Doc {
    int location;
    int weight;
    public Doc(int location,int weight){
	this.location = location;
	this.weight = weight;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
	
	Stack<Doc> docStack = new Stack<Doc>();
	Stack<Doc> tempStack = new Stack<Doc>();
	
	//1. 스텍의 데이터가 현재 데이터보다 적을때 까지 꺼넨다. 
	//2. 내 데이터를 넣는다.  남아 있는 데이터를 넣는다.
	//3. 데이터를 꺼내면서 
	
	for (int i = 0; i < priorities.length; i++) {
	    // 도큐먼트 생성
	    Doc doc = new Doc(i,priorities[i]);

	    // 도큐먼트 우선순위 정리
	    for(Doc lDoc : docStack ){
		if(docStack.empty()){
		    docStack.push(doc);
			}	    
		if (docStack.peek().weight < doc.weight){		
		    docStack.push(doc);	       
		}else{
		    tempStack.push(docStack.pop());
		}
	    }
	    if(! tempStack.empty()) {
		for(Doc lDoc :tempStack){
		    docStack.push(lDoc);
		    }
	    }
	}
	
	for(Doc ldoc:docStack){
	    if(location == ldoc.location){
		answer = ldoc.weight;
	    }
		
		//System.out.Println(ldoc.weight);
	}
        return answer;
    }

    public static void main (String[] args){
	Solution solution = new Solution();
	int [] data = {2, 1, 3, 2};
	System.out.println(solution.solution(data , 2));
	
    }
}
