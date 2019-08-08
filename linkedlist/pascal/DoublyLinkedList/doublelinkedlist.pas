program doublelinkedlist;

{$mode objfpc}{$H+}

uses
  {$IFDEF UNIX}{$IFDEF UseCThreads}
  cthreads,
  {$ENDIF}{$ENDIF}
  Classes, uDoublyLinkedList;
  { you can add units after this }

var
  LinkedList:TDoublyLinkedList;
  LStrPtr:^String;
  LNode:TNode;
begin
  LinkedList := TDoublyLinkedList.Create;
  New(LStrPtr);
  LStrPtr^ := 'Head';
  LinkedList.InsertBefore(nil,LStrPtr);

  New(LStrPtr);
  LStrPtr^ := 'Middle';
  LinkedList.InsertNext(LinkedList.Tail, LStrPtr);

    New(LStrPtr);
  LStrPtr^ := 'Middle1';
  LinkedList.InsertNext(LinkedList.Tail, LStrPtr);
    New(LStrPtr);
  LStrPtr^ := 'Middle2';
  LinkedList.InsertNext(LinkedList.Tail, LStrPtr);
    New(LStrPtr);
  LStrPtr^ := 'Middle3';
  LinkedList.InsertNext(LinkedList.Tail, LStrPtr);

  New(LStrPtr);
  LStrPtr^ := 'Tail';
  LinkedList.InsertNext(LinkedList.Tail, LStrPtr);

  LNode := LinkedList.Head;

  While Assigned(LNode) do
  begin
       LStrPtr := LNode.Value;

       WriteLn(LStrPtr^);
       LNode := LNode.Next;
  end;



end.

