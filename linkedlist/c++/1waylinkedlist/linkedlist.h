
typedef struct Node {
  int data;
  Node * next; 
} Node;

  
class OneWayLinkedList
  {
  public:
    OneWayLinkedList();
    ~OneWayLinkedList();
    void display();
    int addNode(int value);
    int delNode();
  private:
    Node * head;
    Node * tail;
 
};
