#include <iostream>
#include "linkedlist.h"

LinkedList::LinkedList()
{
    this->head = nullptr;
}

LinkedList::~LinkedList()
{
    Node* current = head;

    while (current != 0)
    { 
        Node* next = current->next;
        delete current;
        current = next;
    }

    head = nullptr;

    std::cout << "List successfully deleted from memory" << std::endl;
}

void LinkedList::insert(int value)
{
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
        tail->data = value;
        tail->next = nullptr;
    }
}

void LinkedList::createCycle()
{
    tail->next = head->next;  
}

void LinkedList::display()
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


int  main(){
 LinkedList* myList = new LinkedList();
    myList->insert(5);
    myList->insert(7);
    myList->insert(12);
    myList->insert(7);
    myList->insert(16);
    myList->insert(16);
    myList->insert(25);
    myList->insert(11);
    myList->insert(5);

    std::cout << "The original list is: ";
    myList->display();

    // change to removeDuplicates_2 to run that implementation

    std::cout << "The list with duplicated removed is: ";
    myList->display();
    delete myList;

    return 0;
}
