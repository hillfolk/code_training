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
    private LinkedList<Document> documentLinkedList;

    public PrintQueue() {
        this.documentLinkedList = new LinkedList<Document>();
    }

    public void enqueue(Document document) {
        this.documentLinkedList.add(document);
    }

    public Document dequeue() {
        return documentLinkedList.poll();
    }

    public Document peek() {
        return documentLinkedList.peek();
    }
    public void addFirst(Document document) {
        this.documentLinkedList.addFirst(document);
    }

    public void addLast(Document document) {
        this.documentLinkedList.addLast(document);
    }

    public Document get(int i) {
        return this.documentLinkedList.get(i);
    }

    public boolean isEmpty() {
        return documentLinkedList.isEmpty();
    }

    public int size() {
        return this.documentLinkedList.size();
    }


}

class Solution2 {

    public int solution(int[] priorities, int location) {
        int answer = 1;
        PrintQueue printQueue = new PrintQueue();


        for (int i = 0  ; i   < priorities.length; i++) {
            // 도큐먼트 생성
            Document doc = new Document(i, priorities[i]);
            printQueue.enqueue(doc);
        }

        Document printDocument = null;

        while (printQueue.size() > 1) {

            printDocument = printQueue.peek();
            for (int i = 1; i < printQueue.size(); i++) {
                if (printDocument.weight < printQueue.get(i).weight) {
                    printQueue.addLast(printDocument);
                    printQueue.dequeue();
                    break;
                }

                if (i == printQueue.size() - 1) {
                    if (printDocument.location == location) return answer;
                    printQueue.dequeue();
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] testingData = {2, 1, 3, 2};
        int[] testingData2 = {1, 1, 9, 1, 1, 1};
        int[] testingData3 = {1};
        System.out.println(solution.solution(testingData, 2));
        System.out.println(solution.solution(testingData2, 0));
        System.out.println(solution.solution(testingData3, 1));
    }
}