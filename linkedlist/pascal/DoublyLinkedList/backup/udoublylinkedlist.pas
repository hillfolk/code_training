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
    function hasNext:Boolean;
    function hasPrev:Boolean;
    property Value: Pointer read FValue write FValue;
    property Next: TNode read FNext write FPrev;
    property Prev: TNode read FPrev write FPrev;

  end;

  { TDoublyLinkedList }

  TDoublyLinkedList = class(TObject)
    FHead: TNode;
    FTail: TNode;
    FCount: integer;
  public
    procedure InsertBefore(APosNode:TNode;AValuePtr:Pointer);
    procedure InsertNext(APosNode:TNode;AValuePtr:Pointer);
    procedure DeleteAt(APos:TNode);
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

function TNode.hasNext: Boolean;
begin
     if Assigned(FNext) then Result := True;
     else Result := False;
end;

function TNode.hasPrev: Boolean;
begin
       if Assigned(FPrev) then Result := True;
     else Result := False;
end;

{ TDoublyLinkedList }

procedure TDoublyLinkedList.InsertBefore(APosNode: TNode; AValuePtr: Pointer);
var
  LNode:TNode;
begin

     if Assigned(APosNode.Prev) then
     begin
     LNode :=  APosNode.Prev ;
     APosNode.Prev := TNode.Create;
     APosNode.Prev.Value := AValuePtr;
     APosNode.Prev.Prev := LNode;
     end;

end;

procedure TDoublyLinkedList.InsertNext(APosNode: TNode; AValuePtr: Pointer);
begin
         if Assigned(APosNode.Prev) then
     begin
     LNode :=  APosNode.Next ;
     APosNode.Next := TNode.Create;
     APosNode.Next.Value := AValuePtr;
     APosNode.Next.Prev := LNode;
     end;

end;

procedure TDoublyLinkedList.DeleteAt(APos: TNode);
begin

end;


constructor TDoublyLinkedList.Create;
begin
  {Init Node}
  FHead := nil;
  FTail := nil;
  FCount := 0;
  //

end;

end.
