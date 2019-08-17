import java.util.*;

class Document {
    int location;
    int weight;

    public Document(int location, int weight) {
        this.location = location;
        this.weight = weight;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.location).append(this.weight);
        return sb.toString();

    }
}

class PrintStack {
    private Stack<Document> documentStack;

    public PrintStack() {
        this.documentStack = new Stack<Document>();
    }

    public void push(Document document) {
        this.documentStack.push(document);
        this.sort(this.documentStack);


    }

    public Document pop() {
        return documentStack.pop();
    }

    public Document peek() {
        return documentStack.peek();
    }

    public boolean isEmpty() {
        return documentStack.isEmpty();
    }

    private void sort(Stack<Document> s) {
        Stack<Document> r = new Stack<Document>();

        while (!s.isEmpty()) {
            Document doc = s.pop();
            while(!r.isEmpty() && r.peek().weight < doc.weight ) {
                s.push(r.pop());
            }
            r.push(doc);
        }

        while(!r.isEmpty()) {
            s.push(r.pop());
        }
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PrintStack printStack = new PrintStack();


        for (int i = 0  ; i   < priorities.length; i++) {
            // 도큐먼트 생성
            Document doc = new Document(i, priorities[i]);
            printStack.push(doc);
        }


        int cnt = 1;
        while (!printStack.isEmpty()) {
            Document ldoc = printStack.pop();
            System.out.println("data:"+ldoc.toString());
            if (location == ldoc.location) {
                answer = cnt;
                System.out.println("Result:"+ldoc.toString());
                break;
            }
            cnt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testingData = {2, 1, 3, 2};
        int[] testingData2 = {1, 1, 9, 1, 1, 1};
        System.out.println(solution.solution(testingData, 2));
        System.out.println(solution.solution(testingData2, 0));
    }
}
