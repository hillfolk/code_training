import java.util.*;

class Document implements Comparable<Document> {
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

    @Override
    public int compareTo(Document target) {
        if(this.weight < target.weight) {
            return 1; // x에 대해서는 오름차순
        }
        else if(this.weight == target.weight) {
            if(this.location > target.location) { // y에 대해서는 내림차순
                return -1;
            }
        }
        return -1;
            }
}

class PrintQueue {
    private Queue<Document> documentQueue;

    public PrintQueue() {
        this.documentQueue = new PriorityQueue<Document>();

    }

    public void enqueue(Document document) {
        this.documentQueue.offer(document);
    }

    public Document dequeue() {
        return documentQueue.poll();
    }

    public Document peek() {
        return documentQueue.peek();
    }

    public boolean isEmpty() {
        return documentQueue.isEmpty();
    }


}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PrintQueue printQueue = new PrintQueue();


        for (int i = 0  ; i   < priorities.length; i++) {
            // 도큐먼트 생성
            Document doc = new Document(i, priorities[i]);
            printQueue.enqueue(doc);
        }


        int cnt = 1;
        while (!printQueue.isEmpty()) {
            Document ldoc = printQueue.dequeue();
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