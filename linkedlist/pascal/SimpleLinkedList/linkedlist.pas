unit LinkedList;

{$mode objfpc}{$H+}

interface

uses
  Classes, SysUtils;

type
  { TNode }
  TNode = class(TObject)
    Data: Pointer;
    Next: TNode;
    function HasNext: boolean;

  public
    constructor Create(AData: Pointer); overload;
  end;

  { TLinkedList }

  TLinkedList = class(TObject)
    Head: TNode;
    Tail: TNode;
    FCnt: integer;
  public
    constructor Create;
    procedure Add(AData: Pointer);
    procedure Del;
    property Cnt: integer read FCnt write FCnt;
  end;

implementation

{ TNode }

function TNode.HasNext: boolean;
begin
  if Self.Next <> nil then
    Result := True;
end;

constructor TNode.Create(AData: Pointer);
begin
  Data := AData;
  Next := nil;
end;

{ TLinkedList }

constructor TLinkedList.Create;
begin
  Head := nil;
  Tail := nil;
end;

procedure TLinkedList.Add(AData: Pointer);
begin
  if FCnt = 0 then
  begin
    Head := TNode.Create(AData);
    Tail := Head;
  end
  else
  begin
    Tail.Next := TNode.Create(AData);
    Tail := Tail.Next;
  end;
  Inc(FCnt);

end;

procedure TLinkedList.Del;
var
  LCurrentNode: TNode;
begin
  // FIFO
  if FCnt = 0 then
    raise Exception.Create('EMPTY LIST');

  LCurrentNode := Head;
  Head := Head.Next;
  FreeAndNil(LCurrentNode);
end;

end.
