template <class TYPE> class BinaryTree
{
public:
BinaryTree();
~BinaryTree();
void RemoveAll();
protected:
struct Node {
TYPE data;
Node* pLeft;
Node* pRight;
};
Node* m_pNodeHead;
Node* m_pNodeTail;
void RemoveSubtree(Node *pNode);
};
