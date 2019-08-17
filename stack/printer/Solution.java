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
        if (this.weight < target.weight) {
            return 1;
        }
        if (this.weight == target.weight) {
            return 0;
        }

//        if (this.location < target.location) {
//            return 1;
//        }

        return  -1;
    }
}

class PrintQueue {
    private Queue<Document> documentQueue;

    public PrintQueue() {
        this.documentQueue = new PriorityQueue<Document>();

    }

    public void enqueue(Document document) {
        this.documentQueue.add(document);
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
            for(int i = 0; i < priorities.length;i++) {
                if (priorities[i] == printQueue.peek().weight) {
                    if (location == printQueue.peek().location) {
                        answer = cnt;
                        System.out.println("Result:" +printQueue.peek().toString());
                    }
                    printQueue.dequeue();
                    cnt++;
                    break;

                }
            }
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