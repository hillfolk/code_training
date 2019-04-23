#include <iostream>

using namespace std;

int bitCount(int x) {
  if(x == 0 ) return 0;
  return x % 2 + bitCount(x /2);
}

int main(){
  //bit 를 이용한 집합 구현

  //10 1111 0010  = 2^1+2^4+2^5+2^6+2^7+2^9 = 754;
  
  // 공집합과 꽉 찬 집합
  
  int fullPizza = (1 << 20)-1; // 20개 bit 가 켜진 상태의 정수

  cout<<fullPizza<<endl;

  
  int p = 0;
  int toppings = 754;
  //원소 추가 
  toppings |= (1 << p);
 
  cout<<toppings<<endl;

  //원소의 포함여부 확인
  if(toppings & (1 << p)) cout << "pepperoni is in" <<endl;

  //원소 삭제
  toppings -= (1 << p);
  
  cout<<toppings<<endl;
  
  toppings &= ~(1 <<p);
  cout<<toppings<<endl;

  //원소 토글
  toppings ^= (1 << p);
  cout<<toppings<<endl;

  //두 집합에 대한 연산하기
  p = 3;
  int a = 0;
  a |= (1 << p); //원소 추가 

  p = 2;
  int b = 0;
  b |= (1 << p); //원소 추가

  int added = (a | b); // a 와 b 의 합집합

  int intersection = (a & b); // a 와 b 교집합

  int removed = (a & ~b); // a 에서 b 를 뺀 차집합

  int toggled = (a ^ b); // a 와 b 중 하나에만 포함된 원소의 집합

  // 집합의 크기
  int toppings_cnt  = bitCount(toppings);

  cout<<"toppings Cnt:"<<toppings_cnt<<endl;

  toppings = 40;
  // 최소 원소 bit 값 찾기
  int firstTopping = (toppings & -toppings);

  cout<<"firstTopping:" << firstTopping << endl;

  //최소 원소 지우기
  
  toppings &= (toppings - 1);
  
  
  return 0;
  
}
