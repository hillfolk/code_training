
#include "linkedlist.h"
#include <iostream>


int  main(){
 OneWayLinkedList* myList = new OneWayLinkedList();
 
    myList->addNode(5);
    myList->addNode(7);
    myList->addNode(12);
  

    std::cout << "The original list is: ";
    myList->display();

    // change to removeDuplicates_2 to run that implementation

    std::cout << "The list with duplicated removed is: ";
    myList->display();
    delete myList;

    return 0;
}
