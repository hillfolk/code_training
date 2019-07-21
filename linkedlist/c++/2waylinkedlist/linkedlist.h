
typedef struct node {
  int data;
  Node * next;
  Node * prev;
} node_t

  
class TwoWayLinkedList {
    private
    node_t *head;
    node_t *tail;
    public
    int AddNode(int value);
    int DelNode();
  }
