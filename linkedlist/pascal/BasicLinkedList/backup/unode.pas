unit uNode;

{$mode objfpc}{$H+}

interface

uses
  Classes, SysUtils;
  type
    PSimpleNode = ^TSimpleNode;

    TSimpleNode = record
      Next:PSimpleNode;
      Data:SomeDataType;
    end;

implementation
              var
                 NextNode, CurrentNode:PSimpleNode;



end.

