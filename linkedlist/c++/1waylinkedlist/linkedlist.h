
typedef struct node {
  int data;
  Node * next; 
} node_t

  
class OneWayLinkedList {
    private
    node_t *head;
    public
    int AddNode(int value);
    int DelNode();
  }
