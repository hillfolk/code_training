unit uDoublyLinkedList;

{$mode objfpc}{$H+}

interface

uses
  Classes, SysUtils;

type

  { TNode }

  TNode = class(TObject)
  private
    FNext: TNode;
    FPrev: TNode;
    FValue: Pointer;
  public
    constructor Create;
    function hasNext: boolean;
    function hasPrev: boolean;
    property Value: Pointer read FValue write FValue;
    property Next: TNode read FNext write FNext;
    property Prev: TNode read FPrev write FPrev;

  end;

  { TDoublyLinkedList }

  TDoublyLinkedList = class(TObject)
    FHead: TNode;
    FTail: TNode;
    FCount: integer;
  public
    procedure InsertBefore(APosNode: TNode; var AValuePtr: Pointer);
    procedure InsertNext(APosNode: TNode; var AValuePtr: Pointer);
    procedure DeleteAt(APos: TNode);
    property Head: TNode read FHead write FHead;
    property Tail: TNode read FTail write FTail;
    property Count: integer read FCount write FCount;
    constructor Create;

  end;


implementation

{ TNode }

constructor TNode.Create;
begin

end;

function TNode.hasNext: boolean;
begin
  if Assigned(FNext) then
  begin
    Result := True;

  end
  else
  begin
    Result := False;

  end;
end;

function TNode.hasPrev: boolean;
begin
  if Assigned(FPrev) then
  begin
    Result := True;
  end
  else
    Result := False;
end;

{ TDoublyLinkedList }

procedure TDoublyLinkedList.InsertBefore(APosNode: TNode; var AValuePtr: Pointer);
var
  LNode: TNode;
begin
  if not Assigned(APosNode) then
  begin
    Head := TNode.Create;
    Head.Value := AValuePtr;
    exit;
  end;

  if Assigned(APosNode.Prev) then
  begin
    LNode := APosNode.Prev;
    APosNode.Prev := TNode.Create;
    APosNode.Prev.Value := AValuePtr;
    APosNode.Prev.Prev := LNode;
  end
  else
  begin
    APosNode.Prev := TNode.Create;
    APosNode.Prev.Value := AValuePtr;
    Head := APosNode.Prev;
  end;
  Inc(FCount);
end;

procedure TDoublyLinkedList.InsertNext(APosNode: TNode; var AValuePtr: Pointer);
var
  LNode: TNode;
begin
  if not Assigned(APosNode) then
  begin
    Tail := TNode.Create;
    Tail.Value := AValuePtr;
    exit;
  end;
  if Assigned(APosNode.Next) then
  begin
    LNode := APosNode.Next;
    APosNode.Next := TNode.Create;
    APosNode.Next.Value := AValuePtr;
    APosNode.Next.Prev := LNode;
  end
  else
  begin

    APosNode.Next := TNode.Create;
    APosNode.Next.Value := AValuePtr;
    Tail := APosNode.Next;
  end;
  Inc(FCount);

end;

procedure TDoublyLinkedList.DeleteAt(APos: TNode);
var
  LNode: TNode;
begin
  if Assigned(APos.Prev) then
  begin
    LNode := APos.Prev;
    LNode.Next := APos.Next;
    FreeAndNil(APos);
  end
  else
  begin
    FreeAndNil(APos);
  end;
  Dec(FCount);

end;


constructor TDoublyLinkedList.Create;
begin
  {Init Node}
  FHead := nil;
  FTail := nil;
  FCount := 0;

end;

end.
