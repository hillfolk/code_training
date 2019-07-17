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
  
}
