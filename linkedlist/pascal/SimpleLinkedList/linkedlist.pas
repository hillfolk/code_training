unit LinkedList;

{$mode objfpc}{$H+}

interface

uses
  Classes, SysUtils;

type

  { TNode }

  TNode = record
    Data: Pointer;
    Next: TNode;
    function Create(AData: Pointer): TNode;
  end;

  { TLinkedList }

  TLinkedList = record
    Head: TNode;
    Tail: TNode;
    function Create: TLinkedList;
    procedure Add(AData: Pointer);
    procedure Del;
  end;

implementation

{ TNode }

function TNode.Create(AData: Pointer): TNode;
begin
  Result.Data := AData;
  Result.Next := nil;
end;

{ TLinkedList }

function TLinkedList.Create: TLinkedList;
begin
  Result.Head := nil;
end;

procedure TLinkedList.Add(AData:Pointer);
var
  CurrentNode: TNode;
begin
  if Assigned(Head) then
  begin
    Self.tail.Next := TNode.Create(AData);
    Self.tail := Tail.Next;

  end
  else
  begin
     Self.Head := TNode.Create(AData);
    Self.Tail := Anode;
    Self.Head.Next := nil;
  end;

end;

procedure TLinkedList.Del;
begin

end;

end.

