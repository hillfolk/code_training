program BasicLinkedList;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes, uNode
  { you can add units after this };

var
  SingleLinkedList:PSimpleNode;
  GivenNode,NewNode:PSimpleNode;

begin

  {initialize the linked List}

  SingleLinkedList:= nil;

  New(NewNode);
  NewNode^.Data:= 'First';


end.

