#include <iostream>
#include "linkedlist.h"
using namespace std;

OneWayLinkedList::OneWayLinkedList()
{
  this->head = nullptr;
  this->tail = nullptr;
}


OneWayLinkedList::addNode(int value){
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
  return 0;
      
}

void OneWayLinkedList::display()
{
     Node* temp;

    if (head == NULL)
    {
        return;
    }

    temp = head;

    while (temp != NULL)
    {
        std::cout << temp->data << ' ';
        temp = temp->next;
    }

    std::cout << std::endl;
}


int OneWayLinkedList::delNode(){
  // Head 부터 삭제 가능 
   Node* current = head;
   if (current){
   delete current;
   current = next;
   }
   head = current;
   return 0;  
}

OneWayLinkedList::~OneWayLinkedList()
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
