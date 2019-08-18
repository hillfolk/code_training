program SImpleLinkedList;

{$mode objfpc}{$H+}

uses {$IFDEF UNIX} {$IFDEF UseCThreads}
  cthreads, {$ENDIF} {$ENDIF}
  Classes,
  LinkedList { you can add units after this };

var
  List: TLinkedList;
  LNode: TNode;
  LStr1, LStr2, LStr3: string;
begin
  List := TLinkedList.Create;
  LStr1 := 'A';
  LStr2 := 'B';
  LStr3 := 'C';
  List.Add(Addr(LStr1));
  List.Add(Addr(LStr2));
  List.Add(Addr(LStr3));
  //LData := 'D';
  //List.Add(Addr(LData));
  LNode := List.Head;

  while Assigned(LNode) do
  begin

    Write(string(LNode.Data^));
    LNode := LNode.Next;
  end;

  ReadLn;
end.

