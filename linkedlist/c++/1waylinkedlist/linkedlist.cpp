#include <iostream>
using namespace std;

#include "linkedlist.h"

OneWayLinkedList::OneWayLinkedList(){
  this->head = nullptr;
}


OneWayLinkedList::AddNode(int value){
  if (head == NULL)
    {
      head = new Node();
      tail = head;
      head->next = nullptr;
      head->data = value;
    }
  else
    {
      tail->next = new Node();
      tail = tail->next;
      tail->data = vlaue;
      tail->next= nullptr;
    }
      
}


OneWayLinkedList::DelNode(){
  // Head 부터 삭제 가능 
   Node* current = head;
   if (current){
   delete current;
   current = next;
   }
   head = current;
     
}

OneWayLinkedList::~LinkedList()
{
    Node* current = head;

    while (current != 0)
    { 
        Node* next = current->next;
        delete current;
        current = next;
    }

    head = nullptr;

    
}
